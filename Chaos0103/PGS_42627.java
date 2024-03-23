import java.util.*;
import java.util.Collections;

class Solution {
    public static class Schedule {
        public int start;
        public int run;
        
        public Schedule(int start, int run) {
            this.start = start;
            this.run = run;
        }
    }
    
    public int solution(int[][] jobs) {
        List<Schedule> schedules = new ArrayList<>();
        for (int[] job : jobs) {
            schedules.add(new Schedule(job[0], job[1]));
        }
        Collections.sort(schedules, (s1, s2) -> s1.start - s2.start);
        
        Queue<Schedule> q = new LinkedList<>(schedules);
        PriorityQueue<Schedule> pq = new PriorityQueue<>((s1, s2) -> s1.run - s2.run);
        
        int totalTime = 0;
        int endTime = 0;
        while (!q.isEmpty() || !pq.isEmpty()) {
            while (!q.isEmpty() && q.peek().start <= endTime) {
                pq.add(q.poll());
            }
            
            if (pq.isEmpty()) {
                endTime = q.peek().start;
                continue;
            }
            
            Schedule schedule = pq.poll();
            totalTime += endTime - schedule.start + schedule.run;
            endTime += schedule.run;
        }
        
        return totalTime / jobs.length;
    }
}
