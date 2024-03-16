import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int MOD = 1000000;

    public static void main(String[] args) throws IOException {
        //입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pwd = br.readLine();

        //시작이 0인 경우 해석 불가
        if (pwd.startsWith("0")) {
            System.out.println(0);
            return;
        }

        //DP 테이블 초기화
        int[] dp = new int[pwd.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= pwd.length(); i++) {
            //두자리씩 비교
            int now = Integer.parseInt(pwd.substring(i - 2, i));
            if (now == 10 || now == 20) { //10: J, 20: T만 가능한 경우
                dp[i] = dp[i - 2];
            } else if (now % 10 == 0) { //일의 자리 수가 0인 경우 -> 알파벳 매칭 불가
                dp[pwd.length()] = 0;
                break;
            } else {
                //두자리수가 알파벳으로 만들 수 있는 경우
                //dp[i - 1] + dp[i - 2]
                dp[i] = 10 < now && now < 27 ? (dp[i - 1] + dp[i - 2]) % MOD : dp[i - 1];
            }
        }

        //출력부
        System.out.println(dp[pwd.length()]);
    }
}
