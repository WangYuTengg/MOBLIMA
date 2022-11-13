package model;

import java.util.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 * Represents the Payment Class, to calculate the cost of the ticket.
 * 
 * @version 3.0
 * @author Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong
 *         Jian
 * @since 2022-10-30
 */
public class Payment implements java.io.Serializable {

    /**
     * Base price of ticket.
     */
    public double base_price = 10;

    /**
     * Additional pricing for Blockbuster movies.
     */
    private double blockBuster_price = 2;

    /**
     * Additional pricing for 3D movies.
     */
    private double is3D_price = 2;

    /**
     * Additional pricing for a Platinum Cinema ticket.
     */
    private double isPlat_price = 2;

    /**
     * Additional pricing for an elite seat.
     */
    private double isEliteSeat_price = 2;

    /**
     * A multiplier used for a ticket purchased on a holiday.
     */
    private double holiday_priceMultiplier = 1.2;

    /**
     * A multiplier used for tickets purchased on the weekend. (friday nights
     * included)
     */
    private double weekend_priceMultiplier = 1.2;

    /**
     * A multiplier used for student purchased tickets.
     */
    private double student_priceMultiplier = 0.8;

    /**
     * A multiplier used for senior citizen purchased tickets.
     */
    private double senior_priceMultiplier = 0.5;

    /**
     * List of acceptable Loyalty Cards.
     */
    private ArrayList<String> loyaltyCards = new ArrayList<>();

    /**
     * A multiplier used when a loyalty card is used during purchase.
     */
    private double loyaltyCardMultiplier = 0.9;

    /**
     * Gets the current base ticket price.
     * 
     * @return The base price of a ticket.
     */
    public double getBasePrice() {
        return base_price;
    }

    /**
     * Gets the current additional pricing for Blockbuster movies.
     * 
     * @return The additional cost incurred.
     */
    public double getIsBBPrice() {
        return blockBuster_price;
    }

    /**
     * Gets the current additional pricing for 3D movies.
     * 
     * @return The additional cost incurred.
     */
    public double getIs3DPrice() {
        return is3D_price;
    }

    /**
     * Gets the current additional pricing for movies shown in Platinum Cinemas.
     * 
     * @return The additional cost incurred.
     */
    public double getIsPlatPrice() {
        return isPlat_price;
    }

    /**
     * Gets the current additional pricing for purchasing a ticket for an elite
     * seat.
     * 
     * @return The additional cost incurred.
     */
    public double getIsEliteSeatprice() {
        return isEliteSeat_price;
    }

    /**
     * Gets the current multiplier used when purchasing a ticket for a movie shown
     * on a Holiday.
     * 
     * @return The multiplier being used.
     */
    public double getHolidayMultiplier() {
        return holiday_priceMultiplier;
    }

    /**
     * Gets the current multiplier used when purchasing a ticket for a movie shown
     * on a weekend (Friday included).
     * 
     * @return The multiplier being used.
     */
    public double getWeekendMultiplier() {
        return weekend_priceMultiplier;
    }

    /**
     * Gets the current multiplier used when purchasing a ticket as a student.
     * 
     * @return The multiplier being used.
     */
    public double getStudentMultipier() {
        return student_priceMultiplier;
    }

    /**
     * Gets the current multiplier used when purchasing a ticket as a senior
     * citizen.
     * 
     * @return The multiplier being used.
     */
    public double getSeniorMultipier() {
        return senior_priceMultiplier;
    }

    /**
     * Gets the list of loyalty cards.
     * 
     * @return The loyalty card being used.
     */
    public ArrayList<String> getLoyaltyCards() {
        return loyaltyCards;
    }

    /**
     * Gets the current multiplier used when purchasing a ticket with a loyalty
     * card.
     * 
     * @return The multiplier being used.
     */
    public double getLoyaltCardMultiplier() {
        return loyaltyCardMultiplier;
    }

    /**
     * Sets the base price of ticket.
     * 
     * @param price The base price to be set.
     */
    public void setBasePrice(double price) {
        base_price = price;
        System.out.printf("Base ticket price updated successfully to $%.2f.\n", base_price);
    }

