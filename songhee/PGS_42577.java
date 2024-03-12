import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        int idx = 0;
        Arrays.sort(phone_book, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                return o1.length()-o2.length();
            }
        });

        while(idx<phone_book.length){
            int endIdx = phone_book[idx].length();
            for(int i=idx+1;i<phone_book.length;i++){
                String s = phone_book[i];
                if(s.substring(0, endIdx).equals(phone_book[idx])){
                    return false;
                }
            }
            idx++;
        }
        return true;
    }
}