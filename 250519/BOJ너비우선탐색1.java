import java.util.*;
import java.io.*;

public class BOJ너비우선탐색1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int r = sc.nextInt()-1;
		
		boolean[] v = new boolean[n];
		List<List<Integer>> adjList = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}
		
		for(int i = 0;i < m; i++) {
			int s = sc.nextInt()-1;
			int e = sc.nextInt()-1;
			
			adjList.get(s).add(e);
			adjList.get(e).add(s);
		}
		
		for(int i = 0;i < n; i++) {
			adjList.get(i).sort((o1, o2) -> o1 - o2);
		}
		
		int[] orderN = new int[n];
		int cnt = 1;
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(r);
		v[r] = true;
		orderN[r] = cnt;
		cnt++;
		
		while(!queue.isEmpty()) {
			int pos = queue.poll();
			
			for(int i = 0; i < adjList.get(pos).size(); i++) {
				int np = adjList.get(pos).get(i);
				if(v[np] == false) {
					queue.offer(np);
					v[np] = true;
					orderN[np] = cnt;
					cnt++;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println(orderN[i]);
		}
		
	}
}