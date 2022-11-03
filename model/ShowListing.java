package model;

import java.util.*;

import controller.Database;

import java.text.*;

public class ShowListing {
	private ArrayList<Show> shows = new ArrayList<>();
	static private int len = 0;

	public void sortbyRating() {
		for (int i = 0; i < this.shows.size() - 1; ++i)
			for (int j = i; j < this.shows.size() - 1; ++j)
				if (this.shows.get(j).getMovie().getOverallRating() < this.shows.get(j + 1).getMovie()
						.getOverallRating()) {
					Show temp = this.shows.get(j);
					this.shows.set(j, this.shows.get(j + 1));
					this.shows.set(j + 1, temp);
				}
	}

	public void sortbySales() {
		for (int i = 0; i < this.shows.size() - 1; ++i)
			for (int j = i; j < this.shows.size() - 1; ++j)
				if (this.shows.get(j).getMovie().getTotalSales() < this.shows.get(j + 1).getMovie().getTotalSales()) {
					Show temp = this.shows.get(j);
					this.shows.set(j, this.shows.get(j + 1));
					this.shows.set(j + 1, temp);
				}
	}

	public void sortbyShowTime() {
		for (int i = 0; i < this.shows.size() - 1; ++i)
			for (int j = i; j < this.shows.size() - 1; ++j)
				if (this.shows.get(j).getShowTime().after(this.shows.get(j + 1).getShowTime())) {
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
		System.out.printf("%10s%20s%10s%10s%20s\n", "Index", "Movie Title", "Cineplex", "Cinema", "Time");
		for (int i = 0; i < this.shows.size(); ++i) {
			System.out.printf("%8d", i);
			this.shows.get(i).display();
		}
	}

	public void displayShows(int lim) {
		System.out.printf("%10s%20s%10s%10s%20s\n", "Index", "Movie Title", "Cineplex", "Cinema", "Time");
		for (int i = 0; i < lim; ++i) {
			System.out.printf("%8d", i);
			this.shows.get(i).display();
		}
	}

	public int length() {
		return len;
	}

	public void listTop5byRating() {
		sortbyRating();
		displayShows(5);
	}

	public void listTop5bySales() {
		sortbySales();
		displayShows(5);
	}

	public void addShow(Show show){
		shows.add(show);
		len++;
	}
	
	public void createShow() throws ParseException {
		Movie[] movies =  new Movie[Database.movieListing.getMovies().size()];
	        movies = Database.movieListing.getMovies().toArray(movies);
		for (int i = 0; i < movies.length; i++) {
			System.out.printf("%d. Movie Name: %s\n", i + 1, movies[i].getTitle());
		}
		System.out.println("Choose Movie Index");
		Scanner in = new Scanner(System.in);
		int movie_ind = in.nextInt();
		Cineplex cineplex[] = new Cineplex[Database.cineplexes.size()];
		cineplex = Database.cineplexes.toArray(cineplex);
		for (int i = 0; i < cineplex.length; i++) {
			System.out.printf("%d. Cineplex Name: %s\n", i + 1, cineplex[i].getName());
		}
		System.out.println("Choose Cinplex Index");
		int cineplex_ind = in.nextInt();
		System.out.println("Enter Cinema Number");
		int cinema_ind = in.nextInt();
		System.out.println("Is the Show going to be in 3D?");
		boolean is3D = in.nextBoolean();
		System.out.println("Enter Show time(yyyy-MM-dd hh:mm)");
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date showtime = ft.parse(in.next());
		System.out.println("Enter ticket price");
		double price = in.nextDouble();
		in.close();
		shows.add(new Show((cineplex[cineplex_ind].getCinemaList())[cinema_ind], movies[movie_ind - 1],
				cineplex[cineplex_ind - 1], is3D, showtime, price));
		System.out.println("Show successfully created!");
	}

	public void deleteShow() {
		System.out.println("Enter Show ID");
		Scanner in = new Scanner(System.in);
		int show_id = in.nextInt();
		in.close();
		shows.remove(show_id);
		System.out.println("Show successfully deleted!");
	}

	public void updateShow(int show_ind) throws ParseException {
		Scanner in = new Scanner(System.in);
		int choice;
		Show show = shows.get(show_ind);
		do {
			System.out.printf("Choose Action:\n" + "1. Update Cinema\n" + "2. Update Movie\n" + "3. Update Show time\n"
					+ "4. Update ticket price\n" + "5. Update is3D\n" + "6. Exit\n");
			choice = in.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Cinema Number");
				int cinema_ind = in.nextInt();
				show.setCinema(show.getCineplex().getCinemaList()[cinema_ind]);
				System.out.println("Cinema Update successfully!");
				break;
			case 2:
				Movie[] movies =  new Movie[Database.movieListing.getMovies().size()];
			        movies = Database.movieListing.getMovies().toArray(movies);
				for (int i = 0; i < movies.length; i++) {
					System.out.printf("%d. Movie Name: %s\n", i + 1, movies[i].getTitle());
				}
				System.out.println("Choose Movie Index");
				int movie_ind = in.nextInt();
				show.setMovie(movies[movie_ind]);
				System.out.println("Movie Update successfully!");
				break;
			case 3:
				System.out.println("Enter Show time(yyyy-MM-dd hh:mm)");
				SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm");
				Date showtime = ft.parse(in.next());
				show.setShowTime(showtime);
				System.out.println("Show time updated succesfully");
				break;
			case 4:
				System.out.println("Enter ticket price");
				double price = in.nextDouble();
				show.setPrice(price);
				System.out.println("Price updated successfully!");
			case 5: 
				System.out.println("Is the show in 3D?");
				boolean is3D = in.nextBoolean();
				show.set3D(is3D);
				break;	
			}
		} while (choice != 6);
		in.close();
	}

	public ArrayList<Show> getShows() {
		return shows;
	}
}
