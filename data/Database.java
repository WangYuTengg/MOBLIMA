package data;
import java.util.ArrayList;

import controller.BookingSystem;
import controller.MovieGoer;
import controller.MovieListing;
import controller.ShowListing;
import controller.Staff;
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
	 * Instantiates all the prices and multipliers used during payment.
	 */
	public Payment payment = new Payment();
	
	/**
	 * Creates a new database.
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
	 * Construct a new database with the following parameters:
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
	 * A function to add a new cineplex into the database.
	 * @param newCineplex The new cineplex to be added.
	 */
	public void addCineplex(Cineplex newCineplex) {
		cineplexes.add(newCineplex);
	}

	/**
	 * A function to remove a target cineplex from the database.
	 * @param cineplexToRemove	The cineplex to be removed.
	 */
	public void removeCineplex(Cineplex cineplexToRemove) {
		cineplexes.remove(cineplexes.indexOf(cineplexToRemove));
	}

	/**
	 * A function to check whether a target cineplex is already in the database.
	 * @param cineplexName	The name of the cineplex.
	 * @return The cineplex if found, else null.
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
	 * A function to add a new movie goer into the database.
	 * @param newMovieGoer	The new movie goer to be added. 
	 */
	public void addMovieGoer(MovieGoer newMovieGoer) {
		movieGoers.add(newMovieGoer);
	}

	/**
	 * A function to remove a target movie goer from the database.
	 * @param movieGoerToRemove The movie goer to be removed.
	 */
	public void removeMovieGoer(MovieGoer movieGoerToRemove) {
		movieGoers.remove(movieGoers.indexOf(movieGoerToRemove));
	}

	/**
	 * A function to get fetch the movie goer from the database using user email.
	 * @param userEmail The user's email.
	 * @return The target Movie Goer.
	 */
	public MovieGoer getMovieGoer(String userEmail) {
		MovieGoer targetMovieGoer;
		for (MovieGoer user : movieGoers) {
			if (userEmail.compareTo(user.getEmail()) == 0) {
				targetMovieGoer = user;
				return targetMovieGoer;
			}
		}
		return null;
	}

	/**
	 * A function to add a new staff member into the database.
	 * @param newStaff A new staff member to be added.
	 */
	public void addStaff(Staff newStaff) {
		staffs.add(newStaff);
	}

	/**
	 * A function to remove a target staff from the database.
	 * @param staffToRemove	The staff to be removed from the database.
	 */
	public void removeStaff(Staff staffToRemove) {
		staffs.remove(staffs.indexOf(staffToRemove));
	}

	/**
	 * A function to fetch a staff member from the database using their email.
	 * @param adminEmail The email of the staff member.
	 * @return The staff member.
	 */
	public Staff getStaff(String adminEmail) {
		Staff targetStaff;
		for (Staff staff : staffs) {
			if (adminEmail.compareTo(staff.getEmail()) == 0) {
				targetStaff = staff;
				return targetStaff;
			}
		}
		return null;
	}

}
