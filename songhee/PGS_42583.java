import java.util.*;
class Solution {
    /*
    Queue<Integer> 선언
    1. 큐가 비어있을때
    넣어주고 시간 증가
    2. 큐가 비어있지 않을때
    1) 큐가 다리 길이만큼 되었을때
    2) 다음 무게가 weight 초과일때
    3) 다음 무게가 weight 이내일때
    */
    static Queue<Integer> q = new LinkedList<>();
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        long totalWeights = 0;
        for(int truck : truck_weights){
            while(true){
                if(q.isEmpty()){
                    q.add(truck);
                    answer++;
                    totalWeights += truck;
                    break;
                }else if(q.size() == bridge_length){
                    totalWeights -= q.poll();
                }else{
                    if(weight >= totalWeights + truck){
                        q.add(truck);
                        totalWeights += truck;
                        answer++;
                        break;
                    }else{
                        q.add(0);
                        answer++;
                    }
                }
            }
        }

        return answer + bridge_length;
    }
}