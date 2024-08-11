package jpmc;

/**
 * Given a long statement and a input letter,
 * find the word which contains the most number of the given character.
 * If more than one word has the exact same number of the given letter,
 * it should return the word with the most number of total letters,
 * if more than one words have equal number of given character
 * and total number of characters return the word that appeared first in the given statement.
 */
public class Problem1 {


 public static String apply(String inputText, char inputChar){
     System.out.println("Input character : " + inputChar);
     if(inputText == null || inputText.length() == 0 || inputChar == ' ')
         return "";

     //Variables holding position of last known best selected word
     int selectedCharCount = 0;
     int selectedTotalCharCount = 0;
     String selectedWord = "";

     //Check for each word and keep updating the selected pointers (if there is an update)
     for(String word : inputText.split(" ")) {
         int charCount = count(word, inputChar);
         int totalCharCount = word.length();

         //no match
         if (charCount == 0) {
             continue;
         }

         //If count of matched char is more than current selection then update
         //If count of matched char is equal but total count is more then update
         if ((charCount > selectedCharCount)
                 || ((charCount == selectedCharCount) && (totalCharCount > selectedTotalCharCount))) {
             //System.out.println("Found word [" + word + "] which has more matching char or more total length");
             selectedCharCount = charCount;
             selectedTotalCharCount = totalCharCount;
             selectedWord = word;
         }
     }
     System.out.println("Word : " + selectedWord);
     return selectedWord;
 }

    private static int count(String word, char c) {
        int count = 0;
        for (char ch : word.toCharArray()) {
            if (ch == c)
                count++;
        }
        return count;
    }
}