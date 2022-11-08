package controller;

import model.Cinema;
import model.Cineplex;
import model.MovieGoer;
import model.Show;
import model.Staff;
import model.Movie;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class DataController {

	public static Database main() {
		Database database = new Database();

		initCineplexes(database);
		initMovieGoers(database);
		initStaff(database);

		return database;
	}

	public static void initMovieGoers(Database db) {
		MovieGoer member1 = new MovieGoer(30, "John Tan", 1,"abc123");
		MovieGoer member2 = new MovieGoer(10, "Adam Wong",2, "abc123");
		MovieGoer member3 = new MovieGoer(18, "Ben Sim", 3,"abc123");

		db.addMovieGoer(member1);
		db.addMovieGoer(member2);
		db.addMovieGoer(member3);
	}

	public static void initStaff(Database db) {
		Staff admin1 = new Staff("admin1@gmail.com", "admin123", "Yu Teng");
		Staff admin2 = new Staff("admin2@gmail.com", "admin123", "Yong Jian");
		Staff admin3 = new Staff("admin3@gmail.com", "admin123", "Davyn");
		Staff admin4 = new Staff("admin4@gmail.com", "admin123", "Aditya");
		Staff admin5 = new Staff("admin5@gmail.com", "admin123", "Si Han");

		db.addStaff(admin1);
		db.addStaff(admin2);
		db.addStaff(admin3);
		db.addStaff(admin4);
		db.addStaff(admin5);
	}

	public static void initCineplexes(Database db) {
		String[] avengersCast = {"Tom Hiddlestone", "Samuel L Jackson", "Chris Hemsworth"};
		String[] blackAdamCast = {"Dwayne Johnson", "Sarah Shahi"};
		String[] zootopiaCast = {"Judy Hopps", "Nick Wilde", "Bell Weather", "Gazelle"};
		String[] shangChiCast = {"Shang Chi"};
		String[] hungerGamesCast = {"Katniss Everdeen", "Peeta Mellark"};

		Movie theAvengers = new Movie("The Avengers", true, "NOW_SHOWING", "Anthony Russo", "The Avengers band together to defeat bad dudes", avengersCast, 3);
		Movie blackAdam = new Movie("Black Adam", true, "PREVIEW", "Collet-Sarra", "Teth adams was bestowed powers by god", blackAdamCast, 2);
		Movie zootopia = new Movie("Zootopia", false, "END_OF_SHOWING", "Byron Howard", "In a world of animals, rabbit cop follows her dreams and tries to protect the city of Zootopia", zootopiaCast, 4);
		Movie shangChi = new Movie("Shang Chi and the Legend of the 10 Rings", true, "END_OF_SHOWING", "your mum", "Asian dude with 10 rings", shangChiCast, 1);
		Movie hungerGames = new Movie("The Hunger Games", true, "NOW_SHOWING", "your dad", "Everyone is hungry and fights", hungerGamesCast, 2);
		
		Database.movieListing.addMovie(theAvengers);
		Database.movieListing.addMovie(blackAdam);
		Database.movieListing.addMovie(hungerGames);
		Database.movieListing.addMovie(shangChi);
		Database.movieListing.addMovie(zootopia);

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

		Cineplex cineplex3 = new Cineplex("Jurong Point Cineplex", 3);
		Cinema cinema7 = new Cinema(1, "CAN", false, cineplex3.getName(), 10, 10);
		Cinema cinema8 = new Cinema(2, "CBN", false, cineplex3.getName(), 10, 10);
		Cinema cinema9 = new Cinema(3, "CCP", true, cineplex3.getName(), 10, 10);
		cineplex3.addCinema(cinema7);
		cineplex3.addCinema(cinema8);
		cineplex3.addCinema(cinema9);

		db.addCineplex(cineplex1);
		db.addCineplex(cineplex2);
		db.addCineplex(cineplex3);

		//public Show(Cinema cinema,Movie movie,Cineplex cineplex,boolean is3d,Date showTime)
		Calendar calendar = new GregorianCalendar();
		Date date = calendar.getTime();
		Show TAshow1 = new Show(cinema1, theAvengers, cineplex1, false, date);
		Show HGshow1 = new Show(cinema1, hungerGames, cineplex1, false,  date);
		Show HGshow2 = new Show(cinema1, hungerGames, cineplex1, false, date);
		Show HGshow3 = new Show(cinema1, hungerGames, cineplex1, false,  date);
		Show TAshow2 = new Show(cinema4, theAvengers, cineplex2, false,  date);
		Show HGshow4 = new Show(cinema4, hungerGames, cineplex2, false, date);
		Show HGshow5 = new Show(cinema4, hungerGames, cineplex2, false, date);
		Show TAshow3 = new Show(cinema6, theAvengers, cineplex2, true,  date);
		Show TAshow4 = new Show(cinema6, theAvengers, cineplex2, true,  date);

		Database.showListing.addShow(TAshow1);
		Database.showListing.addShow(TAshow2);
		Database.showListing.addShow(TAshow3);
		Database.showListing.addShow(TAshow4);
		Database.showListing.addShow(HGshow1);
		Database.showListing.addShow(HGshow2);
		Database.showListing.addShow(HGshow3);
		Database.showListing.addShow(HGshow4);
		Database.showListing.addShow(HGshow5);
	}
}
