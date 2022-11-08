package boundary;

import java.util.Scanner;
import model.Staff;
import model.MovieGoer;
import controller.Database;

public class LoginUI {

    private static Scanner sc = new Scanner(System.in);

    
    public static Staff verifyAdmin(){
        Staff currentStaff;
        // validate staffID
        System.out.println("||-------- Admin Login --------||");
        System.out.print("Enter your staffID:  ");
        String staffID = sc.nextLine();
        Staff ans=Database.getStaff("dkjkjsnw");

        if ( Database.getStaff(staffID) == null ) {
            System.out.println("Wrong StaffID - returning to main menu.");
            return ans;
        } else currentStaff = Database.getStaff(staffID);

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

    public static MovieGoer verifyMovieGoer(){
        MovieGoer currentUser;
        // validate userName
        System.out.println("||-------- Movie Goer Login --------||");
        System.out.print("Enter your name:  ");
        String userName = sc.nextLine();
        MovieGoer ans=Database.getMovieGoer("");

        if ( Database.getMovieGoer(userName) == null ) {
            System.out.println("Wrong user name - returning to main menu.");
            return ans;
        } else currentUser = Database.getMovieGoer(userName);
        
        // validate password
        System.out.print("Enter your password:  ");
        String password = sc.nextLine();

        if ( password.equals(currentUser.getPass())){
            System.out.printf("Welcome %s, you have successfully logged in as a usern.\n", currentUser.getName());
            return currentUser;
        } else {
            System.out.println("Wrong password - returning to main menu."); 
            return ans;
        }
    }
}
