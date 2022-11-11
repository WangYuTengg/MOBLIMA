package controller;

import java.util.*;
import model.*;

public class BookingSystem {
	private ShowListing showListing;
	private static Scanner in = new Scanner(System.in);
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
		for (int j = 0; j < column; j++) {
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
	public Ticket[] book(int id) throws InvalidIdException, ExitException, InputMismatchException{
		Movie[] movies =  new Movie[Database.movieListing.getMovies().size()];
	    	movies = Database.movieListing.getMovies().toArray(movies);
		int movie_ind;
		boolean flag1;
		do
		{
			flag1 = true;
			Database.movieListing.listMovies();
			System.out.println("Choose Movie Index");
			movie_ind = in.nextInt() - 1;
			if(movie_ind >= movies.length || movie_ind < 0) 
			{
				throw new InvalidIdException("Invalid Movie index. Returning to Movie Goer Menu...");
			}
			else if(!movies[movie_ind].getStatus().equals("NOW_SHOWING"))
			{
				System.out.println("Movie currently not in cinemas. Choose another movie!");
				flag1 = false;
			}
		}while(flag1 == false);
		String movie_name = movies[movie_ind].getTitle();
		Cineplex cineplex[] = new Cineplex[Database.cineplexes.size()];
		cineplex = Database.cineplexes.toArray(cineplex);
		Show[] shows = new Show[showListing.getShows().size()];
		shows =	showListing.getShows().toArray(shows);
		int show_length = showListing.length();
		for (int i = 0; i < cineplex.length; i++) 
		{
			for(int j = 0; j < show_length; j++)
			{
				if(shows[j].getMovie().getTitle() == movie_name && shows[i].getCineplex().getName() == cineplex[i].getName())
				{
					System.out.printf("%d. Cineplex Name: %s\n", i + 1, cineplex[i].getName());
					break;
				}
			}
		}
		System.out.println("Choose Cinplex Index");
		int cineplex_ind = in.nextInt() - 1;
		for(int i = 0; i < show_length; i++)
		{
			flag1 = false;
			if(shows[i].getMovie().getTitle() == movie_name && shows[i].getCineplex().getName() == cineplex[cineplex_ind].getName())
			{
				flag1 = true;
				break;
			}	
		}
		if(flag1 == false)
		{
			throw new InvalidIdException("Incorrect Cineplex ID. Returning to Movie Goer Menu...");
		}
		String cineplex_name = cineplex[cineplex_ind].getName();
		for (int i = 0; i < show_length; i++) {
			if (movie_name.equals(shows[i].getMovie().getTitle())
					&& cineplex_name.equals(shows[i].getCineplex().getName())) {
				System.out.printf("index: %d, Movie Name: %s, Cineplex Name: %s, Showtime: %s\n", i + 1, movie_name,
						cineplex_name, shows[i].getShowTime());
			}
		}
		System.out.println("Choose Show Index");
		int show_index = in.nextInt() - 1;
		if(!shows[show_index].getMovie().getTitle().equals(movie_name) || !shows[show_index].getCineplex().getName().equals(cineplex_name)) 
			throw new InvalidIdException("Incorrect Show Index. Returning to movie goer menu...");
		displayLayout(shows[show_index]);
		System.out.println("Enter the number of seats required");
		int num_seats = in.nextInt();
		String seat_index[] = new String[num_seats];
		Ticket ticket[] = new Ticket[num_seats];
		System.out.printf("Enter the index of the ticket category:\n"
				+ "1. Standard\n"
				+ "2. Student\n"
				+ "3. Senior\n");
		MoviegoerType mType = MoviegoerType.STANDARD;
		switch(in.nextInt())
		{
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
		for (int i = 0; i < num_seats; i++) {
			System.out.println("Please input the seat that you want (e.g. 3E):");
			seat_index[i] = in.next();
			price += Payment.calPrice(shows[show_index], mType);
		}
		String confirm;
		do 
		{
			System.out.printf("Your chosen seats: ");
			for (int i = 0; i < num_seats; i++)
			{
				System.out.printf("%s ", seat_index[i]);
			}
			System.out.printf("\nConfirm Seats?(Yes/No)\n");
			confirm = in.nextLine();
			if(confirm.equalsIgnoreCase("No"))
			{
				throw new ExitException("Cancelling order and returning to Movie goer Menu...");
			}
		}while(!confirm.equalsIgnoreCase("Yes") && !confirm.equalsIgnoreCase("No"));
		System.out.printf("The total price of the tickets is: %.2f\n", price);
		String TID = Payment.generateTID(shows[show_index].getCinema());
		System.out.println("Payment Successful! Transaction ID: " + TID);
		for (int i = 0; i < num_seats; i++) {
			ticket[i] = shows[show_index].createTicket(seat_index[i], TID);
		}
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
		int ind = in.nextInt();
		// validating movie index
		if (ind >= 1 || ind <= len) {
			movies[ind - 1].display();
		} else
			System.out.println("Index out of bound");
	}

}

