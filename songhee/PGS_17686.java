import java.util.*;
//소문자로 -> .toLowerCase()
class PGS_17686 {
    public String[] solution(String[] files) {
        String[] answer = {};

        Arrays.sort(files, (file1, file2) -> {
                file1 = file1.toLowerCase();
                file2 = file2.toLowerCase();

                int idx1 = findStringIdx(file1); //문자열이 끝나는 지점 찾기
                int idx2 = findStringIdx(file2);
                String HEADER1 = file1.substring(0, idx1);
                String HEADER2 = file2.substring(0, idx2);

                if(HEADER1.equals(HEADER2)){
                    while(file1.charAt(idx1) == '.' || file1.charAt(idx1) == '-' || file1.charAt(idx1) == ' ' ){
                        idx1++;
                        if(idx1>=file1.length()) return file1.length()-1;
                    }
                    while(file2.charAt(idx2) == '.' || file2.charAt(idx2) == '-' || file2.charAt(idx2) == ' ' ){
                        idx2++;
                        if(idx2>=file2.length()) return file2.length()-1;
                    }

                    int idx3 = findNumber(idx1, file1); //숫자가 끝나는 지점 찾기
                    int idx4 = findNumber(idx2, file2);
                    int NUMBER1 = Integer.parseInt(file1.substring(idx1, idx3));
                    int NUMBER2 = Integer.parseInt(file2.substring(idx2, idx4));
                    return NUMBER1-NUMBER2;
                }
                else if(HEADER1.compareTo(HEADER2)>0){
                    return 1;
                }
                else if(HEADER1.compareTo(HEADER2) == 0){
                    return 0;
                }else{
                    return -1;
                }
            }
        );


        return files;
    }
    public static int findStringIdx(String file){
        for(int i=0;i<file.length();i++){
            char a = file.charAt(i);
            if(a == '.' || a == ' ' || a == '-') continue;
            else if(!Character.isLetter(a)) return i;
        }
        return file.length();
    }
    public static int findNumber(int idx, String file){
        for(int i=idx;i<file.length();i++){
            char a = file.charAt(i);
            if(a == '.' || a== ' ' || a == '-') return i;
            if(Character.isLetter(a)) return i;
        }
        return file.length();
    }
}