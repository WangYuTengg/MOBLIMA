/**
 * The Main Class for the MOBLIMA Application.
 * @version  3.0
 * @author   Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong Jian
 * @since    2022-10-30
*/

import boundary.MainMenuUi;
import data.DataInitialiser;
import data.Database;
import data.Serialization;


public class MoblimaApp {

	/**
	 * The Main Function to start the MOBLIMA Application.
	 * @param args
	 */
	public static void main(String[] args) {
		MainMenuUi mainMenuUI = new MainMenuUi();
		Database db;
		db = DataInitialiser.main();
		//db=Serialization.read();
		mainMenuUI.main(db);
		Serialization.write(db);
	}
}
