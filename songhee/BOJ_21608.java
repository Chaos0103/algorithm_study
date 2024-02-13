import java.io.*;
import java.util.*;
public class BOJ_21608 {
    static class xy{
        int x;
        int y;
        xy(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int arr[][];
    static int n;
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static Map<Integer, Integer> total = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = (int)Math.pow(Integer.parseInt(br.readLine()), 2);
        arr = new int[n+1][n+1];

        total.put(0, 0);
        total.put(1, 1);
        total.put(2, 10);
        total.put(3, 100);
        total.put(4, 1000);

        while(n-->0) {
            st = new StringTokenizer(br.readLine());
            int num  = Integer.parseInt(st.nextToken());

            List<Integer> list = new ArrayList<>();
            for(int i=1;i<5;i++) {
                int a = Integer.parseInt(st.nextToken());
                list.add(a);
            }

            map.put(num, list);

            //0인곳 찾기
            List<xy> find = findZero();

            //조건 1인지 확인
            List<xy> find1 = findOne(list, find);
            if(find1.size() == 1) {
                arr[find1.get(0).x][find1.get(0).y] = num;
                continue;
            }
            //조건 2인지 확인
            List<xy> find2 = findTwo(find1);
            if(find2.size() == 1) {
                arr[find2.get(0).x][find2.get(0).y] = num;
                continue;
            }
            //조건 3인지 확인
            xy end = findThree(find2);
        }

        //만족도 조사
        System.out.println(checkHappy());


    }
    private static int checkHappy() {
        int sum = 0;
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<n+1;j++) {
                List<Integer> likeStudents = map.get(arr[i][j]);
                sum += total.get(check(likeStudents, new xy(i, j)));
            }
        }
        return sum;
    }
    private static int check(List<Integer> likeStudents, xy item) {
        int sum = 0;
        for(int i=0;i<dx.length;i++) {
            int x = item.x + dx[i];
            int y = item.y + dy[i];

            if(x<=0 || y<=0 || x>=n+1 || y>=n+1) continue;
            int findNum = arr[x][y];
            for(int stuNum : likeStudents) {
                if(findNum == stuNum) {
                    sum ++;
                }
            }
        }
        return sum;
    }
    private static xy findThree(List<xy> zeroList) {
        return zeroList.get(0);
    }
    private static List<xy> findTwo(List<xy> zeroList) {
        List<Integer> sumList = new ArrayList<>();
        int maxSum = 0;
        for(int i=0;i<zeroList.size();i++) {
            xy position = zeroList.get(i);
            int sum = 0;

            for(int j=0;j<dx.length;j++) {
                int x = position.x+dx[j];
                int y = position.y+dy[j];

                if(x<=0 || y<=0 || x>=n+1 || y>=n+1) continue;
                int compare = arr[x][y];
                if(compare == 0) {
                    sum++;
                }
            }
            if(maxSum < sum) {
                maxSum = sum;
            }
            sumList.add(sum);
        }

        for(int i=0;i<sumList.size();i++) {
            if(sumList.get(i) < maxSum) {
                zeroList.remove(i);
            }
        }
        return zeroList;
    }
    private static List<xy> findOne(List<Integer> likeNums, List<xy> zeroList) {
        List<Integer> sumList = new ArrayList<>();
        int maxSum = 0;

        for(int i=0;i<zeroList.size();i++) {
            xy position = zeroList.get(i);
            int sum = 0;

            for(int j=0;j<dx.length;j++) {
                int x = position.x+dx[j];
                int y = position.y+dy[j];

                if(x<=0 || y<=0 || x>=n+1 || y>=n+1) continue;
                int compare = arr[x][y];
                sum += calcul(compare, likeNums);
            }
            if(maxSum < sum) {
                maxSum = sum;
            }
            sumList.add(sum);
        }

        for(int i=0;i<sumList.size();i++) {
            if(sumList.get(i) < maxSum) {
                zeroList.remove(i);
            }
        }
        return zeroList;
    }
    private static int calcul(int compare, List<Integer> likeNums) {
        for(int num: likeNums) {
            if(num == compare) {
                return 1;
            }
        }
        return 0;
    }
    private static List<xy> findZero() {
        List<xy> list = new ArrayList<>();
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<n+1;j++) {
                if(arr[i][j] == 0) {
                    list.add(new xy(i, j));
                }
            }
        }
        return list;
    }
}
