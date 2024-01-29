import java.util.*;
import java.io.*;
class BOJ_9935{

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String original = br.readLine();
        String regex = br.readLine();

        Stack<Character> s = new Stack<>();
        for(int i=0;i<original.length();i++) {
            s.add(original.charAt(i));

            if(s.size()>=regex.length()) {
                boolean isSame = true;
                for(int j=0;j<regex.length();j++) {
                    if(!s.get(s.size()-regex.length()+j).equals(regex.charAt(j))) {
                        isSame = false;
                        break;
                    }
                }
                if(isSame) {
                    for(int j=0;j<regex.length();j++) {
                        s.pop();
                    }
                }
            }
        }

        for(int i=0;i<s.size();i++) {
            sb.append(s.get(i));
        }

        if(sb.length() == 0) sb.append("FRULA");
        System.out.println(sb);
    }
}