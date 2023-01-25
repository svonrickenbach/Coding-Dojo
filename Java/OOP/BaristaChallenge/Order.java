import java.util.ArrayList;

public class Order { 
    private String name;
    private boolean ready;
    private ArrayList<Item> items;

    public Order() { 
        this.name = "Guest";
        this.items = new ArrayList<Item>(); 
    }

    public Order(String name) { 
        this.name = name;
        this.items = new ArrayList<Item>(); 
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setIsReady(boolean ready) { 
        this.ready = ready;
    }
    public void setItems(Item items) {
        this.items.add(items);  
    }

    public String getName() {
        return name;
    }
    public boolean getIsReady() { 
        return ready; 
    }
    public ArrayList<Item> getItems() {
        return items; 
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public String getStatusMessage() {
        if (ready) {
            return "Your order is ready.";
        }
        else {
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }

    public double getOrderTotal() {
        double total = 0;
        for (int i = 0; i < getItems().size(); i++ ) {
            total = total + getItems().get(i).getPrice();
        }
        return total;
    }

    public void display() { 
        String customerName = getName();
        System.out.println(String.format("Customer Name: %s", customerName));
        for (int i = 0; i < getItems().size(); i++) {
            String itemName = getItems().get(i).getName();
            double itemPrice = getItems().get(i).getPrice(); 
            System.out.println(String.format("%s - $%.2f", itemName, itemPrice));
        }
        System.out.println(String.format("Total: $%.2f" ,getOrderTotal())+ "\n");
    }   
}