import java.util.ArrayList;
import java.util.Arrays;

public class CafeUtil { 
    public int getStreakGoal(int numWeeks) {
        int x = 0;
        for (int i = 1; i <= numWeeks; i++) {
            x = x + i; 
        }
        return x;
    }

    public double getOrderTotal(double[] lineItems) {
        double x = 0;
        for (int i = 0; i < lineItems.length; i++) {
        x = x + lineItems[i];
        }
        return x;
    }

    public void displayMenu(ArrayList<String>menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.print(i + " ");
            System.out.println(menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName);
        customers.add(userName);
        int arrLength = customers.size() - 1;
        System.out.println(String.format("There are %d people in front of you.", arrLength));
    }

    public void printPriceChart(String product, double price, int maxQuantity){
        System.out.println(product);
        for (int i = 1; i <= maxQuantity; i++) {
            double newprice = price * i;
                if (i > 1) {
                    newprice = newprice - (0.5 * (i -1) );
                }
            System.out.println(i + " - " + "$" + newprice);
        }
    }

    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + " " + menuItems.get(i) + " -- " + prices.get(i));
        }
        return true;
    }
}