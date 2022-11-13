package model;

/**
 * Represents a review of a movie.
 * @version  4.0
 * @author   Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong Jian
 * @since    2022-10-30
*/
public class Review implements java.io.Serializable{
	
  /**
   * Review's rating, an integer value from 1 to 5.
   */
  private int rating;
  
  /**
   * Review's comment.
   */
  private String comment;
  
  /**
   * Creates a new Review with a rating and a comment.
   * @param rating   This Review's rating.
   * @param comment  This Review's comment.
   */
  public Review(int rating,String comment){
  	this.rating = rating;
  	this.comment = comment;
  	}
	
  /**
   * Gets the rating of a Review.
   * @return This Review's rating (1 to 5).
   */
  public int getRating(){
  	return this.rating;
  	}

  /**
   * Gets the comment of a Review.
   * @return This Review's comment.
   */
  public String getComment(){
  	return this.comment;
  	}
	
}