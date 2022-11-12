package boundary;

import java.util.Scanner;

import controller.Database;
import model.MovieGoer;

public class MovieGoerUI {
	private static Scanner sc = new Scanner(System.in);
	/*
	 * Method to search movie 
	 */
	public void searchMovieUI(Database db) {
		boolean exit = false;
		do {			
			System.out.println("");
			System.out.println("||-------- Search Movie Menu --------||");
			System.out.println("1. List all movies");
			System.out.println("2. Search Movie by movie title");
			System.out.println("3. Search Movie by Director");
			System.out.println("4. Return to Movie Goer menu");
			System.out.printf("Select your option:  ");
			String userInput = sc.nextLine();
			switch(userInput){
				case "1": 
					System.out.println("----- Listing all movies -----");
					db.movieListing.listMovies();
					break;
				case "2":
					System.out.println("----- Seaching movie by title -----");
					db.movieListing.searchMovieByTitle();
					break;
				case "3":
					System.out.println("----- Searching movie by director -----");
					db.movieListing.searchMovieByDirector();
					break;
				case "4":
					exit = true;
					break; 
				default: System.out.println("Please select a valid option.");
			}
		} while (!exit);
		System.out.println("Returning to Movie Goer menu...");
	}

	/**
	 * Method to view details of a certain movie
	 */
	public void viewMovieDetailsUI(Database db) {
		boolean exit = false;
		do {
			System.out.println("");
			System.out.println("||-------- View Movie Details Menu --------||");
			System.out.println("1. Select movie to view details of ");
			System.out.println("2. Return to Movie Goer menu");
			System.out.print("Select option: ");
			String userInput = sc.next();
			switch(userInput){
				case "1": 
					MovieGoer.viewMovieDetails(db);
					break;
				case "2":
					exit = true;
					break;
				default: System.out.println("Please enter a valid option.");
			}
		} while (!exit);
		System.out.println("Returning to Movie Goer menu...");
	}

	/**
	 * Method to ask MovieGoer to input choice to list top 5 by sales or rating.
	 */
	public void listTop5UI(Database db) {
		boolean exit = false;
		do {
			System.out.println("");
			System.out.println("||-------- List top 5 menu --------||");
			System.out.println("Would you like to list top 5 by: ");
			System.out.println("1. Overall Rating ");
			System.out.println("2. Total ticket sales ");
			System.out.println("3. Return to Movie Goer Menu");
			System.out.print("Select your option: ");
			String userInput = sc.next();
			switch (userInput) {
			case "1":
				System.out.println("Listing top 5 by overall rating: ");
				if (!Top5UI.getIsTop5ByRatingBlocked()) db.movieListing.listTop5byRating();
				else System.out.println("List currently blocked by admin.");
				break;
			case "2":
				System.out.println("Listing top 5 by total ticket sales: ");
				if (!Top5UI.getIsTop5BySalesBlocked()) db.movieListing.listTop5bySales();
				else System.out.println("List currently blocked by admin.");
				break;
			case "3":
				exit = true;
				break;
			default: System.out.println("Please enter a valid option. ");
			}
		} while (!exit);
		System.out.println("Returning to Movie Goer menu...");
	}

	/**
	 * Method to allow MovieGoer to choose to rate a movie
	 */
	public void rateMovieUI(Database db) {
		boolean exit = false;
		do {
			System.out.println("");
			System.out.println("||------- Rate Movie Menu -------||");
			System.out.println("1. Rate a movie ");
			System.out.println("2. Returning to Movie Goer menu");
			System.out.print("Select option: ");
			String userInput  = sc.next();
			switch(userInput) {
			case "1":
				MovieGoer.addReview(db);
				break;
			case "2":
				exit = true;
				break;
			default: System.out.println("Please enter a valid option. ");
			}
		} while (!exit);
		System.out.println("Returning to Movie Goer menu...");
	}

	/*
	 * Method to viewBookingHistory of MovieGoer
	 */
	public void viewBookingHistoryUI(MovieGoer user) {
		boolean exit = false;
		do {
			System.out.println("");
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
	}

}
