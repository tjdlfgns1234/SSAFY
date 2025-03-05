import java.util.*;
import java.io.*;

public class Solution {

	static class AP{
		int x, y, c, p;
		AP(int x, int y, int c, int p){
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}
	
	static int M, A;
	static int[] arrA;
	static int[] arrB;
	static int[] dx = {0, 0, 1, 0, -1};
	static int[] dy = {0, -1, 0, 1, 0};
	static ArrayList<AP> aps;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			arrA = new int[M+1];
			arrB = new int[M+1];
			aps = new ArrayList<AP>();

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < M+1; i++) {
				arrA[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < M+1; i++) {
				arrB[i] = Integer.parseInt(st.nextToken());
			}
			
			int x, y, c, p;
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				p = Integer.parseInt(st.nextToken());
				aps.add(new AP(x,y,c,p));
			}
			
			int a_x = 1;
			int a_y = 1;
			int b_x = 10;
			int b_y = 10;
			
			int a_max, b_max;
			int result = 0;
			
			for (int i = 0; i < M+1; i++) {
				a_x += dx[arrA[i]];
				a_y += dy[arrA[i]];
				b_x += dx[arrB[i]];
				b_y += dy[arrB[i]];
				
				boolean[] Acheck = new boolean[A];
				boolean[] Bcheck = new boolean[A];
				
				for (int j = 0; j < A; j++) {
					if(Math.abs(aps.get(j).x - a_x) + Math.abs(aps.get(j).y - a_y) <= aps.get(j).c) {
						Acheck[j] = true;
					}
					if(Math.abs(aps.get(j).x - b_x) + Math.abs(aps.get(j).y - b_y) <= aps.get(j).c) {
						Bcheck[j] = true;
					}
						
				}
				
				 // 매 경우 마다의 합
				int max_sum = 0; // 경우들 중 가장 높은 합
				for (int j = 0; j < A; j++) { //A가 선택한 AP 
					for (int k = 0; k < A; k++) { //B가 선택한 AP
						int sum = 0;
						if(Acheck[j]) {
							sum += aps.get(j).p; 
						}
						
						if(Bcheck[k]) {
							sum += aps.get(k).p;
						}
						
						if(j == k && Acheck[j] && Bcheck[k]) {
							sum /= 2;
							
						}
						
						max_sum = Math.max(max_sum, sum);
					}
				}
				result += max_sum;
			}

		
			System.out.printf("#%d %d\n",t, result);
		}
		
	}

}
