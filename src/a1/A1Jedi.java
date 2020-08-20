package a1;

import java.util.ArrayList;
import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int numberOfItems = scan.nextInt();
		String[] names = new String[numberOfItems];
		double[] prices = new double[numberOfItems];

		for (int i = 0; i < numberOfItems; i++) {
			String itemName = scan.next();
			names[i] = itemName;
			double itemPrice = scan.nextDouble();
			prices[i] = itemPrice;
		}

		int numberOfCustomers = scan.nextInt();

		ArrayList firstName = new ArrayList();
		ArrayList lastName = new ArrayList();
		ArrayList customerItems = new ArrayList();
		ArrayList quantityBought = new ArrayList();
		ArrayList idx = new ArrayList();
		do {
			String customerFirst = scan.next();
			firstName.add(customerFirst);
			String customerLast = scan.next();
			lastName.add(customerLast);

			int itemsBought = scan.nextInt();

			do {
				String customerItemName = scan.next();
				customerItems.add(customerItemName);

				int quantity = scan.nextInt();
				quantityBought.add(quantity);

				itemsBought = itemsBought - quantity;
			} while (itemsBought > 0);

			numberOfCustomers--;

		} while (numberOfCustomers > 0);

		int count = 0;
		int sum = 0;

		for (int i = 0; i < names.length; i++) {
			for (int k = 0; k < customerItems.size(); k++) {
				if (customerItems.get(k).equals(names[i])) {
					sum += (int) quantityBought.get(k);
					count++;
				}
			}
			if (count > 0) {
				System.out.println(count + " bought " + sum + " " + names[i]);
			} else {
				System.out.println("No customers bought " + names[i]);
			}
			count = 0;
			sum = 0;
		}


	}
}
