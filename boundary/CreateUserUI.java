

package boundary;

import java.util.Scanner;
import java.util.regex.Pattern;

import controller.MovieGoer;
import data.Database;

/**
 * The UI used when creating a new Movie Goer account.
 * @version  3.0
 * @author   Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong Jian
 * @since    2022-10-30
 */
public class CreateUserUI implements BaseUI {

    /**
     * The static scanner used throughout CreateUserUI.
     */
    private static Scanner sc = new Scanner(System.in);

    /**
     * Main UI for creation of new movie goer account.
     * @param db The database.
     */
    public void main(Database db) {
        int age, id;
        String name, email, password;

        display();
        age = getAgeFromUser();
        if (age == 0) {
            System.out.println("Creation of account failed, returning to main menu...");
            return;
        } else
            System.out.printf("Age successfully entered: %d years old\n", age);

        name = getNameFromUser(db);
        if (name == null) {
            System.out.println("Creation of account failed, returning to main menu...");
            return;
        } else
            System.out.printf("Name successfully entered: %s\n", name);

        email = getEmailFromUser(db);
        if (email == null) {
            System.out.println("Creation of account failed, returning to main menu...");
            return;
        } else
            System.out.printf("Email successfully entered: %s\n", email);

        password = getPasswordFromUser();
        if (password == null) {
            System.out.println("Creation of account failed, returning to main menu...");
            return;
        } else
            System.out.printf("Password successfully entered: %s\n", password);

        id = db.movieGoers.size() + 1;

        db.addMovieGoer(new MovieGoer(age, name, email, id, password));
        System.out.printf("Your account has successfully been created, welcome %s!\n", name);
    }

    /**
     * Method to get a valid age from moviegoer during account creation.
     * @return The user's age.
     */
    private static int getAgeFromUser() {
        sc=new Scanner(System.in);
        boolean exit = false;
        int userInput;
        do {
            System.out.print("Enter your age (type 0 to exit): ");
            // check for integer input
            while (!sc.hasNextInt()) {
                System.out.printf("Enter a valid age (+ve integer):  ");
                sc.next();
            }
            userInput = sc.nextInt();

            if (userInput >= 0)
                exit = true; // exit if user is at least 1 years old
            else
                System.out.println("Please enter a valid age.");
        } while (!exit);
        return userInput;
    }

    /**
     * Method to get a name from user to create account.
     * If name already exists, exit account creation.
     * 
     * @param db The database to check for existing name.
     * @return The user's name.
     */
    private static String getNameFromUser(Database db) {
        sc=new Scanner(System.in);
        // get input from user
        System.out.printf("Enter your name (type 0 to exit):  ");
        String userInput = sc.nextLine();

        // check for exit
        if (userInput.equals("0")) {
            System.out.println("Exiting...");
            userInput = null;
        }

        // check for existing name
        for (MovieGoer movieGoer : db.movieGoers) {
            if (movieGoer.getName().equals(userInput)) {
                System.out.printf("The name %s already exists.\n", movieGoer.getName());
                userInput = null;
                break;
            }
        }
        return userInput;
    }

    /**
     * Method to get a valid email from user for account creation.
     * 
     * @param db The database to check for existing email.
     * @return The email of the user.
     */
    private static String getEmailFromUser(Database db) {
        sc=new Scanner(System.in);
        boolean exit = false;
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"; // for validating email
        String userInput;
        do {
            // get user input for their email
            System.out.print("Enter your email (type 0 to exit):  ");
            userInput = sc.nextLine();

            // check for exit
            if (userInput.equals("0")) {
                System.out.println("Exiting...");
                userInput = null;
                exit = true;
                break;
            }

            // check for existing email
            for (MovieGoer movieGoer : db.movieGoers) {
                if (movieGoer.getEmail().equals(userInput)) {
                    System.out.printf("Email: %s already exists. \n", movieGoer.getEmail());
                    userInput = null;
                    exit = true;
                    break;
                }
            }

            // check for valid email input
            if (Pattern.compile(regexPattern).matcher(userInput).matches())
                exit = true;
        } while (!exit);
        return userInput;
    }

    /**
     * Method to get password from user to create an account.
     * Password requirements:
     * Password must contain at least one digit [0-9].
     * Password must contain at least one lowercase Latin character [a-z].
     * Password must contain at least one uppercase Latin character [A-Z].
     * Password must contain at least one special character.
     * Password must contain a length of at least 8 characters and a maximum of 20 characters.
     * @return The password used.
     */
    private static String getPasswordFromUser() {
        sc=new Scanner(System.in);
        boolean exit = false;
        String regexPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$"; // for
                                                                                                             // validating
                                                                                                             // password
        String userInput;
        do {
            System.out.println("--------------- Password requirements ----------------");
            System.out.println("1. Password must contain at least one digit [0-9].");
            System.out.printf("2. Password must contain at least one lowercase Latin character [a-z].\n" +
                    "3. Password must contain at least one uppercase Latin character [A-Z].\n" +
                    "4. Password must contain at least one special character like ! @ # & ( ). \n" +
                    "5. Password must contain a length of at least 8 characters and a maximum of 20 characters.\n");
            System.out.printf("Please enter the password (type 0 to exit):  ");
            userInput = sc.next();

            // check for exit
            if (userInput.equals("0")) {
                System.out.println("Exiting...");
                userInput = null;
                exit = true;
                break;
            }

            // check password requirements
            if (Pattern.compile(regexPattern).matcher(userInput).matches())
                exit = true;
            else
                System.out.println("Password does not meet the requirements.");
        } while (!exit);
        return userInput;
    }

    /**
     * Displays the User Creation UI Header.
     */
    private void display()
    {
        System.out.println("||------- Creating User Account -------||");
    }

}
