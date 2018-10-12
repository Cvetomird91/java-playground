import java.util.*;

public class RomanLetters {

    private final static HashMap<Character, Integer> literals = new HashMap<>();
    private final static TreeMap<Integer, String> outputmap = new TreeMap<Integer, String>();

    static {
        literals.put('I', 1);
        literals.put('V', 5);
        literals.put('X', 10);
        literals.put('L', 50);
        literals.put('C', 100);
        literals.put('D', 500);
        literals.put('M', 1000);

        outputmap.put(1000, "M");
        outputmap.put(900, "CM");
        outputmap.put(500, "D");
        outputmap.put(400, "CD");
        outputmap.put(100, "C");
        outputmap.put(90, "XC");
        outputmap.put(50, "L");
        outputmap.put(40, "XL");
        outputmap.put(10, "X");
        outputmap.put(9, "IX");
        outputmap.put(5, "V");
        outputmap.put(4, "IV");
        outputmap.put(1, "I");
    }

    public static boolean isValid(String romanNumber) {
        char[] charArray = romanNumber.toCharArray();
        for (char c: charArray) {
            if (!literals.keySet().contains(c))
                throw new IllegalArgumentException();
        }

        return true;
    }

    public static int computeInput(String romanNumber) {
        char[] charArray = romanNumber.toCharArray();
        int sum = 0;

        for (int i = 0; i < charArray.length; i++) {

            int current = literals.get(charArray[i]);
            int nextIdx = (i + 1 <= charArray.length-1) ? i + 1 : charArray.length-1;
            int next = literals.get(charArray[nextIdx]);
            int followingIdx = (i + 2 <= charArray.length-1) ? i + 2 : charArray.length-1;
            int following = literals.get(charArray[followingIdx]);

            //first char corner case
            if (i == 0 && current < next) {
                int temp = next - current;
                sum += temp;
                i += 2;
                continue;
            }

            sum += current;

            if (next < following) {
                int temp = following - next;
                sum += temp;
                i += 2;
            }
        }

        return sum;
    }

    public static String generateRomanNumber(int number) {
        int l = outputmap.floorKey(number);
        if (number == l) {
            return outputmap.get(number);
        }

        return outputmap.get(l) + generateRomanNumber(number - l);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int expressions = scanner.nextInt();
        String[] numbers = new String[expressions];
        scanner.nextLine();

        for (int i = 0; i < expressions; i++) {
            if (scanner.hasNextLine()) {
                String romanNumber = scanner.nextLine();

                //check if roman number is valid
                if (isValid(romanNumber)) {
                    //compute the input
                    numbers[i] = romanNumber;
                }
            }
        }

        for (String number : numbers) {
            System.out.println(generateRomanNumber(computeInput(number)));
        }
    }
}