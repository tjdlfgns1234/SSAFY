import java.io.*;
import java.util.*;

class BC {
    int x, y;
    int c, p;

    BC() {
    }

    BC(int x, int y, int c, int p) {
        this.x = x;
        this.y = y;
        this.c = c;
        this.p = p;
    }

}

public class Solution {

	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int[] a, b;
	static int[] dx = {0,-1,0,1,0};
	static int[] dy = {0,0,1,0,-1};
	static BC [] arr;
	static int n,m,T, ans;
	static int ax, ay, bx, by;

	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		for(int testcase = 1; testcase <= T;testcase++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
	
			a = new int[n];
			b = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n;i++) 
				a[i] = Integer.parseInt(st.nextToken());
				
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n;i++) 
				b[i] = Integer.parseInt(st.nextToken());

			arr = new BC[m];
			
			for(int i = 0; i < m;i++) {
				st = new StringTokenizer(br.readLine());	
				arr[i] = new BC();
				arr[i].y = Integer.parseInt(st.nextToken());
				arr[i].x = Integer.parseInt(st.nextToken());
				arr[i].c = Integer.parseInt(st.nextToken());
				arr[i].p = Integer.parseInt(st.nextToken());			
			} 

			ax = 1;
			ay = 1;
			bx = 10;
			by = 10;
			
			ans = 0;
			
			solve();
			
			System.out.println("#" + testcase + " " + ans);
		}
	}

	private static void solve() {
		// 사용자는 초기 위치부터 충전할 수 있다. b
		charge(0);
		for(int i = 0; i < n;i++) {
			move(i);
			charge(i+1);
		
		}
	}
	private static void charge(int idx) {
		int sum = 0;
		for(int i = 0; i < m;i++) {
			for(int j = 0; j < m;j++) {
				int x =0, y =0;
				if(check(i,1))  // 정류소가 사용가능한지 확인
					x = arr[i].p;							
				if(check(j,2)) 
					y = arr[j].p;				
				if(i == j && x != 0 && y !=0) {
					 x=  x/2;
					 y = y/2;
				}	
				sum = Math.max(sum, x+y);
			}
		} 
		ans += sum;
		//System.out.println("# "+(idx) + " " +sum);
	}

	private static void move(int idx) {
		ax =ax + dx[a[idx]];
		ay =ay + dy[a[idx]];

		bx =bx + dx[b[idx]];
		by =by + dy[b[idx]];
	}
	private static boolean check(int i, int who) {		
		if(who == 1) {
			if(dist(arr[i].x, arr[i].y, ax,ay) <= arr[i].c )
				return true;
		}
		else if(who == 2) {
			if(dist(arr[i].x, arr[i].y, bx,by) <= arr[i].c )
				return true;
		}
	
		return false;
	}
	
	
	private static int dist(int x, int y, int x2, int y2) {
		return Math.abs(x - x2) + Math.abs(y - y2);
	}
}{

}
