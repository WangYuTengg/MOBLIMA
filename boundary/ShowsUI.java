package boundary;

import data.Database;

import java.util.*;
import model.*;

/**
 * The class used for ShowsUI.
 */
public class ShowsUI {

	/**
	 * A static scanner used throughout ShowsUI.
	 */
	private static Scanner sc = new Scanner(System.in);

	/**
	 * The Main UI used for Staff to edit shows.
	 * @param db	The database.
	 */
	public void main(Database db) {
		boolean exit = false;
		do {
			System.out.println("");
			System.out.println("||---------- Show Listing Menu ----------||");
			System.out.printf(
					"1. Create showing of movie\n" + "2. Update showing of movie\n" + "3. Remove showing of movie\n"
							+ "4. View list of showings of a movie\n" + "5. Return to Admin Menu\n");
			System.out.print("Select option: ");
			String adminInput = sc.next();
			switch (adminInput) {
			case "1":
				System.out.println("");
				System.out.println("------- Creating show of movie -------");
				Staff.addShow(db);
				break;
			case "2":
				System.out.println("");
				System.out.println("------ Update showing of movie -------");
				Staff.updateShow(db);
				break;
			case "3":
				System.out.println("");
				System.out.println("------- Deleting showing of movie -------");
				Staff.deleteShow(db);
				break;
			case "4":
				System.out.println("");
				System.out.println("||----- Display Shows -----||");
				db.showListing.displayShows();
				break;
			case "5":
				exit = true;
				break;
			default: System.out.println("Enter a valid option.");
			}
		} while (!exit);
		System.out.println("Returning to Admin menu...");
	}
}

