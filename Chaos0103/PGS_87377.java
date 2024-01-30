import java.util.ArrayList;

class Point {
    private final long x;
    private final long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }
}

class Solution {
    public String[] solution(int[][] line) {
        long maxPointX = Long.MIN_VALUE;
        long minPointX = Long.MAX_VALUE;
        long maxPointY = Long.MIN_VALUE;
        long minPointY = Long.MAX_VALUE;

        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point point = calculateCrossPoint(line[i], line[j]);
                if (point != null) {
                    points.add(point);
                    maxPointX = Math.max(maxPointX, point.getX());
                    minPointX = Math.min(minPointX, point.getX());

                    maxPointY = Math.max(maxPointY, point.getY());
                    minPointY = Math.min(minPointY, point.getY());
                }
            }
        }

        boolean[][] arr = new boolean[(int) (maxPointY - minPointY + 1)][(int) (maxPointX - minPointX + 1)];
        for (Point point : points) {
            arr[(int) (maxPointY - point.getY())][(int) (point.getX() - minPointX)] = true;
        }

        String[] answer = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (boolean d : arr[i]) {
                builder.append(d ? "*" : ".");
            }
            answer[i] = builder.toString();
        }

        return answer;
    }

    private Point calculateCrossPoint(int[] line1, int[] line2) {
        long under = (long) line1[0] * line2[1] - (long) line1[1] * line2[0];


        double x = (double) ((long) line1[1] * line2[2] - (long) line1[2] * line2[1]) / under;
        double y = (double) ((long) line1[2] * line2[0] - (long) line1[0] * line2[2]) / under;

        if (x % 1 != 0 || y % 1 != 0) {
            return null;
        }

        return new Point((long) x, (long) y);
    }
}
