package boundary;

import java.util.Scanner;
import controller.*;
import model.MovieGoer;

public class MainMenuUi {
	private static Scanner sc = new Scanner(System.in);
	public void main(Database db) {
		boolean exit = false;
		// main program loop
		do {
			System.out.println("||----------- Welcome to MOBLIMA ----------||");
			System.out.println("1. Login as admin");
			System.out.println("2. Login as Movie Goer");
			System.out.println("3. Create Movie Goer account");
			System.out.println("4. Exit");
			System.out.print("Select Option: ");
			String userInput = sc.next();
			switch (userInput) {
			case "1":
				if (LoginUI.verifyAdmin(db).getAdminEmail().equals("dkjkjsnw") ) break;
				adminLogin(db);
				break;
			case "2":
				MovieGoer temp = LoginUI.verifyMovieGoer(db);
				if (temp.getName().equals("")) break;
				movieGoerLogin(temp, db);
				break;
			case "3":
				CreateUserUI createUserUI = new CreateUserUI();
				createUserUI.main(db);
				break;
			case "4":
				System.out.println("Exiting MOBLIMA...");
				exit = true;
				break;
			default:
				System.out.println("Select a valid option.");
			}
		} while (exit == false);
		System.out.println("||---- Program End ----||");
	}

	// admin UI after logging in ---------------------
	/**
	 * @param db
	 */
	public static void adminLogin(Database db) {
		boolean loggedIn = true;
		do {
			System.out.println("");
			System.out.println("||----------- Admin Menu -----------||");
			System.out.println("1. Add/Delete/Update movies in movie listing");
			System.out.println("2. Add/Delete/Update shows in show listing");
			System.out.println("3. Add/Delete cineplex");
			System.out.println("4. Configure system settings");
			System.out.println("5. View/Block Top 5 Lists");
			System.out.println("6. Sales Report of Movies ");
			System.out.println("7. Log out ");
			System.out.print("Select Option: ");
			String adminInput = sc.next();
			switch (adminInput) {
			case "1":
				MovieListingUI movieListingUI = new MovieListingUI();
				movieListingUI.main(db);
				break;
			case "2":
				ShowsUI showsUI = new ShowsUI();
				showsUI.main(db);
				break;
			case "3":
				CineplexUI cineplexUI=new CineplexUI();
				cineplexUI.main(db);
				break;
			case "4":
				SettingsUI settingsUI = new SettingsUI();
				settingsUI.main(db);
				break;
			case "5":
				Top5UI top5UI = new Top5UI();
				top5UI.main(db);
				break;
			case "6":
				db.movieListing.listSalesofMovie();
				break;
			case "7":
				System.out.println("Logging out --- Returning to Main Menu");
				loggedIn = false;
				break;
			default:
				System.out.println("Select a valid option.");
			}
		} while (loggedIn == true);
	}

	// movieGoer UI after logging in --------------------
	public static void movieGoerLogin(MovieGoer currentUser, Database db) {
		boolean loggedIn = true;
		do {
			System.out.println("");
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

			switch (movieGoerInput) {
			case "1":
				movieGoerUI.searchMovieUI(db);
				break;
			case "2":
				movieGoerUI.viewMovieDetailsUI(db);
				break;
			case "3":
				movieGoerUI.listTop5UI(db);
				break;
			case "4":
				movieGoerUI.rateMovieUI(db);
				break;
			case "5":
				currentUser.bookTickets(db);
				break;
			case "6":
				currentUser.viewBookingHistory();
				break;
			case "7":
				System.out.println("Logging out --- Returning to Main Menu");
				loggedIn = false;
				break;
			default:
				System.out.println("Please enter a valid option.");
			}
		} while (loggedIn == true);
	}
	// end of main
}
