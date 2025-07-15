package backjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B1238 {
	
	static List<List<Node>> graph = new ArrayList<>();;
	static List<List<Node>> reverseGraph = new ArrayList<>();;
	
	static final int INF = Integer.MAX_VALUE;
	static int N, M, X;
	
	static class Node implements Comparable<Node>{
		int v;
		int cost;
		
		public Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //마을 수
		M = sc.nextInt(); //도로 수 
		X = sc.nextInt(); //파티 마을
		
		for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }
		
		for(int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int time = sc.nextInt();
			
			graph.get(start).add(new Node(end, time));
			reverseGraph.get(end).add(new Node(start, time));
		}
				
		int[] toX = dijkstra(X, reverseGraph);
		int[] fromX = dijkstra(X, graph);

		int answer = 0;
		for(int i = 1; i <= N; i++) {
			int roundTrip = toX[i] + fromX[i];
			answer = Math.max(answer, roundTrip);
		}
		
		System.out.println(answer);
	}
	
	static int[] dijkstra(int start, List<List<Node>> g) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        
        while (!pq.isEmpty()) {
        	Node now = pq.poll();
            int nowNode = now.v;
            int nowCost = now.cost;

            if (nowCost > dist[nowNode]) continue;

            for (Node next : g.get(nowNode)) {
                int nextNode = next.v;
                int newCost = dist[nowNode] + next.cost;

                if (newCost < dist[nextNode]) {
                    dist[nextNode] = newCost;
                    pq.offer(new Node(nextNode, newCost));
                }
            }
        }

        return dist;
	}

}
