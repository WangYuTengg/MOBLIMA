

package boundary;

import data.Database;
import java.util.*;

import controller.Staff;

/**
 * The UI used when the Admin is Adding/Deleting a Cineplex.
 * @version  3.0
 * @author   Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong Jian
 * @since    2022-10-30
 */
public class CineplexUI implements BaseUI{

    /**
     * A static scanner used throughout CineplexUI.
     */
    private static Scanner sc = new Scanner(System.in);

    /**
     * Main UI for adding/deleting Cineplexes.
     * @param db The database with Cineplexes.
     */
    public void main(Database db){
        sc=new Scanner(System.in);
        boolean flag=true;
        while(flag){
            display();
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

    /**
     * Dsiplays the Admin Cineplex Management Menu.
     */
    private void display()
    {
        System.out.println("");
			System.out.println("||----------- Admin Cineplex Management Menu -----------||");
            System.out.println("1. Add cineplex");
			System.out.println("2. Delete cineplex");
            System.out.println("3. Exit");
            System.out.print("Select Option: ");
    }
}
