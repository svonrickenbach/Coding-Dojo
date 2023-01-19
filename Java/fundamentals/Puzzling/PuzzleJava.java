import java.util.Random;
import java.util.ArrayList;

public class PuzzleJava {
    Random randMachine = new Random(); 

    public ArrayList<Integer> getTenRolls() { 
        ArrayList<Integer> random10 = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            random10.add(randMachine.nextInt(21));
        }
        return random10;
    }

    public char 
}