package model;
/**
 Represents a cineplex
 @version   2.0
 @author    Guo Sihan
 @since     2022-10-30
 */
public class Cineplex implements java.io.Serializable{
	
    /**
     * The list of cinemas in the cineplex.
     */
    private Cinema[] cinemaList;
    
    /**
     * The current number of cinemas in the cineplex.
     */
    private int cinemaNum = 0;
    
    /**
     * The name of the cineplex.
     */
    private String name;
    
    /**
     * Creates a new Cineplex with Cineplex's name and size
     * @param name          the name of the cineplex.
     * @param cineplexSize  the total number of cinemas.
     */
    public Cineplex(String name,int cineplexSize){
    	this.name = name;
    	this.cinemaList = new Cinema[cineplexSize];
    }
    
    /**
     * Get the name of the cineplex.
     * @return  the name of the cineplex.
     */
    public String getName(){
    	return this.name;
    }
    
    /**
     * Return list of cinema in cineplex
     * @return  cinemaList  The list of cinemas.
     */
    public Cinema[] getCinemaList() {
    	return this.cinemaList;
    }

    /**
     * Get cinema using cinema code
     * @param cinemacode    The cinema code.
     * @return cinema       The cinema corresponding to the code. 
     */
    public Cinema getCinema(String cinemacode){
        for (Cinema cinema: cinemaList) {
            if (cinema.getCinemaCode().equals(cinemacode)) return cinema;
        }
        return null;
    }

    /**
     * Get cinema using index
     * @param index the cinema index.
     */
    public Cinema getCinema(int cinemaId){
        return cinemaList[cinemaId];
    }
    
    /**
     * Add a cinema to the cineplex.
     * @param a the cinema to be added to the cineplex.
     */
    public void addCinema(Cinema a){
    	this.cinemaList[this.cinemaNum++]=a;
    }
}
