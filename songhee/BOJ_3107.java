import java.util.*;
import java.io.*;
class Main{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String original = br.readLine();
        if(original.contains("::")) {
            original = original.replace("::", ":zero:");
        }
        String [] arr = original.split(":");

        List<String> inputList = new ArrayList<>();
        List<String> answerList = new ArrayList<>();

        for(int i=0;i<arr.length;i++) {
            inputList.add(arr[i]);
        }

        for(int i=0;i<inputList.size();i++) {
            String a = inputList.get(i);
            if(a.isEmpty()) {
                continue;
            }
            int size = 4-a.length();
            while(size-->0) {
                a="0"+a;
            }

            answerList.add(a);
        }

        String[] answer = new String[8]; int idx = 0;
        int size = 8 - answerList.size() + 1;
        for(int i=0;i<answerList.size();i++) {

            String a = answerList.get(i);

            if(a.equals("zero")) {
                while(size-->0) {
                    answer[idx++] = "0000";
                }
            }else{
                answer[idx++] = a;
            }
        }

        String sw = answer[0];
        for(int i=1;i<answer.length;i++) {
            sw = sw+":"+answer[i];
        }

        System.out.println(sw);
    }
}