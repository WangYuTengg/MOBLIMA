package boundary;

import java.util.Scanner;
import model.Payment;

public class SettingsUI {

	/**
	 * Declare static scanner once for this class
	 */
	private static Scanner sc = new Scanner(System.in);

	/**
	 * Main function containing the program loop for settings menu
	 */
	public void main() {
		boolean exit = false;
		double newPrice;
		double newMultiplier;
		do {
			System.out.println("||----------- Settings Menu -----------||");
			System.out.println("1. List all holidays");
			System.out.println("||----------- Update Multipliers -----------||");
			System.out.println("2. Update Holiday Price Multiplier");
			System.out.println("3. Update Weekend Price Multiplier");
			System.out.println("4. Update Senior Price Multiplier");
			System.out.println("5. Update Student Price Multiplier");
			System.out.println("||---------- Update Prices -----------||");
			System.out.println("6. Update Base ticket price");
			System.out.println("7. Update 3d Movie additional charge");
			System.out.println("8. Update Platinum Cinema additional charge");
			System.err.println("9. Update Blockbuster Movie additional charge");
			System.out.println("10. Return to Admin menu");
			System.out.print("Select option: ");
			String adminInput = sc.next();
			switch (adminInput) {
			case "1":
				System.out.println("Listing all holidays: ");
				break;
			case "2":
				System.out.println("-------- Updating Holiday Multiplier --------");
				newMultiplier = getMultiplierFromUser();
				Payment.setHolidayPriceMultiplier(newMultiplier);
				System.out.printf("Holiday price multiplier successfully updated to: %.2f\n", newMultiplier);
				break;
			case "3":
				System.out.println("-------- Updating Weekend Multiplier --------");
				newMultiplier = getMultiplierFromUser();
				Payment.setWeekendPriceMultiplier(newMultiplier);
				System.out.printf("Weekend price multiplier successfully updated to: %.2f\n", newMultiplier);
				break;
			case "4":
				System.out.println("-------- Updating Senior Multiplier --------");
				newMultiplier = getMultiplierFromUser();
				Payment.setSeniorPriceMultiplier(newMultiplier);
				System.out.printf("Senior price multiplier successfully updated to: %.2f\n", newMultiplier);
				break;
			case "5":
				System.out.println("-------- Updating Student Multiplier --------");
				newMultiplier = getMultiplierFromUser();
				Payment.setStudentPriceMultiplier(newMultiplier);
				System.out.printf("Student price multiplier successfully updated to: %.2f\n", newMultiplier);
				break;
			case "6":
				System.out.println("-------- Updating Base Price --------");
				newPrice = getPriceFromUser();
				Payment.setBasePrice(newPrice);
				System.out.printf("Base price successfully updated to: %.2f\n", newPrice);
				break;
			case "7":
				System.out.println("-------- Updating 3D Charge --------");
				newPrice = getPriceFromUser();
				Payment.set3dAdditionalPrice(newPrice);
				System.out.printf("3D additional charge successfully updated to: %.2f\n", newPrice);
				break;
			case "8":
				System.out.println("-------- Updating Platinum Charge --------");
				newPrice = getPriceFromUser();
				Payment.setPlatAdditionalPrice(newPrice);
				System.out.printf("Platinum cinema additional charge successfully updated to: %.2f\n", newPrice);
				break;
			case "9":
				System.out.println("-------- Updating Blockbuster Charge --------");
				newPrice = getPriceFromUser();
				Payment.setBlockBusterAdditionalPrice(newPrice);
				System.out.printf("Blockbuster movie additonal charge successfully updated to: %.2f\n", newPrice);
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
