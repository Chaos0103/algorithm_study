
import java.util.*;
import java.lang.*;
import java.io.*;
// The main method must be in a class named "Main".
class Main {
    static int arr[][], nowR, nowC, r, c, k;
    static int choosingNumber, count;
    public static void main(String[] args) throws Exception {
        arr = new int[101][101];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i=1;i<=3;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=3;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        nowR = 3;
        nowC = 3;

        while(true){
            if(arr[r][c] == k){
                System.out.println(count);
                return;
            }

            if(count >= 100){
                System.out.println(-1);
                return;
            }
            //R 또는 C 연산 선택
            choosingNumber = chooseNum();
            //R이라면 각 행마다 숫자가 몇번 등장했는지 조사
            if(choosingNumber == 1){
                changeArrByR();
            }else if(choosingNumber == 2){
                changeArrByC();
            }

            count++;
        }
    }
    public static int chooseNum(){
        if(nowR>=nowC){
            return 1;
        }else{
             return 2;
        }
    }
    public static void changeArrByR(){
        int c = nowC;
        for(int i=1;i<=nowR;i++){
            Map<Integer, Integer> m = new HashMap<>();
            for(int j=1;j<=c;j++){
                m.put(arr[i][j], m.getOrDefault(arr[i][j], 0)+1);
                arr[i][j] = 0;
            }

            nowC = Math.max(nowC, m.size()*2);
            List<Integer> keys = new ArrayList<>(m.keySet());
            Collections.sort(keys, (o1, o2)-> {
                if(m.get(o1) == m.get(o2)){
                    return o1-o2;
                }else{
                    return m.get(o1) - m.get(o2);
                }
            });
            
            int idx = 1;
            for(int key : keys){
                arr[i][idx++] = key;
                arr[i][idx++] = m.get(key); 
            }
        }
        
    }
    public static void changeArrByC(){
        int r = nowR;
        for(int j=1;j<=nowC;j++){
            Map<Integer, Integer> m = new HashMap<>();
            for(int i=1;i<=r;i++){
                m.put(arr[i][j], m.getOrDefault(arr[i][j], 0)+1);
                arr[i][j] = 0;
            }

            nowR= Math.max(nowR, m.size()*2);
            List<Integer> keys = new ArrayList<>(m.keySet());
            Collections.sort(keys, (o1, o2)-> {
                if(m.get(o1) == m.get(o2)){
                    return o1-o2;
                }else{
                    return m.get(o1) - m.get(o2);
                }
            });
            
            int idx = 1;
            for(int key : keys){
                arr[idx++][j] = key;
                arr[idx++][j] = m.get(key); 
            }
        }
        
    }
}
