import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static List<Integer> solution(int[] size) {
        //중복을 제거한 결과 저장을 위해 HashSet 사용
        Set<Integer> result = new HashSet<>();
        //순환을 막기 위해 물의 양을 방문 처리: new boolean[a + 1][b + 1][c + 1]
        boolean[][][] isVisited = new boolean[size[0] + 1][size[1] + 1][size[2] + 1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, size[2]});

        while (!q.isEmpty()) {
            int[] bucket = q.poll();

            //A 물통이 0인 경우 C 물통에 담긴 물의 양을 결과에 추가
            if (bucket[0] == 0) {
                result.add(bucket[2]);
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 1; j < 3; j++) {
                    //인스턴스 참조를 제거하기 위해 새로운 배열 생성
                    int[] next = new int[3];
                    //현재 물통에 남은 물의 양과 이동할 물통에 담을 수 있는 물의 양 중 작은 값을 선택
                    int min = Math.min(bucket[i], size[(i + 1) % 3] - bucket[(i + 1) % 3]);
                    //물 옮기기
                    next[i] = bucket[i] - min;
                    next[(i + 1) % 3] = bucket[(i + 1) % 3] + min;
                    next[(i + 2) % 3] = bucket[(i + 2) % 3];
                    //같은 물의 양의 형태가 존재하지 않았다면
                    if (!isVisited[next[0]][next[1]][next[2]]) {
                        //큐에 삽입 후 방문 처리
                        q.add(next);
                        isVisited[next[0]][next[1]][next[2]] = true;
                    }
                }
            }
        }

        //결과를 정렬하여 List로 반환
        return result.stream()
            .sorted()
            .collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        //입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] init = new int[3];
        for (int i = 0; i < 3; i++) {
            init[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> result = solution(init);
        
        //출력부
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
