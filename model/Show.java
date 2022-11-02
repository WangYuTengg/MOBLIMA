package model;

/**
Represents a available show.
@version  1.0
@author   Guo Sihan
@since    2022-10-30
*/
import java.util.Scanner;

public class Show {
	/**
	 * The cineplex of the show.
	 */
	private Cineplex cineplex;

	/**
	 * The time of the show.
	 */
	private String showTime;

	/**
	 * The date of the show.
	 */
	private String showDate;

	/**
	 * The movie of the show.
	 */
	private Movie movie;

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
	private int ticketLength = 0;

	/**
	 * The general price of each ticket of the show.
	 */
	private double price;

	/**
	 * Constructor of a Show.
	 * 
	 * @param cinema   the tickets of the show.
	 * @param movie    the movie of the show.
	 * @param cineplex the cineplex of the show.
	 * @param showDate the time of the show.
	 * @param showTime the time of the show.
	 * @param price    the general price of each ticket of the show.
	 */
	public Show(Cinema cinema, Movie movie, Cineplex cineplex, String showDate, String showTime, double price) {
		this.tickets = new Ticket[cinema.getLayoutRowLength() * cinema.getLayoutColumnLength()];
		this.price = price;
		this.cinema = new Cinema(cinema);
		this.movie = movie;
		this.cineplex = cineplex;
		this.showDate = showDate;
		this.showTime = showTime;
	}

	/**
	 * Set the movie of the show.
	 * 
	 * @param movie the movie to be set.
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	/**
	 * Set the date of the show.
	 * 
	 * @param showDate the date to be set.
	 */
	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}

	/**
	 * Set the time of the show.
	 * 
	 * @param showTime the time to be set.
	 */
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	/**
	 * Set the price of the show.
	 * 
	 * @param price the price to be set.
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Set the cinema of the show;
	 * 
	 * @param cinema the cinema to be set.
	 */
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	/**
	 * Finding the th ticket
	 * 
	 * @param index the index of the ticket to be find.
	 * @return the ticket found.
	 */
	public Ticket ticketAt(int index) {
		return this.tickets[index];
	}

	/**
	 * Get the cinema of the show.
	 * 
	 * @return the cinema of the show.
	 */
	public Cinema getCinema() {
		return this.cinema;
	}

	/**
	 * Get the movie of the show.
	 * 
	 * @return the movie of the show.
	 */
	public Movie getMovie() {
		return this.movie;
	}

	/**
	 * Get the cineplex of the show.
	 * 
	 * @return the cineplex of the show.
	 */
	public Cineplex getCineplex() {
		return this.cineplex;
	}

	/**
	 * Get the date of the show.
	 * 
	 * @return the date of the show.
	 */
	public String getShowDate() {
		return this.showDate;
	}

	/**
	 * Get the time of the show.
	 * 
	 * @return the time of the show.
	 */
	public String getShowTime() {
		return this.showTime;
	}

	/**
	 * Create a ticket corresponding to the seat with index equal to seatIndex.
	 * 
	 * @param seatIndex the index of the seat.
	 * @return the ticket created.
	 */
	public Ticket createTicket(String seatIndex) {
		Scanner sc = new Scanner(seatIndex);
		int row = (sc.nextInt() - 1);
		int column = sc.next().charAt(0) - 'A';
		sc.close();
		if (this.cinema.getLayout()[row][column])
			System.out.println("Oops! This seat is alr taken. Please select another one.");
		else
			this.cinema.assignSeat(row, column);
		this.movie.addSale();
		return this.tickets[this.ticketLength++] = new Ticket(seatIndex, this.cineplex.getName(), this.movie.getTitle(),
				this.showDate + this.showTime, this.cinema.getIndex(), this.ticketLength + 1, this.price);
	}

	/**
	 * To display the detail of the show.
	 */
	public void display() {
		System.out.printf("%20s%10s%10d%20s%20s\n", this.movie.getTitle(), this.cineplex.getName(),
				this.cinema.getIndex(), this.showDate, this.showTime);
	}
}
