package a1;

import java.util.ArrayList;
import java.util.*;

public class A1Novice {

	int itemsBought;
	String itemName;
	double itemPrice;
	int itemEach;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);


		ArrayList total = new ArrayList();
		ArrayList<Character> firstName = new ArrayList<>();
		ArrayList<String> lastName = new ArrayList<>();


		int numberOfCustomers = scan.nextInt();

		do {

			char firstInitial = scan.next().charAt(0);
			firstName.add(firstInitial);

			lastName.add(scan.next());
			int customerID = scan.nextInt();
			double eachTotal = getTotal();
			total.add(eachTotal);

			numberOfCustomers--;
			}while (numberOfCustomers >0);

		for(int j=0; j<firstName.size();j++) {
			System.out.print(firstName.get(j) + ".");
			System.out.print(lastName.get(j) +": ");
			System.out.println(total.get(j));
		}
		}

		static double getTotal() {
			Scanner scan = new Scanner(System.in);
			ArrayList<Number> totalOfEachItem = new ArrayList<>();
			double customerTotal = 0;
			int itemsBought = scan.nextInt();
			do {
				int itemEach = scan.nextInt();
				String itemName = scan.next();
				double itemPrice = scan.nextDouble();
				totalOfEachItem.add(itemEach * itemPrice);
				itemsBought = itemsBought - itemEach;
			} while (itemsBought > 0);

			for (int i = 0; i < totalOfEachItem.size(); i++) {
				customerTotal += (double) totalOfEachItem.get(i);
			}
			return customerTotal;
			}

	}

