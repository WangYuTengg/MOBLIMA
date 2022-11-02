package model;

/**
 Represents the Staff Class.
 @version   1.0
 @author    Davyn Yam
 @since     2022-11-01
 */

import controller.Database;
import java.util.Scanner;
import java.util.ArrayList;

public class Staff {
    /**
     * The userID of the Staff member.
     */
    private String userID;
    /**
     * The password of the Staff member.
     */
    private String password;
    /**
     * The name of the Staff member.
     */
    private String staffName;

    /**
     * The Constructor of the class.
     * @param staffId
     * @param pass
     */
    public Staff(String staffId, String pass, String name){
        userID = staffId;
        password = pass;
        staffName = name;
    }

    /**
     * get the ID of the Staff member.
     * @return
     */
    public String getID() {
        return userID;
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
    public void addMovie(){
        Scanner scan = new Scanner(System.in);
        int alreadyExists = 0;
        System.out.println("Enter the Title of the Movie: "); // movie title
        String title = scan.nextLine();

        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies = Database.movieListing.getMovies();

        for (int i = 0; i<movies.size(); i++) {
            if (movies.get(i).getTitle() == title){
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

        System.out.println("Enter the Movie Type: "); // movie type
        String type = scan.nextLine();

        System.out.println("Enter the Movie's Showing Status: "); // movie showing status
        String status = scan.nextLine();

        System.out.println("Enter the Movie's director: "); // movie director
        String director = scan.nextLine();

        System.out.println("How many cast members would you like to list?"); // movie cast
        int castLength = scan.nextInt();
        String[] cast = new String[castLength];
        System.out.println("Enter the name of the cast members: ");
        for (int i = 0; i < castLength; i++) {
            cast[i] = scan.nextLine();
        }

        System.out.println("Enter the Synopsis of the Movie: "); // movie synopsis
        String synopsis = scan.nextLine();

        Movie movie = new Movie(title, type, status, director, synopsis, cast, castLength);

        Database.movieListing.addMovie(movie); 

        scan.close();
    }
    /**
     * Edit the details of a Movie.
     */
    public void editMovie(){
        Scanner scan = new Scanner(System.in);
        Database.movieListing.listMovies();
        System.out.println("Please input the index of the movie to update.");
        int choice = scan.nextInt();
        Database.movieListing.updateMovie(choice);
        System.out.println("Movie details have successfully been udpated.");
        scan.close();
    }

    /**
     * Removing a movie from the movieListing within the Database. 
     */
    public void deleteMovie(){
        Database.movieListing.deleteMovie();
        System.out.println("Movie has successfully been deleted.");
    }
    
    /**
     * Adding a Show class to the MovieListing class.
     */
    public void addShow(){
        Database.showListing.createShow();
        System.out.println("The Show has been successfully created.");
    }

    /**
     * Removing a Show from the MovieListing.
     */
    public void deleteShow() {
       Database.showListing.deleteShow(); 
       System.out.println("The Show has been deleted");
    }

    /**
     * Updating attributes of a Show
     */
    public void updateShow(){ 
        Scanner scan = new Scanner(System.in);
        Database.showListing.displayShows();
        System.out.println("Input the index of the show to be updated");
        int choice = scan.nextInt();
        Database.showListing.updateShow(choice);
        System.out.println("The Show has been udpated.");
        scan.close();
    }

    public void setTicketPrice(){
        Scanner scan = new Scanner(System.in);
        double price = scan.nextDouble();
        Payment.setTicketPrice(price);
        System.out.println("The base ticket price has been updated.");
    }
    
}
