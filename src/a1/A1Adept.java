    package a1;
    import java.lang.reflect.Array;
    import java.util.ArrayList;
    import java.util.Scanner;

    public class A1Adept {

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
           // String[] firstName = new String[numberOfCustomers];
            //String[] lastName = new String[numberOfCustomers];
            //double[] total = new double[numberOfCustomers];
            ArrayList total = new ArrayList();
            //	int [] quantityBought = new int [numberOfCustomers];


            ArrayList customerItemTotals = new ArrayList();
            do {
                double customerTotal = 0;
                    String customerFirst = scan.next();
                    firstName.add(customerFirst);
                    String customerLast = scan.next();
                    lastName.add(customerLast);
                    customerTotal = getTotal(names, prices, (ArrayList) customerItemTotals.clone(), customerTotal);
                    total.add(customerTotal);

                    numberOfCustomers--;

            }while (numberOfCustomers > 0);

          double sum = findAverage(total);
          double average = sum/total.size();

            String biggestSpentIndexVal = findBiggestIndexWithValue(total);
            String biggestIndexVal[]=  biggestSpentIndexVal.split("::");
             int idxMax = Integer.parseInt(biggestIndexVal[0]);
            double biggestValue = Double.parseDouble(biggestIndexVal[1]);

            String smallestSpentIndexVal = findSmallestIndexWithValue(total);
            String smallestIndexVal[]=  smallestSpentIndexVal.split("::");
            int idxMin = Integer.parseInt(smallestIndexVal[0]);
            double smallestValue = Double.parseDouble(smallestIndexVal[1]);


       System.out.println("Biggest: " + firstName.get(idxMax) + " " + lastName.get(idxMax) + "  (" + biggestValue + ")");
      System.out.println("Smallest: " + firstName.get(idxMin) + " " + lastName.get(idxMin) + "  (" + smallestValue + ")");
        System.out.println("Average: " + average);
        }




        static String findSmallestIndexWithValue(ArrayList<Double> total) {
            double min = total.get(0);
            int minInt = 0;
            int i;
            for (i = 1; i < total.size(); i++) {
                if (total.get(i) < min) {
                    min = total.get(i);
                    minInt=i;
                }
            }
            return (minInt + "::" + min);
        }
        static String findBiggestIndexWithValue(ArrayList<Double> total) {
            double max = total.get(0);
            int maxInt = 0;
            int i;
            for (i = 1; i < total.size(); i++) {
                if (total.get(i) > max) {
                    max = total.get(i);
                    maxInt=i;
                }
            }
            return (maxInt + "::" + max);
        }

        static double findAverage(ArrayList<Double> total) {
            double sum = 0;
            for (int i = 0; i < total.size(); i++) {
                sum += total.get(i);
            }
            return sum;

        }
        static double getTotal(String[] names, double[] prices, ArrayList customerItemTotals, double customerTotal){
            Scanner scan = new Scanner(System.in);
            int itemsBought = scan.nextInt();

            do {
                String customerItemName = scan.next();
                int quantity = scan.nextInt();
                //find customerItemName in names array
                //use that index in the prices array to get the price
                //multiply it with the user's quantity to get the total of that item - store in an array
                //add up all totals and put into a different array which is what will be searched for the outputs
                for (int k = 0; k < names.length; k++) {
                    if (customerItemName.equals(names[k])) {
                        double totalOfItem = quantity * prices[k];
                        customerItemTotals.add(totalOfItem);
                    }
                }
                itemsBought = itemsBought - quantity;
            } while (itemsBought > 0);

            for (int i = 0; i < customerItemTotals.size(); i++) {
                customerTotal += (double) customerItemTotals.get(i);
            }


            return customerTotal;
        }
    }

    /*
          int minIndex =0;
          for(int j=0; j<total.size(); j++) {
              if (total.equals(smallestSpent)) {
                  minIndex = j;
              }
          }
            int maxIndex =0;
            for(int k=0; k<total.size(); k++) {
                if (total.equals(biggestSpent)) {
                    maxIndex = k;
                }
            }
           int test = total.equals(biggestSpent));
            }
                static double findBiggest(ArrayList<Double> total) {
            double max = total.get(0);
            for (int i = 1; i < total.size(); i++) {
                if (total.get(i) > max) {
                    max = total.get(i);
                }
            }
            System.out.println("testing the max:"+max);
            return max;
        }
            static double findSmallest(ArrayList<Double> total) {
            double min = total.get(0);
            int i;
            for (i = 1; i < total.size(); i++) {
                if (total.get(i) < min) {
                    min = total.get(i);
                }
                else {
                    min=total.get(0);
                }
            }
            return min;
        }
     */