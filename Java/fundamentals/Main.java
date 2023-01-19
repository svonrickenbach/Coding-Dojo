public class Main {
    public static void main(String[] args){
        int[] numbers = {5, 10, 50, 0, 2};
        for (int i = 0; i < 5; i++ ) {
            try {
                int answer = 100 / numbers[i];
                System.out.println(answer);
            }
            catch (Exception e) {
                System.out.println("Cannot divide by zero.");
            }
        }
        // Use a for loop to divide 100 by each number and print the quotient
        // Use a try/catch block to prevent a crash due to a zero division error (ArithmeticException)
        // Handle the exception by printing 'Cannot divide by zero.'

    }
}