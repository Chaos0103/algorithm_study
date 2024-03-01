import java.io.*;
import java.util.*;
class BOJ_1707 {
    static List<List<Integer>> list;
    static int v[];
    static boolean visit[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        while(K-->0) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            for(int i=0;i<V+1;i++) {
                list.add(new ArrayList<>());
            }

            int indexHasTwoItem = 1;

            for(int i=0;i<E;i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list.get(a).add(b);
                list.get(b).add(a);
            }
            v = new int[V+1];
            visit = new boolean[V+1];

            for(int i=1;i<V+1;i++) {
                if(list.get(i).size() == 2) {
                    indexHasTwoItem = i;
                    break;
                }
            }

            dfs(indexHasTwoItem);

            boolean flag = true;
            for(int i=1;i<V+1;i++) {
                if(v[i] != 2 && v[i] != 0) {
                    sb.append("NO\n");
                    flag = false;
                    break;
                }
            }

            if(flag) {
                sb.append("YES\n");
            }
        }

        System.out.println(sb);
    }

    private static void dfs(int idx) {
        visit[idx] = true;
        List<Integer> slist = list.get(idx);
        for(int i=0;i<slist.size();i++) {
            int a = slist.get(i);
            if(!visit[a]) {
                v[idx]++;
                dfs(a);
            }
        }

    }
}