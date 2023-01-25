import java.util.ArrayList;

public class OrderTest {
    public static void main(String[] args) {
        // Test #1 
        // Order order1 = new Order(); 
        // Order order2 = new Order(); 

        // System.out.println(order1.getName());
        // System.out.println(order2.getName());

        // Test #2 
        // Order order3 = new Order("Cindhuri"); 
        // Order order4 = new Order("Sam");
        // Order order5 = new Order("Ben");

        // System.out.println(order3.getName());
        // System.out.println(order4.getName());
        // System.out.println(order5.getName());

        // Test 3
        // Item item1 = new Item("Drip Coffee", 1.50);
        // Item item2 = new Item("Latte", 4.00);
        // Item item3 = new Item("Mocha", 4.50);

        // order3.addItem(item1);
        // order3.addItem(item2);
        // order3.addItem(item3);

        // order4.addItem(item2);
        // order4.addItem(item3);

        // order5.addItem(item1);
        // order5.addItem(item2);

        // order1.addItem(item1);
        // order1.addItem(item2);

        // order2.addItem(item2);
        // order2.addItem(item3);

        // order3.display();
        // order4.display();
        // order5.display();
        // order1.display();
        // order2.display();

        // Test 4
        // order3.setIsReady(true);
        // System.out.println(order3.getStatusMessage());

        // Test 5
        // System.out.println(order3.getOrderTotal());

        // Coffeedore64 Testing 
        CoffeeKiosk coffeedore64 = new CoffeeKiosk();

        coffeedore64.addMenuItem("Drip Coffee", 1.50);
        coffeedore64.addMenuItem("Latte", 3.50);
        coffeedore64.addMenuItem("Mocha", 4.50);
        coffeedore64.addMenuItem("Scone", 4.00);

        // coffeedore64.displayMenu();
        coffeedore64.newOrder();
    }
}