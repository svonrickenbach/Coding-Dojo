import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
public class PuzzleJava {
    Random randMachine = new Random(); 

    public ArrayList<Integer> getTenRolls() { 
        ArrayList<Integer> random10 = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            random10.add(randMachine.nextInt(21));
        }
        return random10;
    }

    public char getRandomLetter() {
        char[] myArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        return myArray[randMachine.nextInt(25)];
        }

    public String generatePassword() {
        String password = "";
        for (int i = 0; i <= 7; i++) {
            password = password + String.format("%c", getRandomLetter());
        }
        return password;
    }

    public String[] getNewPasswordSet(int num) {
        String[] myArray;
        myArray = new String[num];
        for (int i = 0; i < num; i++) {
            String password = "";
            for (int y = 0; y <= 7; y++) {
                password = password + String.format("%c", getRandomLetter());
            }
            myArray[i] = password;
        }
        return myArray;
    }
}


