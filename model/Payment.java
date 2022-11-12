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
     * The multiplier used when a loyalty card is used.
     */
    private double loyaltyCardMultiplier = 0.9;
    
    /**
     * Get current base ticket price
     * @return base_price;  The base price.
     */
    public  double getBasePrice(){
        return base_price;
    }

    /**
     * Get current additional blockbuster movie charge
     * @return blockBuster_price;   The additional cost incurred.
     */
    public  double getIsBBPrice(){
        return blockBuster_price;
    }

    /**
     * Get current additional 3D movie charge
     * @return is3D_price;      The additional cost incurred.
     */
    public double getIs3DPrice(){
        return is3D_price;
    }

    /**
     * Get current additional platinum cinema charge
     * @return isPlat_price;    The additional cost incurred.
     */
    public double getIsPlatPrice(){
        return isPlat_price;
    }
    
    /**
     * Get current additional elite seat charge
     * @return isPlat_price;    The additional cost incurred.
     */
    public double getIsEliteSeatprice()
    {
    	return isEliteSeat_price;
    }
    /**
     * Get current holiday price multiplier
     * @return holiday_priceMultiplier  The multiplier being used.
     */
    public double getHolidayMultiplier(){
        return holiday_priceMultiplier;
    }
    
    /**
     * Get current weekend price multiplier
     * @return weekend_priceMultiplier  The multiplier being used.
     */
    public double getWeekendMultiplier(){
        return weekend_priceMultiplier;
    }

    /**
     * Get current student price multiplier
     * @return student_priceMultiplier  The multiplier being used.
     */
    public double getStudentMultipier(){
        return student_priceMultiplier;
    }

    /**
     * Get current senior price multiplier
     * @return senior_priceMultiplier   The multiplier being used.
     */
    public double getSeniorMultipier(){
        return senior_priceMultiplier;
    }
    
    /**
     * Get the list of loyalty cars
     * @return loyaltyCards The multiplier being used.
     */
    public ArrayList<String> getLoyaltyCards()
    {
    	return loyaltyCards;
    }
    
    /**
     * Get current Loyalty card multiplier
     * @return loyaltyCardMultiplier The multiplier being used.
     */
    public double getLoyaltCardMultiplier()
    {
    	return loyaltyCardMultiplier;
    }

    /**
     * Set base price of ticket
     * @param price The base price to be set.
     */
    public void setBasePrice(double price)
    {
    	base_price = price;
    	System.out.printf("Base ticket price updated successfully to $%.2f.\n", base_price);
    }

    /**
     * Set blockbuster price add-on of ticket
     * @param price The additional price to be added.
     */
    public void setBlockBusterAdditionalPrice(double price)
    {
    	blockBuster_price = price;
    	System.out.printf("Additional blockbuster charge updated successfully to $%.2f.\n", blockBuster_price);
    }

    /**
     * Set 3D price add-on of ticket.
     * @param price The additional price to be added.
     */
    public void set3dAdditionalPrice(double price)
    {
    	is3D_price = price;
    	System.out.printf("Additional 3D charge updated successfully to $%.2f.\n", is3D_price);
    }

    /**
     * Set Platinum cinema price add-on of ticket.
     * @param price The additional price to be added.
     */
    public void setPlatAdditionalPrice(double price)
    {
    	isPlat_price = price;
    	System.out.printf("Additional Platinum Cinema charge updated successfully to $%.2f.\n", isPlat_price);
    }
    
    /**
     * Sets how much more to be charged when purchasing an elite seat.
     * @param price The additional price to be added.
     */
    public void setEliteAdditionalPrice(double price)
    {
    	isEliteSeat_price = price;
    	System.out.printf("Additional Elite seat charge updated successfully to $%.2f.\n", isEliteSeat_price);
    }

    /**
     * Set Holiday price multiplier
     * @param multiplier    The multiplier value to be applied 
     */
    public void setHolidayPriceMultiplier(double multiplier)
    {
    	holiday_priceMultiplier = multiplier;
    	System.out.printf("Holiday price multiplier updated successfully to %.2f.\n", holiday_priceMultiplier);
    }

    /**
     * Set Student price multiplier
     * @param multiplier    The multiplier value to be applied 
     */
    public void setStudentPriceMultiplier(double multiplier)
    {
    	student_priceMultiplier = multiplier;
    	System.out.printf("Student price multiplier updated successfully to %.2f.\n", student_priceMultiplier);
    }

    /**
     * Set Senior price multiplier
     * @param multiplier    The multiplier value to be applied 
     */
    public void setSeniorPriceMultiplier(double multiplier)
    {
    	senior_priceMultiplier = multiplier;
    	System.out.printf("Senior price multiplier updated successfully to %.2f.\n", senior_priceMultiplier);
    }

    /**
     * Set Weekend price multiplier
     * @param multiplier    The multiplier value to be applied 
     */
    public void setWeekendPriceMultiplier(double multiplier)
    {
    	weekend_priceMultiplier = multiplier;
    	System.out.printf("Weekend price multiplier updated successfully to %.2f.\n", weekend_priceMultiplier);
    }
    
    /**
     * Sets the multiplier to be applied when using a loyalty card during payment.
     * @param multiplier    The multiplier to be used.
     */
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
        price *= loyaltyCardMultiplier;
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

    /**
     * A function to display all prices and multiplier values.
     */
    public void displayPrices(){
        System.out.println("---------- Displaying Price Table -----------");
        System.out.printf("%s %.2f\n","Base Price                             ",base_price);
        System.out.println("---------- Discounts -----------");
        System.out.printf("%s %.2f\n","Holiday Price Multiplier               ",holiday_priceMultiplier);
        System.out.printf("%s %.2f\n","Loyalty Card Multiplier                ",loyaltyCardMultiplier);
        System.out.printf("%s %.2f\n","Senior Price Multiplier                ",senior_priceMultiplier);
        System.out.printf("%s %.2f\n","Student Price Multiplier               ",student_priceMultiplier);
        System.out.printf("%s %.2f\n","Weekend Price Multiplier               ",weekend_priceMultiplier);
        System.out.println("-----------Extra Charges -----------");
        System.out.printf("%s %.2f\n","Block Buster Extra Charge              ",blockBuster_price);
        System.out.printf("%s %.2f\n","3D Extra Charge                        ",is3D_price);
        System.out.printf("%s %.2f\n","Elite Seat Extra Charge                ",isEliteSeat_price);
        System.out.printf("%s %.2f\n","Platinum Cinema Extra Charge           ",isPlat_price);
    }
}
