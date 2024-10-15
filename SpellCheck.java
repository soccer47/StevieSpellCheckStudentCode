import java.util.ArrayList;
import java.util.HashMap;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Stevie Halprin
 * */

public class SpellCheck {


    /**
     * checkWords finds all words in text that are not present in dictionary
     *
     * @param text The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all mispelled words in the order they appear in text. No duplicates.
     */
    public String[] checkWords(String[] text, String[] dictionary) {

        // HashMap of all fake words in text
        // Will add all fake words from text (no dupes) and then return this ArrayList at the end
        HashMap<String, Integer> nonWords = new HashMap<>();

        // HashMap to hold all the words in the dictionary
        HashMap<String, Boolean> dictToInt = new HashMap<>();

        // Iterate through every word in the dictionary
        for (String word : dictionary) {
            // Put every word in dictionary into dictToInt, with the word as the key
            // If the word is already added, the new (identical) instance will replace the old instance
            dictToInt.put(word, true);
        }

        // Int to be used to record order that keys are added to nonWords
        int index = 0;
        // Iterate through every word in the text
        for (String word : text) {
            // Check if the word is in the HashMap dictToWord...
            if (!dictToInt.containsKey(word)) {
                // Add the word to nonWords if it hasn't already been added
                if (!nonWords.containsKey(word)) {
                    // Also make the value at the key the order the word was added
                    nonWords.put(word, index);
                    // Increment index by 1
                    index++;
                }
            }
        }

        // Array of Strings to hold all fake words to be returned
        String[] nonWordsToReturn = new String[nonWords.size()];
        // Add every fake word to nonWordsToReturn in the order they were added
        for (String key : nonWords.keySet()) {
            nonWordsToReturn[nonWords.get(key)] = key;
        }
        // Return array of fake words
        return nonWordsToReturn;
    }

}


