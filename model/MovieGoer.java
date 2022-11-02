package model;

import controller.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieGoer {
	Scanner sc = new Scanner(System.in);
	// Attributes
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

	// Constructor

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

	// Methods
	// Get Methods
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
	 * Get the past owned tickets and current tickets of this MovieGoer
	 * 
	 * @return ArrayList<Ticket> this MovieGoer's tickets
	 */
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}

	// Functionalities

	/**
	 * Add review to a movie.
	 */
	public static void addReview() {
		// declare variables needed
		int moviesLength = Database.movieListing.length();
		int userInput, index, rating;
		boolean exit = false;

		// list the movies for MovieGoer to see
		Database.movieListing.listMovies();
		Scanner sc = new Scanner(System.in);
		
		// loop to get a valid index from user
		do{
			System.out.println("Please choose the movie by index:\n");
			System.out.println("Enter -1 to exit.");

			//check for integer input
			while (!sc.hasNextInt()) {
				System.out.println("Please enter a number.");
				sc.next();
			}
			userInput = sc.nextInt();

			// return to main menu if MovieGoer inputs -1
			if (userInput == -1){
				System.out.println("Returning to main menu. Review not added.");
				return;
			}

			// check for valid movie index
			if ( userInput > 0 && userInput <= moviesLength) {
				exit = true; //exit loop
			} 
			else System.out.println("Invalid index, please try again.");
		}while(!exit);
		index = userInput - 1;

		// Loop to get a valid rating
		do{
			System.out.println("Please enter rating ( 1 to 5 )");
			System.out.println("Option selected: ");
			//check for integer input
			while (!sc.hasNextInt()) {
				System.out.println("Please enter a number.");
				sc.next();
			}
			userInput = sc.nextInt();
			// check for valid movie index
			if ( userInput > 0 && userInput <= 5) {
				exit = true; //exit loop
			} 
			else System.out.println("Invalid rating, please try again.");
		}while(!exit);
		rating = userInput;

		// get MovieGoer input for movie review
		System.out.println("Please enter the comment:\n");
		String comment = sc.next();
		sc.close();

		// add review to Movie
		Database.movieListing.getMovies().get(index).addReview(rating, comment);
		System.out.printf("Successfully adding review to %s!\n",
				Database.movieListing.getMovies().get(index).getTitle());
		return;
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
	 * 
	 */
	public static void searchMovie() {
		return;
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
		return;
	}

	/**
	 * View the detail of the movie.
	 */
	public static void viewMovieDetails() {
		// declare variables needed
		int moviesLength = Database.movieListing.length();
		int userInput, index;
		boolean exit = false;

		// display list of movies for MovieGoer to choose movie to view details of
		Database.movieListing.listMovies();
		Scanner sc = new Scanner(System.in);

		// loop to get valid index of movie from MovieGoer
		do{
			System.out.println("Please choose the movie by index:\n");
			System.out.println("Enter -1 to exit.");
			System.out.print("Select Option: ");

			//check for integer input
			while (!sc.hasNextInt()) {
				System.out.println("Please enter a number.");
				sc.next();
			}
			userInput = sc.nextInt();

			// return to main menu if MovieGoer inputs -1
			if (userInput == -1){
				System.out.println("Returning to main menu. Review not added.");
				return; 
			}

			// check for valid movie index
			if ( userInput > 0 && userInput <= moviesLength) {
				exit = true; //exit loop
			} 
			else System.out.println("Invalid index, please try again.");
		}while(!exit);
		index = userInput - 1;
		sc.close();
		Database.movieListing.getMovies().get(index).display();
		return;
	}

}
