package boundary;

import java.util.Scanner;
import model.Staff;
import model.MovieGoer;
import controller.Database;

public class LoginUI {

    private static Scanner sc = new Scanner(System.in);

    public static boolean main(int role){
        if (role == 1) return verifyAdmin();
        if (role == 2) return verifyMovieGoer();
        else return false;
    }
    
    private static boolean verifyAdmin(){
        Staff currentStaff;
        // validate admin email
        System.out.println("||-------- Admin Login --------||");
        System.out.print("Enter your admin email:  ");
        String adminEmail = sc.nextLine();

        if ( Database.getStaff(adminEmail) == null ) {
            System.out.println("Wrong email entered - returning to main menu.");
            return false;
        } else currentStaff = Database.getStaff(adminEmail);

        // validate password
        System.out.print("Enter your password:  ");
        String password = sc.nextLine();
        
        if ( password.equals(currentStaff.getPass()) ){
            System.out.printf("Welcome %s, you have successfully logged in as admin.\n", currentStaff.getName());
            return true;
        } else {
            System.out.printf("Wrong password - returning to main menu.\n"); 
            return false;
        }
    }

    private static boolean verifyMovieGoer(){
        MovieGoer currentUser;
        // validate user email
        System.out.println("||-------- Movie Goer Login --------||");
        System.out.print("Enter your email: ");
        String userEmail = sc.nextLine();

        if ( Database.getMovieGoer(userEmail) == null ) {
            System.out.println("Wrong email entered - returning to main menu.");
            return false;
        } else currentUser = Database.getMovieGoer(userEmail);
        
        // validate password
        System.out.print("Enter your password:  ");
        String password = sc.nextLine();

        if ( password.equals(currentUser.getPass())){
            System.out.printf("Welcome %s, you have successfully logged in as a usern.\n", currentUser.getName());
            return true;
        } else {
            System.out.println("Wrong password - returning to main menu."); 
            return false;
        }
    }
}
