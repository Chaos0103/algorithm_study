import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    //무한대 상수: 10억
    private static final int INF = (int) 1e9;
    //그래프 정보
    private static final ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    //그래프 노드 정보를 저장하기 위한 클래스
    private static class Node implements Comparable<Node> {
        public int index;
        public int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return distance - o.distance;
        }
    }

    //다익스트라 알고리즘
    private static void dijkstra(int[] d) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(1, 0)); //현서의 위치는 1

        while (!q.isEmpty()) {
            Node node = q.poll();
            int index = node.index;
            int distance = node.distance;

            //최소 거리를 계산한 적이 존재하면 생략
            if (d[index] < distance) {
                continue;
            }

            //노드에 연결된 모든 간선 순회
            for (int i = 0; i < graph.get(index).size(); i++) {
                //다음으로 가는 비용 계산
                int cost = distance + graph.get(index).get(i).distance;
                //다음으로 가는 비용이 더 싸다면 갱신
                if (d[graph.get(index).get(i).index] > cost) {
                    d[graph.get(index).get(i).index] = cost;
                    q.add(new Node(graph.get(index).get(i).index, cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //그래프를 노드 개수만큼 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        //그래프 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        //최단 거리 저장을 위한 배열 생성 및 무한대로 초기화
        int[] d = new int[n + 1];
        Arrays.fill(d, INF);

        //다익스트라 알고리즘 수행
        dijkstra(d);

        //출력부
        System.out.println(d[n]);
    }
}
