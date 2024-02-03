import java.util.ArrayList;
import java.util.List;

class Solution {

    private static final char[] arr = "AEIOU".toCharArray();

    private List<String> generator(String word) {
        List<String> words = new ArrayList<>();
        words.add(word);

        if (word.length() == 5) {
            return words; 
        }

        for (char c : arr) {
            words.addAll(generator(word + c));
        }
        
        return words;
    }
    
    public int solution(String word) {
        return generator("").indexOf(word);
    }
}
