package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {

	public static void main(String[] args) {
		Queue<Integer> que = new LinkedList<>();

		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };

		// 1. 완료일 계산
		for (int i = 0; i < speeds.length; i++) {
			// 2. days설정
			int days = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);

			que.add(days);
		}

		// 3.
		while (!que.isEmpty()) {
			System.out.println(que.poll());
		}
	}

}

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> que = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		
		// 1. 완료일 계산
		for (int i = 0; i < speeds.length; i++) {
			// 2. days설정
			int days = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);

			que.add(days);
		}

		// 3. 여기 안에는 지금 필요시간이 있음
		int count = 0; // 몇 개의 기능이 배포?
		int temp = que.peek(); // 큐의 가장 맨 앞에 있는 애가 기준
		
		// 앞에것이 기준
		while (!que.isEmpty()) {
			// temp보다 que안에 있는게 더 작거나 같으면 > 빼준다
			if(que.peek() <= temp) {
				que.poll();
			}
			// 아니면 그냥 빼버려
			else {
				temp = que.poll();
			}
			count++;
			
			if(que.isEmpty()) {
				list.add(count);
			}
			
			// temp보다 que에 잇는게 크면
			else if(que.peek() > temp) {
				list.add(count); // 그 전것들 미리 다 넣기
				count = 0;
				temp = que.peek();
			}
			
		}
		
		int [] answer = new int [list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}

		return answer;
		
		// 왜 어떤건 2개를 하나로 묶고 어떤거는 1개를 따로 보는건가...
		// gpt에 논리구조를 물어봤음
	}
}