package boundary;

import java.util.Scanner;
import controller.Database;

public class Top5UI {

    // declare private scanner once
    private static Scanner sc = new Scanner(System.in);

    private static boolean isTop5BySalesBlocked = false;
    private static boolean isTop5ByRatingBlocked = false;

    public void main(Database db){
        boolean exit = false;
		do {
			System.out.println("");
			System.out.println("||---------- Top 5 menu ----------||");
			System.out.println("1. List Top 5 by Overall Rating ");
			System.out.println("2. List Top 5 by Total ticket sales ");
            System.out.println("3. Block/Unblock List for MovieGoers");
			System.out.println("4. Return to Admin Menu");
			System.out.print("Select your option: ");
			String userInput = sc.next();
			switch (userInput) {
			case "1":
                System.out.println("Top 5 Movies by Rating: ");
				db.movieListing.listTop5byRating();
				break;
			case "2":
                System.out.println("Top 5 Movies by Sales: ");
				db.movieListing.listTop5bySales();
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

    private static void blockUI(){
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

    public static boolean getIsTop5BySalesBlocked(){
        return isTop5BySalesBlocked;
    }

    public static boolean getIsTop5ByRatingBlocked(){
        return isTop5ByRatingBlocked;
    }
    
}
