class Solution {
    public int solution(String s) {
        if (s.length() == 1) {
            return 1;
        }

        int answer = Integer.MAX_VALUE;

        for (int step = 1; step <= s.length() / 2; step++) {
            String prev = s.substring(0, step);
            StringBuilder builder = new StringBuilder();
            int count = 1;
            for (int i = step; i <= s.length() - step; i += step) {
                String target = s.substring(i, i + step);
                if (prev.equals(target)) {
                    count++;
                } else {
                    if (count > 1) {
                        builder.append(count);
                    }
                    builder.append(prev);

                    count = 1;
                    prev = target;
                }
            }

            if (count > 1) {
                builder.append(count);
            }
            builder.append(prev);

            if (s.length() % step > 0) {
                builder.append(s.substring(s.length() - s.length() % step));
            }

            answer = Math.min(answer, builder.length());
        }

        return answer;
    }
}
