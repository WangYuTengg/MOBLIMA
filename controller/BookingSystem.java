package controller;

import java.util.*;
import model.*;

public class BookingSystem {
	private ShowListing showListing;

	public BookingSystem(ShowListing showListing) {
		this.showListing = showListing;
	}

	// display cinema layout
	private void displayLayout(Show show) {
		Cinema cinema = show.getCinema();
		int row = cinema.getLayoutRowLength();
		int column = cinema.getLayoutColumnLength();
		boolean layout[][] = cinema.getLayout();
		System.out.printf("O: Available seats\nX: Occupied seats\n");
		System.out.printf(" \t");
		for (int j = 0; j <= column; j++) {
			System.out.printf("%c ", j + 'A');
		}
		System.out.println();
		for (int i = 0; i < row; i++) {
			System.out.printf("%d\t", i + 1);
			for (int j = 0; j < column; j++) {
				if (layout[i][j] == false)
					System.out.print("O ");
				else
					System.out.print("X ");
			}
			System.out.println();
		}
	}

	// book tickets
	public Ticket[] book(Movie movies[], String id) {
		for (int i = 0; i < movies.length; i++) {
			System.out.printf("%d. Movie Name: %s\n", i + 1, movies[i].getTitle());
		}
		System.out.println("Choose Movie Index");
		Scanner in = new Scanner(System.in);
		int movie_ind = in.nextInt();
		String movie_name = movies[movie_ind - 1].getTitle();
		Cineplex cineplex[] = (Cineplex[]) Database.cineplexes.toArray();
		for (int i = 0; i < cineplex.length; i++) {
			System.out.printf("%d. Cineplex Name: %s\n", i + 1, cineplex[i].getName());
		}
		System.out.println("Choose Cinplex Index");
		int cineplex_ind = in.nextInt();
		String cineplex_name = cineplex[cineplex_ind - 1].getName();
		Show[] shows = (Show[]) showListing.getShows().toArray();
		int show_length = showListing.length();
		for (int i = 0; i < show_length; i++) {
			if (movie_name.equals(shows[i].getMovie().getTitle())
					&& cineplex_name.equals(shows[i].getCineplex().getName())) {
				System.out.printf("index: %d, Movie Name: %s, Cineplex Name: %s, Showtime: %s:%s\n", i + 1, movie_name,
						cineplex_name, shows[i].getShowDate(), shows[i].getShowTime());
			}
		}
		System.out.println("Choose Show Index");
		int show_index = in.nextInt();
		displayLayout(shows[show_index - 1]);
		System.out.println("Enter the number of seats required");
		int num_seats = in.nextInt();
		String seat_index[] = new String[num_seats];
		Ticket ticket[] = new Ticket[num_seats];
		for (int i = 0; i < num_seats; i++) {
			seat_index[i] = in.next();
			ticket[i] = shows[show_index - 1].createTicket(seat_index[i]);
		}
		in.close();
		return ticket;
	}

	// List Movies
	public void displayshowListing(Movie movies[]) {
		int len = movies.length;
		for (int i = 0; i < len; i++) {
			System.out.printf("%d. Movie Name: %s, Status: %s\n", i + 1, movies[i].getTitle(), movies[i].getStatus());
		}
		System.out.println();
		System.out.println("Enter the movie index for more details.");
		Scanner in = new Scanner(System.in);
		int ind = in.nextInt();
		in.close();
		// validating movie index
		if (ind >= 1 || ind <= len) {
			movies[ind - 1].display();
		} else
			System.out.println("Index out of bound");
	}

}