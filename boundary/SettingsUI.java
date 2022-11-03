package boundary;

import java.util.Scanner;

public class SettingsUI {
	private static Scanner sc = new Scanner(System.in);
	public void main() {
		boolean exit = false;
		do {
			System.out.println("||----------- Settings Menu -----------||");
			System.out.println("1. List all holidays");
			System.out.println("2. Add holiday");
			System.out.println("3. Delete holiday");
			System.out.println("4. Update Standard price");
			System.out.println("5. Update Holiday price");
			System.out.println("6. Update Senior price");
			System.out.println("7. Update Premium Cinema price");
			System.out.println("8. Return to Admin menu");
			System.out.print("Select option: ");
			String adminInput = sc.next();
			switch (adminInput) {
			case "1":
				System.out.println("Listing Holidays");
				break;
			case "2":
				System.out.println("Adding Holidays");
				break;
			case "3":
				System.out.println("Deleting Holidays");
				break;
			case "4":
			case "5":
			case "6":
			case "7":
				System.out.println("Updating prices...");
				break;
			case "8":
				exit = true;
				break;
			default:
				System.out.println("Enter a valid option.");
			}
		} while (!exit);
		System.out.println("Returning to Admin menu...");
		return;
	}

}
