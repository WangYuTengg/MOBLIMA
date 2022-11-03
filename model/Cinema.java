package model;
/**
 Represents a cinema
 @version   1.4
 @author    Guo Sihan
 @since     2022-10-30
 */
public class Cinema {
    /**
     * The index of the cinema.
     */
    private int index;

    /**
     * The unique code of each cinema
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
     * The number of rows of the seats.
     */
    private int rowLength;
    
    /**
     * The number of columns of the seats.
     */
    private int columnLength;
    
    /**
     * Constructs a new cinema with the given attributes
     * @param index         the index of the cinema.
     * @param isPlatinum    whether cinema is platinum class
     * @param cineplex      the name of the cineplex.
     * @param rowLength     the number of rows of the seats.
     * @param columnLength  the number of columns of the seats.
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
     * Simplified constructor of the class.(used in show class)
     * @param a the cinema to be copied.
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
                char data[] = {(char)(i+'1'),(char)(j+'A')};
                String temp = new String(data);
                layout[i][j] = new Seat(temp);
            }
    }
    
    /**
     * Get the index of the cinema.
     * @return  the index of the cinema.
     */
    public int getIndex(){return this.index;}
    /**
     * Get the cinema code.
     * @return  the cinema code
     */
    public String getCinemaCode() {return this.cinemaCode;}
    /**
     * Get the type of the cinema.
     * @return  the type of the cinema.
     */
    public boolean getType(){return this.isPlatinum;}
    
    /**
     * Get the name of the cineplex.
     * @return  the name of the cineplex.
     */
    public String getCiniplexName(){return this.cineplexName;}
    
    /**
     * Get the number of rows of the seats.
     * @return  the number of rows of the seats.
     */
    public int getLayoutRowLength(){return this.rowLength;}
    
    /**
     * Get the number of columns of the seats.
     * @return  the number of columns of the seats
     */
    public int getLayoutColumnLength(){return this.columnLength;}

    /**
     * Get cinema code
     * @return cinemaCode
     */
    public String getCinemaCode(){
        return this.cinemaCode;
    }
    
    /**
     * Find the occupying status of seats.
     * @return  occupying status shown in 2D array boolean form.
     */
    public boolean[][] getLayout(){
        boolean[][] a=new boolean[rowLength][columnLength];
        for(int i=0;i<rowLength;++i)
            for(int j=0;j<columnLength;++j)
                a[i][j]=this.layout[i][j].isOccupied();
        return a;
    }
    
    /**
     * To assign a seat.
     * @param row       the row of the seat.
     * @param column    the column of the seat.
     */
    public void assignSeat(int row,int column){
    	this.layout[row][column].assign();
    	}
    
}
