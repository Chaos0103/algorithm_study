/**
 * 2671 잠수함 식별
 * https://www.acmicpc.net/problem/2671
 * 
 * @author minchae
 * @date 2024. 1. 30.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String sound = br.readLine();
		String pattern = "^(100+1+|01)+$";

		System.out.println(sound.matches(pattern) ? "SUBMARINE" : "NOISE");
	}
}
