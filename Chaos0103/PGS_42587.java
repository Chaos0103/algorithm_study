import java.util.*;

class Solution {
    private static class Process {
        public int index;
        public int priority;
        
        public Process(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        Queue<Process> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        for (int i = 0; i < priorities.length; i++) {
            q.add(new Process(i, priorities[i]));
            pq.add(priorities[i]);
        }
        
        int result = 1;
        while (!pq.isEmpty()) {
            int priority = pq.poll();
            while(!q.isEmpty()) {
                Process process = q.poll();
                if (priority == process.priority && location == process.index) {
                    return result;
                } else if (priority == process.priority) {
                    break;
                }
                q.add(process);
            }
            result++;
        }
        
        return 0;
    }
}
