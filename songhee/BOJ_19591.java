import java.util.*;
import java.io.*;
class BOJ_19591 {
    static ArrayList<Long> number;
    static ArrayList<Character> qngh;
    static long start, finish;
    static int starti, finishi;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        number = new ArrayList<Long>();
        qngh = new ArrayList<Character>();
        String s = br.readLine();
        long value = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-' || s.charAt(i) == '+' ||
                s.charAt(i) == '*' ||s.charAt(i) == '/') {
                number.add(value);
                qngh.add(s.charAt(i));
                value = 0;
            } else {
                if (value == 0 && s.charAt(i) != '0') {
                    value = (s.charAt(i) - '0');
                } else if (value != 0) {
                    value *= 10;
                    value += (s.charAt(i) - '0');
                }
            }
        }
        number.add(value);
        if (number.get(0) == 0&&!qngh.isEmpty()) {
            starti = 1;
            start = number.get(1) * -1;
        } else {
            start = number.get(0);
        }
        finishi = qngh.size() - 1;
        finish = number.get(number.size() - 1);
        long result = 0;
        if (qngh.size() == 0 || qngh.size() == 1 && number.get(0) == 0) {
            result = start;
        } else {
            while (starti != finishi) {
                char first = qngh.get(starti);
                char last = qngh.get(finishi);
                if ((first == '-' || first == '+') && (last == '*' || last == '/')) {
                    long next = number.get(finishi);
                    finish = cal( next, finish, qngh.get(finishi));
                    finishi--;
                } else if ((first == '*' || first == '/') && (last == '-' || last == '+')) {
                    long next = number.get(starti + 1);
                    start = cal(start,  next, qngh.get(starti));
                    starti++;
                } else {
                    long next1 = number.get(starti + 1);
                    long start2 = cal(start, next1,qngh.get(starti));
                    long next2 = number.get(finishi);
                    long finish2 = cal(next2,finish,qngh.get(finishi));
                    if (start2 >= finish2) {
                        start = start2;
                        starti++;
                    } else {
                        finish = finish2;
                        finishi--;
                    }
                }
            }
            result = cal(start, finish, qngh.get(starti));
        }
        System.out.println(result);
    }

    private static long cal(long next, long finish2, char character) {
        if (character == '-') {
            return next - finish2;
        } else if (character == '+') {
            return next + finish2;
        } else if (character == '*') {
            return next * finish2;
        } else {
            return next / finish2;
        }
    }
}