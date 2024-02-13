import java.io.*;
import java.util.*;
public class Solution4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long arr[][] = new long[n][2];

        StringTokenizer st;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<2;j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2)-> {
            if(o1[0] == o2[0]) {
                return (int) (o1[1] - o2[1]);
            }else {
                return (int) (o1[0]-o2[0]);
            }
        });

        for(long[] ar : arr) {
            pq.add(ar);
        }

        List<Long> list = new ArrayList<>();

        int ans = 0;
        while(!pq.isEmpty()) {
            long pop[] = pq.remove();
            boolean flag = false;
            if(list.isEmpty()) {
                list.add(pop[1]);
                ans++;
                continue;
            }
            for(int i=list.size()-1;i>=0;i--) {
                if(list.get(i) <= pop[0]) {
                    list.set(i,pop[1]);
                    flag = true;
                    break;
                }
            }
            if(flag) continue;
            list.add(pop[1]);
            ans++;
        }

        System.out.println(ans);
    }
}
