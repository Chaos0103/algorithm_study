/**
 * 26086 어려운 스케줄링
 * https://www.acmicpc.net/problem/21608
 * 
 * @author minchae
 * @date 2024. 2. 24.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Deque<Integer> dq = new ArrayDeque<>();
		
		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int order = Integer.parseInt(st.nextToken());
			
			switch (order) {
			case 0:
				dq.addLast(Integer.parseInt(st.nextToken()));
				break;
			case 1:
				ArrayList<Integer> list = new ArrayList<>();
				
				while (!dq.isEmpty()) {
					list.add(dq.poll());
				}
				
				Collections.sort(list);
				
				// 고유번호가 낮은게 가장 먼저 처리될 수 있게 함
				for (int n : list) {
					dq.addFirst(n);
				}
				
				break;
			case 2:
				list = new ArrayList<>();
				
				while (!dq.isEmpty()) {
					list.add(dq.poll());
				}
				
				for (int n : list) {
					dq.addFirst(n);
				}
				
				break;
			}
		}
		
		while (k-- > 1) {
			dq.pollLast();
		}
		
		System.out.println(dq.pollLast());
	}

}
