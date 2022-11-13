package controller;
import java.util.Scanner;

import data.Database;
import model.Cinema;
import model.Cineplex;
import model.Movie;
import model.User;

import java.text.ParseException;
import java.util.ArrayList;

/**
* Represents the Staff Class.
* @version  4.0
* @author   Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong Jian
* @since    2022-10-30
*/
public class Staff extends User{

    /**
     * A static Scanner class used throughout the Staff class.
     */
    private static Scanner scan = new Scanner(System.in);

    /**
     * The Constructor of the Staff class.
     * @param adminEmail    The email of the Staff member.
     * @param pass          The password of the Staff member.
     * @param name          The name of the Staff member.
     */
    public Staff(String adminEmail, String pass, String name){
        super(name, adminEmail, pass);
    }
    
    /**
     * Creating a Movie class, and adding it to the movieListing within the Database.
     * @param db Inputing the database as a parameter.
     */
    public static void addMovie(Database db){
        scan=new Scanner(System.in);
        int alreadyExists = 0;
        System.out.printf("Enter the Title of the Movie: "); // movie title
        String title = scan.nextLine();

        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies = db.movieListing.getMovies();

        for (int i = 0; i<movies.size(); i++) {
            if (movies.get(i).getTitle().equals(title)){
                System.out.println("The movie already exists in the system.");
                alreadyExists = 1;
                break;
            }
        }

        while (alreadyExists == 1){
            System.out.printf("Please re-enter the Title of the Movie: ");
            title = scan.nextLine();
            alreadyExists = 0;
            for (int i = 0; i<movies.size(); i++) {
                if (movies.get(i).getTitle() == title){
                    System.out.println("The movie already exists in the system.");
                    alreadyExists = 1;
                    break;
                }
            }
        }
        Boolean type;
        System.out.printf("Is the movie a Blockbuster movie? (true or false) "); // movie type
        String input = scan.nextLine();
    
        // Error checking for invalid inputs
        while (input.equals("true") == false && input.equals("false") == false){
            System.out.println("Invalid Input. Please re-enter.\nIs the movie a Blockbuster movie? (true or false)");
            input = scan.nextLine();
        }
        type = Boolean.parseBoolean(input);
        String status = "unknown";
        System.out.println("Enter the Movie's Showing Status: \n1. Coming Soon\n2. Preview\n3. Now Showing\n4. End Of Showing"); // movie showing status
        
        String statusInput = scan.nextLine();
        // Error checking for invalid inputs
        do {
            switch (statusInput) {
                case("1"):
                    status = "COMING_SOON";
                    break;
                case("2"):
                    status = "PREVIEW";
                    break;
                case("3"):
                    status = "NOW_SHOWING";
                    break;
                case ("4"):
                    status = "END_OF_SHOWING";
                    break;
                default:
                    System.out.println("Invalid Input. Please re-enter.\nEnter the Movie's Showing Status: \n1. Coming Soon\n2. Preview\n3. Now Showing\n4. End Of Showing");
                    statusInput = scan.next();
            }
        } while(status.equals("unknown"));
        

        System.out.printf("Enter the Movie's director: "); // movie director
        String director = scan.nextLine();

        System.out.printf("How many cast members would you like to list? (Maximum 10) "); // movie cast
        int castLength = scan.nextInt();
        while (castLength > 10 || castLength <= 0){
            System.out.println("Invalid Input.\nPlease re-enter.");
            castLength = scan.nextInt();
        }
        scan.nextLine();
        String[] cast = new String[10];
        System.out.println("Enter the name of the cast members: ");
        for (int i = 0; i < castLength; i++) {
            System.out.printf("Cast Member No.%d:", i+1);
            String temp = scan.nextLine();
            cast[i] = temp;
        }

        System.out.println("Enter the Synopsis of the Movie: "); // movie synopsis
        String synopsis = scan.nextLine();

        String ageRating = "unknown";
        System.out.println("Please enter the age rating for the movie:\n1. G\n2. PG\n3. PG13\n4. R\n5. M18\n6. R21");
        String ageRatingInput = scan.nextLine();
        do {
            switch (ageRatingInput) {
                case("1"):
                    ageRating = "G";
                    break;
                case("2"):
                    ageRating = "PG";
                    break;
                case("3"):
                    ageRating = "PG13";
                    break;
                case ("4"):
                    ageRating = "R";
                    break;
                case ("5"):
                    ageRating = "M18";
                    break;
                case("6"):
                    ageRating = "R21";
                    break;
                default:
                    System.out.println("Invalid Input. \nPlease enter the age rating for the movie:\n1. G\n2. PG\n3. PG13\n4. R\n5. M18\n6. R21");
                    ageRatingInput = scan.nextLine();
            }
        } while (ageRating.equals("unknown"));

        Movie movie = new Movie(title, type, status, director, synopsis, cast, castLength, ageRating);

        db.movieListing.addMovie(movie); 
        System.out.printf("%s successfully added to movie list.\n", movie.getTitle());
    }

