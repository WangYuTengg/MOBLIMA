package controller;

import java.util.*;

import model.Movie;
/**
 * A Class to act as a List of all Movies.
 * @version  3.0
 * @author   Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong Jian
 * @since    2022-10-30
 */
public class MovieListing implements java.io.Serializable{
	
	/**
	 * A static scanner to be used throughout MovieListing.
	 */
	private static Scanner in = new Scanner(System.in);

	/**
	 * An ArrayList of movies.
	 */
	private ArrayList<Movie> movies = new ArrayList<>();

	/**
	 * The number of movies in MovieListing.
	 */
	private int len = 0;

	/**
	 * Adds a movie to the Movie Listing.
	 * @param movie	the movie to be added.
	 */
	public void addMovie(Movie movie) {
		movies.add(movie);
		len++;
	}

	/**
	 * Deletes a movie.
	 * @param isAdmin A boolean for whether the user is an Admin or a Movie Goer.
	 */
	public void deleteMovie(boolean isAdmin) {
		in = new Scanner(System.in);
		listMovies(isAdmin);
		System.out.println("Enter the Index of the movie to be deleted: (-1 to return)");
		
		try {
			int movie_ind = in.nextInt();
			if (movie_ind==-1)
			{
				System.out.println("Returning...");
				return;
			}
			if (movie_ind < -1 || movie_ind > movies.size() || movie_ind == 0) {
				System.out.println("Invalid index entered. Returning to previous menu...");
				return;
			}
			movies.remove(movie_ind - 1);
			len--;
			System.out.println("Movie has successfully been deleted.");
		} catch (Exception e) {
			System.out.println("Non-integer value detected. Returning to previous menu...");
		}
	}

	/**
	 * Lists all movies that are coming soon or currently showing.
	 * @param isAdmin A boolean for whether the user is an Admin or a Movie Goer.
	 */
	public void listMovies(boolean isAdmin) {
		int i = 0;
		for (Movie obj : movies) {
			i++;
			if (!isAdmin && obj.getStatus().equals("END_OF_SHOWING"))
				continue;
			System.out.printf("%d. %s, STATUS: %s\n", i , obj.getTitle(), obj.getStatus());
		}
	}

	/**
	 * Lists a number of movies that are coming soon or currently showing, limited by lim.
	 * @param lim the limit of number of movies displayed.
	 * @param isAdmin A boolean for whether the user is an Admin or a Movie Goer.
	 */
	public void listMovies(int lim, boolean isAdmin) {
		int i = 0;
		for (Movie obj : movies) {
			if (!isAdmin && obj.getStatus().equals("END_OF_SHOWING"))
				continue;
			System.out.printf("%d. %s, STATUS: %s\n", i+1, obj.getTitle(), obj.getStatus());
			i++;
			if (i == lim)
				break;
		}
	}

	/**
	 * Searches for the movie by title.
	 */
	public void searchMovieByTitle(){
		in=new Scanner(System.in);
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

	/**
	 * Searches for the movie by director.
	 */
	public void searchMovieByDirector(){
		in=new Scanner(System.in);
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

	/**
	 * Updates the details of a movie.
	 * @param movie_ind	Index of the movie.
	 */
	public void updateMovie(int movie_ind) {
		in=new Scanner(System.in);
		int choice;
		do {
			System.out.printf("Choose Action:\n" + "1. Update Movie Type\n" + "2. Update Synopsis\n"
					+ "3. Update Showing Status\n" + "4. Update Age Rating\n" + "5. Exit\n");
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
			case 4:
				in.nextLine();
				String ageRating = "unknown";
				System.out.println("Please enter the age rating for the movie:\n1. G\n2. PG\n3. PG13\n4. R\n5. M18\n6. R21");
				String ageRatingInput = in.nextLine();
				do {
					switch (ageRatingInput) {
						case("1"):
							ageRating = "G";
							break;
						case("2"):
							ageRating = "PG";
							break;
						case("3"):
							ageRating = "PG13";
							break;
						case ("4"):
							ageRating = "R";
							break;
						case ("5"):
							ageRating = "M18";
							break;
						case("6"):
							ageRating = "R21";
							break;
						default:
							System.out.println("Invalid Input. \nPlease enter the age rating for the movie:\n1. G\n2. PG\n3. PG13\n4. R\n5. M18\n6. R21");
							ageRatingInput = in.nextLine();
					}
				} while (ageRating.equals("unknown"));
				movies.get(movie_ind).setAgeRating(ageRating);
				break;
			}
		} while (choice != 5);
		System.out.println("Movie successfully updated");
	}

	/**
	 * Returns the number of movies.
	 * @return	The number of movies.
	 */
	public int length() {
		return len;
	}

	/**
	 * Sorts the movies by rating.
	 */
	public void sortbyRating() {
		for (int i = 0; i < len-1; i++)
			for (int j = 0; j < len-1-i; j++)
				if (movies.get(j).getOverallRating() < movies.get(j + 1).getOverallRating()) {
					Movie temp = movies.get(j);
					movies.set(j, movies.get(j + 1));
					movies.set(j + 1, temp);
				}
	}
	
	/**
	 * Sorts the movies by sales.
	 */
	public void sortbySales() {
		for (int i = 0; i < len-1; i++)
			for (int j = 0; j < len-1-i; j++)
				if (movies.get(j).getTotalSales() < movies.get(j + 1).getTotalSales()) {
					Movie temp = movies.get(j);
					movies.set(j, movies.get(j + 1));
					movies.set(j + 1, temp);
				}
	}

	/**
	 * Lists the top 5 movies by rating.
	 * @param isAdmin	A boolean for whether the user is an Admin or a Movie Goer.
	 */
	public void listTop5byRating(boolean isAdmin) {
		sortbyRating();
		listMovies(5,isAdmin);

	}

	/**
	 * Lists the top 5 movies by sales.
	 * @param isAdmin	A boolean for whether the user is an Admin or a Movie Goer.
	 */
	public void listTop5bySales(boolean isAdmin) {
		sortbySales();
		listMovies(5,isAdmin);

	}
	
	/**
	 * Lists the total sales of each movie.
	 */
	public void listSalesofMovie() {
		int i=1;
		System.out.printf("%10s%40s%15s\n", "Index", "Movie Title", "Total Sales");
		for (Movie movie : movies)
			System.out.printf("%10d%40s%15s\n", i++, movie.getTitle(), movie.getTotalSales());
	}

	/**
	 * Lists the sorted total sales of a limited number of movies.
	 * @param lim The limit of number of movies displayed.
	 */
	public void listSalesofMovie(int lim) {
		int i=1;
		sortbySales();
		System.out.printf("%10s%40s%15s\n", "Index", "Movie Title", "Total Sales");
		for (Movie movie : movies){
			if (i > lim) break;
			System.out.printf("%10d%40s%15s\n", i++, movie.getTitle(), movie.getTotalSales());
		}
	}

	/**
	 * Lists top 5 movies with their overall ratings displayed.
	 * @param lim The limit of number of movies displayed.
	 */
	public void listRatingofMovie(int lim) {
		int i=1;
		sortbyRating();
		System.out.printf("%10s%40s%15s\n", "Index", "Movie Title", "Overall Rating");
		for (Movie movie : movies){
			if (i > lim) break;
			System.out.printf("%10d%40s%15s\n", i++, movie.getTitle(), movie.getOverallRating());
		}
	}

	/**
	 * Returns the movies in an array.
	 * @return	An array of all movies. 
	 */
	public ArrayList<Movie> getMovies() {
		return movies;
	}
}
