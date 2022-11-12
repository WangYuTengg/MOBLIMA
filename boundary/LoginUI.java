package boundary;

import java.util.Scanner;

import data.Database;
import model.Staff;
import model.MovieGoer;

public class LoginUI {

    // declare private static scanner once for this class
    private static Scanner sc = new Scanner(System.in);
    
    /**
     * UI Method to verify admin login
     * @param db database to check for admin login details
     * @return
     */
    public static Staff verifyAdmin(Database db){
        Staff currentStaff;

        System.out.println("");
        System.out.println("||-------- Admin Login --------||");

        // validate admin email
        System.out.print("Enter your admin email:  ");
        String adminEmail = sc.nextLine();
        Staff ans = db.getStaff("dkjkjsnw");
        if (db.getStaff(adminEmail) == null ) {
            System.out.println("Wrong admin email entered - returning to main menu.");
            return ans;
        } else currentStaff = db.getStaff(adminEmail);

        // validate password
        System.out.print("Enter your password:  ");
        String password = sc.nextLine();
        
        if ( password.equals(currentStaff.getPass()) ){
            System.out.printf("Welcome %s, you have successfully logged in as admin.\n", currentStaff.getName());
            return currentStaff;
        } else {
            System.out.printf("Wrong password - returning to main menu.\n"); 
            return ans;
        }
    }

    /**
     * UI method to verify moviegoer login
     * @param db
     * @return
     */
    public static MovieGoer verifyMovieGoer(Database db){
        MovieGoer currentUser;

        System.out.println("");
        System.out.println("||-------- Movie Goer Login --------||");

        // validate user email
        System.out.print("Enter your user email:  ");
        String userEmail = sc.nextLine();
        MovieGoer ans = db.getMovieGoer("");
        if (db.getMovieGoer(userEmail) == null ) {
            System.out.println("Wrong user email entered - returning to main menu.");
            return ans;
        } else currentUser = db.getMovieGoer(userEmail);
        
        // validate password
        System.out.print("Enter your password:  ");
        String password = sc.nextLine();

        if ( password.equals(currentUser.getPass())){
            System.out.printf("Welcome %s, you have successfully logged in as a user.\n", currentUser.getName());
            return currentUser;
        } else {
            System.out.println("Wrong password - returning to main menu."); 
            return ans;
        }
    }
}
