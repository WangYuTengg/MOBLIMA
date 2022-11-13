package controller;

import java.util.*;

import data.Database;
import model.Cinema;
import model.Cineplex;
import model.Movie;
import model.Show;

import java.text.*;

/**
 * A class to represent all the shows.
 * 
 * @version 3.0
 * @author Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong
 *         Jian
 * @since 2022-10-30
 */
public class ShowListing implements java.io.Serializable {
	/**
	 * A static scanner used throughout Show Listing.
	 */
	static private Scanner in = new Scanner(System.in);

	/**
	 * Instantiates an ArrayList of Show type.
	 */
	private ArrayList<Show> shows = new ArrayList<>();

	/**
	 * The number of shows in Show Listing.
	 */
	private int len = 0;

	/**
	 * Sorts the movies by rating.
	 */
	public void sortbyRating() {
		for (int i = 0; i < this.shows.size() - 1; ++i)
			for (int j = 0; j < this.shows.size() - 1 - i; ++j)
				if (this.shows.get(j).getMovie().getOverallRating() < this.shows.get(j + 1).getMovie()
						.getOverallRating()) {
					Show temp = this.shows.get(j);
					this.shows.set(j, this.shows.get(j + 1));
					this.shows.set(j + 1, temp);
				}
	}

	/**
	 * Sorts the movies by sales volume.
	 */
	public void sortbySales() {
		for (int i = 0; i < this.shows.size() - 1; ++i)
			for (int j = 0; j < this.shows.size() - 1 - i; ++j)
				if (this.shows.get(j).getMovie().getTotalSales() < this.shows.get(j + 1).getMovie().getTotalSales()) {
					Show temp = this.shows.get(j);
					this.shows.set(j, this.shows.get(j + 1));
					this.shows.set(j + 1, temp);
				}
	}

	/**
	 * Sorts the movies by show time.
	 */
	public void sortbyShowTime() {
		for (int i = 0; i < this.shows.size() - 1; ++i)
			for (int j = i; j < this.shows.size() - 1; ++j)
				if (this.shows.get(j).getShowTime().after(this.shows.get(j + 1).getShowTime())) {
					Show temp = this.shows.get(j);
					this.shows.set(j, this.shows.get(j + 1));
					this.shows.set(j + 1, temp);
				}
	}

	/**
	 * Sorts the shows by Movie name.
	 */
	public void sortbyMovieName() {
		for (int i = 0; i < this.shows.size() - 1; ++i)
			for (int j = i; j < this.shows.size() - 1; ++j)
				if (this.shows.get(j).getMovie().getTitle()
						.compareTo(this.shows.get(j + 1).getMovie().getTitle()) > 0) {
					Show temp = this.shows.get(j);
					this.shows.set(j, this.shows.get(j + 1));
					this.shows.set(j + 1, temp);
				}
	}

	/**
	 * Displays all shows.
	 */
	public void displayShows() {
		System.out.printf("%10s%40s%25s%10s%20s\n", "Index", "Movie Title", "Cineplex", "Cinema", "Time");
		for (int i = 0; i < this.shows.size(); ++i) {
			System.out.printf("%10d", i + 1);
			this.shows.get(i).display();
		}
	}

	/**
	 * Displays a number of shows determined by lim.
	 * 
	 * @param lim The number of shows to be displayed.
	 */
	public void displayShows(int lim) {
		System.out.printf("%10s%40s%25s%10s%20s\n", "Index", "Movie Title", "Cineplex", "Cinema", "Time");
		for (int i = 0; i < lim; ++i) {
			System.out.printf("%10d", i + 1);
			this.shows.get(i).display();
		}
	}

	/**
	 * Returns the length of the Show Listing.
	 * 
	 * @return Length of the Show Listing.
	 */
	public int length() {
		return len;
	}

	/**
	 * Adds a show to the Show Listing.
	 * 
	 * @param show Show to be added.
	 */
	public void addShow(Show show) {
		shows.add(show);
		len++;
	}

	/**
	 * Lists the top 5 movies based on rating.
	 */
	public void listTop5byRating() {
		sortbyRating();
		displayShows(5);
	}

	/**
	 * Lists the top 5 movies based on sales.
	 */
	public void listTop5bySales() {
		sortbySales();
		displayShows(5);
	}

