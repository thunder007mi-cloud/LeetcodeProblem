import java.util.ArrayList;
import java.util.List;

class Solution { // Changed from KeyboardRow to Solution

    private static final int[] ROW_MAP = new int[26];

    static {
        String[] rows = {
            "qwertyuiop",
            "asdfghjkl", 
            "zxcvbnm"    
        };
        
        for (int rowIndex = 0; rowIndex < rows.length; rowIndex++) {
            for (char c : rows[rowIndex].toCharArray()) {
                ROW_MAP[c - 'a'] = rowIndex;
            }
        }
    }

    public String[] findWords(String[] words) {
        List<String> validWords = new ArrayList<>();

        for (String word : words) {
            if (isValidSingleRowWord(word)) {
                validWords.add(word);
            }
        }

        return validWords.toArray(new String[0]);
    }

    private boolean isValidSingleRowWord(String word) {
        if (word == null || word.isEmpty()) {
            return true;
        }

        int targetRow = ROW_MAP[Character.toLowerCase(word.charAt(0)) - 'a'];

        for (int i = 1; i < word.length(); i++) {
            int currentRow = ROW_MAP[Character.toLowerCase(word.charAt(i)) - 'a'];
            if (currentRow != targetRow) {
                return false;
            }
        }

        return true;
    }
}
