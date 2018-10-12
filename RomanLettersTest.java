import static org.junit.Assert.*;

//import org.junit.Before;
//import org.junit.After;
import org.junit.Test;

import java.util.Random;

public class RomanLettersTest {

    @Test
    public void computeInput() {
        Random r = new Random();
        //generate a random number within the range of 1 and 1000000
        int random = r.nextInt((1000000 - 1) + 1) + 1;
        System.out.println(random);
        String roman = RomanLetters.generateRomanNumber(random);
        assertEquals(random, RomanLetters.computeInput(roman));
    }

    @Test
    public void generateRomanNumber() {
        Random r = new Random();
        //generate a random number within the range of 1 and 100000
        int random = r.nextInt((1000000 - 1) + 1) + 1;
        System.out.println(random);
        String roman = RomanLetters.generateRomanNumber(random);
        assertEquals(roman, RomanLetters.generateRomanNumber(random));
    }
}
