import java.io.*;
import java.util.*;
class Main {
    static List<List<Integer>> arr;
    static int N, M, H, count;
    static boolean v[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        v = new boolean[N];

        for(int i=0;i<N;i++) {
            arr.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreElements()) {
                arr.get(i).add(Integer.parseInt(st.nextToken()));
            }
            arr.get(i).add(0);
        }

        allFind(0, 0);
        System.out.println(count%10007);
    }
    private static void allFind(int sum, int idx) {
        if(sum>H) return;
        if(sum == H) {
            count++;
            return;
        }
        if(idx == N) {
            if(sum == H) {
                count++;
            }
            return;
        }

        for(int i=idx;i<N;i++) {
            if(!v[i]) {
                v[i] = true;
                List<Integer> list = arr.get(i);
                for(int j=0;j<list.size();j++) {
                    allFind(sum + list.get(j), idx+1);
                }
                v[i] = false;
            }
        }
    }

}