    /**
     * Sets the additional pricing for Blockbuster movies.
     * 
     * @param price The additional price to be added.
     */
    public void setBlockBusterAdditionalPrice(double price) {
        blockBuster_price = price;
        System.out.printf("Additional blockbuster charge updated successfully to $%.2f.\n", blockBuster_price);
    }

    /**
     * Sets the additional pricing for a 3D movie.
     * 
     * @param price The additional price to be added.
     */
    public void set3dAdditionalPrice(double price) {
        is3D_price = price;
        System.out.printf("Additional 3D charge updated successfully to $%.2f.\n", is3D_price);
    }

    /**
     * Sets the additional pricing for movies shown in Platinum Cinemas.
     * 
     * @param price The additional price to be added.
     */
    public void setPlatAdditionalPrice(double price) {
        isPlat_price = price;
        System.out.printf("Additional Platinum Cinema charge updated successfully to $%.2f.\n", isPlat_price);
    }

    /**
     * Sets the additional pricing for purchasing an elite seat.
     * 
     * @param price The additional price to be added.
     */
    public void setEliteAdditionalPrice(double price) {
        isEliteSeat_price = price;
        System.out.printf("Additional Elite seat charge updated successfully to $%.2f.\n", isEliteSeat_price);
    }

    /**
     * Sets the multiplier used when purchasing a ticket on a Holiday.
     * 
     * @param multiplier The multiplier value to be applied.
     */
    public void setHolidayPriceMultiplier(double multiplier) {
        holiday_priceMultiplier = multiplier;
        System.out.printf("Holiday price multiplier updated successfully to %.2f.\n", holiday_priceMultiplier);
    }

    /**
     * Sets the multiplier used when purchasing a ticket as a student.
     * 
     * @param multiplier The multiplier value to be applied.
     */
    public void setStudentPriceMultiplier(double multiplier) {
        student_priceMultiplier = multiplier;
        System.out.printf("Student price multiplier updated successfully to %.2f.\n", student_priceMultiplier);
    }

    /**
     * Sets the multiplier used when purchasing a ticket as a senior citizen.
     * 
     * @param multiplier The multiplier value to be applied.
     */
    public void setSeniorPriceMultiplier(double multiplier) {
        senior_priceMultiplier = multiplier;
        System.out.printf("Senior price multiplier updated successfully to %.2f.\n", senior_priceMultiplier);
    }

    /**
     * Sets the multiplier used when purchasing a ticket on a weekend (Friday
     * included).
     * 
     * @param multiplier The multiplier value to be applied.
     */
    public void setWeekendPriceMultiplier(double multiplier) {
        weekend_priceMultiplier = multiplier;
        System.out.printf("Weekend price multiplier updated successfully to %.2f.\n", weekend_priceMultiplier);
    }

    /**
     * Sets the multiplier to be applied when using a loyalty card during payment.
     * 
     * @param multiplier The multiplier value to be applied.
     */
    public void setLoyaltyCardMultiplier(double multiplier) {
        loyaltyCardMultiplier = multiplier;
        System.out.printf("Loyalty Card multiplier updated successfully to %.2f.\n", loyaltyCardMultiplier);
    }

    /**
     * Adds accepted Loyalty Cards.
     * 
     * @param card The name of the loyalty card.
     */
    public void addLoyaltyCards(String card) {
        loyaltyCards.add(card);
        //System.out.printf("%s loyalty card successfully added!\n", card);
    }

    /**
     * Removes a Loyalty Card from being used.
     * 
     * @param card The name of the loyalty card.
     */
    public void removeLoyaltyCards(String card) {
        loyaltyCards.remove(card);
        System.out.printf("%s loyalty card successfully removed.\n", card);
    }

