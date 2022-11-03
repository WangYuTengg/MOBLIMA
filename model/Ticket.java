package model;

import java.util.Date;

/**
  Represents a ticket.
  @version  1.0
  @author   Guo Sihan
  @since    2022-10-30
*/

public class Ticket {
    /**
	 * Ticket's seatIndex 
	 * Row represented by numbers e.g 4 for 4th row from the front
	 * Columns represented by uppercase letters e.g B for 2nd row from the left
	 * e.g seatIndex = "3C" -> row 3 col 3 
	 */
    private String seatIndex;
    
	/**
	 * Ticket's associated cineplex name 
	 */
    private String cineplexName;
    
	/**
	 * Ticket's associated movie title
	 */
    private String movieTitle;
    
	/**
	 * Ticket's associated movie timing
	 */
    private Date movieTiming;
    
	/**
	 * Ticket's cinema number
	 */
    private int cinemaNum;
    
	/**
	 * Ticket's index
	 */
    private int ticketIndex;
    
	/**
	 * Ticket's price
	 */
    private double price;
    /**
	 * The transaction ID of the ticket
	 */
    private String TID;
    
    
	/**
	 * Creates a new ticket with the given attributes
	 * @param seatIndex This Ticket's seat index.
	 * @param cineplexNum This Ticket's cineplex number.
	 * @param movieTitle This Ticket's movie title.
	 * @param movieTiming This Ticket's movie timing.
	 * @param cinemaNum This Ticket's cinema number.
	 * @param ticketIndex This Ticket's ticket index.
	 * @param price This Ticket's price.
	 */
    public Ticket(String seatIndex,String cineplexName,String movieTitle,Date movieTiming,int cinemaNum,int ticketIndex,double price, String TID){
        this.seatIndex=seatIndex;
        this.cinemaNum=cinemaNum;
        this.cineplexName=cineplexName;
        this.movieTiming=movieTiming;
        this.movieTitle=movieTitle;
        this.price=price;
        this.ticketIndex=ticketIndex;
        this.TID = TID;
    }
    
    
    /**
     * Gets the seat index of the ticket. 
     * @return this Ticket's seatIndex
     */
    public String getSeatIndex(){
    	return this.seatIndex;
    	}

    /**
     * Gets the cineplex name of the ticket. 
     * @return this Ticket's cineplexName
     */
    public String getCineplexName(){
    	return this.cineplexName;
    	}

    /**
     * Gets the movie title of the ticket. 
     * @return this Ticket's movieTitle
     */
    public String getMovieTitle(){
    	return this.movieTitle;
    	}

    /**
     * Gets the movie timing of the ticket. 
     * @return this Ticket's movieTiming
     */
    public Date getMovieTiming(){
    	return this.movieTiming;
    	}
    
    /**
     * Gets the cinema number of the ticket. 
     * @return this Ticket's cinemaNum
     */
    public int getCinemaNum(){
    	return this.cinemaNum;
    	}
    
    /**
     * Gets the price of the ticket. 
     * @return this Ticket's price
     */
    public double getPrice(){
    	return this.price;
    	}
    
    /**
     * Gets the index of the ticket. 
     * @return this Ticket's ticketIndex
     */
    public int getIndex(){
    	return this.ticketIndex;
    	}
    /**
     * Gets the transaction ID of the ticket. 
     * @return this Ticket's Transaction ID
     */
    public String getTID()
    {
    	return this.TID;
    }
    
    /**
     * Sets the price of the ticket. 
     * @param price     The price of the ticket to set it to
     */
    public void setPrice(double price){
    	this.price=price;
    }
}
