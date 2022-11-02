package boundary;

import java.util.Scanner;

import controller.Database;
import model.MovieGoer;

public class MovieGoerUI {

	public void searchMovieUI() {
		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		do {
			//code
			exit = true;
		} while (!exit);
		System.out.println("Returning to Movie Goer menu...");
		sc.close();
		return;
	}

	/**
	 * Method to view details of a certain movie
	 */
	public void viewMovieDetailsUI() {
		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("||-------- View Movie Details Menu --------||");
			System.out.println("1. Select movie to view details of ");
			System.out.println("2. Return to Movie Goer menu");
			System.out.print("Select option: ");
			String userInput = sc.next();
			switch(userInput){
				case "1": 
					MovieGoer.viewMovieDetails();
					break;
				case "2":
					exit = true;
					break;
				default: System.out.println("Please enter a valid option.");
			}
		} while (!exit);
		System.out.println("Returning to Movie Goer menu...");
		sc.close();
		return;
	}

	/**
	 * Method to ask MovieGoer to input choice to list top 5 by sales or rating.
	 */
	public void listTop5UI() {
		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("||-------- List top 5 menu --------||");
			System.out.println("Would you like to list top 5 by: ");
			System.out.println("1. Overall Rating ");
			System.out.println("2. Total ticket sales ");
			System.out.println("3. Return to Movie Goer Menu");
			System.out.print("Select your option: ");
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
		sc.close();
		System.out.println("Returning to Movie Goer menu...");
		return;
	}
	/**
	 * Method to allow MovieGoer to choose to rate a movie
	 */
	public void rateMovieUI() {
		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("||------- Rate Movie Menu -------||");
			System.out.println("1. Rate a movie ");
			System.out.println("2. Returning to Movie Goer menu");
			System.out.print("Select option: ");
			String userInput  = sc.next();
			switch(userInput) {
			case "1":
				MovieGoer.addReview();
				break;
			case "2":
				exit = true;
				break;
			default: System.out.println("Please enter a valid option. ");
			}
		} while (!exit);
		System.out.println("Returning to Movie Goer menu...");
		sc.close();
		return;
	}

	public void viewBookingHistoryUI(MovieGoer user) {
		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("||-------- View Booking History menu --------||");
			System.out.println("1. View your booking history");
			System.out.println("2. Returning to Movie Goer Menu");
			System.out.print("Select option: ");
			String userInput  = sc.next();
			switch(userInput) {
			case "1":
				user.viewBookingHistory();
				break;
			case "2":
				exit = true;
				break;
			default: System.out.println("Please enter a valid option. ");
			} 
		} while (!exit);
		System.out.println("Returning to Movie Goer menu...");
		sc.close();
		return;
	}

}
