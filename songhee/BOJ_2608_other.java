import java.io.*;
import java.util.*;
public class BOJ_2608 {
    static Map<String, Integer> stringMap = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        stringMap.put("I", 1);
        stringMap.put("V", 5);
        stringMap.put("X", 10);
        stringMap.put("L", 50);
        stringMap.put("C", 100);
        stringMap.put("D", 500);
        stringMap.put("M", 1000);

        stringMap.put("IV", 4);
        stringMap.put("IX", 9);
        stringMap.put("XL", 40);
        stringMap.put("XC", 90);
        stringMap.put("CD", 400);
        stringMap.put("CM", 900);

        int sum = calculate(s1) + calculate(s2);
        sb.append(sum+"\n");

        stringMap.putAll(charMap);
        List<String> keySet = new ArrayList<>(stringMap.keySet());
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return stringMap.get(o2).compareTo(stringMap.get(o1));
            }
        });
        findArabia(sum);
        sb.append(sb);

    }

    private static void findArabia(int sum) {
        String num = String.valueOf(sum);
        for(int i=0;i<num.length();i++) {
            int n = Character.getNumericValue(num.charAt(i))*(int)Math.pow(1.0, (num.length()-1-i));
            for(String key : stringMap.keySet()) {
                if(n%stringMap.get(key) == 0) {
                    int value = n/stringMap.get(key);
                    while(value -->0) {
                        sb.append(stringMap.get(key));
                    }
                    break;
                }
            }
        }
    }

    private static int calculate(String s) {
        int sum = 0;
        int idx = 0;
        for(int i=0;i<s.length();){
            char ch = s.charAt(i);
            if(ch == 'I' || ch == 'X' || ch == 'C'){
                if(i+1 < s.length()){
                    String madeString = s.substring(i, i+2);
                    if(stringMap.containsKey(madeString)){
                        sum += stringMap.get(madeString);
                        i+=2;
                    }
                }
            }else{
                String madeString = String.valueOf(ch);
                if(stringMap.containsKey(madeString)){
                    sum += stringMap.get(madeString);
                    i++;
                }
            }
        }
        return sum;
    }
}