    /**
     * Edits the details of a Movie.
     * @param db The database containing the movies.
     */
    public static void editMovie(Database db){
        scan=new Scanner(System.in);
        db.movieListing.listMovies(true);
        System.out.println("Please input the index of the movie to update. (-1 to return)");
        int choice = scan.nextInt();
        if (choice==-1)
        {
            System.out.println("Returning...");
            return;
        }
        db.movieListing.updateMovie(choice-1);
        System.out.println("Movie details have successfully been updated.");
    }

    /**
     * Removing a movie from the movieListing within the Database.
     * @param db The database containing the movies. 
     */
    public static void deleteMovie(Database db){
        db.movieListing.deleteMovie(true);
    }
    
    /**
     * Adding a Show class to the ShowListing class.
     * @param db The database containing the shows.
     */
    public static void addShow(Database db){
        try {
			db.showListing.createShow(db);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }

    /**
     * Removing a Show from the ShowListing class.
     * @param db The database containing the shows.
     */
    public static void deleteShow(Database db) {
            db.showListing.deleteShow(); 
    }

    /**
     * Updates attributes of an existing Show.
     * @param db The database containing the shows.
     */
    public static void updateShow(Database db){ 
        scan=new Scanner(System.in);
        db.showListing.displayShows();
        System.out.println("Input the index of the show to be updated (-1 to return)");
        
        while(!scan.hasNextInt()){
            System.out.println("Please enter a valid index.");
            scan.next();
        }
        int choice = scan.nextInt();
        
        if (choice==-1)
        {
            System.out.println("Returning...");
            return;
        }

        if(choice < -1 || choice >= db.showListing.getShows().size() || choice == 0){
            System.out.println("Invalid input. Returning to previous menu...");
            return;
        }
        try {
			db.showListing.updateShow(choice-1,db);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        System.out.println("The Show has been udpated.");
    }

    /**
     * Method to add a Cineplex to the database.
     * @param db The database containing the cineplexes.
     */
    public static void addCineplex(Database db){
        scan=new Scanner(System.in);
        System.out.println("Enter the number of the cinemas");
        while(!scan.hasNextInt()){System.out.println("Please enter a number!");}
        int num_cinema=scan.nextInt();
        scan.nextLine();
        System.out.println("Enter the name of the cineplex");
        String cineplex_name = scan.nextLine();
        Cineplex cineplex;
        char first_letter='A';
        if(db.cineplexes.size()>0) first_letter=(char)((int)db.cineplexes.get(db.cineplexes.size()-1).getCinema(0).getCinemaCode().charAt(0)+1);
        db.addCineplex(cineplex=new Cineplex(cineplex_name, num_cinema));
        int cnt=1;
        while(num_cinema>=cnt){
            if(addCinema(cineplex,cnt,first_letter)) cnt++;
        }
        System.out.printf("%s added successfully!\n",cineplex.getName());
    }

    /**
     * Method to add a Cinema to the database.
     * @param cineplex      The cineplex that the cinema is being added to.
     * @param index         The index of the cinema.
     * @param first_letter  The first letter of the cinema code.
     * @return              A boolean value for when the cinema has been added.
     */
    public static boolean addCinema(Cineplex cineplex,int index,char first_letter){
        scan=new Scanner(System.in);
	    System.out.printf("Adding cinema No.%d\n",index);
        System.out.println("Enter the platinum type of the cinema(P/N)");
        String platinum_type=scan.next();
        while(!(platinum_type.equals("P")||platinum_type.equals("N"))){
            System.out.println("Enter the platinum type of the cinema(P/N)");
            platinum_type=scan.next();
        }
        char[] cinemaCode={first_letter,(char)(index+'0'),platinum_type.charAt(0)};
        System.out.println("Enter the number of rows");
        while(!scan.hasNextInt()){System.out.println("Please enter a number!");}
        int row=scan.nextInt();
        System.out.println("Enter the number of columns");
        while(!scan.hasNextInt()){System.out.println("Please enter a number!");}
        int column=scan.nextInt();
        Cinema temp=new Cinema(index,new String(cinemaCode),platinum_type=="P",cineplex.getName(),row,column);
        System.out.println("Enter the number of elite rows");
        while(!scan.hasNextInt()){System.out.println("Please enter a number!");}
        int num_elite=scan.nextInt();
        for(int i=0;i<num_elite;++i){
            System.out.printf("Enter the row index of the %dth row elite seats(1-%d)\n",i+1,row);
            while(!scan.hasNextInt()){System.out.println("Please enter a number!");}
            temp.setElite(scan.nextInt()-1);
        }
        cineplex.addCinema(temp);
        return true;
    }

    /**
     * Method to delete cineplex from database.
     * @param db The database containing all the cineplexes.
     */
    public static void deleteCineplex(Database db){
        scan=new Scanner(System.in);
        for(int i=1;i<=db.cineplexes.size();++i){
            System.out.printf("%d. %s\n",i,db.cineplexes.get(i-1).getName());
        }
        System.out.println("Please enter the index of cineplex");
        int index;
        while(true){
            if(!scan.hasNextInt())System.out.println("Please enter a number!");
            else{
                index=scan.nextInt();
                if(index<1||index>db.cineplexes.size()) System.out.println("Please enter a valid number!");
                else break;
            }
        }
        db.cineplexes.remove(index-1);
        System.out.println("Removal of cineplex successful!");
    }
}
