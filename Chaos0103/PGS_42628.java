import java.util.*;

class Solution {
    private static class DoublePriorityQueue {
        private int size = 0;
        private PriorityQueue<Integer> minPq = new PriorityQueue<>();
        private PriorityQueue<Integer> maxPq = new PriorityQueue<>((a, b) -> b - a);
        
        public void add(int elem) {
            minPq.add(elem);
            maxPq.add(elem);
            size++;
        }
        
        public void pollMin() {
            if (size > 0) {
                minPq.poll();
                size--;
                init();    
            }
        }
        
        public void pollMax() {
            if (size > 0) {
                maxPq.poll();
                size--;
                init();
            }
        }
        
        private void init() {
            if (size == 0) {
                minPq = new PriorityQueue<>();
                maxPq = new PriorityQueue<>((a, b) -> b - a);
            }
        }
        
        public int[] getResult() {
            if (size == 0) {
                return new int[]{0, 0};
            }
            return new int[]{maxPq.peek(), minPq.peek()};
        }
    }
    
    public int[] solution(String[] operations) {
        DoublePriorityQueue dpq = new DoublePriorityQueue();
        
        int size = 0;
        for (String operation : operations) {
            String[] data = operation.split(" ");
            if (data[0].equals("I")) {
                dpq.add(Integer.parseInt(data[1]));
                continue;
            }
            
            if (Integer.parseInt(data[1]) == 1) {
                dpq.pollMax();
            } else if (Integer.parseInt(data[1]) == -1) {
                dpq.pollMin();
            }
        }
            
        return dpq.getResult();
    }
}
