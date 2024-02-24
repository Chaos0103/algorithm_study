import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemSet = new HashSet<>(Arrays.asList(gems));

        int[] answer = new int[]{1, gems.length};

        int leftIndex = 0;
        int rightIndex = 0;
        Map<String, Integer> gemMap = new HashMap<>();
        while (rightIndex < gems.length && leftIndex <= rightIndex) {
            String gem = gems[rightIndex];
            int count = gemMap.getOrDefault(gem, 0);
            gemMap.put(gem, count + 1);

            while (gemMap.keySet().size() == gemSet.size()) {
                int length = answer[1] - answer[0];
                if (length > rightIndex - leftIndex) {
                    answer = new int[]{leftIndex + 1, rightIndex + 1};
                }

                gemMap.put(gems[leftIndex], gemMap.get(gems[leftIndex]) - 1);
                if (gemMap.get(gems[leftIndex]) == 0) {
                    gemMap.remove(gems[leftIndex]);
                }
                leftIndex++;
            }

            rightIndex++;
        }


        return answer;
    }
}
