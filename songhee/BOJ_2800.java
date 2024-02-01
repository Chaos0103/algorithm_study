import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;
public class Solution3 {
    static List<Integer> left = new ArrayList<>();
    static List<Integer> right = new ArrayList<>();
    static String s;
    static int size;
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        s = br.readLine();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                stack.add(i);
            }else if(ch == ')') {
                left.add(stack.pop());
                right.add(i);
            }

        }

        for(int i=0;i<left.size();i++) {
            System.out.print(left.get(i)+", ");
            System.out.println(right.get(i));
        }

        size = left.size();


        find(0, s);

        Collections.sort(list);

        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
    }
    private static void find(int leftIdx, String compare) {
        if(leftIdx == size) {
            return;
        }

        int lIdx = left.get(leftIdx);
        int rIdx = right.get(leftIdx);
        String remain = compare.substring(0, lIdx)
            + " "+ compare.substring(lIdx+1, rIdx)
            + " "+ compare.substring(rIdx+1, compare.length());

        if(!list.contains(remain.replace(" ", ""))) list.add(remain.replace(" ", ""));
        find(leftIdx+1, remain);
        find(leftIdx+1, compare);
    }
}
