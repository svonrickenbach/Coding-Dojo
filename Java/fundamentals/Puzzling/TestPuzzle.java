import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class TestPuzzle {
    
	public static void main(String[] args) {
		PuzzleJava generator = new PuzzleJava();

		System.out.println("-------Test Print Random #-------\n");
		ArrayList<Integer> randomRolls = generator.getTenRolls();
		System.out.println(randomRolls);

		System.out.println("\n-------Test Print Random Letter-------\n");
		char letter = generator.getRandomLetter();
		System.out.println(letter + "\n");

		System.out.println("\n-------Test Print Password-------\n");
		String password = generator.generatePassword();
		System.out.println(password + "\n");
		
		System.out.println("\n-------Test Print Password Array-------\n");
		String[] passwordArray = generator.getNewPasswordSet(4);
		System.out.println(Arrays.toString(passwordArray) + "\n");
    	//..
		// Write your other test cases here.
		//..
	}
}
