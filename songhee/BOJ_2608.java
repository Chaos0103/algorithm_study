import java.io.*;
import java.util.*;
public class BOJ_2608 {
    static Map<String, Integer> charMap = new HashMap<>();
    static Map<String, Integer> stringMap = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        charMap.put("I", 1);
        charMap.put("V", 5);
        charMap.put("X", 10);
        charMap.put("L", 50);
        charMap.put("C", 100);
        charMap.put("D", 500);
        charMap.put("M", 1000);

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
        int idx = s.length()-1;
        while(idx >= 0) {
            int thirdRule = checkIsThirdRule(idx, s);
            if(thirdRule > 0) {
                sum += thirdRule;
                idx -=2;

            }else {
                sum += charMap.get(s.substring(idx, idx+1));
                idx--;
            }
        }
        return sum;
    }

    private static int checkIsThirdRule(int idx, String s) {
        if(idx-1 <0) return 0;
        String subString = s.substring(idx-1, idx+1);
        if(idx-1 >= 0 && stringMap.containsKey(subString)) {
            return stringMap.get(subString);
        }
        return 0;
    }
}
