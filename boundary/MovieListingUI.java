package boundary;

import java.util.Scanner;

import controller.Staff;
import data.Database;

/**
 * The UI used for allowing the Staff to manipulate the MovieListing.
 * @version  3.0
 * @author   Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong Jian
 * @since    2022-10-30
 */
public class MovieListingUI  implements BaseUI{

	/**
	 * A static scanner used for MovieListingUI.
	 */
	private static Scanner sc = new Scanner(System.in);

	/**
	 * The main UI used for Staff members to create, update, and delete movies.
	 * @param db	The database.
	 */
	public void main(Database db) {
		sc=new Scanner(System.in);
		boolean exit = false;
		do {
			display();
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
				db.movieListing.listMovies(true);
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

	/**
	 * Displays the Movie Listing Menu.
	 */
	private void display()
	{
		System.out.println("");
			System.out.println("||----------- Movie Listing Menu -----------||");
			System.out.println("1. Create Movie in movie listing");
			System.out.println("2. Update Movie in movie listing");
			System.out.println("3. Delete Movie in movie listing");
			System.out.println("4. View movie listing");
			System.out.println("5. Return to admin menu");
			System.out.print("Select option: ");
	}
}
