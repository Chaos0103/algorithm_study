import java.util.*;
class PGS_42885 {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int idx = 0;
        int peopleNum = 0;
        for(int i=people.length-1;i>=idx;i--){

            if(people[idx] + people[i] <= limit){
                answer++;
                idx++;
            }else{
                answer++;
            }
        }


        return answer;
    }
}