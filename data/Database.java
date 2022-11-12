package data;
import java.util.ArrayList;

import controller.BookingSystem;
import controller.MovieListing;
import controller.ShowListing;
import model.*;

/**
 * Stores all data used.
 * @version  5.0
 * @author   Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong Jian
 * @since    2022-10-30
 */
public class Database implements java.io.Serializable{

	/**
	 * The collection of cineplexes.
	 */
	public ArrayList<Cineplex> cineplexes;

	/**
	 * The storage of movie listing.
	 */
	public MovieListing movieListing;

	/**
	 * The storage of show listing.
	 */
	public ShowListing showListing;

	/**
	 * The storage of booking system.
	 */
	public BookingSystem bookingSystem;

	/**
	 * The collection of movie goers.
	 */
	public ArrayList<MovieGoer> movieGoers;

	/**
	 * The collection of staffs.
	 */
	ArrayList<Staff> staffs;
	
	/**
	 * instantiate payment for displaying of prices
	 */
	public Payment payment = new Payment();
	
	/**
	 * Creates a new database
	 */
	public Database() {
		this.cineplexes = new ArrayList<Cineplex>();
		this.movieListing = new MovieListing();
		this.showListing = new ShowListing();
		this.bookingSystem = new BookingSystem(this.showListing);
		this.movieGoers = new ArrayList<MovieGoer>();
		this.staffs = new ArrayList<Staff>();
	}

	/**
	 * Construct a new database with the following parameters
	 * @param cineplexes		An ArrayList of Cineplexes.
	 * @param movieListing		An ArrayList of Movies.
	 * @param showListing		An ArrayList of Shows.
	 * @param bookingSystem		The Booking System.
	 * @param movieGoers		An ArrayList of Movie Goers.
	 * @param staffs			An ArrayList of Staff members.
	 */
	Database(ArrayList<Cineplex> cineplexes, MovieListing movieListing, ShowListing showListing,
			BookingSystem bookingSystem, ArrayList<MovieGoer> movieGoers, ArrayList<Staff> staffs) {
		this.cineplexes = cineplexes;
		this.movieListing = movieListing;
		this.showListing = showListing;
		this.bookingSystem = new BookingSystem(this.showListing);
		this.movieGoers = movieGoers;
		this.staffs = staffs;
	}

	/**
	 * Function to add a new cineplex into the database
	 * @param newCineplex The new cineplex to be added.
	 * @return void
	 */
	public void addCineplex(Cineplex newCineplex) {
		cineplexes.add(newCineplex);
	}

	/**
	 * Function to remove a target cineplex from the database
	 * @param cineplexToRemove	The cineplex to be removed.
	 * @return void
	 */
	public void removeCineplex(Cineplex cineplexToRemove) {
		cineplexes.remove(cineplexes.indexOf(cineplexToRemove));
	}

	/**
	 * Function to check whether a target cineplex is already in the database
	 * @param cineplexName	The name of the cineplex.
	 * @return Cineplex
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

	/**
	 * Function to add a new movie goer into the database
	 * @param newMovieGoer	The new movie goer to be added. 
	 * @return void
	 */
	public void addMovieGoer(MovieGoer newMovieGoer) {
		movieGoers.add(newMovieGoer);
	}

	/**
	 * Function to remove a target movie goer from the database
	 * @param movieGoerToRemove The movie goer to be removed.
	 * @return void
	 */
	public void removeMovieGoer(MovieGoer movieGoerToRemove) {
		movieGoers.remove(movieGoers.indexOf(movieGoerToRemove));
	}

	/**
	 * Function to get target movie goer in the database using user email
	 * @param userEmail The user's email.
	 * @return MovieGoer
	 */
	public MovieGoer getMovieGoer(String userEmail) {
		MovieGoer targetMovieGoer;
		for (MovieGoer user : movieGoers) {
			if (userEmail.compareTo(user.getUserEmail()) == 0) {
				targetMovieGoer = user;
				return targetMovieGoer;
			}
		}
		return null;
	}

	/**
	 * Function to add a new staff into the database
	 * @param newStaff A new staff member to be added.
	 * @return void
	 */
	public void addStaff(Staff newStaff) {
		staffs.add(newStaff);
	}

	/**
	 * Function to remove a target staff from the database
	 * @param staffToRemove	The staff to be removed from the database.
	 * @return void
	 */
	public void removeStaff(Staff staffToRemove) {
		staffs.remove(staffs.indexOf(staffToRemove));
	}

	/**
	 * Function to get staff in the database using email
	 * @param adminEmail The email of the staff member.
	 * @return Staff
	 */
	public Staff getStaff(String adminEmail) {
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
