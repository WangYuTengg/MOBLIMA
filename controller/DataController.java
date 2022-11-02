package controller;

import model.Cinema;
import model.Cineplex;
import model.MovieGoer;
import model.Staff;
import model.Movie;

public class DataController {

	public static Database main() {
		Database database = new Database();
		initCineplexes(database);
		initMovieGoers(database);
		initStaff(database);
		initMovieListing(database);
		initShowListing(database);
		return database;
	}

	public static void initCineplexes(Database db) {
		Cineplex cineplex1 = new Cineplex("VivoCity Cineplex", 3);
		Cinema cinema1 = new Cinema(1, "normal", "VivoCity Cineplex", 10, 10);
		Cinema cinema2 = new Cinema(2, "normal", "VivoCity Cineplex", 10, 10);
		Cinema cinema3 = new Cinema(3, "platinum", "VivoCity Cineplex", 10, 10);
		cineplex1.addCinema(cinema1);
		cineplex1.addCinema(cinema2);
		cineplex1.addCinema(cinema3);

		Cineplex cineplex2 = new Cineplex("VivoCity Cineplex", 3);
		Cinema cinema4 = new Cinema(1, "normal", "Westmall Cineplex", 10, 10);
		Cinema cinema5 = new Cinema(2, "normal", "Westmall Cineplex", 10, 10);
		Cinema cinema6 = new Cinema(3, "platinum", "Westmall Cineplex", 10, 10);
		cineplex2.addCinema(cinema4);
		cineplex2.addCinema(cinema5);
		cineplex2.addCinema(cinema6);

		Cineplex cineplex3 = new Cineplex("VivoCity Cineplex", 3);
		Cinema cinema7 = new Cinema(1, "normal", "VivoCity Cineplex", 10, 10);
		Cinema cinema8 = new Cinema(2, "normal", "VivoCity Cineplex", 10, 10);
		Cinema cinema9 = new Cinema(3, "platinum", "VivoCity Cineplex", 10, 10);
		cineplex3.addCinema(cinema7);
		cineplex3.addCinema(cinema8);
		cineplex3.addCinema(cinema9);

		db.addCineplex(cineplex1);
		db.addCineplex(cineplex1);
		db.addCineplex(cineplex1);
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
		Staff admin1 = new Staff("admin1", "admin123", "Yu Teng");
		Staff admin2 = new Staff("admin2", "admin123", "Yong Jian");
		Staff admin3 = new Staff("admin3", "admin123", "Davyn");
		Staff admin4 = new Staff("admin4", "admin123", "Aditya");
		Staff admin5 = new Staff("admin5", "admin123", "Si Han");

		db.addStaff(admin1);
		db.addStaff(admin2);
		db.addStaff(admin3);
		db.addStaff(admin4);
		db.addStaff(admin5);

	}

	public static void initMovieListing(Database db) {
		String[] avengersCast = {"Tom Hiddlestone", "Samuel L Jackson", "Chris Hemsworth"};
		String[] blackAdamCast = {"Dwayne Johnson", "Sarah Shahi"};
		Movie theAvengers = new Movie("The Avengers", true, "NOW_SHOWING", "Anthony Russo", "The Avengers band together to defeat bad dudes", avengersCast, 3);
		Movie blackAdam = new Movie("Black Adam", true, "PREVIEW", "Collet-Sarra", "Teth adams was bestowed powers by god", blackAdamCast, 2);
		
		Database.movieListing.addMovie(theAvengers);
		Database.movieListing.addMovie(blackAdam);
		return;
	}

	public static void initShowListing(Database db) {
		return;
	}
}
