package model;
import java.util.ArrayList;

/**
 * Represents a movie.
 * @version  3.0
 * @author   Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong Jian
 * @since    2022-10-30
 */
public class Movie implements java.io.Serializable{

    /**
     * The title of the movie.
     */
    private String movieTitle;

    /**
     * The Blockbuster type of the movie. 
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
     * The total average score of ratings of the movie.
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
     * The age rating of the movie.
     */
    private String ageRating;

    /**
     * The past reviews of the movie.
     */
    private ArrayList<Review> pastReview=new ArrayList<Review>(); 

    /**
     * The constructor of the class.
     * @param title         The title of the movie.
     * @param blockbuster   The blockbuster type of the movie.
     * @param status        The showing status of the movie.
     * @param director      The director of the movie.
     * @param synopsis      The synopsis of the movie.
     * @param cast          The cast list of the movie.
     * @param castLength    The length of the cast list of the movie.
     * @param rating        The age rating of the movie.
     */
    public Movie(String title,boolean blockbuster,String status,String director,String synopsis,String[] cast,int castLength, String rating){
        this.movieTitle=title;
        this.isBlockbuster=blockbuster;
        this.showingStatus=status;
        this.director=director;
        this.synopsis=synopsis;
        this.cast=cast;
        this.castLength=castLength;
        this.ageRating=rating;
    }

    /**
     * Gets the title of the movie.
     * @return  The title of the movie.
     */
    public String getTitle(){
        return this.movieTitle;
    }
    /**
     * Gets the blockbuster type of the movie.
     * @return  The blockbuster type of the movie.
     */
    public boolean isBlockbuster(){
        return this.isBlockbuster;
    }

    /**
     * Gets the showing status of the movie.
     * @return  The showing status of the movie.
     */
    public String getStatus(){
        return this.showingStatus;
    }

    /**
     * Gets the synopsis of the movie.
     * @return  The synopsis of the movie.
     */
    public String getSynopsis(){
        return this.synopsis;
    }

    /**
     * Gets the director of the movie.
     * @return  The director of the movie.
     */
    public String getDirector(){
        return this.director;
    }
    /**
     * Gets the cast list of the movie.
     * @return  The cast list of the movie.
     */
    public String[] getCast(){
        return this.cast;
    }

    /**
     * Gets the overall rating of the movie.
     * @return  The overall rating of the movie.
     */
    public double getOverallRating(){
        return this.pastReview.size()>1?this.overallRating/this.pastReview.size():-1;
    }

    /**
     * Gets the past reviews of the movie.
     * @return  The past reviews of the movie.
     */
    public ArrayList<Review> getPastReview(){
        return this.pastReview;
    }

    /**
     * Gets the total sales of the movie.
     * @return  The total sales of the movie.
     */
    public int getTotalSales(){
        return this.totalSales;
    }

    /**
     * Gets the age rating of the movie.
     * @return The age rating of the movie.
     */
    public String getAgeRating(){
        return this.ageRating;
    }

    /**
     * Set the showing status of the movie.
     * @param st    The showing status to be set.
     */
    public void setStatus(String st){
        this.showingStatus=st;
    }

    /**
     * Sets the blockbuster type of the movie.
     * @param blockbuster  The blockbuster type to be set.
     */
    public void setBlockbuster(boolean blockbuster){
        this.isBlockbuster=blockbuster;
    }

    /**
     * Sets the synopsis of the movie.
     * @param synopsis  The synopsis to be set.
     */
    public void setSynopsis(String synopsis){
        this.synopsis=synopsis;
    }

    /**
     * Sets the age rating of the movie.
     * @param rating The age rating.
     */
    public void setAgeRating(String rating){
        this.ageRating=rating;
    }

    /**
     * Adds a new review.
     * @param rating    The rating of the review.
     * @param review    The comment of the review.
     */
    public void addReview(int rating,String review){
        this.pastReview.add(new Review(rating,review));
        this.overallRating+=rating;
    }

    /**
     * Increments the total sales by 1.
     */
    public void addSale(){
        this.totalSales++;
    }

    /**
     * Displays the details of the movie.
     */
    public void display(){
        System.out.printf("Movie title:  %s\n",this.movieTitle);
        System.out.printf("Movie blockbuster type:  %b\n",this.isBlockbuster);
        System.out.printf("Movie status:  %s\n",this.showingStatus);
        System.out.printf("Movie age rating: %s\n", this.ageRating);
        System.out.printf("Movie synposis:\n%s\n",this.synopsis);
        System.out.printf("Movie director:  %s\n",this.director);
        System.out.printf("Movie cast:\n");
        for(int i=0;i<this.castLength;++i) System.out.printf("%d. %s\n", i+1,this.cast[i]);
        System.out.printf("Overall rating: ");
        if(this.pastReview.size()>1)System.out.printf("%.1f\n",this.overallRating/this.pastReview.size());
        else System.out.printf("Overall rating not available!\n");
        if (this.pastReview.size()>1) {
            System.out.printf("Past reviews:\n");
            for(int i=0;i<this.pastReview.size();++i) System.out.printf("%d. Rating: %d/5, Comments: %s\n", i+1, this.pastReview.get(i).getRating(),this.pastReview.get(i).getComment());
        }
    }
}
