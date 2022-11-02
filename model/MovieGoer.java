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
		Database.movieListing.listMovies();
		System.out.println("Please choose the movie by index:\n");
		Scanner sc = new Scanner(System.in);
		int index = sc.nextInt();
		System.out.println("Please enter the rating:\n");
		int rating = sc.nextInt();
		System.out.println("Please enter the comment:\n");
		String comment = sc.next();
		sc.close();
		Database.movieListing.getMovies().get(index).addReview(rating, comment);
		System.out.printf("Successfully adding review to %s!\n",
				Database.movieListing.getMovies().get(index).getTitle());
	}

	/**
	 * Book tickets.
	 */
	public void bookTickets() {
		Ticket[] temp = Database.bookingSystem.book(Database.movieListing.getMovies(), id);
		for (Ticket i : temp)
			this.tickets.add(i);
	}

	/*
	 * 
	 */
	public void searchMovie() {
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
	public void viewMovieDetails() {
		Database.movieListing.listMovies();
		System.out.printf("Enter the index of movie:\n");
		Scanner sc = new Scanner(System.in);
		int index = sc.nextInt();
		sc.close();
		Database.movieListing.getMovies().get(index).display();
	}

}
