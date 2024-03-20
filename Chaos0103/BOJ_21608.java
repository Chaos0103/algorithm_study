import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final Map<Integer, Set<Integer>> map = new HashMap<>();

    private static class Point implements Comparable<Point> {
        public int y;
        public int x;
        public int count;
        public int blank;

        public Point(int y, int x) {
            this.y = y; //3 asc
            this.x = x; //4 asc
            this.count = 0; //1 desc
            this.blank = 0; //2 desc
        }

        public void addCount() {
            count++;
        }

        public void addBlack() {
            blank++;
        }

        @Override
        public int compareTo(Point o) {
            if (count == o.count) {
                if (blank == o.blank) {
                    if (y == o.y) {
                        return x - o.x;
                    }
                    return y - o.y;
                }
                return o.blank - blank;
            }
            return o.count - count;
        }
    }

    private static void checkPoint(int[][] room, int student, Point point) {
        for (int i = 0; i < 4; i++) {
            int ny = point.y + DIRECTIONS[i][0];
            int nx = point.x + DIRECTIONS[i][1];

            if (!(0 <= ny && ny < room.length && 0 <= nx && nx < room.length)) {
                continue;
            }

            if (room[ny][nx] == 0) {
                point.addBlack();
            }

            if (map.get(student).contains(room[ny][nx])) {
                point.addCount();
            }
        }
    }

    //학생 배치하는 메서드
    private static void setStudent(int[][] room, int student) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                if (room[i][j] > 0) {
                    continue;
                }

                Point point = new Point(i, j);
                checkPoint(room, student, point);
                points.add(point);
            }
        }

        Collections.sort(points);
        Point point = points.get(0);
        room[point.y][point.x] = student;
    }

    //만족도 계산하는 메서드
    private static int calculate(int[][] room) {
        int total = 0;
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                int student = room[i][j];
                Point point = new Point(i, j);
                checkPoint(room, student, point);
                int count = point.count;
                if (count == 1) {
                    total += 1;
                } else if (count == 2) {
                    total += 10;
                } else if (count == 3) {
                    total += 100;
                } else if (count == 4) {
                    total += 1000;
                }
            }
        }
        return total;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n * n; i++) {
            map.put(i, new HashSet<>());
        }

        int[][] room = new int[n][n];
        for (int i = 0; i < n * n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) {
                Set<Integer> set = map.get(student);
                set.add(Integer.parseInt(st.nextToken()));
            }

            setStudent(room, student);
        }
        
        int result = calculate(room);

        System.out.println(result);
    }

    //1. n입력
    //2. n^2만큼 반복하면서 한 라인 입력 받을 때 마다 학생 배치
}
