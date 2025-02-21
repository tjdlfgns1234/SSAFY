import java.util.*;
import java.io.*;

public class Solution {
	static Queue<Integer> q;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < 10; t++) {
			int T = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			q = new ArrayDeque<>(); 
			for (int i = 0; i < 8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			calc();
			System.out.printf("#%d ", T);
			while(!q.isEmpty()) {
				System.out.printf("%d ", q.poll());
			}
			System.out.println();
			
		}
	}
	static void calc() {
		int temp;
		while(true) {
			for (int i = 1; i <= 5; i++) {
				temp = q.poll();
				if(temp - i <= 0) {
					q.add(0); 
					return;
				}
				q.add(temp - i);
			}
		}
	}
}
