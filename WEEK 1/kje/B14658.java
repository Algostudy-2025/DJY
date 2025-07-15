package backjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;                     

//하늘에서 별똥별이 빗발친다
public class B14658 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //x
		int M = sc.nextInt(); //y
		int L = sc.nextInt();
		int K = sc.nextInt();
		
		List<Integer> coordinates = new ArrayList<>(); //여기 좌표를 저장
		
		int count = 0;
		int meteor = Integer.MIN_VALUE;
		
		for(int i = 0; i < K; i++) { //좌표는 좌하단부터 시작
			int a = sc.nextInt();
			int b = sc.nextInt();
			coordinates.add(b); //y
			coordinates.add(a); //x
		}
		
		for(int i = 0; i < coordinates.size() - 1; i += 2) {
			int j = i+1;
			for(int n = 0; n < L; n++) {
				count = 0;
				for(int k = coordinates.get(i)-3+n; k <= coordinates.get(i)+1+n; k++) {
					for(int l = coordinates.get(j)-3+n; l <= coordinates.get(j)+1+n; l++) {
						for(int c = 0; c < coordinates.size() - 1; c += 2) {
							int d = c+1;
							if(coordinates.get(c) < 0 || coordinates.get(d) < 0|| coordinates.get(c) >= M || coordinates.get(d) >= N) continue;
							else if(coordinates.get(c) == k && coordinates.get(d) == l) count++;
						}
					}
				}
				if(count > meteor) {
					meteor = count;
				}
			}
		}
		System.out.println(meteor);		
	}
}





/* 메모리초과 - 일단 2차원 배열 만드는거부터 안된다
public class b14658 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		int K = sc.nextInt();
		
		int meteor = Integer.MIN_VALUE; //비교
		int count = 0; //현재 위치에서의 별똥별 갯수
		
		Stack<Integer> stack = new Stack<>();
		
		boolean[][] area = new boolean[M][N]; //배열은 좌상단부터 시작
		
		for(int i = 0; i < K; i++) { //좌표는 좌하단부터 시작
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			area[b-1][a-1] = true; //배열에 넣기 위해 -1 처리
			
			stack.add(a-1);
			stack.add(b-1);
		}
		
		while(!stack.isEmpty()) {
		
			int c = stack.pop();
			int d = stack.pop();

			if(area[c][d]) { //별똥멸이 있는 위치 찾음
				count = 0; //주변 별똥별 세기 (모서리 포함)
				for(int k = c-1; k < c+L; k++) {
					for(int l = d-1; l < d+L; l++) {
						if(k < 0 || l < 0 || k >= M || l >= N) continue;
						else if(area[k][l]) count++; 
					}
				}
			}
				
			if(meteor < count) {
				meteor = count;
			}
		}
		
		System.out.println(meteor);

	}

}
*/
