import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class UsingClip implements LineListener {

	static String beatLink = "SequencerProject-Beat.wav";
	static String synthLink = "SequencerProject-Synth.wav";
	static String saxLink = "SequencerProject-Sax.wav";	

	Clip audioClipBeat;
	Clip audioClipSynth;
	Clip audioClipSax;
	
	boolean playCompleted;
	long clipLength;
	long duration;

	void play(String audioFilePath) {
		File audioFile = new File(audioFilePath);
		try {
			AudioInputStream audioStreamBeat = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(beatLink));
			AudioInputStream audioStreamSynth = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(synthLink));
			AudioInputStream audioStreamSax = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(saxLink));
			
			AudioFormat formatBeat = audioStreamBeat.getFormat();
			AudioFormat formatSynth = audioStreamSynth.getFormat();
			AudioFormat formatSax = audioStreamSax.getFormat();
			
			DataLine.Info infoBeat = new DataLine.Info(Clip.class, formatBeat);
			DataLine.Info infoSynth = new DataLine.Info(Clip.class, formatSynth);
			DataLine.Info infoSax = new DataLine.Info(Clip.class, formatSax);
			
			audioClipBeat 	= (Clip) AudioSystem.getLine(infoBeat);
			audioClipSynth 	= (Clip) AudioSystem.getLine(infoSynth);
			audioClipSax 	= (Clip) AudioSystem.getLine(infoSax);
			
			audioClipBeat.addLineListener(this);
			audioClipSynth.addLineListener(this);
			audioClipSax.addLineListener(this);
			
			audioClipBeat.open(audioStreamBeat);
			audioClipSynth.open(audioStreamSynth);
			audioClipSax.open(audioStreamSax);

			
			clipLength = audioClipBeat.getFrameLength();
			duration = audioClipBeat.getFramePosition();
			System.out.println(clipLength + " " + duration);
		
			audioClipBeat.start();
			audioClipSynth.start();
			audioClipSax.start();
			
			//Thread.sleep(3000);
			
			//audioClipBeat.stop();
			
			while (!playCompleted) {
				// wait for the playback completes
//				try {
					duration = audioClipBeat.getFramePosition();
					if (clipLength <= duration) {
						System.out.println("Eighthway? " + clipLength+" "+duration);
						playCompleted = true;
						//System.out.println("Playback completed.");
					}
					//Thread.sleep(1000);
//				} 
			}
			audioClipBeat.setFramePosition(0);

			audioClipBeat.stop();
			audioClipBeat.flush();
			audioClipBeat.drain();
			//audioClipBeat.start();
			
			

		} catch (UnsupportedAudioFileException ex) {
			System.out.println("The specified audio file is not supported.");
			ex.printStackTrace();
		} catch (LineUnavailableException ex) {
			System.out.println("Audio line for playing back is unavailable.");
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("Error playing the audio file.");
			ex.printStackTrace();
		} 

	}

	@Override
	public void update(LineEvent event) {
		LineEvent.Type type = event.getType();
		duration = audioClipBeat.getFramePosition();

		if (type == LineEvent.Type.START) {
			System.out.println("Playback started.");
			System.out.println(audioClipBeat.isRunning());

		} else if (type == LineEvent.Type.STOP) {
			System.out.println("Playback completed.");
			
//			event.getLine().close();
			try {			
				Thread.sleep(500);
				audioClipBeat.open();
				audioClipBeat.start();
				System.out.println(audioClipBeat.getFrameLength());
			} catch (LineUnavailableException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		// below won't work
//		} else if (clipLength/2 <= duration) {
//			System.out.println("Halfway? " + clipLength+" "+duration);
//			playCompleted = true;
//			System.out.println("Playback completed.");
//		}
			
	}

	public static void main(String[] args) {
		String audioFilePath = "E:/Test/Audio.wav";
		UsingClip player = new UsingClip();
		player.play(beatLink);
	}

}
