package model;

import java.util.*;

public class MovieListing {
	private ArrayList<Movie> movies = new ArrayList<>();
	private static int len = 0;

	public void addMovie(Movie movie) {
		movies.add(movie);
		len++;
	}

	public void deleteMovie() {
		listMovies();
		System.out.println("Enter the move Index to delete the movie");
		Scanner in = new Scanner(System.in);
		int movie_ind = in.nextInt();
		movies.remove(movie_ind - 1);
		len--;
		in.close();
	}

	public void listMovies() {
		int i = 0;
		for (Movie obj : movies) {
			i++;
			System.out.printf("%d. %s\n", i - 1, obj.getTitle());
		}
	}

	public void listMovies(int lim) {
		for (int i = 0; i < lim; i++) {
			i++;
			System.out.printf("%d. %s\n", i + 1, movies.get(i).getTitle());
		}
	}

	public void updateMovie(int movie_ind) {
		Scanner in = new Scanner(System.in);
		int choice;
		do {
			System.out.printf("Choose Action:\n" + "1. Update Movie Type\n" + "2. Update Synopsis\n"
					+ "3. Update Showing Status\n" + "4. Exit\n");
			choice = in.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Movie Type");
				String type = in.next();
				movies.get(movie_ind).setType(type);
				break;
			case 2:
				System.out.println("Enter Movie Synopsis");
				String synopsis = in.nextLine();
				movies.get(movie_ind).setSynopsis(synopsis);
				break;
			case 3:
				System.out.println("Enter Movie Status");
				String status = in.next();
				movies.get(movie_ind).setStatus(status);
				break;
			}
		} while (choice != 4);
		System.out.println("Movie successfully updated");
		in.close();
	}

	public int length() {
		return len;
	}

	public void sortbyRating() {
		for (int i = 0; i < len; i++)
			for (int j = i; j < len; j++)
				if (movies.get(j).getOverallRating() < movies.get(j + 1).getOverallRating()) {
					Movie temp = movies.get(j);
					movies.set(j, movies.get(j + 1));
					movies.set(j + 1, temp);
				}
	}

	public void sortbySales() {
		for (int i = 0; i < len; i++)
			for (int j = i; j < len; j++)
				if (movies.get(j).getTotalSales() < movies.get(j + 1).getTotalSales()) {
					Movie temp = movies.get(j);
					movies.set(j, movies.get(j + 1));
					movies.set(j + 1, temp);
				}
	}

	public void listTop5byRating() {
		sortbyRating();
		listMovies(5);

	}

	public void listTop5bySales() {
		sortbySales();
		listMovies(5);

	}

	public ArrayList<Movie> getMovies() {
		return movies;
	}
}