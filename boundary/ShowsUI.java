package boundary;

import controller.*;
import java.util.*;
import model.*;

public class ShowsUI {
	private static Scanner sc = new Scanner(System.in);
	public void main() {
		boolean exit = false;
		do {
			System.out.println("||---------- Show Listing Menu ----------||");
			System.out.printf(
					"1. Create showing of movie\n" + "2. Update showing of movie\n" + "3. Remove showing of movie\n"
							+ "4. View list of showings of a movie\n" + "5. Return to Admin Menu\n");
			System.out.print("Select option: ");
			String adminInput = sc.next();
			switch (adminInput) {
			case "1":
				System.out.println("Creating show of movie...");
				break;
			case "2":
				System.out.println("Updating show of movie...");
				break;
			case "3":
				System.out.println("Deleting show of movie...");
				break;
			case "4":
				System.out.println("Viewing list of showings...");
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
