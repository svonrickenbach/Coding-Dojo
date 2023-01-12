public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffee = 1.5;
        double latte = 5.0;
        double cappucino = 3.0;

    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = false; 
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = true; 
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        // Cindhuri's message
        System.out.println(customer1 + pendingMessage);
        // Noah's message 
        if (isReadyOrder4) {
            System.out.println(customer4 + readyMessage + ". "+ displayTotalMessage + cappucino);
        }
        else {
            System.out.println(customer4 + pendingMessage);
        }
        // Sam's message 
        System.out.println(displayTotalMessage + latte * 2); 
        if (isReadyOrder2) {
            System.out.println(customer2 + readyMessage);
        }
        else {
            System.out.println(customer2 + pendingMessage);
        }
        // Jimmy's message 
        System.out.println(displayTotalMessage + (latte - dripCoffee));
    }
}