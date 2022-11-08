package controller;

/**
Stores the whole data.
 @version   1.0
 @author    Ng Yong Jian
 @since     2022-11-01
 */

import java.util.ArrayList;
import model.Cineplex;
import model.MovieGoer;
import model.MovieListing;
import model.ShowListing;
import model.Staff;

public class Database {
	// Attributes
	/**
	 * The collection of cineplexes.
	 */
	public static ArrayList<Cineplex> cineplexes;
	/**
	 * The storage of movie listing.
	 */
	public static MovieListing movieListing;
	/**
	 * The storage of show listing.
	 */
	public static ShowListing showListing;
	/**
	 * The storage of booking system.
	 */
	public static BookingSystem bookingSystem;
	/**
	 * The collection of movie goers.
	 */
	static ArrayList<MovieGoer> movieGoers;
	/**
	 * The collection of staffs.
	 */
	static ArrayList<Staff> staffs;

	// Constructor
	/**
	 * Creates a new database
	 */
	public Database() {
		Database.cineplexes = new ArrayList<Cineplex>();
		Database.movieListing = new MovieListing();
		Database.showListing = new ShowListing();
		Database.bookingSystem = new BookingSystem(Database.showListing);
		Database.movieGoers = new ArrayList<MovieGoer>();
		Database.staffs = new ArrayList<Staff>();
	}

	/**
	 * Construct a new database with the following parameters
	 * 
	 * @param cineplexes
	 * @param movieListing
	 * @param showListing
	 * @param bookingSystem
	 * @param movieGoers
	 * @param staffs
	 */
	Database(ArrayList<Cineplex> cineplexes, MovieListing movieListing, ShowListing showListing,
			BookingSystem bookingSystem, ArrayList<MovieGoer> movieGoers, ArrayList<Staff> staffs) {
		Database.cineplexes = new ArrayList<Cineplex>();
		Database.movieListing = new MovieListing();
		Database.showListing = new ShowListing();
		Database.bookingSystem = new BookingSystem(Database.showListing);
		Database.movieGoers = new ArrayList<MovieGoer>();
		Database.staffs = new ArrayList<Staff>();
	}

	// Methods
	// Functionalities
	/*
	 * Function to add a new cineplex into the database
	 * 
	 * @returns void
	 */
	public void addCineplex(Cineplex newCineplex) {
		cineplexes.add(newCineplex);
	}

	/*
	 * Function to remove a target cineplex from the database
	 * 
	 * @returns void
	 */
	public void removeCineplex(Cineplex cineplexToRemove) {
		cineplexes.remove(cineplexes.indexOf(cineplexToRemove));
	}

	/*
	 * Function to check whether a target cineplex is already in the database
	 * 
	 * @returns Cineplex
	 */
	public Cineplex getCineplex(String cineplexName) {
		Cineplex targetCineplex;
		for (Cineplex i : cineplexes) {
			if (cineplexName.compareTo(i.getName()) == 0) {
				targetCineplex = i;
				return targetCineplex;
			}
		}
		return null;
	}

	/*
	 * Function to add a new movie goer into the database
	 * 
	 * @returns void
	 */
	public void addMovieGoer(MovieGoer newMovieGoer) {
		movieGoers.add(newMovieGoer);
	}

	/*
	 * Function to remove a target movie goer from the database
	 * 
	 * @returns void
	 */
	public void removeMovieGoer(MovieGoer movieGoerToRemove) {
		movieGoers.remove(movieGoers.indexOf(movieGoerToRemove));
	}

	/*
	 * Function to get target movie goer in the database using user email
	 * 
	 * @returns MovieGoer
	 */
	public static MovieGoer getMovieGoer(String userEmail) {
		MovieGoer targetMovieGoer;
		for (MovieGoer user : movieGoers) {
			if (userEmail.compareTo(user.getUserEmail()) == 0) {
				targetMovieGoer = user;
				return targetMovieGoer;
			}
		}
		return null;
	}

	/*
	 * Function to add a new staff into the database
	 * 
	 * @returns void
	 */
	public void addStaff(Staff newStaff) {
		staffs.add(newStaff);
	}

	/*
	 * Function to remove a target staff from the database
	 * 
	 * @returns void
	 */
	public void removeStaff(Staff staffToRemove) {
		staffs.remove(staffs.indexOf(staffToRemove));
	}

	/*
	 * Function to get staff in the database using email
	 * 
	 * @returns Staff
	 */
	public static Staff getStaff(String adminEmail) {
		Staff targetStaff;
		for (Staff staff : staffs) {
			if (adminEmail.compareTo(staff.getAdminEmail()) == 0) {
				targetStaff = staff;
				return targetStaff;
			}
		}
		return null;
	}

}
