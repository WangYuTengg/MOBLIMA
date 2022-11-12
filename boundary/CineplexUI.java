package boundary;

import controller.*;
import model.*;
import java.util.*;

public class CineplexUI {

    // declare a private static scanner for class
    private static Scanner sc = new Scanner(System.in);

    /**
     * Main UI for adding/deleting Cineplexes
     * @param db database with cineplexes
     */
    public void main(Database db){
        boolean flag=true;
        while(flag){
            System.out.println("");
			System.out.println("||----------- Admin Cineplex Management Menu -----------||");
            System.out.println("1. Add cineplex");
			System.out.println("2. Delete cineplex");
            System.out.println("3. Exit");
            System.out.print("Select Option: ");
            String opt=sc.next();
            switch(opt){
                case "1":
                    Staff.addCineplex(db);
                    break;
                case "2":
                    Staff.deleteCineplex(db);
                    break;
                case "3":
                    flag=false;
                    break;
                default:
                    System.out.println("Please enter a valid option!");
            }
        }
    }
}
