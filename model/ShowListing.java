package model;

import java.util.ArrayList;
import java.util.Scanner;

import controller.Database;

public class ShowListing {
	private ArrayList<Show> shows = new ArrayList<>();
	static private int len = 0;

	public void sortbyShowTime() {
		for (int i = 0; i < this.shows.size() - 1; ++i)
			for (int j = i; j < this.shows.size() - 1; ++j)
				if ((this.shows.get(j).getShowDate() + this.shows.get(j).getShowTime())
						.compareTo((this.shows.get(j + 1).getShowDate() + this.shows.get(j + 1).getShowTime())) > 0) {
					Show temp = this.shows.get(j);
					this.shows.set(j, this.shows.get(j + 1));
					this.shows.set(j + 1, temp);
				}
	}

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

	public void displayShows() {
		System.out.printf("%10s%20s%10s%10s%20s%20s\n", "Index", "Movie Title", "Cineplex", "Cinema", "Date", "Time");
		for (int i = 0; i < this.shows.size(); ++i) {
			System.out.printf("%10d", i);
			this.shows.get(i).display();
		}
	}

	public int length() {
		return len;
	}

	public void createShow() {
		Movie movies[] = (Movie[]) Database.movieListing.getMovies().toArray();
		for (int i = 0; i < movies.length; i++) {
			System.out.printf("%d. Movie Name: %s\n", i + 1, movies[i].getTitle());
		}
		System.out.println("Choose Movie Index");
		Scanner in = new Scanner(System.in);
		int movie_ind = in.nextInt();
		Cineplex cineplex[] = (Cineplex[]) Database.cineplexes.toArray();
		for (int i = 0; i < cineplex.length; i++) {
			System.out.printf("%d. Cineplex Name: %s\n", i + 1, cineplex[i].getName());
		}
		System.out.println("Choose Cinplex Index");
		int cineplex_ind = in.nextInt();
		System.out.println("Enter Cinema Number");
		int cinema_ind = in.nextInt();
		System.out.println("Enter Show Date(dd-mm-yyyy)");
		String showdate = in.next();
		System.out.println("Enter Show time(hh:mm)");
		String showtime = in.next();
		System.out.println("Enter ticket price");
		double price = in.nextDouble();
		in.close();
		shows.add(new Show((cineplex[cineplex_ind].getCinemaList())[cinema_ind], movies[movie_ind - 1],
				cineplex[cineplex_ind - 1], showdate, showtime, price));
		len++;
		System.out.println("Show successfully created!");
	}

	public void deleteShow() {
		System.out.println("Enter Show ID");
		Scanner in = new Scanner(System.in);
		int show_id = in.nextInt();
		in.close();
		shows.remove(show_id);
		len--;
		System.out.println("Show successfully deleted!");
	}

	public void updateShow(int show_ind) {
		Scanner in = new Scanner(System.in);
		int choice;
		Show show = shows.get(show_ind);
		do {
			System.out.printf("Choose Action:\n" + "1. Update Cinema\n" + "2. Update Movie\n" + "3. Update Show Date\n"
					+ "4. Update Show time\n" + "5. Update ticket price\n" + "6. Exit\n");
			choice = in.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Cinema Number");
				int cinema_ind = in.nextInt();
				show.setCinema(show.getCineplex().getCinemaList()[cinema_ind]);
				System.out.println("Cinema Update successfully!");
				break;
			case 2:
				Movie movies[] = (Movie[]) Database.movieListing.getMovies().toArray();
				for (int i = 0; i < movies.length; i++) {
					System.out.printf("%d. Movie Name: %s\n", i + 1, movies[i].getTitle());
				}
				System.out.println("Choose Movie Index");
				int movie_ind = in.nextInt();
				show.setMovie(movies[movie_ind]);
				System.out.println("Movie Update successfully!");
				break;
			case 3:
				System.out.println("Enter Show Date(dd-mm-yyyy)");
				String showdate = in.next();
				show.setShowDate(showdate);
				System.out.println("Show date updated succesfully");
				break;
			case 4:
				System.out.println("Enter Show time(hh:mm)");
				String showtime = in.next();
				show.setShowTime(showtime);
				System.out.println("Showtime updated succesfully");
				break;
			case 5:
				System.out.println("Enter ticket price");
				double price = in.nextDouble();
				show.setPrice(price);
				System.out.println("Price updated successfully!");
			}
		} while (choice != 6);
		in.close();
	}

	public ArrayList<Show> getShows() {
		return shows;
	}
}