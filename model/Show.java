/**
  Represents a available show.
  @version  2.0
  @author   Guo Sihan
  @since    2022-10-30
*/

package model;
import java.util.*;
import java.text.*;

public class Show implements java.io.Serializable{
    /**
     * The cineplex of the show.
     */
    private Cineplex cineplex;
    /**
     * The time of the show.
     */
    private Date showTime;
    /**
     * The movie of the show.
     */
    private Movie movie;
    /**
     * The 3D type of the show.
     */
    private boolean is3D;
    /**
     * The cinema of the show.
     */
    private Cinema cinema;
    /**
     * The tickets of the show.
     */
    private Ticket[] tickets;
    /**
     * The number of sold tickets of the show.
     */
    private int ticketLength=0;
    /**
     * The general price of each ticket of the show.
     */
    private double price;
    /**
     * Constructor of the class.
     * @param cinema        the cinema of the show.
     * @param movie         the movie of the show.
     * @param cineplex      the cineplex of the show.
     * @param showTime      the time of the show.
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
     * Set the movie of the show.
     * @param movie the movie to be set.
     */
    public void setMovie(Movie movie){this.movie=movie;}
    /**
     * Set the time of the show.
     * @param showTime  the time to be set.
     */
    public void setShowTime(Date showTime){this.showTime=showTime;}
    /**
     * Set the price of the show.
     * @param price the price to be set.
     */
    public void setCinema(Cinema cinema){this.cinema=cinema;}
    /**
     * Set the 3D type of the show.
     * @param is3D  the 3D type.
     */
    public void set3D(boolean is3D){this.is3D=is3D;}
    /**
     * Finding the th ticket
     * @param index the index of the ticket to be find.
     * @return      the ticket found.
     */
    public Ticket ticketAt(int index){return this.tickets[index];}
    /**
     * Get the cinema of the show.
     * @return  the cinema of the show.
     */
    public Cinema getCinema(){return this.cinema;}
    /**
     * Get the movie of the show.
     * @return  the movie of the show.
     */
    public Movie getMovie(){return this.movie;}
    /**
     * Get the cineplex of the show.
     * @return  the cineplex of the show.
     */
    public Cineplex getCineplex(){return this.cineplex;}
    /**
     * Get the 3D type of the show.
     * @return  the 3D type.
     */
    public boolean is3D(){return this.is3D;}
    /**
     * Get the time of the show.
     * @return  the time of the show.
     */
    public Date getShowTime(){return this.showTime;}
    /**
     * Create a ticket corresponding to the seat with index equal to seatIndex.
     * @param seatIndex the index of the seat.
     * @return          the ticket created.
     */
    public Ticket createTicket(String seatIndex, String TID){
        Scanner sc=new Scanner(seatIndex.substring(0, seatIndex.length()-1));
        int row=(sc.nextInt()-1);
        int column=(int)(seatIndex.charAt(seatIndex.length()-1)-'A');
        //sc.close();
        

        this.cinema.assignSeat(row,column);
        this.movie.addSale();
        this.tickets[this.ticketLength]=new Ticket(seatIndex,this.cineplex.getName(),this.movie.getTitle(),this.showTime,this.cinema.getIndex(),this.ticketLength+1,this.price, TID);
        this.ticketLength++;
        return this.tickets[this.ticketLength-1];
    }

    public boolean checkOccupied(String seatIndex){
        Scanner sc=new Scanner(seatIndex.substring(0, seatIndex.length()-1));
        int row=(sc.nextInt()-1);
        int column=(int)(seatIndex.charAt(seatIndex.length()-1)-'A');
        return this.cinema.getLayout()[row][column];
    }

    /**
     * To display the detail of the show.
     */
    public void display(){
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm");
        //System.out.println("Hi");
        System.out.printf("%20s%20s%20d%20s\n",this.movie.getTitle(),this.cineplex.getName(),this.cinema.getIndex(), ft.format(this.showTime));
    }
}
