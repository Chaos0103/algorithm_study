import java.io.*;
import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        List<Character> list = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            list.add(s.charAt(i));
        }
        
        int idx = 0;
        while(idx < list.size()){
            int size = list.size();
            boolean flag = false;
            for(int i=idx;i<size-1;i++){
                if(list.get(i) == list.get(i+1)){
                    list.remove(i);
                    list.remove(i);
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                return 0;
            }
            if(idx > 0){
                idx--;
            }
        }
        
        if(list.size() == 0) return 1;
        else return 0;
        
        String[] arr = s.split("");
        Stack<String> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(!stack.isEmpty() && stack.peek().equals(arr[i])){
                stack.pop();
            }else{
                stack.push(arr[i]);
            }
        }
        
        if(stack.size() == 0) return 1;
        else return 0;
    }
}
