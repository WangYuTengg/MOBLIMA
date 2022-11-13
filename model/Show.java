package model;
import java.util.*;
import java.text.*;

/**
 * Represents a showing of a movie.
 * @version  3.0
 * @author   Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong Jian
 * @since    2022-10-30
*/
public class Show implements java.io.Serializable{

    /**
     * The cineplex of the movie showing.
     */
    private Cineplex cineplex;

    /**
     * The time of the movie showing.
     */
    private Date showTime;

    /**
     * The movie being shown.
     */
    private Movie movie;

    /**
     * The 3D type of the movie showing. 
     */
    private boolean is3D;

    /**
     * The cinema used for the movie showing.
     */
    private Cinema cinema;

    /**
     * The tickets of the movie showing.
     */
    private Ticket[] tickets;

    /**
     * The number of sold tickets of the movie showing.
     */
    private int ticketLength=0;

    /**
     * The general price of each ticket of the movie showing.
     */
    private double price;

    /**
     * Constructor of the class.
     * @param cinema        The cinema of the movie showing.
     * @param movie         The movie being shown.
     * @param cineplex      The cineplex of the movie showing.
     * @param is3d          Whether the show is in 3D.
     * @param showTime      The time of the show.
     */
    public Show(Cinema cinema,Movie movie,Cineplex cineplex,boolean is3d,Date showTime){
        this.tickets = new Ticket[cinema.getLayoutRowLength()*cinema.getLayoutColumnLength()];
        this.cinema = cinema;
        this.movie = movie;
        this.cineplex = cineplex;
        this.showTime = showTime;
		this.is3D = is3d;
    }

    /**
     * Sets the movie of the show.
     * @param movie The movie to be set.
     */
    public void setMovie(Movie movie){
        this.movie=movie;
    }

    /**
     * Sets the time of the show.
     * @param showTime  The time to be set.
     */
    public void setShowTime(Date showTime){
        this.showTime=showTime;
    }

    /**
     * Set the cinema of the show.
     * @param cinema The cinema to be set.
     */
    public void setCinema(Cinema cinema){
        this.cinema=cinema;
    }

    /**
     * Set the 3D type of the movie showing.
     * @param is3D  Whether the showing is in 3D or not.
     */
    public void set3D(boolean is3D){
        this.is3D=is3D;
    }

    /**
     * Finding a specific ticket
     * @param index The index of the ticket to be found.
     * @return      The ticket found.
     */
    public Ticket ticketAt(int index){
        return this.tickets[index];
    }

    /**
     * Get the cinema of the movie showing.
     * @return  The cinema of the movie showing.
     */
    public Cinema getCinema(){
        return this.cinema;
    }

    /**
     * Get the movie being shown.
     * @return  The movie being shown.
     */
    public Movie getMovie(){
        return this.movie;
    
    }
    /**
     * Get the cineplex of the movie showing.
     * @return  The cineplex of the movie showing.
     */
    public Cineplex getCineplex(){
        return this.cineplex;
    }

    /**
     * Get the 3D type of the movie showing.
     * @return  Whether the movie showing is in 3D or not.
     */
    public boolean is3D(){
        return this.is3D;
    }

    /**
     * Get the time of the movie showing.
     * @return  The time of the movie showing.
     */
    public Date getShowTime(){
        return this.showTime;
        }

    /**
     * Creates a ticket corresponding to the seat with index equal to seatIndex.
     * @param seatIndex The index of the seat.
     * @param TID       The transaction ID.
     * @return          The ticket created.
     */
    public Ticket createTicket(String seatIndex, String TID){
        Scanner sc=new Scanner(seatIndex.substring(0, seatIndex.length()-1));
        int row=(sc.nextInt()-1);
        int column=(int)(seatIndex.charAt(seatIndex.length()-1)-'A');
        this.cinema.assignSeat(row,column);
        this.movie.addSale();
        this.tickets[this.ticketLength]=new Ticket(seatIndex,this.cineplex.getName(),this.movie.getTitle(),this.showTime,this.cinema.getIndex(),this.ticketLength+1,this.price, TID);
        this.ticketLength++;
        return this.tickets[this.ticketLength-1];
    }

    /**
     * A function to check if a specific seat is currently already occupied.
     * @param seatIndex     The index of the seat to be checked.
     * @return              Returns a boolean value, true meaning the seat is occupied and false meaning otherwise.
     */
    public boolean checkOccupied(String seatIndex){
        Scanner sc=new Scanner(seatIndex.substring(0, seatIndex.length()-1));
        int row=(sc.nextInt()-1);
        int column=(int)(seatIndex.charAt(seatIndex.length()-1)-'A');
        return this.cinema.getLayout()[row][column];
    }

    /**
     * To display the details of the movie showing.
     */
    public void display(){
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm");
        System.out.printf("%40s%25s%10d%20s\n",this.movie.getTitle(),this.cineplex.getName(),this.cinema.getIndex(), ft.format(this.showTime));
    }
}
