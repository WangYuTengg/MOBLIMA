package model;
/**
 Represents a cineplex
 @version   1.0
 @author    Guo Sihan
 @since     2022-10-30
 */
public class Cineplex{
	
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
     * Add a cinema to the cineplex.
     * @param a the cinema to be added to the cineplex.
     */
    public void addCinema(Cinema a){
    	this.cinemaList[this.cinemaNum++]=a;
    }
   
    public Cinema[] getCinemaList() {
    	return this.cinemaList;
    }
}
