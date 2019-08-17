package DOM;

public class User {

	public String username, password, fname, lname;
	public Event[] feed;
	public String[] following;
	
	public User () {}
	
	public User (String u, String p, String f, String l, Event[] events, String[] users)
	{
		username = u;
		password = p;
		fname = f;
		lname = l;
		feed = events;
		following = users;
	}
}
