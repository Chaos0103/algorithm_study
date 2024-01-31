import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Map.Entry;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Information> info = new HashMap<>();
        
        int max = 0;
        for (int i = 0; i < edges.length; i++) {
            max = Math.max(max, Math.max(edges[i][0], edges[i][1]));
        }
        boolean[] check = new boolean[max + 1];
                           
        for (int i = 1; i <= max; i++) {
            graph.put(i, new ArrayList<>());
            info.put(i, new Information(0, 0));
        }
                           
        
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            
            List<Integer> list = graph.get(from);
            list.add(to);
            
            info.get(from).addOut();
            info.get(to).addIn();
        }
        
        int findEdge = 0;
        for (int key : info.keySet()) {
            Information i = info.get(key);
            if (i.out >= 2 && i.in == 0) {
                findEdge = key;
            }
        }
        
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            
            if (from == findEdge) {
                
                info.get(to).minusIn();
            }
        }
    
        info.remove(findEdge);
        
        List<Integer> sortedList = info.entrySet().stream()
            .sorted(new Comparator<Entry<Integer, Information>>() {
                @Override
                public int compare(Entry<Integer, Information> o1, Entry<Integer, Information> o2) {
                    return o1.getValue().in - o2.getValue().in;
                }
            })
            .map(entry -> entry.getKey())
            .collect(Collectors.toList());
        
        int[] arr = new int[3];
        
        for (int node : sortedList) {
            if (check[node]) {
                continue;
            }
            Pass pass = dfs(graph, node, check);
            int v = pass.vertex;
            int e = pass.edge - 1;
            if (v == e) {
                arr[0]++;
            } else if (v - 1 == e) {
                arr[1]++;
            } else {
                arr[2]++;
            }
        }
        
        int[] answer = {findEdge, arr[0], arr[1], arr[2]};
        return answer;
    }
    
    class Information {
        int out;
        int in;
        
        public Information(int out, int in) {
            this.out = out;
            this.in = in;
        }
        
        public void addOut() {
            this.out++;
        }
        
        public void addIn() {
            this.in++;
        }
        
        public void minusIn() {
            this.in--;
        }
    }
    
    class Pass {
        int vertex;
        int edge;
        
        public Pass(int vertex, int edge) {
            this.vertex = vertex;
            this.edge =edge;
        }
        
        public void addVertex() {
            this.vertex++;
        }
        public void addEdge() {
            this.edge++;
        }
    }
    
    private Pass dfs(Map<Integer, List<Integer>> graph, int now, boolean[] check) {
        if (check[now]) {
            return new Pass(0, 1);
        }
        
        List<Integer> nexts = graph.get(now);
        
        int v = 1;
        int e = 1;
        check[now] = true;
        for (int next : nexts) {
            Pass p = dfs(graph, next, check);
            v += p.vertex;
            e += p.edge;
        }
        return new Pass(v, e);
    }
}