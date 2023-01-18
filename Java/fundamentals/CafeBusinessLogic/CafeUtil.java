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

// Generates total price for a given order given as a double[]
    public double getOrderTotal(double[] lineItems) {
        double x = 0;
        for (int i = 0; i < lineItems.length; i++) {
        x = x + lineItems[i];
        }
        return x;
    }

// Generates a menu using a loop to extract items from ArrayList. The iterater becomes the menu item # and the items in the ArrayList become the menu item names. 
    public void displayMenu(ArrayList<String>menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.print(i + " ");
            System.out.println(menuItems.get(i));
        }
    }

// Allows the user to add customer their and to an ArrayList, and lets the user know how many other orders are in front of theirs. 
    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName);
        customers.add(userName);
        int arrLength = customers.size() - 1;
        System.out.println(String.format("There are %d people in front of you.", arrLength));
    }

// Prints a price chart for an input price that doubles and subtracts 50 cents for each time the input quantity doubles. 
    public void printPriceChart(String product, double price, int maxQuantity){
        System.out.println(product);
        for (int i = 1; i <= maxQuantity; i++) {
            double newprice = price * i;
                if (i > 1) {
                    newprice = newprice - (0.5 * (i -1) );
                }
            System.out.println(i + " - " + "$" + newprice);
        }
        System.out.println("");
    }

// Displays a menu with menu items names and prices. Overloads the previous displayMenu().
    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        if (menuItems.size() != prices.size()) {
            System.out.print("False!");
            return false;
        }
        else{
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println(i + " " + menuItems.get(i) + " -- " + prices.get(i));
            }
        }
        System.out.println("");
        return true;
    }
}