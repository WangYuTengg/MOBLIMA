

package boundary;

import java.util.Scanner;
import data.Database;

/**
 * A class for Top5UI.
 * @version  3.0
 * @author   Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong Jian
 * @since    2022-10-30
 */
public class Top5UI implements BaseUI{

    /**
     * A static scanner to be used in Top5UI.
     */
    private static Scanner sc = new Scanner(System.in);
    /**
     * A Boolean showing whether top 5 by sales is blocked.
     */
    private static boolean isTop5BySalesBlocked = false;

    /**
     * A Boolean showing whether top 5 by rating is blocked.
     */
    private static boolean isTop5ByRatingBlocked = false;

    /**
     * The main UI used for listing Top5 and Blocking/Unblocking Movie Goers.
     * @param db The Databse.
     */
    public void main(Database db){
        sc=new Scanner(System.in);
        boolean exit = false;
		do {
			display();
			String userInput = sc.next();
			switch (userInput) {
			case "1":
                System.out.println("Top 5 Movies by Rating: ");
				db.movieListing.listRatingofMovie(5);
				break;
			case "2":
                System.out.println("Top 5 Movies by Sales: ");
				db.movieListing.listSalesofMovie(5);
				break;
            case "3":
                blockUI();
                break;
			case "4":
				exit = true;
				break;
			default: System.out.printf("Please enter a valid option:  ");
			}
		} while (!exit);
		System.out.println("Returning to Admin menu...");
    }

    /**
     * Display the UI to list the top 5 movies by specific methods.
     */
    private void display() 
    {
        System.out.println("");
			System.out.println("||---------- Top 5 menu ----------||");
			System.out.println("1. List Top 5 by Overall Rating ");
			System.out.println("2. List Top 5 by Total ticket sales ");
            System.out.println("3. Block/Unblock List for MovieGoers");
			System.out.println("4. Return to Admin Menu");
			System.out.print("Select your option: ");
    }

    /**
     * A UI used to change whether a specific method of listing Top5 movies is blocked for MovieGoer.
     */
    private static void blockUI(){
        sc=new Scanner(System.in);
        boolean exit = false;
        do{
            System.out.println("");
            System.err.println("||-------- Block/Unblock Lists -------||");
            System.out.printf("1. Block/Unblock Top5ByRating -- current block status: %s \n", isTop5ByRatingBlocked);
            System.out.printf("2. Block/Unblock Top5BySales -- current block status: %s \n", isTop5BySalesBlocked);
            System.out.println("3. Exit to previous menu");
            System.err.printf("Select option:  ");
            String userInput = sc.next();
            switch(userInput){
                case "1":
                    isTop5ByRatingBlocked = !isTop5ByRatingBlocked;
                    break;
                case "2":
                    isTop5BySalesBlocked = !isTop5BySalesBlocked;
                    break;
                case "3":
                    exit = true;
                    break;
                default: System.out.printf("Please enter a valid option:  ");
            }
        }while(!exit);
    }

    /**
     * Checks whether top5 by Sales is blocked for MovieGoer.
     * @return  A boolean representing if the list is blocked or not.
     */
    public static boolean getIsTop5BySalesBlocked(){
        return isTop5BySalesBlocked;
    }

    /**
     * Checks whether top5 by Rating is blocked for MovieGoer.
     * @return  A boolean representing if the list is blocked or not.
     */
    public static boolean getIsTop5ByRatingBlocked(){
        return isTop5ByRatingBlocked;
    }
    
}
