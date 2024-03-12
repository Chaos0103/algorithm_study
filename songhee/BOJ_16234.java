import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int N;
    static int L;
    static int R;
    static int arrMap[][];
    static boolean arrVisit[][];
    static int nDay = 0;
    static Queue<Node> q = new LinkedList<Node>();
    static List<Node> comunityList;
    static int row[] = {0, 0, -1, 1};
    static int col[] = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);

        arrMap = new int[N][N];
        arrVisit = new boolean[N][N];

        for(int nRow = 0 ; nRow < N ; nRow++) {
            input = br.readLine().split(" ");
            for(int nCol = 0 ; nCol < N ; nCol++) {
                arrMap[nRow][nCol] = Integer.parseInt(input[nCol]);
            }
        }

        doMove();

        System.out.println(nDay);
    }

    private static void doMove() {

        while(true) {
            boolean nMoveFalg = false;
            arrVisit = new boolean[N][N];

            for(int nRow = 0 ; nRow < N ; nRow++) {
                for(int nCol = 0 ; nCol < N ; nCol++) {
                    if(arrVisit[nRow][nCol] == false) {
                        int nTotalPerson = bfs(nRow, nCol);

                        if(comunityList.size() > 1) {
                            doComunityMove(nTotalPerson);
                            nMoveFalg = true;
                        }
                    }
                }
            }


            if(nMoveFalg == true) {
                nDay++;
            }else {
                return;
            }
        }
    }

    private static int bfs(int nRow, int nCol) {
        int nTotalPerson = 0;
        comunityList = new ArrayList<Node>();
        q.add(new Node(nRow,nCol));
        comunityList.add(new Node(nRow,nCol));
        arrVisit[nRow][nCol] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(int nIdx = 0 ; nIdx < 4 ; nIdx++) {
                int nTargetRow = cur.row + row[nIdx];
                int nTargetCol = cur.col + col[nIdx];
                if(nTargetRow < 0 || nTargetCol < 0 || nTargetRow >= N || nTargetCol >= N)
                    continue;

                if(arrVisit[nTargetRow][nTargetCol] == true)
                    continue;
                int nCurPerson = arrMap[cur.row][cur.col];
                int nTargetPerson = arrMap[nTargetRow][nTargetCol];
                int nDiff = Math.abs(nCurPerson - nTargetPerson);

                if(L <= nDiff && nDiff <= R) {

                    q.add(new Node(nTargetRow, nTargetCol));
                    comunityList.add(new Node(nTargetRow, nTargetCol));
                    arrVisit[nTargetRow][nTargetCol] = true;
                }

            }

            nTotalPerson += arrMap[cur.row][cur.col];
        }

        return nTotalPerson;
    }

    private static void doComunityMove(int nTotalPerson) {
        int nCalPerson = Math.round(nTotalPerson/comunityList.size());

        for(Node node : comunityList) {
            arrMap[node.row][node.col] = nCalPerson;
        }

    }

    private static class Node{
        int row;
        int col;

        public Node (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}