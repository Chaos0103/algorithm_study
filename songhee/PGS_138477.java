import java.io.*;
import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for(int i=0;i<tangerine.length;i++){
            m.put(tangerine[i], m.getOrDefault(tangerine[i], 0)+1);
        }

        List<Integer> keySet = new ArrayList<>(m.keySet());
        keySet.sort((o1, o2)->m.get(o2)-m.get(o1));

        while(k>0){
            int tanger = keySet.get(0);
            answer++;
            if(m.get(tanger) < k){
                k -= m.get(tanger);
                m.remove(tanger);
                keySet.remove(0);
            }else{
                return answer;
            }
        }

        return answer;
    }
}