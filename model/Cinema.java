package model;

/**
 * Represents a Cinema.
 * @version  2.0
 * @author   Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong Jian
 * @since    2022-10-30
 */
public class Cinema implements java.io.Serializable{
    /**
     * The index of the cinema.
     */
    private int index;

    /**
     * The unique code of each cinema.
     * 1st letter -> Represents the cineplex.
     * 2nd letter -> Cinema number corresponding to the alphabet. (e.g B == 2)
     * 3rd letter -> N or P -> Normal or Platinum.
     * e.g "ABN" -> cineplex1, cinema1, Normal.
     */
    private String cinemaCode;

    /**
     * The type of the cinema.
     */
    private boolean isPlatinum;
    
    /**
     * The name of the cineplex.
     */
    private String cineplexName;
    
    /**
     * The seats in the cinema.
     */
    private Seat[][] layout;
    
    /**
     * The number of rows of seats.
     */
    private int rowLength;
    
    /**
     * The number of columns of seats.
     */
    private int columnLength;
    
    /**
     * Constructs a new Cinema with the given attributes.
     * @param index         The index of the Cinema.
     * @param cinemaCode    The Cinema code.
     * @param isPlatinum    Whether Cinema is Normal or Platinum
     * @param cineplex      The name of the Cineplex.
     * @param rowLength     The number of rows of seats.
     * @param columnLength  The number of columns of seats.
     */
    public Cinema(int index, String cinemaCode, boolean isPlatinum, String cineplex,int rowLength,int columnLength){
        this.index = index;
        this.cinemaCode = cinemaCode;
        this.isPlatinum = isPlatinum;
        this.cineplexName = cineplex;
        this.rowLength = rowLength;
        this.columnLength = columnLength;
        this.layout = new Seat[rowLength][columnLength];
        for(int i=0; i<rowLength; ++i)
            for(int j =0; j<columnLength; ++j){
                char data[] = {(char)(i+'1'),(char)(j+'A')};
                String temp = new String(data);
                layout[i][j] = new Seat(temp);
            }
    }
    
    /**
     * Simplified constructor of the class. (used in show class)
     * @param a The Cinema to be copied.
     */
    public Cinema(Cinema a){
        this.index = a.index;
        this.cinemaCode = a.cinemaCode;
        this.isPlatinum = a.isPlatinum;
        this.cineplexName = a.cineplexName;
        this.rowLength = a.rowLength;
        this.columnLength = a.columnLength;
        this.layout = new Seat[a.getLayoutRowLength()][a.getLayoutColumnLength()];
        for(int i=0; i<this.rowLength; ++i)
            for(int j=0; j<this.columnLength; ++j){
                layout[i][j] = new Seat(a.getSeats()[i][j]);
            }
    }
    
    /**
     * Gets the index of the Cinema.
     * @return  The index of the Cinema.
     */
    public int getIndex(){return this.index;}

    /**
     * Gets the type of the Cinema.
     * @return  The type of the Cinema.
     */
    public boolean getType(){return this.isPlatinum;}
    
    /**
     * Gets the name of the Cineplex.
     * @return  The name of the Cineplex.
     */
    public String getCiniplexName(){return this.cineplexName;}
    
    /**
     * Gets the number of rows of seats.
     * @return  The number of rows of seats.
     */
    public int getLayoutRowLength(){return this.rowLength;}
    
    /**
     * Gets the number of columns of seats.
     * @return  The number of columns of seats.
     */
    public int getLayoutColumnLength(){return this.columnLength;}

    /**
     * Gets the cinema code.
     * @return The Cinema code.
     */
    public String getCinemaCode(){
        return this.cinemaCode;
    }
    
    /**
     * Gets the seat layout of the Cinema.
     * @return The layout of the Cinema.
     */
    public Seat[][] getSeats()
    {
    	return this.layout;
    }

    /**
     * Finds the status of seats. (Occupied or not)
     * @return  Seats status shown in 2D array boolean form.
     */
    public boolean[][] getLayout(){
        boolean[][] a=new boolean[rowLength][columnLength];
        for(int i=0;i<rowLength;++i)
            for(int j=0;j<columnLength;++j)
                a[i][j]=this.layout[i][j].isOccupied();
        return a;
    }
    
    /**
     * Assigns a seat by setting it to be occupied.
     * @param row       The corresponding row of the seat.
     * @param column    The corresponding column of the seat.
     */
    public void assignSeat(int row,int column){
    	this.layout[row][column].assign();
    	}
    
    /**
     * Sets a row of seats to be Elite seats.
     * @param row   The row number.
     */
    public void setElite(int row){
        for(int i=0;i<columnLength;++i) layout[row][i].setElite();
    }
}
