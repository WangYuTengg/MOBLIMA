package model;
import java.time.LocalDate;

public enum Holiday {
    NEW_YEARS_DAY(LocalDate.of(2022, 1, 1)),
    CHINESE_NEW_YEAR(LocalDate.of(2022, 2,
            1)),
    CHINESE_NEW_YEAR_2(LocalDate.of(2022, 2,
            2)),
    GOOD_FRIDAY(LocalDate.of(2022, 4,
            15)),
    LABOUR_DAY(LocalDate.of(2022, 5,
            1)),
    LABOUR_DAY_REPLACEMENT(LocalDate.of(2022, 5,
            2)),
    HARI_RAYA_PUASA(LocalDate.of(2022, 5,
            3)),
    VESAK_DAY(LocalDate.of(2022, 5,
            15)),
    VESAK_DAY_REPLACEMENT(LocalDate.of(2022, 5,
            16)),
    HARI_RAYA_HAJI(LocalDate.of(2022, 7,
            10)),
    HARI_RAYA_HAJI_REPLACEMENT(LocalDate.of(2022, 7,
            11)),
    NATIONAL_DAY(LocalDate.of(2022, 8,
            9)),
    DEEPAVALI(LocalDate.of(2022, 10,
            24)),
    CHRISTMAS_DAY(LocalDate.of(2022, 12,
            25)),
    CHRISTMAS_DAY_REPLACEMENT(LocalDate.of(2022, 12, 26));

    private final LocalDate date;

    Holiday(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return this.date;
    }
    
    public static boolean isHoliday(LocalDate date)
    {
    	
    	for(Holiday holiday : values())
    	{
    		if(holiday.getDate().compareTo(date) == 0) return true;
    	}
    	return false;
    }

};
