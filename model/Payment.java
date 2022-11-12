/**
 Represents the Payment Class, to calculate the cost of the ticket.
 @version   2.0
 @author    Davyn Yam
 @since     2022-11-01
 */

package model;
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Payment implements java.io.Serializable{
    
    /**
     * Base price of ticket
     */
    public double base_price = 10;

    /**
     * Additional pricing of blockbuster movies
     */
    private double blockBuster_price = 2; 

    /**
     * Additional 3d price 
     */
    private double is3D_price = 2;

    /**
     * Additional platinum cinema price
     */
    private double isPlat_price = 2;
    
    /**
     * Additional Elite seat price
     */
    private double isEliteSeat_price = 2;

    /**
     * Additional holiday price multiplier
     */
    private double holiday_priceMultiplier = 1.2;

    /**
     *  Addtional weekend price multiplier (friday nights included)
     */
    private double weekend_priceMultiplier = 1.2;

    /**
     * Additional student price multiplier
     */
    private double student_priceMultiplier = 0.8;

    /**
     * Additional senior price multiplier
     */
    private double senior_priceMultiplier = 0.5;
    
    /**
     * List of acceptable Loyalty Cards
     */
    private ArrayList<String> loyaltyCards = new ArrayList<>();
    
    /**
     * Additional senior price multiplier
     */
    private double loyaltyCardMultiplier = 0.9;
    
    /**
     * Get current base ticket price
     * @return base_price;
     */
    public  double getBasePrice(){
        return base_price;
    }

    /**
     * Get current additional blockbuster movie charge
     * @return blockBuster_price;
     */
    public  double getIsBBPrice(){
        return blockBuster_price;
    }

    /**
     * Get current additional 3D movie charge
     * @return is3D_price;
     */
    public double getIs3DPrice(){
        return is3D_price;
    }

    /**
     * Get current additional platinum cinema charge
     * @return isPlat_price;
     */
    public double getIsPlatPrice(){
        return isPlat_price;
    }
    
    /**
     * Get current additional elite seat charge
     * @return isPlat_price;
     */
    public double getIsEliteSeatprice()
    {
    	return isEliteSeat_price;
    }
    /**
     * Get current holiday price multiplier
     * @return holiday_priceMultiplier
     */
    public double getHolidayMultiplier(){
        return holiday_priceMultiplier;
    }
    
    /**
     * Get current weekend price multiplier
     * @return weekend_priceMultiplier
     */
    public double getWeekendMultiplier(){
        return weekend_priceMultiplier;
    }

    /**
     * Get current student price multiplier
     * @return student_priceMultiplier
     */
    public double getStudentMultipier(){
        return student_priceMultiplier;
    }

    /**
     * Get current senior price multiplier
     * @return senior_priceMultiplier
     */
    public double getSeniorMultipier(){
        return senior_priceMultiplier;
    }
    
    /**
     * Get the list of loyalty cars
     * @return loyaltyCards
     */
    public ArrayList<String> getLoyaltyCards()
    {
    	return loyaltyCards;
    }
    
    /**
     * Get current Loyalty card multiplier
     * @return loyaltyCardMultiplier
     */
    public double getLoyaltCardMultiplier()
    {
    	return loyaltyCardMultiplier;
    }

    /**
     * Set base price of ticket
     * @param price
     */
    public void setBasePrice(double price)
    {
    	base_price = price;
    	System.out.printf("Base ticket price updated successfully to $%.2f.\n", base_price);
    }

    /**
     * Set blockbuster price add-on of ticket
     * @param price
     */
    public void setBlockBusterAdditionalPrice(double price)
    {
    	blockBuster_price = price;
    	System.out.printf("Additional blockbuster charge updated successfully to $%.2f.\n", blockBuster_price);
    }

    /**
     * Set 3D price add-on of ticket
     * @param price
     */
    public void set3dAdditionalPrice(double price)
    {
    	is3D_price = price;
    	System.out.printf("Additional 3D charge updated successfully to $%.2f.\n", is3D_price);
    }

    /**
     * Set Platinum cinema price add-on of ticket
     * @param price
     */
    public void setPlatAdditionalPrice(double price)
    {
    	isPlat_price = price;
    	System.out.printf("Additional Platinum Cinema charge updated successfully to $%.2f.\n", isPlat_price);
    }
    
    public void setEliteAdditionalPrice(double price)
    {
    	isEliteSeat_price = price;
    	System.out.printf("Additional Elite seat charge updated successfully to $%.2f.\n", isEliteSeat_price);
    }

    /**
     * Set Holiday price multiplier
     * @param price
     */
    public void setHolidayPriceMultiplier(double multiplier)
    {
    	holiday_priceMultiplier = multiplier;
    	System.out.printf("Holiday price multiplier updated successfully to %.2f.\n", holiday_priceMultiplier);
    }

    /**
     * Set Student price multiplier
     * @param price
     */
    public void setStudentPriceMultiplier(double multiplier)
    {
    	student_priceMultiplier = multiplier;
    	System.out.printf("Student price multiplier updated successfully to %.2f.\n", student_priceMultiplier);
    }

    /**
     * Set Senior price multiplier
     * @param price
     */
    public void setSeniorPriceMultiplier(double multiplier)
    {
    	senior_priceMultiplier = multiplier;
    	System.out.printf("Senior price multiplier updated successfully to %.2f.\n", senior_priceMultiplier);
    }

    /**
     * Set Weekend price multiplier
     * @param price
     */
    public void setWeekendPriceMultiplier(double multiplier)
    {
    	weekend_priceMultiplier = multiplier;
    	System.out.printf("Weekend price multiplier updated successfully to %.2f.\n", weekend_priceMultiplier);
    }
    
    public void setLoyaltyCardMultiplier(double multiplier)
    {
    	loyaltyCardMultiplier = multiplier;
    	System.out.printf("Loyalty Card multiplier updated successfully to %.2f.\n", loyaltyCardMultiplier);
    }
    
    /**
     * Add acceptable Loyalty Cards
     * @param card  loyalty card name
     */
    public void addLoyaltyCards(String card)
    {
    	loyaltyCards.add(card);
    	System.out.println("Card added Successfully!");
    }
    
    /**
     * remove a Loyalty Cards
     * @param card  loyalty card name
     */
    public void removeLoyaltyCards(String card)
    {
    	loyaltyCards.remove(card);
    	System.out.println("Card removed Successfully!");
    }


    /**
     * function to calculate price of a ticket depending on certain factors 
     * e.g holiday/senior/student/senior/is3d/isPlat etc. -> all taken from Show and MoviegoerType
     * @param show 
     * @param seat_index
     * @param mType
     * @return price of ticket
     */
    public double calPrice(Show show, String seat_index, MoviegoerType mType)
    {
        double price = base_price;
        Movie movie = show.getMovie();
        Date date = show.getShowTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        LocalDate localDate = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        if(Holiday.isHoliday(localDate))
        {
        	if(!show.is3D()) price = base_price * holiday_priceMultiplier;
        	else price = base_price * holiday_priceMultiplier + is3D_price;
        }
        else if (mType.equals(MoviegoerType.SENIOR) && day >= 1 && day <= 5 && calendar.get(Calendar.HOUR_OF_DAY) < 18 && !show.is3D())
        {
        		price = senior_priceMultiplier * base_price;
        }
        else if (mType.equals(MoviegoerType.STUDENT) && day >= 1 && day <= 5 && calendar.get(Calendar.HOUR_OF_DAY) < 18)
        {	
        		if(!show.is3D()) price = student_priceMultiplier * base_price;
        		else price = student_priceMultiplier * base_price + is3D_price;
        }
        if (day >= 1 && day <= 4)
        {
        	if(!show.is3D()) price = base_price;
        	else price = base_price + is3D_price;
        }
        else if (day == 5)
        {
        	if (calendar.get(Calendar.HOUR_OF_DAY) < 18)
        	{
        		if(!show.is3D()) price = base_price;
            	else price = base_price + is3D_price;
        	}
        	else
        	{
        		if(!show.is3D()) price = base_price * weekend_priceMultiplier;
            	else price = base_price * weekend_priceMultiplier + is3D_price;
        	}	
        }
        else if( day == 0 || day == 6)
        {
        	if(!show.is3D()) price = base_price * weekend_priceMultiplier;
        	else price = base_price * weekend_priceMultiplier + is3D_price;
        }
        if(movie.isBlockbuster())
        {
        	price += blockBuster_price;
        }
        if(show.getCinema().getType())
        {
        	price += isPlat_price;
        }
        Scanner sc=new Scanner(seat_index.substring(0, seat_index.length()-1));
        int row=(sc.nextInt()-1);
        int column=(int)(seat_index.charAt(seat_index.length()-1)-'A');
        if(show.getCinema().getSeats()[row][column].isElite())
        {
        	price += isEliteSeat_price;
        }
        return price;
        
    }
    
    /**
     * function to calculate discounted price based on loyalty card 
     * @param price 
     * @param card_name
     * @return discounted price of ticket
     */
    public double discountedPrice(double price, String card_name)
    {
    	if(loyaltyCards.contains(card_name) == true)
        {
        	price *= loyaltyCardMultiplier;
        }
    	return price;
    }

    /**
     * Method to generate transaction ID after payment is made
     * @param cinema
     * @return transaction id 
     */
    public String generateTID(Cinema cinema)
    {
    	String TID;
    	SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddhhmm");
    	Date temp_date = new Date();
    	String date = sdf.format(temp_date);
    	TID = cinema.getCinemaCode() + date;
    	return TID;
    }
    

}
