package DOM;

public class Movie {

	public String title, director, genre, year, description, rating;
	public String[] writers, actors;
	
	public Movie(String t, String dir, String g, String y, String des, String r, String[] w, String[] a)
	{
		title = t;
		director = dir;
		genre = g;
		year = y;
		description = des;
		rating = r;
		writers = w;
		actors = a;
	}
	
}
