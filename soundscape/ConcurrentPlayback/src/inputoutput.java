import sun.audio.*; //import the sun.audio package
import java.io.*;
import java.net.URL;
import java.util.Scanner;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.sound.sampled.*;

public class inputoutput {


//	//** add this into your application code as appropriate
//	// Open an input stream  to the audio file.
	
	InputStream inputStream;
	AudioStream audioStream;
	String link = "looperman-l-2054129-0104722-laurentwirz-bluesy-half-time-shuffle.wav";
//	InputStream in = new FileInputStream("looperman-l-2054129-0104722-laurentwirz-bluesy-half-time-shuffle.wav");
//	URL myURL = new URL(link); 
//	
//	final Mixer mixer = AudioSystem.getMixer(null);
//	final AudioFileFormat file = AudioSystem.getAudioFileFormat(myURL);
//	final AudioInputStream stream = AudioSystem.getAudioInputStream(myURL);;
//	
//	final AudioFormat format = stream.getFormat();
//	int size = (int) Math.rint((format.getFrameRate() * format.getFrameSize()) / 120);
	
//	String bip = "bip.mp3";
//	Media hit = new Media(new File(link).toURI().toString());
//	MediaPlayer mediaPlayer = new MediaPlayer(hit);
//	mediaPlayer.play();
	
	inputoutput() {
		
	}
	
	public static void main(String args[]) {
		inputoutput io = new inputoutput();
		io.init();
		io.playSound();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Your command\n> ");
		String input = scanner.nextLine();
		if (input.equals("STOP PLEASE")) {
			System.out.println("received.");
			io.pauseSound();
		}
	}
	
	@SuppressWarnings("restriction")
	private void init() {
		try
		  {
		    inputStream = getClass().getResourceAsStream(link);
		    audioStream = new AudioStream(inputStream);
		  }
		  catch (Exception e)
		  {
		    // a special way i'm handling logging in this application
		     e.printStackTrace();
		  }
	}
	
	@SuppressWarnings("restriction")
	private void playSound() 
	{
	  try
	  {
	    AudioPlayer.player.start(audioStream);
	  }
	  catch (Exception e)
	  {
	    // a special way i'm handling logging in this application
	     e.printStackTrace();
	  }
	}
	
	@SuppressWarnings("restriction")
	private void pauseSound() 
	{
		AudioPlayer.player.stop(inputStream);
	}
	
}
