package boundary;

import java.util.Scanner;

import controller.Database;
import model.Holiday;

public class SettingsUI {
	/**
	 * Declare static scanner once for this class
	 */
	private static Scanner sc = new Scanner(System.in);

	/**
	 * Main function containing the program loop for settings menu
	 * @return void
	 */
	public void main(Database db) {
		boolean exit = false;
		double newPrice;
		double newMultiplier;
		do {
			System.out.println("");
			System.out.println("||----------- Settings Menu -----------||");
			System.out.println("1. List all holidays");
			System.out.println("||----------- Update Multipliers -----------||");
			System.out.printf("2. Update Holiday Price Multiplier --- current: %.2fx\n", db.payment.getHolidayMultiplier());
			System.out.printf("3. Update Weekend Price Multiplier --- current: %.2fx\n", db.payment.getWeekendMultiplier());
			System.out.printf("4. Update Senior Price Multiplier  --- current: %.2fx\n", db.payment.getSeniorMultipier());
			System.out.printf("5. Update Student Price Multiplier --- current: %.2fx\n", db.payment.getStudentMultipier());
			System.out.println("||---------- Update Prices -----------||");
			System.out.printf("6. Update Base ticket price        --- current: $%.2f\n", db.payment.getBasePrice());
			System.out.printf("7. Update 3d Movie extra charge    --- current: $%.2f\n", db.payment.getIs3DPrice());
			System.out.printf("8. Update Platinum extra charge    --- current: $%.2f\n", db.payment.getIsPlatPrice());
			System.err.printf("9. Update Blockbuster extra charge --- current: $%.2f\n", db.payment.getIsBBPrice());
			System.out.println("10. Return to Admin menu");
			System.out.print("Select option: ");
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
				System.out.println("-------- Updating Base Price --------");
				newPrice = getPriceFromUser();
				db.payment.setBasePrice(newPrice);
				break;
			case "7":
				System.out.println("-------- Updating 3D Charge --------");
				newPrice = getPriceFromUser();
				db.payment.set3dAdditionalPrice(newPrice);
				break;
			case "8":
				System.out.println("-------- Updating Platinum Charge --------");
				newPrice = getPriceFromUser();
				db.payment.setPlatAdditionalPrice(newPrice);
				break;
			case "9":
				System.out.println("-------- Updating Blockbuster Charge --------");
				newPrice = getPriceFromUser();
				db.payment.setBlockBusterAdditionalPrice(newPrice);
				break;
			case "10":
				exit = true;
				break;
			default: System.out.println("Enter a valid option.");
			}
		} while (!exit);
		System.out.println("Returning to Admin menu...");
	}
	
	/**
	 * Gets a non negative double input from admin for setting of new prices
	 * @return price
	 */
	private static double getPriceFromUser(){
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
	 * Gets a non negative multiplier from admin for setting of new price multipliers
	 * @return multi
	 */
	private static double getMultiplierFromUser(){
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
}
