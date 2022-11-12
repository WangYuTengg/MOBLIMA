package model;

import data.Database;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The MovieGoer Class.
 * @version  4.0
 * @author   Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong Jian
 * @since    2022-10-30
 */
public class MovieGoer extends User implements java.io.Serializable {
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
	 * @param age		age of movie goer.
	 * @param name		name of movie goer.
	 * @param email		email of movie goer.
	 * @param id		id of movie goer.
	 * @param password	password of movie goer.
	 */
	public MovieGoer(int age, String name, String email, int id, String password) {
		super(name, email, password);
		this.age = age;
		this.id = id;
		this.tickets = new ArrayList<Ticket>();
	}

	/**
	 * Get the email of this MovieGoer
	 * @return email
	 */

	/**
	 * Get the age of this MovieGoer
	 * 
	 * @return int this MovieGoer's age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Get the name of this MovieGoer
	 * @return String this MovieGoer's name
	 */
	/**
	 * Get the id of this MovieGoer
	 * @return String this MovieGoer's id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Get the password of this MovieGoer
	 * @return String this MovieGoer's id
	 */

	/**
	 * Get the past owned tickets and current tickets of this MovieGoer
	 * @return The MovieGoer's tickets
	 */
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}

	/**
	 * A static scanner used within MovieGoer.
	 */
	private static Scanner sc = new Scanner(System.in);

	/**
	 * Add review to a movie.
	 * @param db the database.
	 * @return void
	 */
	public static void addReview(Database db) {
		// declare variables needed
		int moviesLength = db.movieListing.length();
		int userInput, index, rating;
		boolean exit = false;

		// loop to get a valid index from user
		do{
			System.out.println("Please choose the movie by index (enter -1 to exit):");
			System.out.println("||------ Listing Movies ------||");
			db.movieListing.listMovies();
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
	 * Method to book tickets for this MovieGoer
	 * @param db the database.
	 * @return void
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
	 * Function to view booking history of this MovieGoer Displays relevant
	 * information of tickets owned by this MovieGoer
	 * @return void
	 */
	public void viewBookingHistory() {
		if (tickets.size() != 0) {
			System.out.println("Displaying booking history:");
			for (Ticket ticket : tickets) {
				System.out.printf("Ticket ID: " + ticket.getIndex() + " - Movie: " + ticket.getMovieTitle() + " at "
						+ ticket.getCineplexName() + ", in Cinema " + ticket.getCinemaNum() + ", at " + ticket.getMovieTiming() + ", at Seat: " + ticket.getSeatIndex());
				System.out.println();
			}

		} else {
			System.out.println("No history available");
		}
	}

	/**
	 * View the detail of the movie.
	 * @param db the database.
	 * @return void
	 */
	public static void viewMovieDetails(Database db) {
		// declare variables needed
		int moviesLength = db.movieListing.length();
		int userInput, index;
		boolean exit = false;

		// loop to get valid index of movie from MovieGoer
		do{
			System.out.println("Please choose the movie by index (enter -1 to exit):");
			System.out.println("||------ Listing Movies ------||");
			db.movieListing.listMovies();
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
		index = userInput-1;
		db.movieListing.getMovies().get(index).display();
	}
}



