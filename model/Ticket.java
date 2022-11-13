package model;

import java.util.Date;

/**
* Represents a ticket.
* @version  3.0
* @author   Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong Jian
* @since    2022-10-30
*/
public class Ticket implements java.io.Serializable{
    /**
	 * Ticket's seatIndex. 
	 * Row represented by numbers e.g 4 for 4th row from the front,
	 * Columns represented by uppercase letters e.g B for 2nd row from the left,
	 * e.g seatIndex = "3C" -> row 3 col 3 
	 */
    private String seatIndex;
    
	/**
	 * Ticket's associated cineplex name. 
	 */
    private String cineplexName;
    
	/**
	 * Ticket's associated movie title.
	 */
    private String movieTitle;
    
	/**
	 * Ticket's associated movie timing.
	 */
    private Date movieTiming;
    
	/**
	 * Ticket's cinema number.
	 */
    private int cinemaNum;
    
	/**
	 * Ticket's index.
	 */
    private int ticketIndex;
    
	/**
	 * Ticket's price.
	 */
    private double price;

    /**
	 * The transaction ID of the ticket.
	 */
    private String TID;

	/**
	 * Creates a new ticket with the given attributes:
	 * @param seatIndex This Ticket's associated seat index.
	 * @param cineplexName This Ticket's associated cineplex name.
	 * @param movieTitle This Ticket's associated movie title.
	 * @param movieTiming This Ticket's associated movie timing.
	 * @param cinemaNum This Ticket's associated cinema number.
	 * @param ticketIndex This Ticket's associated ticket index.
	 * @param price This Ticket's associated price.
     * @param TID This Ticket's associated transaction ID.
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
     * @return This Ticket's associated seatIndex.
     */
    public String getSeatIndex(){
    	return this.seatIndex;
    	}

    /**
     * Gets the cineplex name of the ticket. 
     * @return This Ticket's associated cineplexName.
     */
    public String getCineplexName(){
    	return this.cineplexName;
    	}

    /**
     * Gets the movie title of the ticket. 
     * @return This Ticket's associated movieTitle.
     */
    public String getMovieTitle(){
    	return this.movieTitle;
    	}

    /**
     * Gets the movie timing of the ticket. 
     * @return This Ticket's associated movieTiming.
     */
    public Date getMovieTiming(){
    	return this.movieTiming;
    	}
    
    /**
     * Gets the cinema number of the ticket. 
     * @return This Ticket's associated Cinema Number.
     */
    public int getCinemaNum(){
    	return this.cinemaNum;
    	}
    
    /**
     * Gets the price of the ticket. 
     * @return This Ticket's associated price.
     */
    public double getPrice(){
    	return this.price;
    	}
    
    /**
     * Gets the index of the ticket. 
     * @return This Ticket's associated ticketIndex in a list of Tickets.
     */
    public int getIndex(){
    	return this.ticketIndex;
    	}

    /**
     * Gets the transaction ID of the ticket. 
     * @return This Ticket's associated Transaction ID.
     */
    public String getTID()
    {
    	return this.TID;
    }
    
    /**
     * Sets the price of the ticket. 
     * @param price     The price of the ticket to be set.
     */
    public void setPrice(double price){
    	this.price=price;
    }
}
