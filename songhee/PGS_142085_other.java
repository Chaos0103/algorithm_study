import java.util.*;
import java.io.*;
class PGS_142085_other {
    static class MuZeok{
        int index;
        int enemy;
        MuZeok(int index, int enemy){
            this.index = index;
            this.enemy = enemy;
        }
    }
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        if(k>=enemy.length){
            return enemy.length;
        }

        PriorityQueue<MuZeok> pq = new PriorityQueue<>((o1, o2)->{
            if(o1.enemy == o2.enemy){
                return o1.index-o2.index;
            }else{
                return o2.enemy-o1.enemy;
            }
        });

        for(int i=0;i<enemy.length;i++){
            pq.add(new MuZeok(i, enemy[i]));
        }

        List<MuZeok> list = new ArrayList<>();
        for(int i=0;i<k;i++){
            list.add(pq.poll());
        }

        Collections.sort(list, (o1, o2)->{
            return o1.index-o2.index;
        });

        int listIndex = 0;
        int now = n;
        int count = 0;
        for(int i=0;i<enemy.length;i++){
            if(count+1 <= k && list.get(listIndex).index == i){
                listIndex++;
                count++;
            }else{
                if(now>=enemy[i]){
                    now-=enemy[i];
                }else{
                    if(count+1 <= k){
                        count++;
                    }else{
                        return i;
                    }
                }
            }
        }

        return enemy.length;
    }
}