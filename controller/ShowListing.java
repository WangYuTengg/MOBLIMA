/**	A class to represent all the shows.
 * @version  3.0
 * @author   Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong Jian
 * @since    2022-10-30
 */
package controller;

import java.util.*;

import data.Database;
import model.Cinema;
import model.Cineplex;
import model.Movie;
import model.Show;

import java.text.*;

public class ShowListing implements java.io.Serializable{
	/**
	 * Instantiates an ArrayList of Show type.
	 */
	private ArrayList<Show> shows = new ArrayList<>();

	/**
	 * The number of shows in Show Listing.
	 */
	private int len = 0;

	/**
	 * A static scanner used throughout Show Listing.
	 */
	static private Scanner in = new Scanner(System.in);

	/**
	 * Sorts the movies by rating.
	 */
	public void sortbyRating() {
		for (int i = 0; i < this.shows.size() - 1; ++i)
			for (int j = 0; j < this.shows.size() - 1-i; ++j)
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
			for (int j = 0; j < this.shows.size() - 1-i; ++j)
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
			System.out.printf("%10d", i+1);
			this.shows.get(i).display();
		}
	}

	/**
	 * Displays a number of shows determined by lim.
	 * @param lim	The number of shows to be displayed.
	 */
	public void displayShows(int lim) {
		System.out.printf("%10s%40s%25s%10s%20s\n", "Index", "Movie Title", "Cineplex", "Cinema", "Time");
		for (int i = 0; i < lim; ++i) {
			System.out.printf("%10d", i+1);
			this.shows.get(i).display();
		}
	}

	/**
	 * Returns the length of the Show Listing.
	 * @return	Length of the Show Listing.
	 */
	public int length() {
		return len;
	}

	/**
	 * Adds a show to the Show Listing.
	 * @param show	Show to be added.
	 */
	public void addShow(Show show){
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
	 * @param db				Database
	 * @throws ParseException
	 */
	public void createShow(Database db) throws ParseException {
		Movie[] movies =  new Movie[db.movieListing.getMovies().size()];
	    movies = db.movieListing.getMovies().toArray(movies);
		for (int i = 0; i < movies.length; i++) {
			System.out.printf("%d. Movie Name: %s\n", i + 1, movies[i].getTitle());
		}
		System.out.println("Choose Movie Index:");
		int movie_ind = in.nextInt();
		Cineplex cineplex[] = new Cineplex[db.cineplexes.size()];
		cineplex = db.cineplexes.toArray(cineplex);
		System.out.println("Choose a Cineplex index:");
		for (int i = 0; i < cineplex.length; i++) {
			System.out.printf("%d. Cineplex Name: %s\n", i + 1, cineplex[i].getName());
		}
		int cineplex_ind = in.nextInt()-1;
		System.out.printf("Enter Cinema Number (1 - %d):", cineplex[cineplex_ind].getCinemaList().length);
		int cinema_ind = in.nextInt();
		in.nextLine();
		System.out.println("Is the Show going to be in 3D? (true or false):");
		boolean is3D;
		String input = in.nextLine();

		//Error checking for is3D
		while (input.equals("true") == false && input.equals("false") == false){
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
		
		shows.add(new Show(new Cinema((cineplex[cineplex_ind].getCinemaList())[cinema_ind-1]), movies[movie_ind - 1],
				cineplex[cineplex_ind], is3D, showtime));
		len++;
		System.out.println("Show successfully created!");
	}

	/**
	 * 	Deletes a show.
	 */
	public void deleteShow() {
		System.out.println("||----- Display Shows -----||");
		this.displayShows();
		System.out.println("Enter Show Index to remove:");
		int show_id = in.nextInt();
		shows.remove(show_id-1);
		len--;
		System.out.println("Show successfully deleted!");
	}

	/**
	 * Updates a Show.
	 * @param show_ind			Index of the show to be updated.
	 * @param db				Database
	 * @throws ParseException
	 */
	public void updateShow(int show_ind, Database db) throws ParseException {
		int choice;
		Show show = shows.get(show_ind);
		do {
			System.out.printf("Choose Action:\n" + "1. Update Cinema\n" + "2. Update Movie\n" + "3. Update Show time\n"
					 + "4. Update is3D\n" + "5. Exit\n");
			choice = in.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Cinema Number");
				int cinema_ind = in.nextInt();
				show.setCinema(show.getCineplex().getCinemaList()[cinema_ind-1]);
				System.out.println("Cinema Update successfully!");
				break;
			case 2:
				Movie[] movies =  new Movie[db.movieListing.getMovies().size()];
			    movies = db.movieListing.getMovies().toArray(movies);
				for (int i = 0; i < movies.length; i++) {
					System.out.printf("%d. Movie Name: %s\n", i + 1, movies[i].getTitle());
				}
				System.out.println("Choose Movie Index");
				int movie_ind = in.nextInt();
				show.setMovie(movies[movie_ind-1]);
				System.out.println("Movie Update successfully!");
				break;
			case 3:
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
			case 4: 
				in.nextLine();
				System.out.println("Is the Show going to be in 3D? (true or false):");
				boolean is3D;
				String input = in.nextLine();
		
				//Error checking for is3D
				while (input.equals("true") == false && input.equals("false") == false){
					System.out.println("Invalid Input. Please re-enter.\nIs the movie a 3D movie? (true or false)");
					input = in.nextLine();
				}
				is3D = Boolean.parseBoolean(input);
				show.set3D(is3D);
				break;	
			}
		} while (choice != 5);
	}

	public ArrayList<Show> getShows() {
		return shows;
	}
}

