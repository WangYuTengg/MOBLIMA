package boundary;

import java.util.Scanner;

import data.Database;
import model.Staff;

public class MovieListingUI {
	private static Scanner sc = new Scanner(System.in);
	public void main(Database db) {
		boolean exit = false;
		do {
			System.out.println("");
			System.out.println("||----------- Movie Listing Menu -----------||");
			System.out.println("1. Create Movie in movie listing");
			System.out.println("2. Update Movie in movie listing");
			System.out.println("3. Delete Movie in movie listing");
			System.out.println("4. View movie listing");
			System.out.println("5. Return to admin menu");
			System.out.print("Select option: ");

			String adminInput = sc.next();
			switch (adminInput) {
			case "1":
				System.out.println("Creating movie...");
				Staff.addMovie(db);
				break;
			case "2":
				System.out.println("Updating movie...");
				Staff.editMovie(db);
				break;
			case "3":
				System.out.println("Deleting movie...");
				Staff.deleteMovie(db);
				break;
			case "4":
				System.out.println("Displaying movie list...");
				db.movieListing.listMovies();
				break;
			case "5":
				exit = true;
				break;
			default:
				System.out.println("Enter a valid option.");
			}
		} while (!exit);
		System.out.println("Returning to Admin menu...");
		return;
	}

}
