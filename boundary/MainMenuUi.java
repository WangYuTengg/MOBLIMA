package boundary;

import java.util.Scanner;
import controller.*;
import model.*;

public class MainMenuUi {
	public void main() {
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		DataController.main(); // initialise database
		do {
			System.out.println("||----------- Welcome to MOBLIMA ----------||");
			System.out.println("1. Login as admin");
			System.out.println("2. Login as Movie Goer");
			System.out.println("3. Exit");
			System.out.print("Select Option: ");
			String userInput = sc.next();
			switch (userInput) {
			case "1":
				if (verifyLogin() == true)
					adminLogin();
				break;
			case "2":
				if (verifyLogin() == true)
					movieGoerLogin();
				break;
			case "3":
				System.out.println("Exiting MOBLIMA...");
				exit = true;
				break;
			default:
				System.out.println("Select a valid option.");
			}
		} while (exit == false);
		System.out.println("||---- Program End ----||");
		sc.close();
	}

	// admin UI after logging in ---------------------
	public static void adminLogin() {
		boolean loggedIn = true;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("||----------- Admin Menu -----------||");
			System.out.println("1. Add/Delete/Update movies in movie listing");
			System.out.println("2. Add/Delete/Update shows in show listing");
			System.out.println("3. Configure system settings");
			System.out.println("4. Log out ");
			System.out.print("Select Option: ");
			String adminInput = sc.next();
			switch (adminInput) {
			case "1":
				MovieListingUI movieListingUI = new MovieListingUI();
				movieListingUI.main();
				break;
			case "2":
				ShowsUI showsUI = new ShowsUI();
				showsUI.main();
				break;
			case "3":
				SettingsUI settingsUI = new SettingsUI();
				settingsUI.main();
				break;
			case "4":
				System.out.println("Logging out --- Returning to Main Menu");
				loggedIn = false;
				break;
			default:
				System.out.println("Select a valid option.");
			}
		} while (loggedIn == true);
		return;
	}

	// movieGoer UI after logging in --------------------
	public static void movieGoerLogin() {
		boolean loggedIn = true;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("||----------- Movie Goer Menu -----------||");
			System.out.println("1. Search/List Movie");
			System.out.println("2. View movie details");
			System.out.println("3. List Top 5 movies");
			System.out.println("4. Rate movie");
			System.out.println("5. Book ticket");
			System.out.println("6. View booking history");
			System.out.println("7. Log out");
			System.out.print("Select Option: ");

			String movieGoerInput = sc.next();
			MovieGoerUI movieGoerUI = new MovieGoerUI();
			BookingUI bookingUI = new BookingUI();

			switch (movieGoerInput) {
			case "1":
				movieGoerUI.searchMovieUI();
				break;
			case "2":
				movieGoerUI.viewMovieDetailsUI();
				break;
			case "3":
				movieGoerUI.listTop5UI();
				break;
			case "4":
				movieGoerUI.rateMovieUI();
				break;
			case "5":
				bookingUI.bookTicketUI();
				break;
			case "6":
				movieGoerUI.viewBookingHistoryUI();
				break;
			case "7":
				System.out.println("Logging out --- Returning to Main Menu");
				loggedIn = false;
				break;
			default:
				System.out.println("Please enter a valid option.");
			}
		} while (loggedIn == true);
		return;
	}

	// verifyLogin method for both admin and user
	public static boolean verifyLogin() {
		// add verifying code here
		boolean result = true;
		if (result == true)
			System.out.println("Login verified.");
		else
			System.out.println("Login failed");
		return result;
	}
	// end of main
}
