
package controller;

import java.util.*;
import data.Database;
import model.*;

/**
 * The Booking System class.
 * 
 * @version 3.0
 * @author Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong
 *         Jian
 * @since 2022-10-30
 */
public class BookingSystem implements java.io.Serializable {

	/**
	 * A static Scanner to be used in Booking System
	 */
	private static Scanner in = new Scanner(System.in);

	/**
	 * Show Listing.
	 */
	private ShowListing showListing;

	/**
	 * An instantiation of Booking System.
	 * 
	 * @param showListing The Show Listing used in this class.
	 */
	public BookingSystem(ShowListing showListing) {
		this.showListing = showListing;
	}

	/**
	 * Returns the Show Listing.
	 * 
	 * @return Returns the show listing.
	 */
	public ShowListing getShowlisting() {
		return this.showListing;
	}

	/**
	 * Displays the layout of the Cinema.
	 * 
	 * @param show The show to be displayed.
	 */
	public void displayLayout(Show show) {
		Cinema cinema = show.getCinema();
		int row = cinema.getLayoutRowLength();
		int column = cinema.getLayoutColumnLength();
		Seat layout[][] = cinema.getSeats();
		System.out.printf("O: Available seats\nX: Occupied seats\n");
		System.out.printf(" \t");
		for (int j = 0; j < column; j++) {
			if (j == (column / 5) || j == column - (column / 5))
				System.out.print("     ");
			System.out.printf("%c ", j + 'A');
		}
		System.out.println();
		for (int i = 0; i < row; i++) {
			System.out.printf("%d\t", i + 1);
			for (int j = 0; j < column; j++) {
				if (j == (column / 5) || j == column - (column / 5))
					System.out.print("|  | ");
				if (layout[i][j].isOccupied() == false)
					if (layout[i][j].isElite())
						System.out.print("E ");
					else
						System.out.print("O ");
				else
					System.out.print("X ");
			}
			System.out.println();
		}
	}

