import java.util.Arrays;

public class Parser {

    public static void main(String[] args) {
        String input = "The quick brown fox jumps over the lazy dog";
        //convert the input String to char array
        char[] inputChars = input.toCharArray();

        //initialize an array to store the reverted version of the char array
        char[] outputChars = new char[inputChars.length];

        //an array that will contain the indexes of the reverted char array for debugging purposes
        int[] charIndexes = new int[inputChars.length];

        /*
         * revert the input char array
         */
        for (int i = inputChars.length-1; i>=0; i--) {
            outputChars[inputChars.length-(i+1)] = inputChars[i];
        }

        //initialize integer values to indicate where a word starts and ends
        int wordStart = 0;
        int wordEnd = 0;

        /*
         * Iterate over the char array with reverted order
         */
        for (int i = 0; i <= outputChars.length; i++) {

            //if the previous character is a space assign the word start to the current value
            if (i == 0 || outputChars[i-1] == ' ') {
                wordStart = i;
            }

            int idx = i + 1;

            if (idx < outputChars.length) {

                if (outputChars[idx] == ' ' || idx == (outputChars.length - 1)) {
                    wordEnd = i;

                    /*
                     * edge case check for the end of the last word in the array
                     */
                    if (idx == (outputChars.length - 1)) {
                        wordEnd = idx;
                    }

                    if (wordStart < wordEnd) {
                        /*
                         * calculate the length of the word to get the indexes of the characters
                         * that need to be swapped afterwards
                         */
                        int scope = wordEnd - wordStart + 1;

                        /*
                         * initialize an integer value that
                         */
                        int step = 0;

                        /*
                         * calculate the values of the characters that need to be swapped with
                         * the z variable portraying the "distance" between their indexes
                         */
                        for (int z = scope - 1; z > 0; z -= 2) {
                            char temp = outputChars[step + wordStart];
                            outputChars[step + wordStart] = outputChars[(step + wordStart + z)];
                            outputChars[(step + wordStart + z)] = temp;

                            /*
                             * increment the step variable to move to the next character
                             */
                            step++;
                        }

                    }
                }
            }
        }

        /*
         * fill the indexes array with the char indexes and -1 where there are spaces
         */
        for (int i = 0; i < outputChars.length; i++) {
            if (outputChars[i] == ' ') {
                charIndexes[i] = -1;
            } else {
                charIndexes[i] = i;
            }
        }

        System.out.println("outputChars: " + Arrays.toString(outputChars));

        //for debugging
        System.out.println("charIndexes: " + Arrays.toString(charIndexes));

    }
}
