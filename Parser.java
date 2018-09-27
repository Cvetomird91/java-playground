import java.util.Arrays;

public class Parser {

    public static void main(String[] args) {
        String input = "The quick brown fox jumps over the lazy dog";
        char[] inputChars = input.toCharArray();
        char[] outputChars = new char[inputChars.length];
        int[] charIndexes = new int[inputChars.length];


        for (int i = inputChars.length-1; i>=0; i--) {
            outputChars[inputChars.length-(i+1)] = inputChars[i];
        }

        int wordStart = 0;
        int wordEnd = 0;

        for (int i = 0; i <= outputChars.length; i++) {

            if (i == 0 || outputChars[i-1] == ' ') {
                wordStart = i;
            }

            if ((i+1) < outputChars.length) {
                int idx = i + 1;

                if (idx <= outputChars.length - 1) {

                    if (outputChars[idx] == ' ' || idx == (outputChars.length - 1)) {
                        wordEnd = i;
                        if (idx == (outputChars.length - 1)) {
                            wordEnd = outputChars.length - 1;
                        }

                        if (wordStart < wordEnd) {
                            int scope = wordEnd - wordStart + 1;
                            int step = 0;

                            for (int z = scope - 1; z > 0; z -= 2) {
                                char temp = outputChars[step + wordStart];
                                outputChars[step + wordStart] = outputChars[(step + wordStart + z)];
                                outputChars[(step + wordStart + z)] = temp;

                                step++;
                            }

                        }
                    }
                }
            }
        }

        //debug
        for (int i = 0; i < outputChars.length; i++) {
            if (outputChars[i] == ' ') {
                charIndexes[i] = -1;
            } else {
                charIndexes[i] = i;
            }
        }

        System.out.println("outputChars: " + Arrays.toString(outputChars));
        System.out.println("charIndexes: " + Arrays.toString(charIndexes));

    }
}
