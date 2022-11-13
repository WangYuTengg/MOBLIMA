package model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * An ENUM for all Holidays through the year.
 * @version  3.0
 * @author   Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong Jian
 * @since    2022-10-30
 */
public enum Holiday {

        /**
         * New Years Day.
         */
    NEW_YEARS_DAY(LocalDate.of(2022, 1, 1)),

        /**
         * Day 1 of Chinese New Year.
         */
    CHINESE_NEW_YEAR(LocalDate.of(2022, 2,
            1)),

        /**
         * Day 2 of Chinese New Year.
         */
    CHINESE_NEW_YEAR_2(LocalDate.of(2022, 2,
            2)),

        /**
         * Good Friday.
         */
    GOOD_FRIDAY(LocalDate.of(2022, 4,
            15)),
            
        /**
         * Labour Day.
         */
    LABOUR_DAY(LocalDate.of(2022, 5,
            1)),

        /**
         * Labour Day Replacement.
         */
    LABOUR_DAY_REPLACEMENT(LocalDate.of(2022, 5,
            2)),

        /**
         * Hari Raya Puasa
         */
    HARI_RAYA_PUASA(LocalDate.of(2022, 5,
            3)),

        /**
         * Vesak Day.
         */
    VESAK_DAY(LocalDate.of(2022, 5,
            15)),
        
        /**
         * Vesak Day Replacement.
         */
    VESAK_DAY_REPLACEMENT(LocalDate.of(2022, 5,
            16)),

        /**
         * Hari Raya Haji.
         */
    HARI_RAYA_HAJI(LocalDate.of(2022, 7,
            10)),

        /**
         * Hari Raya Haji Replacement.
         */
    HARI_RAYA_HAJI_REPLACEMENT(LocalDate.of(2022, 7,
            11)),

        /**
         * National Day.
         */
    NATIONAL_DAY(LocalDate.of(2022, 8,
            9)),

        /**
         * Deepavali.
         */
    DEEPAVALI(LocalDate.of(2022, 10,
            24)),

        /**
         * Christmas day.
         */
    CHRISTMAS_DAY(LocalDate.of(2022, 12,
            25)),

        /**
         * Christmas day replacement.
         */
    CHRISTMAS_DAY_REPLACEMENT(LocalDate.of(2022, 12, 26));

    /**
     * The current date.
     */
    private final LocalDate date;

    /**
     * A Constructor of Holiday.
     * @param date The current date.
     */
    Holiday(LocalDate date) {
        this.date = date;
    }

    /**
     * Returns the date.
     * @return The date.
     */
    public LocalDate getDate() {
        return this.date;
    }
    
    /**
     * Checks whether a specific date is a holiday.
     * @param date The date.
     * @return Boolean of whether the date is a holiday or not.
     */
    public static boolean isHoliday(LocalDate date)
    {
    	
    	for(Holiday holiday : values())
    	{
            // System.out.println(holiday);
    		if(holiday.getDate().compareTo(date) == 0) return true;
    	}
    	return false;
    }

    /**
     * Lists all Holidays.
     */
    public static void listHoliday(){
        int i = 0;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (Holiday holiday: Holiday.values()){
                i++;
                System.out.printf("%d. %s: --- ", i, holiday.toString().replaceAll("_", " "));
                System.out.println(dtf.format(holiday.getDate()));
        }
    }
};
