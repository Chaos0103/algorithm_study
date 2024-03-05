import java.io.*;
import java.util.*;
class Solution {
    static class Striming{
        int count;
        int i;
        Striming(int count, int i){
            this.count = count;
            this.i = i;
        }
    }
    static class Genre{
        int idx;
        int sum;
        Genre(int idx){
            this.idx = idx;
            this.sum = 0;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        Map<String, List<Striming>> map = new HashMap<>();
        Map<String, Integer> sum = new HashMap<>();

        for(int i=0;i<genres.length;i++){
            List<Striming> list;
            if(map.containsKey(genres[i])){
                list = map.get(genres[i]);
                list.add(new Striming(plays[i], i));
                sum.put(genres[i], sum.get(genres[i])+1);
            }else{
                list = new ArrayList<>();
                list.add(new Striming(plays[i], i));
                sum.put(genres[i], 1);
            }

            map.put(genres[i], list);

        }

        List<String> ks = new ArrayList<>(sum.keySet());
        ks.sort((o1, o2)-> sum.get(o2)-sum.get(o1));

        List<Integer> l = new ArrayList<>();

        for(int i=0;i<ks.size();i++){
            List<Striming> list = map.get(ks);
            Collections.sort(list, (o1, o2)-> o2.count-o1.count);
            for(int j=0;j<list.size();j++){
                l.add(list.get(j).i);
                if(j == 1){
                    break;
                }
            }
        }

        answer = new int[l.size()];
        for(int i=0;i<l.size();i++){
            answer[i] = l.get(i);
        }
        return answer;
    }
}