    /**
     * A Function to calculate price of a ticket depending on certain factors.
     * e.g holiday/senior/student/senior/is3d/isPlat etc. -> all taken from Show and
     * MoviegoerType
     * 
     * @param show       The show being used.
     * @param seat_index The seat index of the movie goer.
     * @param mType      The movie goer type.
     * @return The final price of the ticket to be paid by the Movie Goer.
     */
    public double calPrice(Show show, String seat_index, MoviegoerType mType) {
        double price = base_price;
        Movie movie = show.getMovie();
        Date date = show.getShowTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        LocalDate localDate = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH));
        if (Holiday.isHoliday(localDate)) {
            if (!show.is3D())
                price = base_price * holiday_priceMultiplier;
            else
                price = base_price * holiday_priceMultiplier + is3D_price;
        } else if (mType.equals(MoviegoerType.SENIOR) && day >= 2 && day <= 5
                && calendar.get(Calendar.HOUR_OF_DAY) < 18) {
            if (!show.is3D())
                price = base_price * senior_priceMultiplier;
            else
                price = base_price * senior_priceMultiplier + is3D_price;
        } else if (mType.equals(MoviegoerType.STUDENT) && day >= 2 && day <= 5
                && calendar.get(Calendar.HOUR_OF_DAY) < 18) {
            if (!show.is3D())
                price = student_priceMultiplier * base_price;
            else
                price = student_priceMultiplier * base_price + is3D_price;
        } else if (day >= 2 && day <= 5) {
            if (!show.is3D())
                price = base_price;
            else
                price = base_price + is3D_price;
        } else if (day == 6) {
            if (calendar.get(Calendar.HOUR_OF_DAY) < 18) {
                if (!show.is3D())
                    price = base_price;
                else
                    price = base_price + is3D_price;
            } else {
                if (!show.is3D())
                    price = base_price * weekend_priceMultiplier;
                else
                    price = base_price * weekend_priceMultiplier + is3D_price;
            }
        } else if (day == 1 || day == 7) {

            if (!show.is3D())
                price = base_price * weekend_priceMultiplier;
            else
                price = base_price * weekend_priceMultiplier + is3D_price;
        }
        if (movie.isBlockbuster()) {
            price += blockBuster_price;
        }
        if (show.getCinema().getType()) {
            price += isPlat_price;
        }
        Scanner sc = new Scanner(seat_index.substring(0, seat_index.length() - 1));
        int row = (sc.nextInt() - 1);
        int column = (int) (seat_index.charAt(seat_index.length() - 1) - 'A');
        if (show.getCinema().getSeats()[row][column].isElite()) {
            price += isEliteSeat_price;
        }
        return price;

    }

    /**
     * A function used to calculate discounted price when a loyalty card is used.
     * 
     * @param price     The current price.
     * @param card_name The name of the loyalty card.
     * @return discounted price of ticket
     */
    public double discountedPrice(double price, String card_name) {
        price *= loyaltyCardMultiplier;
        return price;
    }

    /**
     * A Method to generate the transaction ID after payment is made.
     * 
     * @param cinema The cinema associated to the ticket purchased.
     * @return The transaction ID.
     */
    public String generateTID(Cinema cinema) {
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
    public void displayPrices() {
        System.out.println("---------- Displaying Price Table -----------");
        System.out.printf("%s %.2f\n", "Base Price                             ", base_price);
        System.out.println("---------- Discounts -----------");
        System.out.printf("%s %.2f\n", "Holiday Price Multiplier               ", holiday_priceMultiplier);
        System.out.printf("%s %.2f\n", "Loyalty Card Multiplier                ", loyaltyCardMultiplier);
        System.out.printf("%s %.2f\n", "Senior Price Multiplier                ", senior_priceMultiplier);
        System.out.printf("%s %.2f\n", "Student Price Multiplier               ", student_priceMultiplier);
        System.out.printf("%s %.2f\n", "Weekend Price Multiplier               ", weekend_priceMultiplier);
        System.out.println("-----------Extra Charges -----------");
        System.out.printf("%s %.2f\n", "Block Buster Extra Charge              ", blockBuster_price);
        System.out.printf("%s %.2f\n", "3D Extra Charge                        ", is3D_price);
        System.out.printf("%s %.2f\n", "Elite Seat Extra Charge                ", isEliteSeat_price);
        System.out.printf("%s %.2f\n", "Platinum Cinema Extra Charge           ", isPlat_price);
    }
}