	/**
	 * Creates an instance of a Show.
	 * 
	 * @param db The database.
	 * @throws ParseException Throws an exception when the date and showtime are entered incorrectly.
	 */
	public void createShow(Database db) throws ParseException {

		in = new Scanner(System.in);
		Movie[] movies = new Movie[db.movieListing.getMovies().size()];
		movies = db.movieListing.getMovies().toArray(movies);

		//display list of movieas
		for (int i = 0; i < movies.length; i++) {
			System.out.printf("%d. Movie Name: %s\n", i + 1, movies[i].getTitle());
		}
		System.out.printf("Choose Movie Index: ");

		// check for integer input
		while(!in.hasNextInt()){
			System.out.printf("Please choose a valid movie index (integer): ");
			in.next();
		}
		int movie_ind = in.nextInt();

		// check for valid index
		if(movie_ind <= 0 || movie_ind > movies.length){
			System.out.println("Invalid index entered. Returning to previous menu...");
			return;
		}

		Cineplex cineplex[] = new Cineplex[db.cineplexes.size()];
		cineplex = db.cineplexes.toArray(cineplex);

		// choose cineplex
		System.out.printf("Choose a Cineplex index: \n");
		for (int i = 0; i < cineplex.length; i++) {
			System.out.printf("%d. Cineplex Name: %s\n", i + 1, cineplex[i].getName());
		}

		// check for integer input
		while(!in.hasNextInt()){
			System.out.printf("Please enter a valid cineplex index: ");
			in.next();
		}
		int cineplex_ind = in.nextInt();

		// check for valid cineplex index
		if(cineplex_ind <= 0 || cineplex_ind > cineplex.length) {
			System.out.println("Invalid cineplex index entered. Returning to main menu...");
			return;
		}

		// check for integer input
		System.out.printf("Enter Cinema Number (1 - %d): ", cineplex[cineplex_ind].getCinemaList().length);
		while(!in.hasNextInt()){
			System.out.printf("Please enter a valid cinema number:  ");
			in.next();
		}
		int cinema_ind = in.nextInt();

		// check for valid cinema number
		if (cinema_ind <= 0 || cinema_ind > cineplex[cineplex_ind].getCinemaList().length){
			System.out.println("Invalid cinema number chosen. Returning to main menu...");
			return;
		}

		in.nextLine();
		System.out.println("Is the Show going to be in 3D? (true or false):");
		boolean is3D;
		String input = in.nextLine();

		// Error checking for is3D
		while (input.equals("true") == false && input.equals("false") == false) {
			System.out.println("Invalid Input. Please re-enter.\nIs the movie a 3D movie? (true or false)");
			input = in.nextLine();
		}
		is3D = Boolean.parseBoolean(input);
		System.out.println("Enter Show time (e.g. 2021-04-20 23:00):");
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:m");
		boolean isCorrect = false;
		Calendar calendar = Calendar.getInstance();
		calendar.set(0, 0, 0, 0, 0); // to initialise
		Date showtime = calendar.getTime();
		while (!isCorrect) {
			try {
				showtime = ft.parse(in.nextLine());
				isCorrect = true;
			} catch (Exception e) {
				System.out.println("Invalid input\nPlease re-enter the Show time (e.g. 2021-04-20 23:00):");
			}
		}
		shows.add(new Show(new Cinema((cineplex[cineplex_ind - 1].getCinemaList())[cinema_ind - 1]), movies[movie_ind - 1],
				cineplex[cineplex_ind], is3D, showtime));
		len++;
		System.out.println("Show successfully created!");
	}

	/**
	 * Deletes a show.
	 */
	public void deleteShow() {
		in = new Scanner(System.in);
		System.out.println("||----- Display Shows -----||");
		this.displayShows();
		System.out.println("Enter Show Index to remove: (-1 to return)");

		//check for integer input
		while(!in.hasNextInt()){
			System.out.printf("Please enter a valid show index: ");
			in.next();
		}
		int show_id = in.nextInt();

		//exit key
		if (show_id == -1) {
			System.out.println("Returning");
			return;
		}

		//check for valid show index
		if (show_id < -1 || show_id == 0 || show_id > shows.size()){
			System.out.println("Invalid show index entered. Returning to main menu...");
			return;
		}

		//remove show from shows
		shows.remove(show_id - 1);
		len--;
		System.out.println("Show successfully deleted!");
	}

	/**
	 * Updates a Show.
	 * 
	 * @param show_ind Index of the show to be updated.
	 * @param db       The database.
	 * @throws ParseException Throws an exception when the date and show time are added incorrectly.
	 */
	public void updateShow(int show_ind, Database db) throws ParseException {
		in = new Scanner(System.in);
		String choice;
		boolean exit = false;
		Show show = shows.get(show_ind);
		do {
			System.out.printf("Choose Action:\n" + "1. Update Cinema\n" + "2. Update Movie\n" + "3. Update Show time\n"
					+ "4. Update is3D\n" + "5. Exit\n");
			choice = in.next();
			switch (choice) {
				case "1":
					System.out.println("Enter Cinema Number");
					int cinema_ind = in.nextInt();
					show.setCinema(show.getCineplex().getCinemaList()[cinema_ind - 1]);
					System.out.println("Cinema Update successfully!");
					break;
				case "2":
					Movie[] movies = new Movie[db.movieListing.getMovies().size()];
					movies = db.movieListing.getMovies().toArray(movies);
					for (int i = 0; i < movies.length; i++) {
						System.out.printf("%d. Movie Name: %s\n", i + 1, movies[i].getTitle());
					}
					System.out.println("Choose Movie Index");
					int movie_ind = in.nextInt();
					show.setMovie(movies[movie_ind - 1]);
					System.out.println("Movie Update successfully!");
					break;
				case "3":
					in.nextLine();
					System.out.println("Enter Show time (e.g. 2021-04-20 23:00):");
					SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:m");
					boolean isCorrect = false;
					Calendar calendar = Calendar.getInstance();
					calendar.set(0, 0, 0, 0, 0); // to initialise
					Date showtime = calendar.getTime();
					while (!isCorrect) {
						try {
							showtime = ft.parse(in.nextLine());
							isCorrect = true;
						} catch (Exception e) {
							System.out.println("Invalid input\nPlease re-enter the Show time (e.g. 2021-04-20 23:00):");
						}
					}
					show.setShowTime(showtime);
					System.out.println("Show time updated succesfully");
					break;
				case "4":
					in.nextLine();
					System.out.println("Is the Show going to be in 3D? (true or false):");
					boolean is3D;
					String input = in.nextLine();

					// Error checking for is3D
					while (input.equals("true") == false && input.equals("false") == false) {
						System.out.println("Invalid Input. Please re-enter.\nIs the movie a 3D movie? (true or false)");
						input = in.nextLine();
					}
					is3D = Boolean.parseBoolean(input);
					show.set3D(is3D);
					break;
				case "5":
					System.out.println("Exiting...");
					exit = true;
					break;
				default:
					System.out.println("Invalid input, please try again.");
			}
		} while (!exit);
	}

	/**
	 * To get the ArrayList of Shows.
	 * 
	 * @return An arraylist of all the shows.
	 */
	public ArrayList<Show> getShows() {
		return shows;
	}
}
