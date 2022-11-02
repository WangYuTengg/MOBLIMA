package model; 
/**
 Represents a seat in a cinema.
 @version   1.0
 @author    Guo Sihan
 @since     2022-10-30
 */
public class Seat {
	
    /**
     * The status of the seat.(Occupied or not)
     */
    private boolean occupied = false;
    
    /**
     * The index of the seat.
	    * Row represented by numbers e.g 4 for 4th row from the front
	    * Columns represented by uppercase letters e.g B for 2nd row from the left
	    * e.g index = "3C" -> row 3 col 3 
     */
    private String index;
    
    /**
     * Creates a new Seat with a seat index
     * @param index   the index of the seat.
     */
    public Seat(String index){
    	this.index = index;
    }
 
    /**
     * Check the status of the seat.
     * @return  whether the seat is occupied.
     */
    public boolean isOccupied(){
    	return this.occupied;
    }
    
    /**
     * Get the index of the seat.
     * @return  the index of the seat.
     */
    public String getIndex(){
    	return this.index;
    }
    
    /**
     * Assign the seat.
     */
    public void assign(){
    	this.occupied = true;
    }
}
