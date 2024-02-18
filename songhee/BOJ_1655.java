import java.io.*;
import java.util.*;
public class BOJ_1655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> minHeap = new PriorityQueue<>((o1, o2)-> o1-o2);
        Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2)-> o2-o1);
        while(n-->0) {
            int num = Integer.parseInt(br.readLine());

            if(minHeap.size() == maxHeap.size()) {
                maxHeap.add(num);
            }else {
                minHeap.add(num);
            }

            if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                if(maxHeap.peek() > minHeap.peek()) {
                    int swapNum = maxHeap.poll();
                    minHeap.add(swapNum);
                    maxHeap.add(minHeap.poll());
                }
            }

            sb.append(maxHeap.peek()+"\n");
        }

        System.out.println(sb);


    }

}
