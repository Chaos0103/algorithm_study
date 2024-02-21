import java.io.*;
import java.util.*;
class BOJ_2759 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());

            int arr[] = new int[N];
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            while(true) {
                boolean flag = true;
                if(N > 1) {
                    if(arr[0] > arr[1]) {
                        flag = false;
                    }
                }else {
                    break;
                }

                for(int i=1;i<arr.length;i++) {
                    if(flag == true && arr[i-1] > arr[i]) {
                        for(int j=0;j<=i/2-1;j++) {
                            int x = arr[j];
                            int y = arr[(i-1)-j];
                            arr[j] = y;
                            arr[(i-1)-j] = x;
                        }
                        count++;
                        list.add(i);
                        flag = false;
                    }else if(flag == false && arr[i-1] < arr[i]) {
                        for(int j=0;j<=i/2-1;j++) {
                            int x = arr[j];
                            int y = arr[(i-1)-j];
                            arr[j] = y;
                            arr[(i-1)-j] = x;
                        }
                        count++;
                        list.add(i);
                        flag = true;
                    }
                }

                if(arr[0] > arr[N-1]) {
                    for(int j=0;j<=N/2-1;j++) {
                        int x = arr[j];
                        int y = arr[(N-1)-j];
                        arr[j] = y;
                        arr[(N-1)-j] = x;
                    }
                    list.add(N);
                    count++;
                }else {
                    break;
                }
            }
            sb.append(count+" ");
            for(int i=0;i<list.size();i++) {
                sb.append(list.get(i)+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}