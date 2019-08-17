package dkawalsk_CSCI201L_Assignment1;

import java.util.Scanner;

public class HelloWorld {
	public static void main(String args[]) {
		System.out.println("What's your name?");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		System.out.println("Your name is " + name);
	}
}
