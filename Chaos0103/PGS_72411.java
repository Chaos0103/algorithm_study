import java.util.HashMap;
import java.util.Map;

class Solution {

    private static Map<String, Integer> countMap = new HashMap<>();

    private void dfs(char[] arr, boolean[] course, boolean[] visited, int start, String source) {
        if (arr.length == source.length()) {
            if (course[source.length()]) {
                int count = countMap.getOrDefault(source, 0);
                countMap.put(source, count + 1);
            }
            return;    
        }
        
        if (course[source.length()]) {
            int count = countMap.getOrDefault(source, 0);
            countMap.put(source, count + 1);
        }

        for (int i = start; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(arr, course, visited, i + 1, source + arr[i]);
                visited[i] = false;
            }
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        boolean[] courseArr = new boolean[11];
        for (int i : course) {
            courseArr[i] = true;
        }

        for (String order : orders) {
            dfs(order.toCharArray(), courseArr, new boolean[order.length()], 0, "");
        }

        for (String s : countMap.keySet()) {
            if (countMap.get(s) >= 2) {
                System.out.println(s);
            }
        }
        String[] answer = {};
        return answer;
    }
}
