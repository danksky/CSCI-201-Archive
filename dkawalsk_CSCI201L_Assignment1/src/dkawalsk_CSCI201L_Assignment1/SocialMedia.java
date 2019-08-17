package dkawalsk_CSCI201L_Assignment1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import DOM.*;

public class SocialMedia {
	
	static User current;
	
	public static void main(String args[]) {
		try {
			DOMParser dp = new DOMParser();
			//dp.printValues();
			dp.instantiateValues();
			boolean loggedIn = login(dp); // naturally leads to mainMenuSequence

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void mainMenuSequence(DOMParser dp) {
		System.out.println("1. Search Users\n2. Search Movies\n3. View Feed\n4. View Profile\n5. Logout\n6. Exit");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		if (input.equals("1") || input.equals("2") || input.equals("3") 
				|| input.equals("4") || input.equals("5") || input.equals("6")) {
			int choice = Integer.parseInt(input);
			switch (choice) {
				case 1: 
					searchUsersSequence(dp);
					break;
				case 2:
					searchMoviesSequence(dp);
					break;
				case 3:
					viewFeed(dp);
					break;
				case 4:
					viewProfile(dp);
					break;
				case 5:
					mainMenuSequence(dp);
					break;
				case 6:
					break;
				default:
					System.out.println("You have entered an invalid command, please try again.");
					break;
			}
		} else {
			System.out.println("You have entered an invalid command, please try again.");
		}
	}

	private static void viewFeed(DOMParser dp) {
		for (int i = 0; i < current.following.length; i++) {
			User follow = dp.getUserByUsername(current.following[i]);
			for (int j = 0; j < follow.feed.length; j++) {
				Event f = follow.feed[j];
				System.out.println(follow.username + " " + f.action 
						+ " the movie \'"  + f.movie + "\' " + f.rating);
			}
		}
		boolean valid = false;
		while (!valid) {
			System.out.println("\nTo go back to the login menu, please type ‘0’");
			System.out.print("-> ");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			if (input.equals("0")) {
				valid = true;
				login(dp);
			} else {
				valid = false;
				System.out.println("You have entered an invalid command, please try again.");
			}
		}
	}

	private static void viewProfile(DOMParser dp) {
		System.out.println(current.fname + " " + current.lname);
		System.out.println("username: " + current.username);
		String password = current.password.charAt(0) + "";
		for (int i = 0; i < current.password.length()-2; i++) 
			password += "*";
		password += current.password.charAt(current.password.length()-1);
		System.out.println("password: "+ password);
		System.out.println("Following:");
		for (int i = 0; i < current.following.length; i++)
			System.out.println("   "+current.following[i]);
		System.out.println("Followers:");
		for (int i = 0; i < dp.users.length; i++) {
			for (int j =0; j < dp.users[i].following.length; j++) {
				if (dp.users[i].following[j].equals(current.username)) {
					System.out.println("   "+ dp.users[i].username);
				}
			}
		}
		boolean valid = false;
		while (!valid) {
			System.out.println("\nTo go back to the login menu, please type ‘0’");
			System.out.print("-> ");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			if (input.equals("0")) {
				valid = true;
				login(dp);
			} else {
				valid = false;
				System.out.println("You have entered an invalid command, please try again.");
			}
		}
	}

	private static void searchMoviesSequence(DOMParser dp) {
		System.out.println("1. Search by Actor\n2. Search by Title\n3. Search by Genre\n4. Back to Login Menu");
		System.out.print("-> ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		ArrayList<Movie> foundList = new ArrayList<Movie>();
		if (input.equals("1")) {
			System.out.println("Please enter the name of the actor you wish to search by.");
			System.out.print("-> ");
			String input2 = scanner.nextLine();
			for (int i = 0; i < dp.movies.length; i++)
			{
				for (int j = 0 ; j < dp.movies[i].actors.length; j++) {
					if (dp.movies[i].actors[j].equals(input2) && !foundList.contains(dp.movies[j]))
						foundList.add(dp.movies[j]);
				}
			}
		} else if (input.equals("2")) {
			System.out.println("Please enter the title of the movie you wish to search for.");
			System.out.print("-> ");
			String input2 = scanner.nextLine();
			for (int i = 0; i < dp.movies.length; i++)
			{
				if (dp.movies[i].title.equals(input2) && !foundList.contains(dp.movies[i]))
					foundList.add(dp.movies[i]);
			}
		} else if (input.equals("3")) {
			System.out.println("Please enter the genre you wish to search by.");
			System.out.print("-> ");
			String input2 = scanner.nextLine();
			for (int i = 0; i < dp.movies.length; i++)
			{
				if (dp.movies[i].genre.equals(input2) && !foundList.contains(dp.movies[i]))
					foundList.add(dp.movies[i]);
			}
		} else if (input.equals("4")) {
			login(dp);
			return;
		} else {
			searchMoviesSequence(dp);
		}
		
		// Say here what was found!
		System.out.print(foundList.size() + " result"); 
		if (foundList.size() != 1) System.out.print("s");
		System.out.print(":\n");
		for (int i = 0; i < foundList.size(); i++)
			System.out.println("\'" + foundList.get(i).title + "\'");
		boolean valid = false;
		while (!valid) {
			System.out.println("\nPlease choose from the following options:\n1. Back to Login Menu\n2. Back to Search Movies Menu");
			System.out.print("-> ");
			String input3 = scanner.nextLine();
			if (input3.equals("1")) {
				valid = true;
				login(dp);
			} else if (input3.equals("2")) {
				valid = true;
				searchMoviesSequence(dp);
			} else {
				valid = false;
				System.out.println("You have entered an invalid command, please try again.");
			}
		}
		
	}

	private static void searchUsersSequence(DOMParser dp) {
		System.out.println("Please enter the username you are searching for.");
		System.out.print("-> ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		int results = 0;
		ArrayList<String> foundList = new ArrayList<String>();
		
		// search by username
		for (int i = 0; i < dp.users.length; i++) {
			if (dp.users[i].username.equals(input)) {
				results++;
				foundList.add(input);
			}
		}
		System.out.print(results + " result"); 
		if (results != 1) System.out.print("s");
		System.out.print(":\n");
		for (int i = 0; i < foundList.size(); i++)
			System.out.println(foundList.get(i));
		boolean valid = false;
		while (!valid) {
			System.out.println("Please choose from the following options:\n1. Back to Login Menu\n2. Search Again");
			System.out.print("-> ");
			String input2 = scanner.nextLine();
			if (input2.equals("1")) {
				valid = true;
				login(dp);
			} else if (input2.equals("2")) {
				valid = true;
				searchUsersSequence(dp);
			} else {
				valid = false;
				System.out.println("You have entered an invalid command, please try again.");
			}
		}
	}

	private static boolean login(DOMParser dp) {
		
		Scanner scanner = new Scanner(System.in);
		boolean terminate = false;
		
		while (!terminate) {
			System.out.println("1. Login \n2. Exit");
			String input = scanner.nextLine();
			if (!input.equals("1") && !input.equals("2")) {
				System.out.println("You have entered an invalid command, please try again.");
				continue;
			}
			else if (input.equals("1")) {
				System.out.println("Please enter your username");
				System.out.print("-> ");
				int attempts = 3;
				while (!terminate && attempts > 0) {
					String username = scanner.nextLine();
					attempts--;
					current = dp.getUserByUsername(username);
					if (current != null) {
						mainMenuSequence(dp);
						return true;
						
					} else {
						if (attempts != 0) {
							System.out.println("Invalid username. You have " 
									+ attempts 
									+ " more chances to enter a valid username.");
							System.out.print("-> ");
						}
					}
				}	
			} else if (input.equals("2")) {
				return false;
			}
		}
		scanner.close();
		return false;
	}
}
