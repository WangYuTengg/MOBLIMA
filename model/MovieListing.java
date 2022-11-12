package model;

import java.util.*;

public class MovieListing implements java.io.Serializable{
	private ArrayList<Movie> movies = new ArrayList<>();
	private int len = 0;
	private static Scanner in = new Scanner(System.in);

	public void addMovie(Movie movie) {
		movies.add(movie);
		len++;
	}

	public void deleteMovie() {
		listMovies();
		System.out.println("Enter the move Index to delete the movie");
		int movie_ind = in.nextInt();
		movies.remove(movie_ind - 1);
		len--;
	}

	public void listMovies() {
		int i = 0;
		for (Movie obj : movies) {
			i++;
			System.out.printf("%d. %s\n", i , obj.getTitle());
		}
	}

	public void listMovies(int lim) {
		for (int i = 0; i < lim; i++) {
			System.out.printf("%d. %s\n", i + 1, movies.get(i).getTitle());
		}
	}

	public void searchMovieByTitle(){
		boolean exit = false;
		boolean result = false;
		do {
			System.out.printf("Enter movie title to search for ( enter -1 to exit ): ");
			String userInput = in.nextLine();
			if (userInput.equals("-1")) exit = true;
			
			for (Movie movie: movies){
				if (userInput.equals(movie.getTitle())){
					System.out.printf("'%s' movie found. \n", movie.getTitle());
					System.out.printf("Current showing status: %s \n", movie.getStatus());
					result = true;
				}
			}
			if (!result && !exit) System.out.println("Cannot find such a movie, try again!");
			else exit = true;
		}while(!exit);
		System.out.println("Returning to Search Movie Menu...");
	}

	public void searchMovieByDirector(){
		boolean exit = false;
		boolean result = false;
		do {
			System.out.printf("Enter director to search for ( enter -1 to exit ):");
			String userInput = in.nextLine();
			if (userInput.equals("-1")) exit = true;
			
			for (Movie movie: movies){
				if (userInput.equals(movie.getDirector())){
					System.out.printf("'%s' movie found: %s\n", movie.getDirector(), movie.getTitle());
					System.out.printf("Current showing status: %s \n", movie.getStatus());
					result = true;
				}
			}
			if (!result && !exit) System.out.println("Cannot find such a director, try again!");
			else exit = true;
		}while(!exit);
		System.out.println("Returning to Search Movie Menu...");
	}

	public void updateMovie(int movie_ind) {
		int choice;
		do {
			System.out.printf("Choose Action:\n" + "1. Update Movie Type\n" + "2. Update Synopsis\n"
					+ "3. Update Showing Status\n" + "4. Exit\n");
			choice = in.nextInt();
			switch (choice) {
			case 1:
				in.nextLine();
				System.out.println("Is the movie a Blockbuster movie? (true or false)"); // movie type
				String input = in.nextLine();
				Boolean type;
				// Error checking for invalid inputs
				while (input.equals("true") == false && input.equals("false") == false){
					System.out.println("Invalid Input. Please re-enter.\nIs the movie a Blockbuster movie? (true or false)");
					input = in.nextLine();
				}
				type = Boolean.parseBoolean(input);
				movies.get(movie_ind).setBlockbuster(type);
				break;
			case 2:
				in.nextLine();
				System.out.println("Enter Movie Synopsis");
				String synopsis = in.nextLine();
				movies.get(movie_ind).setSynopsis(synopsis);
				break;
			case 3:
				in.nextLine();
				String status = "unknown";
				System.out.println("Enter the Movie's Showing Status: \n1. Coming Soon\n2. Preview\n3. Now Showing\n4. End Of Showing"); // movie showing status
				
				String statusInput = in.nextLine();
				// Error checking for invalid inputs
				do {
					switch (statusInput) {
						case("1"):
							status = "COMING_SOON";
							break;
						case("2"):
							status = "PREVIEW";
							break;
						case("3"):
							status = "NOW_SHOWING";
							break;
						case ("4"):
							status = "END_OF_SHOWING";
							break;
						default:
							System.out.println("Invalid Input. Please re-enter.\nEnter the Movie's Showing Status: \n1. Coming Soon\n2. Preview\n3. Now Showing\n4. End Of Showing");
							statusInput = in.next();
					}
				} while(status.equals("unknown"));
				movies.get(movie_ind).setStatus(status);
				break;
			}
		} while (choice != 4);
		System.out.println("Movie successfully updated");
	}

	public int length() {
		return len;
	}

	public void sortbyRating() {
		for (int i = 0; i < len-1; i++)
			for (int j = 0; j < len-1-i; j++)
				if (movies.get(j).getOverallRating() < movies.get(j + 1).getOverallRating()) {
					Movie temp = movies.get(j);
					movies.set(j, movies.get(j + 1));
					movies.set(j + 1, temp);
				}
	}

	public void sortbySales() {
		for (int i = 0; i < len-1; i++)
			for (int j = 0; j < len-1-i; j++)
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
