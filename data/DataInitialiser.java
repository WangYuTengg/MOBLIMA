
package data;

import model.Cinema;
import model.Cineplex;
import model.Show;
import model.Movie;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import controller.MovieGoer;
import controller.Staff;

/**
 * A class to instantiate the initial database.
 * 
 * @version 3.0
 * @author Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong
 *         Jian
 * @since 2022-10-30
 */
public class DataInitialiser {

	/**
	 * A function to instantiate the database.
	 * 
	 * @return Initialized database.
	 */
	public static Database main() {
		Database database = new Database();

		try {
			initCineplexes(database);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		initMovieGoers(database);
		initStaff(database);
		initPayment(database);

		return database;
	}

	/**
	 * A function to instantiate a set of movie goers.
	 * 
	 * @param db The database.
	 */
	public static void initMovieGoers(Database db) {
		MovieGoer defaultGoer = new MovieGoer(0, "", "", 0, "");
		MovieGoer member1 = new MovieGoer(30, "John Tan", "JohnTan@gmail.com", 1, "abc123");
		MovieGoer member2 = new MovieGoer(10, "Adam Wong", "AdamWong@gmail.com", 2, "abc123");
		MovieGoer member3 = new MovieGoer(18, "Ben Sim", "BenSim@gmail.com", 3, "abc123");

		db.addMovieGoer(defaultGoer);
		db.addMovieGoer(member1);
		db.addMovieGoer(member2);
		db.addMovieGoer(member3);
	}

	/**
	 * A function to instantiate a set of staff members.
	 * 
	 * @param db The database.
	 */
	public static void initStaff(Database db) {
		Staff admin0 = new Staff("dkjkjsnw", "dknkjnws", "wrong");
		Staff admin1 = new Staff("admin1@gmail.com", "admin123", "Yu Teng");
		Staff admin2 = new Staff("admin2@gmail.com", "admin123", "Yong Jian");
		Staff admin3 = new Staff("admin3@gmail.com", "admin123", "Davyn");
		Staff admin4 = new Staff("admin4@gmail.com", "admin123", "Aditya");
		Staff admin5 = new Staff("admin5@gmail.com", "admin123", "Si Han");

		db.addStaff(admin0);
		db.addStaff(admin1);
		db.addStaff(admin2);
		db.addStaff(admin3);
		db.addStaff(admin4);
		db.addStaff(admin5);
	}

	/**
	 * Initilialise Payment.
	 * 
	 * @param db The database.
	 */
	public static void initPayment(Database db) {
		db.payment.addLoyaltyCards("HSBC Card");
		db.payment.addLoyaltyCards("Gold Card");
		db.payment.addLoyaltyCards("Value movie pass");
	}

	/**
	 * A function to initialize a set of cineplexes.
	 * 
	 * @param db The database.
	 * @throws ParseException An exception thrown.
	 */
	public static void initCineplexes(Database db) throws ParseException {
		String[] avengersCast = { "Tom Hiddlestone", "Samuel L Jackson", "Chris Hemsworth" };
		String[] blackAdamCast = { "Dwayne Johnson", "Sarah Shahi" };
		String[] zootopiaCast = { "Judy Hopps", "Nick Wilde", "Bell Weather", "Gazelle" };
		String[] shangChiCast = { "Awkwafina", "Simu Liu", "Tony Leung Chiu-wai" };
		String[] hungerGamesCast = { "Katniss Everdeen", "Peeta Mellark" };
		String[] blackPantherCast = { "Letitia Wright", "Danai Gurira", "Tenoch Huerta" };
		String[] avatarCast = { "Sam Worthington", "Zoe Saldana" };
		String[] frozenThreeCast = { "Kristen Bell", "Idina Menzel", "Jonathan Groff" };

		Movie theAvengers = new Movie("The Avengers", true, "NOW_SHOWING", "Anthony Russo",
				"The Avengers band together to defeat bad dudes", avengersCast, 3, "PG");
		Movie blackAdam = new Movie("Black Adam", true, "PREVIEW", "Collet-Sarra",
				"Teth adams was bestowed powers by god", blackAdamCast, 2, "PG13");
		Movie zootopia = new Movie("Zootopia", false, "PREVIEW", "Byron Howard",
				"In a world of animals, rabbit cop follows her dreams and tries to protect the city of Zootopia",
				zootopiaCast, 4, "G");
		Movie shangChi = new Movie("Shang Chi & the Legend of the 10 Rings", true, "END_OF_SHOWING",
				"Destin Daniel Cretton", "Asian dude with 10 rings", shangChiCast, 3, "PG13");
		Movie hungerGames = new Movie("The Hunger Games", true, "NOW_SHOWING", "Francis Lawrence",
				"Everyone is hungry and fights", hungerGamesCast, 2, "PG13");
		Movie blackPanther = new Movie("Black Panther: Wakanda Forever", true, "NOW_SHOWING", "Ryan Coogler",
				"Wakanda needs a new king", blackPantherCast, 3, "PG13");
		Movie avatar = new Movie("Avatar:The Way of Water", true, "COMING_SOON", "James Cameron",
				"A war between alien and human", avatarCast, 2, "PG");
		Movie frozenThree = new Movie("Frozen III", false, "COMING_SOON", "Jennifer Lee",
				"Elsa shoots fire instead of ice this time", frozenThreeCast, 3, "G");

		db.movieListing.addMovie(theAvengers);
		db.movieListing.addMovie(blackAdam);
		db.movieListing.addMovie(hungerGames);
		db.movieListing.addMovie(shangChi);
		db.movieListing.addMovie(zootopia);
		db.movieListing.addMovie(blackPanther);
		db.movieListing.addMovie(avatar);
		db.movieListing.addMovie(frozenThree);

		Cineplex cineplex1 = new Cineplex("VivoCity Cineplex", 3);

		Cinema cinema1 = new Cinema(1, "AAN", false, cineplex1.getName(), 10, 10);
		Cinema cinema2 = new Cinema(2, "ABN", false, cineplex1.getName(), 10, 10);
		Cinema cinema3 = new Cinema(3, "ACP", true, cineplex1.getName(), 10, 10);
		cineplex1.addCinema(cinema1);
		cineplex1.addCinema(cinema2);
		cineplex1.addCinema(cinema3);

		Cineplex cineplex2 = new Cineplex("WestMall Cineplex", 3);
		Cinema cinema4 = new Cinema(1, "BAN", false, cineplex2.getName(), 10, 10);
		Cinema cinema5 = new Cinema(2, "BBN", false, cineplex2.getName(), 10, 10);
		Cinema cinema6 = new Cinema(3, "BCP", true, cineplex2.getName(), 10, 10);
		cineplex2.addCinema(cinema4);
		cineplex2.addCinema(cinema5);
		cineplex2.addCinema(cinema6);

		Cineplex cineplex3 = new Cineplex("Jurong Point Cineplex", 4);
		Cinema cinema7 = new Cinema(1, "CAN", false, cineplex3.getName(), 10, 10);
		Cinema cinema8 = new Cinema(2, "CBN", false, cineplex3.getName(), 10, 10);
		Cinema cinema9 = new Cinema(3, "CCP", true, cineplex3.getName(), 10, 10);
		Cinema cinema10 = new Cinema(4, "CDP", true, cineplex3.getName(), 10, 10);
		cineplex3.addCinema(cinema7);
		cineplex3.addCinema(cinema8);
		cineplex3.addCinema(cinema9);
		cineplex3.addCinema(cinema10);

		db.addCineplex(cineplex1);
		db.addCineplex(cineplex2);
		db.addCineplex(cineplex3);

		cinema1.setElite(9);
		cinema2.setElite(9);
		cinema3.setElite(9);
		cinema4.setElite(9);
		cinema5.setElite(9);
		cinema6.setElite(9);
		cinema7.setElite(9);
		cinema8.setElite(9);
		cinema9.setElite(9);
		cinema10.setElite(9);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Show TAshow1 = new Show(new Cinema(cinema1), theAvengers, cineplex1, false, sdf.parse("2022-11-13 10:00"));
		Show TAshow2 = new Show(new Cinema(cinema2), theAvengers, cineplex1, true, sdf.parse("2022-11-15 15:00"));
		Show TAshow3 = new Show(new Cinema(cinema2), theAvengers, cineplex1, true, sdf.parse("2022-11-18 21:00"));
		Show TAshow4 = new Show(new Cinema(cinema4), theAvengers, cineplex2, false, sdf.parse("2022-11-17 21:45"));
		Show TAshow5 = new Show(new Cinema(cinema4), theAvengers, cineplex2, false, sdf.parse("2022-11-20 12:30"));
		Show TAshow6 = new Show(new Cinema(cinema9), theAvengers, cineplex3, false, sdf.parse("2022-11-14 14:20"));
		Show TAshow7 = new Show(new Cinema(cinema7), theAvengers, cineplex3, false, sdf.parse("2022-11-15 21:30"));
		Show TAshow8 = new Show(new Cinema(cinema9), theAvengers, cineplex3, true, sdf.parse("2022-11-18 11:15"));

		Show BAshow1 = new Show(new Cinema(cinema3), blackAdam, cineplex1, false, sdf.parse("2022-12-21 15:00"));
		Show BAshow2 = new Show(new Cinema(cinema3), blackAdam, cineplex1, false, sdf.parse("2022-12-25 09:00"));
		Show BAshow3 = new Show(new Cinema(cinema5), blackAdam, cineplex2, false, sdf.parse("2022-12-20 20:00"));
		Show BAshow4 = new Show(new Cinema(cinema5), blackAdam, cineplex2, false, sdf.parse("2022-12-24 15:00"));
		Show BAshow5 = new Show(new Cinema(cinema5), blackAdam, cineplex2, false, sdf.parse("2022-12-26 22:00"));
		Show BAshow6 = new Show(new Cinema(cinema8), blackAdam, cineplex3, true, sdf.parse("2022-12-18 21:30"));
		Show BAshow7 = new Show(new Cinema(cinema10), blackAdam, cineplex3, false, sdf.parse("2022-12-22 10:30"));
		Show BAshow8 = new Show(new Cinema(cinema10), blackAdam, cineplex3, false, sdf.parse("2022-12-25 14:50"));

		Show ZTshow1 = new Show(new Cinema(cinema1), zootopia, cineplex1, false, sdf.parse("2022-12-23 11:20"));
		Show ZTshow2 = new Show(new Cinema(cinema1), zootopia, cineplex1, false, sdf.parse("2022-12-26 19:20"));
		Show ZTshow3 = new Show(new Cinema(cinema6), zootopia, cineplex2, true, sdf.parse("2022-12-25 16:00"));
		Show ZTshow4 = new Show(new Cinema(cinema7), zootopia, cineplex3, false, sdf.parse("2022-12-20 21:15"));
		Show ZTshow5 = new Show(new Cinema(cinema7), zootopia, cineplex3, false, sdf.parse("2022-12-26 13:45"));

		Show SCshow1 = new Show(new Cinema(cinema1), shangChi, cineplex1, false, sdf.parse("2022-10-18 19:00"));
		Show SCshow2 = new Show(new Cinema(cinema5), shangChi, cineplex2, false, sdf.parse("2022-10-15 15:00"));
		Show SCshow3 = new Show(new Cinema(cinema6), shangChi, cineplex2, true, sdf.parse("2022-10-22 20:30"));
		Show SCshow4 = new Show(new Cinema(cinema8), shangChi, cineplex3, true, sdf.parse("2022-10-16 10:50"));
		Show SCshow5 = new Show(new Cinema(cinema10), shangChi, cineplex3, false, sdf.parse("2022-10-21 20:15"));

		Show HGshow1 = new Show(new Cinema(cinema1), hungerGames, cineplex1, false, sdf.parse("2022-11-14 15:20"));
		Show HGshow2 = new Show(new Cinema(cinema3), hungerGames, cineplex1, false, sdf.parse("2022-11-21 21:20"));
		Show HGshow3 = new Show(new Cinema(cinema4), hungerGames, cineplex2, false, sdf.parse("2022-11-19 09:50"));
		Show HGshow4 = new Show(new Cinema(cinema6), hungerGames, cineplex2, true, sdf.parse("2022-11-22 22:30"));
		Show HGshow5 = new Show(new Cinema(cinema7), hungerGames, cineplex3, false, sdf.parse("2022-11-15 11:00"));
		Show HGshow6 = new Show(new Cinema(cinema9), hungerGames, cineplex3, true, sdf.parse("2022-11-18 15:00"));

		Show BPshow1 = new Show(new Cinema(cinema2), blackPanther, cineplex1, true, sdf.parse("2022-11-13 15:00"));
		Show BPshow2 = new Show(new Cinema(cinema3), blackPanther, cineplex1, false, sdf.parse("2022-11-18 11:15"));
		Show BPshow3 = new Show(new Cinema(cinema3), blackPanther, cineplex1, false, sdf.parse("2022-11-23 21:30"));
		Show BPshow4 = new Show(new Cinema(cinema5), blackPanther, cineplex2, false, sdf.parse("2022-11-14 16:30"));
		Show BPshow5 = new Show(new Cinema(cinema6), blackPanther, cineplex2, true, sdf.parse("2022-11-19 20:45"));
		Show BPshow6 = new Show(new Cinema(cinema7), blackPanther, cineplex3, false, sdf.parse("2022-11-16 21:20"));
		Show BPshow7 = new Show(new Cinema(cinema9), blackPanther, cineplex3, true, sdf.parse("2022-11-17 14:20"));
		Show BPshow8 = new Show(new Cinema(cinema9), blackPanther, cineplex3, false, sdf.parse("2022-11-20 22:00"));

		db.showListing.addShow(TAshow1);
		db.showListing.addShow(TAshow2);
		db.showListing.addShow(TAshow3);
		db.showListing.addShow(TAshow4);
		db.showListing.addShow(TAshow5);
		db.showListing.addShow(TAshow6);
		db.showListing.addShow(TAshow7);
		db.showListing.addShow(TAshow8);

		db.showListing.addShow(BAshow1);
		db.showListing.addShow(BAshow2);
		db.showListing.addShow(BAshow3);
		db.showListing.addShow(BAshow4);
		db.showListing.addShow(BAshow5);
		db.showListing.addShow(BAshow6);
		db.showListing.addShow(BAshow7);
		db.showListing.addShow(BAshow8);

		db.showListing.addShow(ZTshow1);
		db.showListing.addShow(ZTshow2);
		db.showListing.addShow(ZTshow3);
		db.showListing.addShow(ZTshow4);
		db.showListing.addShow(ZTshow5);

		db.showListing.addShow(SCshow1);
		db.showListing.addShow(SCshow2);
		db.showListing.addShow(SCshow3);
		db.showListing.addShow(SCshow4);
		db.showListing.addShow(SCshow5);

		db.showListing.addShow(HGshow1);
		db.showListing.addShow(HGshow2);
		db.showListing.addShow(HGshow3);
		db.showListing.addShow(HGshow4);
		db.showListing.addShow(HGshow5);
		db.showListing.addShow(HGshow6);

		db.showListing.addShow(BPshow1);
		db.showListing.addShow(BPshow2);
		db.showListing.addShow(BPshow3);
		db.showListing.addShow(BPshow4);
		db.showListing.addShow(BPshow5);
		db.showListing.addShow(BPshow6);
		db.showListing.addShow(BPshow7);
		db.showListing.addShow(BPshow8);
	}
}
