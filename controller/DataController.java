package controller;

import model.Cinema;
import model.Cineplex;
import model.MovieGoer;

public class DataController {

	public static void main() {
		Database database = new Database();
		initCineplexes(database);
		initMovieGoers(database);
		initStaff(database);
		initMovieListing(database);
		initShowListing(database);
		return;
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
		MovieGoer member1 = new MovieGoer(30, "John Tan", "abc123");
		MovieGoer member2 = new MovieGoer(10, "Adam Wong", "abc123");
		MovieGoer member3 = new MovieGoer(18, "Ben Sim", "abc123");

		db.addMovieGoer(member1);
		db.addMovieGoer(member2);
		db.addMovieGoer(member3);
	}

	public static void initStaff(Database db) {
		return;
	}

	public static void initMovieListing(Database db) {
		return;
	}

	public static void initShowListing(Database db) {
		return;
	}
}
