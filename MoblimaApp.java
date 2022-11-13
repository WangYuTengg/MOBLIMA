import boundary.MainMenuUi;
import data.DataInitialiser;
import data.Database;
import data.Serialization;

/**
 * The Main Class for the MOBLIMA Application.
 * @version  2.0
 * @author   Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong Jian
 * @since    2022-10-30
*/
public class MoblimaApp {

	/**
	 * The Main Function to start the MOBLIMA Application.
	 * @param args	System Input Arguments.
	 */
	public static void main(String[] args) {

		MainMenuUi mainMenuUI = new MainMenuUi();
		Database db; 

		db = DataInitialiser.main(); //uncomment this for first run of program, comment it out for subsequent runs
		//db=Serialization.read(); //uncomment this for 2nd run onwards
		mainMenuUI.main(db);
		Serialization.write(db);
	}
}
