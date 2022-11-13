package controller;

import data.Database;
import model.Ticket;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The MovieGoer Class.
 * @version  4.0
 * @author   Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong Jian
 * @since    2022-10-30
 */
public class MovieGoer extends User {

	/**
	 * A static scanner used within MovieGoer.
	 */
	private static Scanner sc = new Scanner(System.in);

	/**
	 * MovieGoer's age
	 */
	private int age;
	
	/**
	 * MovieGoer's id
	 */
	private int id;

	/**
	 * MovieGoer's tickets
	 */
	private ArrayList<Ticket> tickets;

	/**
	 * Creates a MovieGoer with the given attributes
	 * @param age		Age of the movie goer.
	 * @param name		Name of the movie goer.
	 * @param email		Email of the movie goer.
	 * @param id		ID of the movie goer.
	 * @param password	Password of the movie goer.
	 */
	public MovieGoer(int age, String name, String email, int id, String password) {
		super(name, email, password);
		this.age = age;
		this.id = id;
		this.tickets = new ArrayList<Ticket>();
	}

	/**
	 * Gets the age of the MovieGoer.
	 * @return The MovieGoer's age.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Gets the ID of this MovieGoer.
	 * @return The MovieGoer's ID.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets all the tickets owned by the MovieGoer.
	 * @return The MovieGoer's tickets.
	 */
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}

	/**
	 * Adds a review to a movie.
	 * @param db the database.
	 */
	public static void addReview(Database db) {
		// declare variables needed
		sc=new Scanner(System.in);
		int moviesLength = db.movieListing.length();
		int userInput, index, rating;
		boolean exit = false;

		// loop to get a valid index from user
		do{
			System.out.println("Please choose the movie by index (enter -1 to exit):");
			System.out.println("||------ Listing Movies ------||");
			db.movieListing.listMovies(false);
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
			if ( userInput >= 1 && userInput <= moviesLength) {
				exit = true; //exit loop
			} 
			else System.out.println("Invalid index, please try again.");
		}while(!exit);
		index = userInput-1;

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
		sc.nextLine();
		System.out.println("Please enter the review comment:");
		String comment = sc.nextLine();

		// add review to Movie
		db.movieListing.getMovies().get(index).addReview(rating, comment);
		System.out.printf("Successfully added review to %s!\n",
				db.movieListing.getMovies().get(index).getTitle());
	}

	/**
	 * A Method used to book tickets for the MovieGoer.
	 * @param db The database.
	 */
	public void bookTickets(Database db) {
		Ticket[] temp = null;
		try {
			temp = db.bookingSystem.book(id, db);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		for (Ticket i : temp)
			this.tickets.add(i);
	}

	/**
	 * Function to view booking history of this MovieGoer, displaying relevant information of all tickets owned by this MovieGoer.
	 */
	public void viewBookingHistory() {
		int count = 1;
		if (tickets.size() != 0) {
			System.out.println("Displaying booking history:");
			for (Ticket ticket : tickets) {
				System.out.printf(count++ + ". TID: " + ticket.getTID() + " Ticket index: "+ticket.getIndex()+" - Movie: " + ticket.getMovieTitle() + " at "
						+ ticket.getCineplexName() + ", in Cinema " + ticket.getCinemaNum() + ", at " + ticket.getMovieTiming() + ", at Seat: " + ticket.getSeatIndex());
				System.out.println();
			}

		} else {
			System.out.println("No history available");
		}
	}

	/**
	 * Views the details of a movie.
	 * @param db The database.
	 */
	public static void viewMovieDetails(Database db) {
		// declare variables needed
		sc=new Scanner(System.in);
		int moviesLength = db.movieListing.length();
		int userInput, index;
		boolean exit = false;

		// loop to get valid index of movie from MovieGoer
		do{
			System.out.println("Please choose the movie by index (enter -1 to exit):");
			System.out.println("||------ Listing Movies ------||");
			db.movieListing.listMovies(false);
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
			if ( userInput > 0 && userInput <= moviesLength) {
				exit = true; //exit loop
			} 
			else System.out.println("Invalid index, please try again.");
		}while(!exit);
		index = userInput-1;
		db.movieListing.getMovies().get(index).display();
	}
}



