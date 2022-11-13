package model;

/**
 * Represents a Cineplex.
 * @version  3.0
 * @author   Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong Jian
 * @since    2022-10-30
 */
public class Cineplex implements java.io.Serializable{
	
    /**
     * The list of cinemas in a Cineplex.
     */
    private Cinema[] cinemaList;
    
    /**
     * The current number of Cinemas in the Cineplex.
     */
    private int cinemaNum = 0;
    
    /**
     * The name of the Cineplex.
     */
    private String name;
    
    /**
     * Creates a new Cineplex with Cineplex's name and size.
     * @param name          The name of the Cineplex.
     * @param cineplexSize  The total number of Cinemas.
     */
    public Cineplex(String name,int cineplexSize){
    	this.name = name;
    	this.cinemaList = new Cinema[cineplexSize];
    }
    
    /**
     * Gets the name of the Cineplex.
     * @return  The name of the Cineplex.
     */
    public String getName(){
    	return this.name;
    }
    
    /**
     * Returns a list of all Cinemas in the Cineplex.
     * @return  The list of Cinemas.
     */
    public Cinema[] getCinemaList() {
    	return this.cinemaList;
    }

    /**
     * Gets a Cinema using it's Cinema Code.
     * @param cinemacode    The Cinema Code.
     * @return The Cinema corresponding to the code. 
     */
    public Cinema getCinema(String cinemacode){
        for (Cinema cinema: cinemaList) {
            if (cinema.getCinemaCode().equals(cinemacode)) return cinema;
        }
        return null;
    }

    /**
     * Gets a Cinema using an index.
     * @param cinemaId The Cinema index.
     * @return returns The Cinema from the Cinema list.
     */
    public Cinema getCinema(int cinemaId){
        return cinemaList[cinemaId];
    }
    
    /**
     * Adds a Cinema to the Cineplex.
     * @param a The Cinema to be added to the Cineplex.
     */
    public void addCinema(Cinema a){
    	this.cinemaList[this.cinemaNum++]=a;
    }
}
