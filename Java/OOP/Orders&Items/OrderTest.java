import java.util.ArrayList;

public class OrderTest {
    public static void main(String[] args) {
        Item item1 = new Item(); 
        item1.name = "mocha";
        item1.price = 4.0;

        Item item2 = new Item(); 
        item2.name = "latte";
        item2.price = 3.50;

        Item item3 = new Item();
        item3.name = "drip coffee" ;
        item3.price = 2.50;

        Item item4 = new Item();
        item4.name = "capuccino";
        item4.price = 3.50;

        Order order1 = new Order();
        order1.name = "Cindhuri";
        order1.ready = true; 

        Order order2 = new Order();
        order2.name = "Jimmy";
        order2.item.add(item1);
        order2.total = item1.price;
        order2.ready = true;

        Order order3 = new Order();
        order3.name = "Noah";
        order3.item.add(item4);
        order3.total = item4.price;

        Order order4 = new Order();
        order4.name = "Sam";
        order4.item.add(item2);
        order4.item.add(item2);
        order4.item.add(item2);
        order4.total = order4.item.get(0).price + item2.price + item2.price;

        System.out.println(order2.name + " Order List: " + order2.item.get(0).name + ", $" + order2.item.get(0).price);
        System.out.println(order2.name + " Order Status: " + order2.ready);
        System.out.println(order3.name + " Order List: " + order3.item.get(0).name + ", $" + order3.item.get(0).price);
        System.out.printf("Total: %s\n", order3.total);
        System.out.println(order4.name + " Order List: " + order4.item);
        System.out.println(order4.name + " Order List: " + order4.item.get(0).name + ", $" + order4.item.get(0).price + ", " + order4.item.get(1).name + ", $" + order4.item.get(1).price + ", " + order4.item.get(2).name + ", $" + order4.item.get(2).price);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order1.ready);
        // System.out.printf("Name: %s\n", order2.name);
        // System.out.printf("Total: %s\n", order2.total);
        // System.out.printf("Ready: %s\n", order1.ready);
    }
}