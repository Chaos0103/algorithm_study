import java.io.*;
import java.util.*;
class BOJ_2668 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer number;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N+1];

        for(int i=1;i<N+1;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        boolean v[] = new boolean[N+1];
        int answer[] = new int[N+1];
        int count = 0;
        for(int i=1;i<N+1; i++) {
            if(!v[i]) {
                List<Integer> list1 = new ArrayList<>();
                List<Integer> list2 = new ArrayList<>();
                boolean idx[] = new boolean[N+1];
                int output = 0;
                int searchIdx = i;
                while(true) {
                    output = arr[searchIdx];
                    list1.add(searchIdx);
                    list2.add(output);
                    idx[searchIdx] = true;

                    searchIdx = output;
                    if(idx[searchIdx]) {
                        break;
                    }
                }
                Collections.sort(list1);
                Collections.sort(list2);

                if(list1.equals(list2)) {
                    for(int j=0;j<list1.size();j++) {
                        if(answer[list1.get(j)] == 0) {
                            count++;
                            answer[list1.get(j)]++;
                            v[list1.get(j)] = true;
                        }
                    }
                }
            }
        }
        sb.append(count+"\n");
        for(int i=1;i<N+1;i++) {
            if(answer[i] == 1) {
                sb.append(i+"\n");
            }
        }
        System.out.println(sb);

    }
}