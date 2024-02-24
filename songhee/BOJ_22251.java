import java.io.*;
import java.util.*;

public class BOJ_22251 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int totalNumbers = Integer.parseInt(st.nextToken());
        int digitCount = Integer.parseInt(st.nextToken());
        int maxDifferences = Integer.parseInt(st.nextToken());
        int targetNumber = Integer.parseInt(st.nextToken());

        int[][] displaySegments = {{1, 1, 1, 0, 1, 1, 1}, 
            {0, 0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 0, 1, 1},
            {1, 0, 1, 1, 0, 0, 1},
            {1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 1, 1},
            {0, 1, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1}};
        long reverseCount = 0;

        int[] targetDigits = new int[10];
        for (int i = 0; i < 10; i++) {
            targetDigits[i] = targetNumber % 10;
            targetNumber /= 10;
        }

        for (int i = 1; i <= totalNumbers; i++) {
            if (i == targetNumber) continue;
            int[] numberDigits = new int[10];
            for (int j = 0; j < 10; j++) {
                numberDigits[j] = i % 10;
                i /= 10;
            }
            if (canReverse(numberDigits, targetDigits, displaySegments, digitCount, maxDifferences)) reverseCount++;
        }
        System.out.println(reverseCount);
    }

    public static boolean canReverse(int[] numberDigits, int[] targetDigits, int[][] displaySegments, int digitCount, int maxDifferences) {
        int differencesCount = 0;
        for (int i = 0; i < digitCount; i++) {
            for (int j = 0; j < 7; j++) {
                if (displaySegments[targetDigits[i]][j] != displaySegments[numberDigits[i]][j]) {
                    differencesCount++;
                    if (differencesCount > maxDifferences) return false;
                }
            }
        }
        return true;
    }
}
