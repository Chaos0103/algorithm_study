import java.util.*;

class Solution {
    private int calculateWorkDay(int progress, int speed) {
        int result = (100 - progress) / speed;
        if ((100 - progress) % speed > 0) {
            result += 1;
        }
        return result;
    }
    
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> result = new ArrayList<>();
        
        Stack<Integer> s = new Stack<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int workDay = calculateWorkDay(progresses[i], speeds[i]);
            if (!s.isEmpty() && s.get(0) < workDay) {
                result.add(s.size());
                s.clear();
            }
            s.add(workDay);
        }
        
        result.add(s.size());
        
        return result.stream()
            .mapToInt(Integer::valueOf)
            .toArray();
    }
}
