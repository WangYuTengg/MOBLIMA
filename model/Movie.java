/**
 Represents a movie.
 @version   1.0
 @author    Guo Sihan
 @since     2022-10-30
 */
package model;
import java.util.ArrayList;

public class Movie{
    /**
     * The title of the movie.
     */
    private String movieTitle;
    /**
     * The bolockbuster type of the movie.
     */
    private boolean isBlockbuster;
    /**
     * The showing status of the movie.
     */
	
    private String showingStatus;
    /**
     * The director of the movie.
     */
    private String director;
    /**
     * The synopsis of the movie.
     */
    private String synopsis;
    /**
     * The cast list of the movie.
     */
    private String[] cast;
    /**
     * The total score of ratings of the movie.
     */
    private double overallRating=0;
    /**
     * The total sales of the movie.
     */
    private int totalSales=0;
    /**
     * The length of the cast list of the movie.
     */
    private int castLength=0;
    /**
     * The past reviews of the movie.
     */
    private ArrayList<Review> pastReview=new ArrayList<Review>(); 
    /**
     * The constructor of the class.
     * @param title         the title of the movie.
     * @param type          the type of the movie.
     * @param status        the showing status of the movie.
     * @param director      the director of the movie.
     * @param synopsis      the synopsis of the movie.
     * @param cast          the cast list of the movie.
     * @param castLength    the length of the cast list of the movie.
     */
    public Movie(String title,boolean blockbuster,String status,String director,String synopsis,String[] cast,int castLength){
        this.movieTitle=title;this.isBlockbuster=blockbuster;this.showingStatus=status;this.director=director;this.synopsis=synopsis;this.cast=cast;this.castLength=castLength;
    }
    /**
     * Get the title of the movie.
     * @return  the title of the movie.
     */
    public String getTitle(){return this.movieTitle;}
    /**
     * Get the blockbuster type of the movie.
     * @return  the blockbuster type of the movie.
     */
    public boolean isBlockbuster(){return this.isBlockbuster;}
    /**
     * Get the showing status of the movie.
     * @return  the showing status of the movie.
     */
    public String getStatus(){return this.showingStatus;}
    /**
     * Get the synopsis of the movie.
     * @return  the synopsis of the movie.
     */
    public String getSynopsis(){return this.synopsis;}
    /**
     * Get the director of the movie.
     * @return  thr director of the movie.
     */
    public String getDirector(){return this.director;}
    /**
     * Get the cast list of the movie.
     * @return  the cast list of the movie.
     */
    public String[] getCast(){return this.cast;}
    /**
     * Get the overall rating of the movie.
     * @return  the overall rating of the movie.
     */
    public double getOverallRating(){return this.pastReview.size()>1?this.overallRating/this.pastReview.size():-1;}
    /**
     * Get the past review of the movie.
     * @return  the past review of the movie.
     */
    public ArrayList<Review> getPastReview(){return this.pastReview;}
    /**
     * Get the total sales of the movie.
     * @return  the total sales of the movie.
     */
    public int getTotalSales(){return this.totalSales;}
    /**
     * Set the showing status as st.
     * @param st    the showing status to be set as.
     */
    public void setStatus(String st){this.showingStatus=st;}
    /**
     * Set the blockbuster type of the movie.
     * @param blockbuster  the blockbuster type to be set.
     */
    public void setBlockbuster(boolean blockbuster){this.isBlockbuster=blockbuster;}
    /**
     * Set the synopsis of the movie.
     * @param synopsis  the synopsis to be set.
     */
    public void setSynopsis(String synopsis){this.synopsis=synopsis;}
    /**
     * Add a new review.
     * @param rating    the rating of the review.
     * @param review    the comment of the review.
     */
    public void addReview(int rating,String review){this.pastReview.add(new Review(rating,review));this.overallRating+=rating;}
    /**
     * Increment the total sales by 1.
     */
    public void addSale(){this.totalSales++;}
    /**
     * Display the details of the movie.
     */
    public void display(){
        System.out.printf("Movie title:  %s\n",this.movieTitle);
        System.out.printf("Movie blockbuster type:  %b\n",this.isBlockbuster);
        System.out.printf("Movie status:  %s\n",this.showingStatus);
        System.out.printf("Movie synposis:\n%s\n",this.synopsis);
        System.out.printf("Movie director:  %s\n",this.director);
        System.out.printf("Movie cast:\n");
        for(int i=0;i<this.castLength;++i) System.out.printf("%d. %s\n", i+1,this.cast[i]);
        System.out.printf("Overall rating: ");
        if(this.pastReview.size()>1)System.out.printf("%.1lf\n",this.overallRating/this.pastReview.size());
        else System.out.printf("Overall rating not available!\n");
        System.out.printf("Past reviews:\n");
        for(int i=0;i<this.pastReview.size();++i) System.out.printf("Rating:%d\nComments:%s\n",this.pastReview.get(i).getRating(),this.pastReview.get(i).getComment());
    }
}
