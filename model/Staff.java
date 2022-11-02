package model;

/**
Represents the Staff Class.
@version   1.0
@author    Davyn Yam
@since     2022-11-01
*/
import java.util.Scanner;

import controller.Database;

public class Staff {
	/**
	 * The userID of the Staff member.
	 */
	private int userID;
	/**
	 * The password of the Staff member.
	 */
	private String password;

	/**
	 * The Constructor of the class.
	 * 
	 * @param staffId
	 * @param pass
	 */
	public Staff(int staffId, String pass) {
		userID = staffId;
		password = pass;
	}

	/**
	 * get the ID of the Staff member.
	 * 
	 * @return
	 */
	public int getID() {
		return userID;
	}

	/**
	 * Get the password of the Staff member.
	 * 
	 * @return
	 */
	public String getPass() {
		return password;
	}

	/**
	 * Creating a Movie class, and adding it to the database.
	 */
	public void addMovie() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the Title of the Movie: "); // movie title
		String title = scan.nextLine();

		while (Database.movies.indexOf(title) != -1) {
			System.out.println("The movie already exists in the system.\n Please re-enter the Title of the Movie:");
			title = scan.nextLine();
		}

		System.out.println("Enter the Movie Type: "); // movie type
		String type = scan.nextLine();

		System.out.println("Enter the Movie's Showing Status: "); // movie showing status
		String status = scan.nextLine();

		System.out.println("Enter the Movie's director: "); // movie director
		String director = scan.nextLine();

		System.out.println("How many cast members would you like to list?"); // movie cast
		int castLength = scan.nextInt();
		String[] cast = new String[castLength];
		System.out.println("Enter the name of the cast members: ");
		for (int i = 0; i < castLength; i++) {
			cast[i] = scan.nextLine();
		}

		System.out.println("Enter the Synopsis of the Movie: "); // movie synopsis
		String synopsis = scan.nextLine();

		Movie movie = new Movie(title, type, status, director, synopsis, cast, castLength);

		Database.movieListing.addMovie(movie);

		scan.close();
	}

	/**
	 * Edit's the details of a Movie.
	 */
	public void editMovie() {
		Database.movieListing.updateMovie();
		System.out.println("Movie details have successfully been udpated.");
	}

	/**
	 * Removing a movie from the Database
	 */
	public void deleteMovie() {
		Database.movieListing.deleteMovie();
		System.out.println("Movie has successfully been deleted.");
	}

	/**
	 * Editing a movie's showing status.
	 */
	public void setMovieStatus() {
		Scanner scan = new Scanner(System.in);
		Database.movieListing.ListMovies();
		System.out.println("Please input the index of the show you wish to set the price of:");
		int show_ind = scan.nextInt();
		Movie movie = Database.movies[show_ind];
		System.out.println("Enter the new Movie Status: ");
		String status = scan.nextLine();
		Database.movie.setStatus(status);
		scan.close();
		System.out.println("Movie Status has been updated.");
	}

	/**
	 * Adding a Show class to the MovieListing class.
	 */
	public void addShow() {
		Database.showListing.createShow();
		System.out.println("The Show has been successfully created.");
	}

	/**
	 * Removing a Show from the MovieListing.
	 */
	public void deleteShow() {
		Database.showListing.deleteShow();
		System.out.println("The Show has been deleted");
	}

	/**
	 * Updating attributes of a Show
	 */
	public void updateShow() {
		Database.showListing.updateShow();
		System.out.println("The Show has been udpated.");
	}

	/**
	 * Editing/Setting a base ticket price.
	 */
	public void setTicketPrice() {
		Scanner scan = new Scanner(System.in);
		Database.showListing.displayShows();
		System.out.println("Please input the index of the show you wish to set the price of:");
		int show_ind = scan.nextInt();
		System.out.println("Enter the Ticket Price: ");
		double ticketPrice = scan.nextDouble(); // where to store the base ticket price?
		Show show = Database.showListing.shows.get(show_ind);
		show.setPrice(ticketPrice);
		scan.close();
		System.out.println("Ticket Price has been updated.");
	}

}