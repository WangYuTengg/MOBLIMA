package model;

import controller.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieGoer {
	/**
	 * MovieGoer's age
	 */
	private int age;
	
	/**
	 * MovieGoer's name
	 */
	private String name;

	/**
	 * MovieGoer's id
	 */
	private int id;

	/**
	 * MovieGoer's password
	 */
	private String password;

	/**
	 * MovieGoer's tickets
	 */
	private ArrayList<Ticket> tickets;

	/**
	 * Creates a MovieGoer with the given attributes
	 */
	public MovieGoer(int age, String name, int id, String password) {
		this.age = age;
		this.name = name;
		this.id = id;
		this.password = password;
		this.tickets = new ArrayList<Ticket>();
	}

	/*
	 * Get the age of this MovieGoer
	 * 
	 * @return int this MovieGoer's age
	 */
	public int getAge() {
		return age;
	}

	/*
	 * Get the name of this MovieGoer
	 * 
	 * @return String this MovieGoer's name
	 */
	public String getName() {
		return name;
	}

	/*
	 * Get the id of this MovieGoer
	 * 
	 * @return String this MovieGoer's id
	 */
	public int getId() {
		return id;
	}

	/*
	 * Get the password of this MovieGoer
	 * 
	 * @return String this MovieGoer's id
	 */
	public String getPass() {
		return password;
	}

	/*
	 * Get the past owned tickets and current tickets of this MovieGoer
	 * 
	 * @return ArrayList<Ticket> this MovieGoer's tickets
	 */
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}

	private static Scanner sc = new Scanner(System.in);
	// Functionalities
	/**
	 * Add review to a movie.
	 */
	public static void addReview() {
		// declare variables needed
		int moviesLength = Database.movieListing.length();
		int userInput, index, rating;
		boolean exit = false;

		// loop to get a valid index from user
		do{
			System.out.println("Please choose the movie by index (enter -1 to exit):");
			System.out.println("||------ Listing Movies ------||");
			Database.movieListing.listMovies();
			System.out.print("Select movie index:  ");

			//check for integer input
			while (!sc.hasNextInt()) {
				System.out.printf("Please enter a number instead:  ");
				sc.next();
			}
			userInput = sc.nextInt();

			// return to main menu if MovieGoer inputs -1
			if (userInput == -1){
				System.out.println("Returning to main menu. Review not added.");
				return;
			}

			// check for valid movie index
			if ( userInput >= 0 && userInput <= moviesLength-1) {
				exit = true; //exit loop
			} 
			else System.out.println("Invalid index, please try again.");
		}while(!exit);
		index = userInput;

		// Loop to get a valid rating
		exit = false;
		do{
			System.out.print("Please enter rating ( 1 to 5 ) here: ");
			//check for integer input
			while(!sc.hasNextInt()){
				System.out.println("Enter a number please.");
				sc.next();
			}
			userInput = sc.nextInt();

			if (userInput >= 1 && userInput <= 5) exit = true;
			else System.out.println("Please enter a rating between 1 and 5.");
		}while(!exit);
		System.out.printf("Rating given: %d\n", userInput);
		rating = userInput;

		// get MovieGoer input for comment
		System.out.println("Please enter the review comment:");
		String comment = sc.nextLine();

		// add review to Movie
		Database.movieListing.getMovies().get(index).addReview(rating, comment);
		System.out.printf("Successfully added review to %s!\n",
				Database.movieListing.getMovies().get(index).getTitle());
	}

	/**
	 * Book tickets.
	 */
	public void bookTickets() {
		Ticket[] temp = Database.bookingSystem.book(id);
		for (Ticket i : temp)
			this.tickets.add(i);
	}

	/*
	 * Function to view booking history of this MovieGoer Displays relevant
	 * information of tickets owned by this MovieGoer
	 * 
	 * @returns void
	 */
	public void viewBookingHistory() {
		if (tickets.size() != 0) {
			System.out.println("Displaying booking history:");
			for (Ticket ticket : tickets) {
				System.out.printf("Ticket ID: " + ticket.getIndex() + " - Movie: " + ticket.getMovieTitle() + " at "
						+ ticket.getCineplexName());
				System.out.println();
			}

		} else {
			System.out.println("No history available");
		}
	}

	/**
	 * View the detail of the movie.
	 */
	public static void viewMovieDetails() {
		// declare variables needed
		int moviesLength = Database.movieListing.length();
		int userInput, index;
		boolean exit = false;

		// loop to get valid index of movie from MovieGoer
		do{
			System.out.println("Please choose the movie by index (enter -1 to exit):");
			System.out.println("||------ Listing Movies ------||");
			Database.movieListing.listMovies();
			System.out.print("Select movie index:  ");

			//check for integer input
			while (!sc.hasNextInt()) {
				System.out.printf("Please enter a number: ");
				sc.next();
			}
			userInput = sc.nextInt();

			// return to main menu if MovieGoer inputs -1
			if (userInput == -1){
				System.out.println("Returning to main menu...");
				return; 
			}

			// check for valid movie index
			if ( userInput >= 0 && userInput <= moviesLength) {
				exit = true; //exit loop
			} 
			else System.out.println("Invalid index, please try again.");
		}while(!exit);
		index = userInput;
		Database.movieListing.getMovies().get(index).display();
	}
}



