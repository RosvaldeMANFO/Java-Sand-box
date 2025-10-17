import java.util.Arrays;

public class CodeChallengeSolution {

    /**
     * This function tell if a word is a palindrome;
     * it means that we still have the same word after
     * reversing characters.
     * @param str String
     * @return boolean
     */
    public boolean isPalindrome(String str) {
        StringBuilder revertedStr = new StringBuilder();
        for (char chr : str.toCharArray()) {
            revertedStr.insert(0, chr);
        }
        return revertedStr.toString().equals(str);
    }

    /**
     * This function tempts to determinate if
     * all string arguments are anagrams or not.
     * For that, it will return true if all arguments
     * match the anagram constraint and false if not.
     * @param args String
     * @return boolean
     */
    public boolean areAnagrams(String... args) {
        String[] sortedString = new String[args.length];

        for (int i =0; i<args.length; i++) {
            String str = args[i].replace("[^A-Za-z]+", "").toLowerCase();
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);

            StringBuilder builder = new StringBuilder();
            for(char ch: charArray){
                builder.append(ch);
            }
            sortedString[i] = builder.toString();
        }

        return Arrays.stream(sortedString).allMatch(sortedString[0]::equals);
    }

    /**
     * This fonction print a pyramid of a specific character with
     * a given size.
     * @param size int
     * @param character char
     */
    public void printPyramidOf(int size, char character) {
        int column = (2 * size) - 1;
        int middle = Math.floorDiv(column, 2);
        for(int i = 0; i < size; i++){
            StringBuilder str = new StringBuilder();
            for(int j= 0; j < column; j++){
                if(j >= middle-i && j <= (middle + i)){
                    str.append(character);
                } else {
                    str.append(" ");
                }
            }
            System.out.println(str);
        }
    }
}
