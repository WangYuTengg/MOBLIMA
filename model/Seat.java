/**
 * Represents a seat in a cinema.
 * @version  3.0
 * @author   Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong Jian
 * @since    2022-10-30
 */

package model;
 
public class Seat implements java.io.Serializable{
	
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
     * The type of seat.(Elite or not)
     */
    private boolean elite=false;

    /**
     * Creates a new Seat with a seat index
     * @param index   the index of the seat.
     * @param elite	  is seat elite or not.
     */
    public Seat(String index){
    	this.index = index;
    }

    /**
     * A constructor to duplicate an already existing seat.
     * @param a
     */
    public Seat(Seat a){
        this.index=a.getIndex();
        this.elite=a.isElite();
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

    /**
     * Get the type of seat(Elite or not).
     * @return true for elite else false.
     */
    public boolean isElite()
    {
    	return this.elite;
    }

    /**
     * Sets a seat to be an Elite seat.
     */
    public void setElite(){this.elite=true;}
}
