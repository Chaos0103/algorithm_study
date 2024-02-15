import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    private static class Course implements Comparable<Course> {
        public int no;
        public int start;
        public int end;

        public Course(int no, int start, int end) {
            this.no = no;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Course o) {
            if (start == o.start) {
                return end - o.end;
            }
            return start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Course> courses = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            Course course = new Course(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
            courses.add(course);
        }
        Collections.sort(courses);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(courses.get(0).end);
        for (int i = 1; i < courses.size(); i++) {
            if (pq.peek() <= courses.get(i).start) {
                pq.poll();
            }
            pq.add(courses.get(i).end);
        }

        System.out.println(pq.size());
    }
}
