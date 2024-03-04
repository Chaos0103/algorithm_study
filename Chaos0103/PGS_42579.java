import java.util.*;

class Solution {
    private static class Info implements Comparable<Info> {
        public int id;
        public String genre;
        public int play;
        public int totalPlay;

        public Info(int id, String genre, int play, int totalPlay) {
            this.id = id;
            this.genre = genre;
            this.play = play;
            this.totalPlay = totalPlay;
        }

        @Override
        public int compareTo(Info o) {
            if (o.totalPlay == totalPlay) {
                if (play == o.play) {
                    return id - o.id;
                }
                return o.play - play;
            }
            return o.totalPlay - totalPlay;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreCountMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            int count = genreCountMap.getOrDefault(genres[i], 0);
            genreCountMap.put(genres[i], count + plays[i]);

            countMap.put(genres[i], 2);
        }

        PriorityQueue<Info> infos = new PriorityQueue<>();
        for (int i = 0; i < genres.length; i++) {
            int totalCount = genreCountMap.get(genres[i]);
            infos.add(new Info(i, genres[i], plays[i], totalCount));
        }

        List<Integer> result = new ArrayList<>();
        while (!infos.isEmpty()) {
            Info info = infos.poll();
            int count = countMap.get(info.genre);
            if (count == 0) {
                continue;
            }

            countMap.put(info.genre, count - 1);
            result.add(info.id);
        }

        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
