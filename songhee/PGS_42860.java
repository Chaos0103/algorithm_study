class Solution {
    static int cnt = Integer.MAX_VALUE;
    public int solution(String name) {
        int answer = 0;

        int idx = 0; int num = 0;
        boolean flag = false; //우측방향
        if(name.charAt(1) == 'A') flag = true;

        while(num < name.length()){
            System.out.println(name.charAt(idx)+", "+answer+". "+idx+", "+num);
            int a = name.charAt(idx) - 'A';
            int b = 1 + 'Z' - name.charAt(idx);

            answer += Math.min(a, b);

            if(flag){
                if(idx == 0) idx = name.length()-1;
                else idx--;
            }else idx++;

            if(idx < name.length()){
                if(num+1 == name.length() && name.charAt(idx) == 'A'){
                    continue;
                }else{
                    answer++;
                }
            }
            num++;

        }

        return answer;
    }
}