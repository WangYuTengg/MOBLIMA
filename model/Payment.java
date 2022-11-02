/**
 Represents the Payment Class, to calculate the cost of the ticket.
 @version   1.0
 @author    Davyn Yam
 @since     2022-11-01
 */

package model;
import java.util.*;



public class Payment {
    
    private double base_price = 10;
    
    public void setBasePrice(double price)
    {
    	base_price = price;
    	System.out.println("Price updated successfully");
    }

    public double calPrice(Show show, String mType)
    {
        double price;
        Movie movie = show.getMovie();
        Date date = show.getShowDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        if (mType == "SENIOR" && day >= 1 && day <= 5 && date.getHours() < 18 && !movie.is3D())
        {
        		price = 0.5 * base_price;
        }
        else if (mType == "STUDENT" && day >= 1 && day <= 5 && date.getHours() < 18)
        {	
        		if(!movie.is3D()) price = 0.8 * base_price;
        		else price = 0.8 * base_price + 2;
        }
        if (day >= 1 && day <= 4)
        {
        	if(!movie.is3D()) price = base_price;
        	else price = base_price + 2;
        }
        else if (day == 5)
        {
        	if (date.getHours() < 18)
        	{
        		if(!movie.is3D()) price = base_price;
            	else price = base_price + 2;
        	}
        	else
        	{
        		if(!movie.is3D()) price = base_price * 1.2;
            	else price = base_price * 1.2 + 2;
        	}	
        }
        else if( day == 0 || day == 6)
        {
        	if(!movie.is3D()) price = base_price * 1.2;
        	else price = base_price * 1.2 + 2;
        }
        if(movie.isblockbuster())
        {
        	price += 1;
        }
        return price;
    }

}
