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
    public static double base_price = 10;

    /**
     * Additional pricing of blockbuster movies
     */
    private static double blockBuster_price = 2; 

    /**
     * Additional 3d price 
     */
    private static double is3D_price = 2;

    /**
     * Additional platinum cinema price
     */
    private static double isPlat_price = 2;

    /**
     * Additional holiday price multiplier
     */
    private static double holiday_priceMultiplier = 1.2;

    /**
     *  Addtional weekend price multiplier (friday nights included)
     */
    private static double weekend_priceMultiplier = 1.2;

    /**
     * Additional student price multiplier
     */
    private static double student_priceMultiplier = 0.8;

    /**
     * Additional senior price multiplier
     */
    private static double senior_priceMultiplier = 0.5; 

    /**
     * Get current base ticket price
     * @return base_price;
     */
    public static double getBasePrice(){
        return base_price;
    }

    /**
     * Get current additional blockbuster movie charge
     * @return blockBuster_price;
     */
    public static double getIsBBPrice(){
        return blockBuster_price;
    }

    /**
     * Get current additional 3D movie charge
     * @return is3D_price;
     */
    public static double getIs3DPrice(){
        return is3D_price;
    }

    /**
     * Get current additional platinum cinema charge
     * @return isPlat_price;
     */
    public static double getIsPlatPrice(){
        return isPlat_price;
    }

    /**
     * Get current holiday price multiplier
     * @return holiday_priceMultiplier
     */
    public static double getHolidayMultiplier(){
        return holiday_priceMultiplier;
    }
    
    /**
     * Get current weekend price multiplier
     * @return weekend_priceMultiplier
     */
    public static double getWeekendMultiplier(){
        return weekend_priceMultiplier;
    }

    /**
     * Get current student price multiplier
     * @return student_priceMultiplier
     */
    public static double getStudentMultipier(){
        return student_priceMultiplier;
    }

    /**
     * Get current senior price multiplier
     * @return senior_priceMultiplier
     */
    public static double getSeniorMultipier(){
        return senior_priceMultiplier;
    }

    /**
     * Set base price of ticket
     * @param price
     */
    public static void setBasePrice(double price)
    {
    	base_price = price;
    	System.out.printf("Base ticket price updated successfully to $%.2f.\n", base_price);
    }

    /**
     * Set blockbuster price add-on of ticket
     * @param price
     */
    public static void setBlockBusterAdditionalPrice(double price)
    {
    	blockBuster_price = price;
    	System.out.printf("Additional blockbuster charge updated successfully to $%.2f.\n", blockBuster_price);
    }

    /**
     * Set 3D price add-on of ticket
     * @param price
     */
    public static void set3dAdditionalPrice(double price)
    {
    	is3D_price = price;
    	System.out.printf("Additional 3D charge updated successfully to $%.2f.\n", is3D_price);
    }

    /**
     * Set Platinum cinema price add-on of ticket
     * @param price
     */
    public static void setPlatAdditionalPrice(double price)
    {
    	isPlat_price = price;
    	System.out.printf("Additional Platinum Cinema charge updated successfully to $%.2f.\n", isPlat_price);
    }

    /**
     * Set Holiday price multiplier
     * @param price
     */
    public static void setHolidayPriceMultiplier(double multiplier)
    {
    	holiday_priceMultiplier = multiplier;
    	System.out.printf("Holiday price multiplier updated successfully to %.2f.\n", holiday_priceMultiplier);
    }

    /**
     * Set Student price multiplier
     * @param price
     */
    public static void setStudentPriceMultiplier(double multiplier)
    {
    	student_priceMultiplier = multiplier;
    	System.out.printf("Student price multiplier updated successfully to %.2f.\n", student_priceMultiplier);
    }

    /**
     * Set Senior price multiplier
     * @param price
     */
    public static void setSeniorPriceMultiplier(double multiplier)
    {
    	senior_priceMultiplier = multiplier;
    	System.out.printf("Senior price multiplier updated successfully to %.2f.\n", senior_priceMultiplier);
    }

    /**
     * Set Weekend price multiplier
     * @param price
     */
    public static void setWeekendPriceMultiplier(double multiplier)
    {
    	weekend_priceMultiplier = multiplier;
    	System.out.printf("Weekend price multiplier updated successfully to %.2f.\n", weekend_priceMultiplier);
    }


    /**
     * function to calculate price of a ticket depending on certain factors 
     * e.g holiday/senior/student/senior/is3d/isPlat etc. -> all taken from Show and MoviegoerType
     * @param show 
     * @param mType
     * @return price of ticket
     */
    public static double calPrice(Show show, MoviegoerType mType)
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
        return price;
    }

    /**
     * Method to generate transaction ID after payment is made
     * @param cinema
     * @return transaction id 
     */
    public static String generateTID(Cinema cinema)
    {
    	String TID;
    	SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddhhmm");
    	Date temp_date = new Date();
    	String date = sdf.format(temp_date);
    	TID = cinema.getCinemaCode() + date;
    	return TID;
    }

}
