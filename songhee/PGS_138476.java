class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();

        int n = tangerine.length;
        int t = 0;
        for (int i=0; i<n; i++) {
            t = tangerine[i];

            if (count.containsKey(t)) {
                count.put(t,count.get(t)+1);
            }
            else {
                count.put(t, 1);
            }

        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(count.entrySet());
        list.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        int answer = 0;

        for (Map.Entry<Integer, Integer> entry : list) {

            if (k <= 0)
                break;

            k -= entry.getValue();
            answer += 1;

        }

        return answer;
    }
}