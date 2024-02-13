import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    private static class Schedule implements Comparable<Schedule> {
        public int startTime;
        public int endTime;

        public Schedule(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Schedule o) {
            if (startTime == o.startTime) {
                return endTime - o.endTime;
            }
            return startTime - o.startTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Schedule> schedules = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] lines = br.readLine().split(" ");
            int startTime = Integer.parseInt(lines[0]);
            int endTime = Integer.parseInt(lines[1]);
            Schedule schedule = new Schedule(startTime, endTime);
            schedules.add(schedule);
        }

        Collections.sort(schedules);

        pq.add(schedules.get(0).endTime);
        for (int i = 1; i < schedules.size(); i++) {
            if (pq.peek() <= schedules.get(i).startTime) {
                pq.poll();
            }
            pq.add(schedules.get(i).endTime);
        }
        System.out.println(pq.size());
    }
}
