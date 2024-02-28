import java.io.*;
import java.util.*;
class BOJ_14267 {
    static long stren[];
    static int n;
    static Map<Integer, List<Integer>> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        stren = new long[n+1];
        st = new StringTokenizer(br.readLine());
        boolean flag = true;
        for(int i=1;i<n+1;i++) {
            int a = Integer.parseInt(st.nextToken());
            if(map.containsKey(a)) {
                List <Integer>list = map.get(a);
                list.add(i);
                map.put(a, list);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(a, list);
            }

            if(i>1 && i-a != 1) {
                flag = false;
            }
        }

        int v[][] = new int[n+1][2];
        int originalWho = 0;
        int originalStrength = 0;
        boolean check = true;
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            v[i][0] = Integer.parseInt(st.nextToken());
            v[i][1] = Integer.parseInt(st.nextToken());

            if(originalWho == 0) {
                originalWho = v[i][0];
                originalStrength = v[i][1];
            }else if(originalWho != v[i][0] && originalStrength != v[i][1]) {
                check = false;
            }
        }

        if(check == true && flag == true) {
            for(int i=originalWho;i<n+1;i++) {
                stren[i] += m*originalStrength;
            }
        }else {
            for(int i=0;i<m;i++) {
                dfs(v[i][0], v[i][1]);
            }
        }

        for(int i=1;i<n+1;i++) {
            sb.append(stren[i]+" ");
        }
        System.out.println(sb);
    }
    private static void dfs(int who, int strength) {
        stren[who] += strength;

        if(map.containsKey(who)) {
            List<Integer> list = map.get(who);
            for(int i=0;i<list.size();i++) {
                dfs(list.get(i), strength);
            }
        }
    }
}