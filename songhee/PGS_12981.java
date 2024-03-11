import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> list = new ArrayList<>();
        int count = 0;
        int idx = 0;
        for(int i=idx;i<words.length;){
            count++;
            for(int j=0;j<n && i<words.length;j++){
                if(list.size() > 0){
                    String before = list.get(list.size()-1);
                    if(before.charAt(before.length()-1) != words[i].charAt(0) || list.contains(words[i])){
                        answer[0] = j+1;
                        answer[1] = count;
                        return answer;
                    }else{
                        list.add(words[i++]);
                    }
                }else{
                    list.add(words[i++]);
                }
            }
        }

        return answer;
    }
}