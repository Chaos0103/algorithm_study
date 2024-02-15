import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : completion) {
            int count = map.getOrDefault(s, 0);
            map.put(s, count + 1);
        }

        for (String s : participant) {
            int count = map.getOrDefault(s, 0);
            if (count == 0) {
                return s;
            }
            map.put(s, count - 1);
        }

        return null;
    }
}
