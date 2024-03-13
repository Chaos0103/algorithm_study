import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final ArrayList<Long> numbers = new ArrayList<>();

    public static void solution(long num, int idx) {
        //10자리를 넘어가는 수는 감소하는 수로 만들 수 없음
        if (idx > 10) {
            return;
        }

        //숫자 추가
        numbers.add(num);

        //감소하는 수 재귀
        for (int i = 0; i < num % 10; i++) {
            solution((num * 10) + i, idx + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        //입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long result = 0;
        //10이하는 자기 자신 반환
        if (n <= 10) {
            result = n;
        } else if (n > 1022) { //1022번째 수는 9876543210이므로 그 이상의 수는 만들 수 없음
            result = -1;
        } else {
            //숫자 조합
            for (int i = 0; i < 10; i++) {
                solution(i, 1);
            }
            //오름차순 정렬
            Collections.sort(numbers);

            result = numbers.get(n);
        }

        //출력부
        System.out.println(result);
    }
}
