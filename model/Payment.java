/**
 Represents the Payment Class, to calculate the cost of the ticket.
 @version   1.0
 @author    Davyn Yam
 @since     2022-11-01
 */

package model;
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;



public class Payment {
    
    public static double base_price = 10;
    
    public static void setBasePrice(double price)
    {
    	base_price = price;
    	System.out.println("Price updated successfully");
    }

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
        	if(!show.is3D()) price = base_price * 1.2;
        	else price = base_price * 1.2 + 2;
        }
        else if (mType.equals(MoviegoerType.SENIOR) && day >= 1 && day <= 5 && calendar.get(Calendar.HOUR_OF_DAY) < 18 && !show.is3D())
        {
        		price = 0.5 * base_price;
        }
        else if (mType.equals(MoviegoerType.STUDENT) && day >= 1 && day <= 5 && calendar.get(Calendar.HOUR_OF_DAY) < 18)
        {	
        		if(!show.is3D()) price = 0.8 * base_price;
        		else price = 0.8 * base_price + 2;
        }
        if (day >= 1 && day <= 4)
        {
        	if(!show.is3D()) price = base_price;
        	else price = base_price + 2;
        }
        else if (day == 5)
        {
        	if (calendar.get(Calendar.HOUR_OF_DAY) < 18)
        	{
        		if(!show.is3D()) price = base_price;
            	else price = base_price + 2;
        	}
        	else
        	{
        		if(!show.is3D()) price = base_price * 1.2;
            	else price = base_price * 1.2 + 2;
        	}	
        }
        else if( day == 0 || day == 6)
        {
        	if(!show.is3D()) price = base_price * 1.2;
        	else price = base_price * 1.2 + 2;
        }
        if(movie.isBlockbuster())
        {
        	price += 1;
        }
        if(show.getCinema().getType())
        {
        	price += 2;
        }
        return price;
    }
    
    public static String generateTID(Cinema cinema)
    {
    	String TID;
    	SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDDhhmm");
    	Date temp_date = new Date();
    	String date = sdf.format(temp_date);
    	TID = cinema.getCinemaCode() + date;
    	return TID;
    }

}
