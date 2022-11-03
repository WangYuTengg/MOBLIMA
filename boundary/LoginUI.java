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
        // validate staffID
        System.out.println("||-------- Admin Login --------||");
        System.out.print("Enter your staffID:  ");
        String staffID = sc.nextLine();

        if ( Database.getStaff(staffID) == null ) {
            System.out.println("Wrong StaffID - returning to main menu.");
            return false;
        } else currentStaff = Database.getStaff(staffID);

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
        // validate userName
        System.out.println("||-------- Movie Goer Login --------||");
        System.out.print("Enter your name:  ");
        String userName = sc.nextLine();

        if ( Database.getMovieGoer(userName) == null ) {
            System.out.println("Wrong user name - returning to main menu.");
            return false;
        } else currentUser = Database.getMovieGoer(userName);
        
        // validate password
        System.out.print("Enter your password:  ");
        String password = sc.nextLine();

        if ( password.equals(currentUser.getPass())){
            System.out.printf("Welcome %s, you have successfully logged in as a user.", currentUser.getName());
            return true;
        } else {
            System.out.println("Wrong password - returning to main menu."); 
            return false;
        }
    }
}
