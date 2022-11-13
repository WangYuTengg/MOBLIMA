package boundary;

import java.util.ArrayList;
import java.util.Scanner;

import data.Database;
import model.Holiday;

/**
 * The class used for SettingsUI.
 * @version  3.0
 * @author   Guo Sihan, Davyn Yam JunHao, Wang Yu Teng, Aditya Pugalia, Ng Yong Jian
 * @since    2022-10-30
 */
public class SettingsUI implements BaseUI{

	/**
	 * A static scanner used throughout SettingsUI.
	 */
	private static Scanner sc = new Scanner(System.in);

	/**
	 * Main function containing the program loop for settings menu.
	 * @param db The database.
	 */
	public void main(Database db) {
		sc=new Scanner(System.in);
		boolean exit = false;
		double newPrice;
		double newMultiplier;
		do {
			display(db);
			String adminInput = sc.next();
			switch (adminInput) {
			case "1":
				System.out.println("Listing all holidays: ");
				Holiday.listHoliday();
				break;
			case "2":
				System.out.println("-------- Updating Holiday Multiplier --------");
				newMultiplier = getMultiplierFromUser();
				db.payment.setHolidayPriceMultiplier(newMultiplier);
				break;
			case "3":
				System.out.println("-------- Updating Weekend Multiplier --------");
				newMultiplier = getMultiplierFromUser();
				db.payment.setWeekendPriceMultiplier(newMultiplier);
				break;
			case "4":
				System.out.println("-------- Updating Senior Multiplier --------");
				newMultiplier = getMultiplierFromUser();
				db.payment.setSeniorPriceMultiplier(newMultiplier);
				break;
			case "5":
				System.out.println("-------- Updating Student Multiplier --------");
				newMultiplier = getMultiplierFromUser();
				db.payment.setStudentPriceMultiplier(newMultiplier);
				break;
			case "6":
				System.out.println("-------- Updating Loyalty Card Multiplier --------");
				newMultiplier = getMultiplierFromUser();
				db.payment.setLoyaltyCardMultiplier(newMultiplier);
				break;
			case "7":
				System.out.println("-------- Updating Base Price --------");
				newPrice = getPriceFromUser();
				db.payment.setBasePrice(newPrice);
				break;
			case "8":
				System.out.println("-------- Updating 3D Charge --------");
				newPrice = getPriceFromUser();
				db.payment.set3dAdditionalPrice(newPrice);
				break;
			case "9":
				System.out.println("-------- Updating Platinum Charge --------");
				newPrice = getPriceFromUser();
				db.payment.setPlatAdditionalPrice(newPrice);
				break;
			case "10":
				System.out.println("-------- Updating Blockbuster Charge --------");
				newPrice = getPriceFromUser();
				db.payment.setBlockBusterAdditionalPrice(newPrice);
				break;
			case "11":
				System.out.println("-------- Updating Elite Seat Charge --------");
				newPrice = getPriceFromUser();
				db.payment.setEliteAdditionalPrice(newPrice);
				break;
			case "12":
				System.out.println("-------- Adding Loyalty Card --------");
				sc.nextLine();
				System.out.println("Enter Loyalty Card name:");
				String card_name=sc.nextLine();
				db.payment.addLoyaltyCards(card_name);
				break;
			case "13":
				System.out.println("-------- Deleting Loyalty Card --------");
				ArrayList<String> loyaltyCards=db.payment.getLoyaltyCards();
				for(int i=0;i<loyaltyCards.size();++i) System.out.printf("%d. %s\n",i+1,loyaltyCards.get(i));
				System.out.printf("Enter Loyalty Card index(1-%d):",loyaltyCards.size());
				int card_index;
				while(true){
					if(!sc.hasNextInt()) System.out.println("Please enter a number");
					else{
						card_index=sc.nextInt();
						if(card_index<1||card_index>loyaltyCards.size()) System.out.println("Please enter a valid number");
						else break;
					}
				}
				db.payment.removeLoyaltyCards(loyaltyCards.get(card_index-1));
				break;
			case "14":
				exit = true;
				break;
			default: System.out.println("Enter a valid option.");
			}
		} while (!exit);
		System.out.println("Returning to Admin menu...");
	}
	
	/**
	 * Gets a non negative double input from admin for setting of new prices.
	 * @return The new price.
	 */
	private static double getPriceFromUser(){
		sc=new Scanner(System.in);
		boolean exit = false;
		double price = -1;
		do{
			System.out.print("Enter new price: ");
			//check for double input
			while(!sc.hasNextDouble()){
				System.out.print("Enter a number please: ");
				sc.next();
			}
			price = sc.nextDouble();

			//check if price is non negative
			if (price >= 0) exit = true;
			else System.out.println("Enter a proper price please. ( more than 0 )");
		}while(!exit);
		return price;
	}
	
	/**
	 * Gets a non negative multiplier from admin for setting of new price multipliers.
	 * @return 	The new multiplier.
	 */
	private static double getMultiplierFromUser(){
		sc=new Scanner(System.in);
		boolean exit = false;
		double multi = -1;
		do {
			System.out.print("Enter new multiplier: ");
			//check for double input
			while(!sc.hasNextDouble()){
				System.out.print("Enter a number please: ");
				sc.next();
			}

			//check if multiplier is non negative
			multi = sc.nextDouble();
			if (multi >= 0) exit = true;
			else System.out.println("Enter a proper multiplier please. ( more than 0 )");
		}while(!exit);
		return multi;
	}

	/**
	 * Displays the Settings Menu for the Staff.
	 * @param db	The database.
	 */
	private void display(Database db)
	{
		System.out.println("");
			System.out.println("||----------- Settings Menu -----------||");
			System.out.println("1. List all holidays");
			System.out.println("||----------- Update Multipliers -----------||");
			System.out.printf("2. Update Holiday Price Multiplier  --- current: %.2fx\n", db.payment.getHolidayMultiplier());
			System.out.printf("3. Update Weekend Price Multiplier  --- current: %.2fx\n", db.payment.getWeekendMultiplier());
			System.out.printf("4. Update Senior Price Multiplier   --- current: %.2fx\n", db.payment.getSeniorMultipier());
			System.out.printf("5. Update Student Price Multiplier  --- current: %.2fx\n", db.payment.getStudentMultipier());
			System.out.printf("6. Update Loyalty Card Multiplier   --- current: %.2fx\n", db.payment.getLoyaltCardMultiplier());
			System.out.println("||---------- Update Prices -----------||");
			System.out.printf("7. Update Base ticket price         --- current: $%.2f\n", db.payment.getBasePrice());
			System.out.printf("8. Update 3d Movie extra charge     --- current: $%.2f\n", db.payment.getIs3DPrice());
			System.out.printf("9. Update Platinum extra charge     --- current: $%.2f\n", db.payment.getIsPlatPrice());
			System.err.printf("10. Update Blockbuster extra charge --- current: $%.2f\n", db.payment.getIsBBPrice());
			System.err.printf("11. Update Elite Seat extra charge  --- current: $%.2f\n", db.payment.getIsEliteSeatprice());
			System.out.println("||---------- Update Loyalty Cards -----------||");
			System.out.printf("12. Add Loyalty Cards\n");
			System.out.printf("13. Delete Loyalty Cards\n");
			System.out.println("14. Return to Admin menu");
			System.out.print("Select option: ");
	}
}
