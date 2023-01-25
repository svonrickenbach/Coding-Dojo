import java.util.ArrayList;

public class CoffeeKiosk {
    ArrayList<Item> menu; 
    ArrayList<Order> orders; 

    public CoffeeKiosk() { 
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();
    }

    public void addMenuItem(String Item, double Price) { 
        Item newItem = new Item(Item, Price);
        menu.add(newItem);
        newItem.setIndex(menu.indexOf(newItem));
    }

    public void displayMenu() {
        for(Item item : menu) { 
            System.out.println(item.getIndex() + " " + item.getName() + " -- $" + item.getPrice());
        }
    }

    public void newOrder() { 
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();

        Order newOrder = new Order(name);
        displayMenu(); 

        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();

        while(!itemNumber.equals("q")) {
            try {
                Item newItem = menu.get(Integer.parseInt(itemNumber));
                newOrder.addItem(newItem);
                
            }
            catch(IndexOutOfBoundsException e) {
                System.out.println("Please enter a menu item number.");
            }
            catch(NumberFormatException e) {
                System.out.println("Please enter a menu item number.");
            }
            System.out.println("Please select another item to add to your order or press 'q' to quit.");
            itemNumber = System.console().readLine();
        }
        newOrder.display();
    }

}

