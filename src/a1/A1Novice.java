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

			char firstInitial = scan.next().charAt(0); lastName.add(scan.next());
			firstName.add(firstInitial);

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
			int customerID = scan.nextInt();
			do {
				int itemEach = scan.nextInt(); String itemName = scan.next(); double itemPrice = scan.nextDouble();
				totalOfEachItem.add(itemEach * itemPrice);
				customerID = customerID - 1;
			} while (customerID > 0);

			for (int i = 0; i < totalOfEachItem.size(); i++) {
				customerTotal += (double) totalOfEachItem.get(i);
			}
			return customerTotal;
			}

	}

