import boundary.MainMenuUi;
import data.DataInitialiser;
import data.Database;
import data.Serialization;

public class MoblimaApp {

	public static void main(String[] args) {
		MainMenuUi mainMenuUI = new MainMenuUi();
		Database db;
		db = DataInitialiser.main();
		//db=Serialization.read();
		mainMenuUI.main(db);
		Serialization.write(db);
	}
}
