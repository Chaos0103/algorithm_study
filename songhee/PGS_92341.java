import java.util.*;
class Solution {
    static int basicTime, basicCost, unitTime, unitCost;
    public int[] solution(int[] fees, String[] records) {

        Map<String, String> map = new HashMap<>(); // 차량번호별 IN 할때의 시간 저장
        Map<String, Integer> useMap = new HashMap<>(); //차량번호별 사용시간 저장
        Map<String, Integer> costMap = new HashMap<>(); //차량번호별 비용 저장
        
        basicTime = fees[0];
        basicCost = fees[1];
        unitTime = fees[2];
        unitCost = fees[3];
        
        for(int i=0;i<records.length;i++){
            String []s = records[i].split(" ");
            if(s[2].equals("IN")){
                map.put(s[1], s[0]);
            }else{
                useMap.put(s[1], 
                           useMap.getOrDefault(s[1], 0) + calculateTime(s[1], map.get(s[1]), s[0]));
                map.remove(s[1]);
            }
        }
        
        int mapSize = map.size();
        for(String key : map.keySet()){
            useMap.put(key, 
                       useMap.getOrDefault(key, 0) + calculateTime(key, map.get(key), "23:59"));
            
        }
        
        for(String key : useMap.keySet()){
            int useTime = useMap.get(key);
            if(useTime<= basicTime){
                costMap.put(key, basicCost);
            }else{
                costMap.put(key, 
                            basicCost+ (int)Math.ceil((double)(useTime-basicTime)/unitTime)*unitCost);
            }
        }
        
       Map<String, Integer> sortedMap = new TreeMap<>(costMap);

        // 정렬된 Map의 value를 int 배열로 변환
        return sortedMap.values().stream()
                            .mapToInt(Integer::intValue)
                            .toArray();

    }
    public static int calculateTime(String num, String in, String out){
        String []t1 = in.split(":");
        String []t2 = out.split(":");
        
        int usedTime = Integer.parseInt(t2[0])*60+Integer.parseInt(t2[1])-(Integer.parseInt(t1[0])*60+Integer.parseInt(t1[1]));

        return usedTime;
    }
}
