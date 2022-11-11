import boundary.MainMenuUi;
import controller.DataController;
import controller.Database;

public class MoblimaApp {

	public static void main(String[] args) {
		MainMenuUi mainMenuUI = new MainMenuUi();
		Database db;
		db = DataController.main();
		//db=Serialization.read();
		mainMenuUI.main(db);
		Serialization.write(db);
	}
}
