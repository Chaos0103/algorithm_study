import java.util.HashSet;
import java.util.Set;

class Solution {
    public String solution(String my_string) {
        Set<Character> set = new HashSet<>();
        
        StringBuilder builder = new StringBuilder();
        for (char c : my_string.toCharArray()) {
            if (set.contains(c)) {
                continue;
            }
            set.add(c);
            builder.append(c);
        }
        
        return builder.toString();
    }
}
