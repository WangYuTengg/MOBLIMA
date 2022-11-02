package boundary;

import java.util.Scanner;

import controller.Database;

public class MovieGoerUI {

	public void searchMovieUI() {
		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		do {

		} while (!exit);
		System.out.println("Returning to Movie Goer menu...");
	}

	/**
	 * Method to view details of a certain movie
	 */
	public void viewMovieDetailsUI() {
		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		do {

		} while (!exit);
		System.out.println("Returning to Movie Goer menu...");
	}

	/**
	 * Method to ask MovieGoer to input choice to list top 5 by sales or rating.
	 */
	public void listTop5UI() {
		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Would you like to list top 5 by: ");
			System.out.println("1. Overall Rating ");
			System.out.println("2. Total ticket sales ");
			System.out.println("3. Return to Movie Goer Menu");
			System.out.println("Select your option: ");
			String userInput = sc.next();
			switch (userInput) {
			case "1":
				Database.movieListing.listTop5byRating();
				break;
			case "2":
				Database.movieListing.listTop5bySales();
				break;
			case "3":
				exit = true;
				break;
			default: System.out.println("Please enter a valid option. ");
			}
		} while (!exit);
		System.out.println("Returning to Movie Goer menu...");
	}

	public void rateMovieUI() {
		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1. Rate a movie ");
			System.out.println("2. Returning to Movie Goer menu");
			String userInput  = sc.next();
			switch(userInput) {
			case "1":
				
				break;
			case "2":
				exit = true;
				break;
			default: System.out.println("Please enter a valid option. ");
			}
		} while (!exit);
		System.out.println("Returning to Movie Goer menu...");
	}

	public void viewBookingHistoryUI() {
		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		do {

		} while (!exit);
		System.out.println("Returning to Movie Goer menu...");
	}

}
