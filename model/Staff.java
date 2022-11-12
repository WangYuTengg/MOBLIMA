/**
 Represents the Staff Class.
 @version   2.0
 @author    Davyn Yam
 @since     2022-11-01
 */

package model;
import controller.Database;
import java.util.Scanner;
import java.text.ParseException;
import java.util.ArrayList;

public class Staff implements java.io.Serializable{
    /**
     * The email of the Staff member.
     */
    private String email;
    /**
     * The password of the Staff member.
     */
    private String password;
    /**
     * The name of the Staff member.
     */
    private String staffName;
    /**
     * A static Scanner class used throughout Staff
     */
    private static Scanner scan = new Scanner(System.in);
    /**
     * The Constructor of the class.
     * @param adminEmail
     * @param pass
     * @param name
     */
    public Staff(String adminEmail, String pass, String name){
        email = adminEmail;
        password = pass;
        staffName = name;
    }

    /**
     * get the ID of the Staff member.
     * @return
     */
    public String getAdminEmail() {
        return email;
    }

    /**
     * Get the password of the Staff member.
     * @return
     */
    public String getPass() {
        return password;
    }

    /**
     * Gets the name of the Staff member.
     * @return
     */
    public String getName(){
        return staffName;
    }
    
    /**
     * Creating a Movie class, and adding it to the movieListing within the Database.
     */
    public static void addMovie(Database db){
        int alreadyExists = 0;
        System.out.println("Enter the Title of the Movie: "); // movie title
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
            System.out.println("Please re-enter the Title of the Movie:");
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
        System.out.println("Is the movie a Blockbuster movie? (true or false)"); // movie type
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
        

        System.out.println("Enter the Movie's director: "); // movie director
        String director = scan.nextLine();

        System.out.println("How many cast members would you like to list? (Maximum 10)"); // movie cast
        int castLength = scan.nextInt();
        while (castLength > 10 || castLength <= 0){
            System.out.println("Invalid Input.\nPlease re-enter.");
            castLength = scan.nextInt();
        }
        scan.nextLine();
        String[] cast = new String[10];
        System.out.println("Enter the name of the cast members: ");
        for (int i = 0; i < castLength; i++) {
            System.out.printf("Cast Member No.%d:\n", i+1);
            String temp = scan.nextLine();
            cast[i] = temp;
        }

        System.out.println("Enter the Synopsis of the Movie: "); // movie synopsis
        String synopsis = scan.nextLine();

        Movie movie = new Movie(title, type, status, director, synopsis, cast, castLength);

        db.movieListing.addMovie(movie); 
    }
    /**
     * Edit the details of a Movie.
     */
    public static void editMovie(Database db){
        db.movieListing.listMovies();
        System.out.println("Please input the index of the movie to update.");
        int choice = scan.nextInt();
        db.movieListing.updateMovie(choice-1);
        System.out.println("Movie details have successfully been updated.");
    }

    /**
     * Removing a movie from the movieListing within the Database. 
     */
    public static void deleteMovie(Database db){
        db.movieListing.deleteMovie();
        System.out.println("Movie has successfully been deleted.");
    }
    
    /**
     * Adding a Show class to the MovieListing class.
     */
    public static void addShow(Database db){
        try {
			db.showListing.createShow(db);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        System.out.println("The Show has been successfully created.");
    }

    /**
     * Removing a Show from the MovieListing.
     */
    public static void deleteShow(Database db) {
       db.showListing.deleteShow(); 
       System.out.println("The Show has been deleted");
    }

    /**
     * Updating attributes of a Show
     */
    public static void updateShow(Database db){ 
        db.showListing.displayShows();
        System.out.println("Input the index of the show to be updated");
        int choice = scan.nextInt();
        try {
			db.showListing.updateShow(choice-1,db);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        System.out.println("The Show has been udpated.");
    }

    public void setTicketPrice(){
        double price = scan.nextDouble();
        Payment.setBasePrice(price);
        System.out.println("The base ticket price has been updated.");
    }
    public static void addCineplex(Database db){
        System.out.println("Enter the name of the cineplex");
        String cineplex_name=scan.nextLine();
        System.out.println("Enter the number of the cinemas");
        while(!scan.hasNextInt()){System.out.println("Please enter a number!");}
        int num_cinema=scan.nextInt();
        Cineplex cineplex;
        char first_letter='A';
        if(db.cineplexes.size()>0) first_letter=(char)((int)db.cineplexes.get(db.cineplexes.size()-1).getCinema(1).getCinemaCode().charAt(0)+1);
        db.addCineplex(cineplex=new Cineplex(cineplex_name, num_cinema));
        int cnt=1;
        while(num_cinema>=cnt){
            if(addCinema(cineplex,cnt,first_letter)) cnt++;
        }
    }

    public static boolean addCinema(Cineplex cineplex,int index,char first_letter){
	System.out.printf("Adding cinema No.%d\n",index);
        System.out.println("Enter the platinum type of the cinema(P/N)");
        String platinum_type=scan.next();
        // System.out.println(platinum_type);
        while(!(platinum_type.equals("P")||platinum_type.equals("N"))){System.out.println("Enter the platinum type of the cinema(P/N)");platinum_type=scan.next();}
        char[] cinemaCode={first_letter,(char)(index+'0'),platinum_type.charAt(0)};
        System.out.println("Enter the number of rows");
        while(!scan.hasNextInt()){System.out.println("Please enter a number!");}
        int row=scan.nextInt();
        System.out.println("Enter the number of columns");
        while(!scan.hasNextInt()){System.out.println("Please enter a number!");}
        int column=scan.nextInt();
        cineplex.addCinema(new Cinema(index,new String(cinemaCode),platinum_type=="P",cineplex.getName(),row,column));
        return true;
    }

    public static void deleteCineplex(Database db){
        for(int i=1;i<=db.cineplexes.size();++i){
            System.out.printf("%d %s\n",i,db.cineplexes.get(i-1).getName());
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
        System.out.println("Remove successful!");
    }
}