	/**
	 * A function for Movie Goers to book tickets.
	 * 
	 * @param id The ID of the MovieGoer.
	 * @param db The database.
	 * @return An array of tickets.
	 * @throws exception.InvalidIdException An exception for invalid ID.
	 * @throws exception.ExitException      An excpetion for when cancelling the
	 *                                      booking of tickets.
	 * @throws InputMismatchException       An exception for wrong type for inputs.
	 */
	public Ticket[] book(int id, Database db)
			throws exception.InvalidIdException, exception.ExitException, InputMismatchException {
		in = new Scanner(System.in);
		Movie[] movies = new Movie[db.movieListing.getMovies().size()];
		movies = db.movieListing.getMovies().toArray(movies);
		int movie_ind;
		boolean flag1;
		do {
			flag1 = true;
			for (int i = 0; i < movies.length; i++) {
				if (movies[i].getStatus().equals("END_OF_SHOWING") || movies[i].getStatus().equals("COMING_SOON"))
					continue;
				System.out.printf("%d. %s, STATUS: %s\n", i + 1, movies[i].getTitle(), movies[i].getStatus());
			}
			System.out.printf("Choose Movie Index:  ");
			movie_ind = in.nextInt() - 1;
			if (movie_ind >= movies.length || movie_ind < 0) {
				throw new exception.InvalidIdException("Invalid Movie index. Returning to Movie Goer Menu...");
			} else if (!(movies[movie_ind].getStatus().equals("NOW_SHOWING"))
					&& !(movies[movie_ind].getStatus().equals("PREVIEW"))) {
				System.out.println("Movie currently not in cinemas. Choose another movie!");
				flag1 = false;
			}
		} while (flag1 == false);
		String movie_name = movies[movie_ind].getTitle();
		Cineplex cineplex[] = new Cineplex[db.cineplexes.size()];
		cineplex = db.cineplexes.toArray(cineplex);
		Show[] shows = new Show[showListing.getShows().size()];
		shows = showListing.getShows().toArray(shows);
		int show_length = showListing.length();
		for (int i = 0; i < cineplex.length; i++) {
			for (int j = 0; j < show_length; j++) {
				if (shows[j].getMovie().getTitle() == movie_name
						&& shows[j].getCineplex().getName() == cineplex[i].getName()) {
					System.out.printf("%d. Cineplex Name: %s\n", i + 1, cineplex[i].getName());
					break;
				}
			}
		}
		System.out.printf("Choose Ciniplex Index: ");
		int cineplex_ind = in.nextInt() - 1;
		for (int i = 0; i < show_length; i++) {
			flag1 = false;
			if (shows[i].getMovie().getTitle() == movie_name
					&& shows[i].getCineplex().getName() == cineplex[cineplex_ind].getName()) {
				flag1 = true;
				break;
			}
		}
		if (flag1 == false) {
			throw new exception.InvalidIdException("Incorrect Cineplex ID. Returning to Movie Goer Menu...");
		}
		String cineplex_name = cineplex[cineplex_ind].getName();
		for (int i = 0; i < show_length; i++) {
			if (movie_name.equals(shows[i].getMovie().getTitle())
					&& cineplex_name.equals(shows[i].getCineplex().getName())) {
				String value3d;
				String valuePlat;
				if (shows[i].is3D())
					value3d = "Yes";
				else
					value3d = "No";
				if (shows[i].getCinema().getType())
					valuePlat = "Platinum";
				else
					valuePlat = "Ordinary";
				System.out.printf(
						"index: %d, Movie Name: %s, Cineplex Name: %s, 3D: %s, Cinema Type: %s, Showtime: %s\n", i + 1,
						movie_name,
						cineplex_name, value3d, valuePlat, shows[i].getShowTime());
			}
		}
		System.out.println("Choose Show Index");
		int show_index = in.nextInt() - 1;
		if (!shows[show_index].getMovie().getTitle().equals(movie_name)
				|| !shows[show_index].getCineplex().getName().equals(cineplex_name))
			throw new exception.InvalidIdException("Incorrect Show Index. Returning to movie goer menu...");
		displayLayout(shows[show_index]);
		System.out.println("Enter the number of seats required");
		int num_seats = in.nextInt();
		while (num_seats <= 0) {
			System.out.println("Invalid Input.\nPlease re-enter the number of seats required:");
			num_seats = in.nextInt();
		}
		String seat_index[] = new String[num_seats];
		Ticket ticket[] = new Ticket[num_seats];
		System.out.printf("Enter the index of the ticket category:\n"
				+ "1. Standard\n"
				+ "2. Student (Discount only applicable on Mon-Thu before 6pm)\n"
				+ "3. Senior (Discount only applicable on Mon-Thu before 6pm)\n");
		MoviegoerType mType = MoviegoerType.STANDARD;
		switch (in.nextInt()) {
			case 1:
				mType = MoviegoerType.STANDARD;
				break;
			case 2:
				mType = MoviegoerType.STUDENT;
				break;
			case 3:
				mType = MoviegoerType.SENIOR;
				break;
		}
		double price = 0;
		int cnt = 0;
		while (cnt < num_seats) {
			System.out.printf("Please input the No.%d seat index that you want(e.g. 3E):\n", cnt + 1);
			seat_index[cnt] = in.next();
			if (shows[show_index].checkOccupied(seat_index[cnt])) {
				System.out.printf("Seat already choosen!\n");
				continue;
			}
			price += db.payment.calPrice(shows[show_index], seat_index[cnt], mType);
			cnt++;
		}
		String confirm;
		in.nextLine();
		do {
			System.out.printf("Your chosen seats: ");
			for (int i = 0; i < num_seats; i++) {
				System.out.printf("%s ", seat_index[i]);
			}
			System.out.printf("\nThe total price of the tickets is: %.2f\n", price);
			System.out.printf("Confirm transaction?(Yes/No)\n");
			confirm = in.nextLine();
			if (confirm.equalsIgnoreCase("No")) {
				throw new exception.ExitException("Cancelling order and returning to Movie goer Menu...");
			}
		} while (!confirm.equalsIgnoreCase("Yes") && !confirm.equalsIgnoreCase("No"));
		do {
			System.out.printf("Payment method:\n"
					+ "1.PayNow\n"
					+ "2.Debit/Credit card\n"
					+ "3.PayPal\n"
					+ "4.Loyalty Card(Additional Discount)\n"
					+ "5.Cancel Order\n");
			int choice = in.nextInt();
			if (choice < 1 || choice > 5) {
				System.out.println("Invalid Choice!");
			} else if (choice > 0 && choice < 4)
				break;
			else if (choice == 5) {
				throw new exception.ExitException("Cancelling order and returning to Movie goer Menu...");
			} else if (choice == 4) {
				int i;
				System.out.printf("Choose the Loyalty card:\n");
				ArrayList<String> loyaltyCards = db.payment.getLoyaltyCards();
				for (i = 0; i < loyaltyCards.size(); i++) {
					System.out.printf("%d. %s\n", i + 1, loyaltyCards.get(i));
				}
				System.out.printf("%d. Go Back\n", i + 1);
				int loyalty_ind = in.nextInt() - 1;
				if (loyalty_ind != i) {
					price = db.payment.discountedPrice(price, loyaltyCards.get(loyalty_ind));
					System.out.printf("The new discounted price is: %.2f\n", price);
					break;
				}
			}
		} while (true);
		String TID = db.payment.generateTID(shows[show_index].getCinema());
		System.out.println("Payment Successful! Transaction ID: " + TID);
		for (int i = 0; i < num_seats; i++) {
			ticket[i] = shows[show_index].createTicket(seat_index[i], TID);
		}
		return ticket;
	}

	/**
	 * Displays the Show Listing.
	 * 
	 * @param movies An array of movies.
	 */
	public void displayshowListing(Movie movies[]) {
		in = new Scanner(System.in);
		int len = movies.length;
		for (int i = 0; i < len; i++) {
			System.out.printf("%d. Movie Name: %s, Status: %s\n", i + 1, movies[i].getTitle(), movies[i].getStatus());
		}
		System.out.println();
		System.out.println("Enter the movie index for more details.");
		int ind = in.nextInt();
		// validating movie index
		if (ind >= 1 || ind <= len) {
			movies[ind - 1].display();
		} else
			System.out.println("Index out of bound");
	}

	/**
	 * Displays a selected show based on index, displaying the Cinema layout.
	 * 
	 * @param db The database.
	 */
	public void displayShowStatus(Database db) {
		in = new Scanner(System.in);
		System.out.println("Displaying all current shows:");
		db.showListing.displayShows();
		System.out.println("Please input the index of the show:");
		int choice = in.nextInt();
		while (choice < 1 || choice > db.showListing.length()) {
			System.out.println("Invalid index.\nPlease input the index of the show:");
			choice = in.nextInt();
		}
		Show show = db.showListing.getShows().get(choice - 1);
		System.out.printf("Displaying status:\nMovie: %s, Cineplex: %s, Cinema: %s, time: %s\n",
				show.getMovie().getTitle(), show.getCineplex().getName(), show.getCinema().getCinemaCode(),
				show.getShowTime());
		db.bookingSystem.displayLayout(show);
	}

}
