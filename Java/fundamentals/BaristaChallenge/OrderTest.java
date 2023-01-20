import java.util.ArrayList;

public class OrderTest {
    public static void main(String[] args) {
        // Test #1 
        Order order1 = new Order(); 
        Order order2 = new Order(); 

        // System.out.println(order1.getName());
        // System.out.println(order2.getName());

        // Test #2 
        Order order3 = new Order("Cindhuri"); 
        Order order4 = new Order("Sam");
        Order order5 = new Order("Ben");

        // System.out.println(order3.getName());
        // System.out.println(order4.getName());
        // System.out.println(order5.getName());

        // Test 3
        Item item1 = new Item("Drip Coffee", 1.50);
        Item item2 = new Item("Latte", 4.00);

        order3.addItem(item1);
        order3.addItem(item2);

        order3.display();





    }
}