public class CafeUtil { 
    public int getStreakGoal(int numWeeks) {
        int x = 0;
        for (int i = 1; i <= numWeeks; i++) {
            x = x + i; 
        }
        return x;
    }

    public double getOrderTotal(double[] lineItems) {
        int x = 0;
        for (int i = 0; i < lineItems.length; i++) {
            x = x + i;
        }
        return x;
    }
}