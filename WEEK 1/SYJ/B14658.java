package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14658 {
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		// 네 정수 입력받기
		// 별똥별 떨어지는 면적
		int N = Integer.parseInt(st.nextToken()); // 별똥별이 떨어지는 구역의 가로길이
		int M = Integer.parseInt(st.nextToken()); // 세로길이
		// 트램펄린
		int L = Integer.parseInt(st.nextToken()); // 트램펄린 한변의 길이
		int K = Integer.parseInt(st.nextToken()); // 별똥별의 수

		int[][] map = new int[N + 1][M + 1]; // 별똥별 떨어지는 위치
		// 1. L*L크기의 트램펄린
		int[][] star = new int[L][L];
		int result = Integer.MIN_VALUE;

		for (int loc = 0; loc < K; loc++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
		} // 별똥별의 좌표

		for (int i = 0; i < N - L; i++) {
			for (int j = 0; j < M - L; j++) {
				int sum = 0;
				for (int o = 0; o < L; o++) {
					for (int o2 = 0; o2 < L; o2++) {
						sum += map[o + i][o2 + j];
					}
				}
				if (sum > result) {
					result = sum;
				}

			}
		}

		System.out.println(result);
		// 지구의 파괴를 막기 위해 지표면에 떨어지는 별똥별의 수를 최소화 해야 함

		// 최대한 많은 별똥별을 튕겨내도록 트램펄린을 배치

		// 그럼 지구에는 몇 개의 별똥별이 부딪힐까

	} // main

} // class
