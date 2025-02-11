import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class pair{
	int x;
	int y;
	
	pair(){
		
	}
	
	pair(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
}


public class Main {

	static String[] mp = new String[5]; 
	static int[] dx = {0,1, 0,-1};
	static int[] dy = {1,0,-1,0};
	static boolean[] sel = new boolean[26];
	static long ans = 0;
	static int n = 5;
	static int test = 0;
	static BufferedReader br;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("./input.txt"));
		//---------여기에 코드를 작성하세요.---------------//
		br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < n;i++) { 
			
			mp[i] = br.readLine();
		}
		
		
		
//		for(int i = 0; i < n;i++) 
//			System.out.println(s[i]);
//		
		
		solve();
	}
	public static void solve() throws IOException {
		/*	25명의 여학생
		 * 	7명의 여학생
		 *  7명의 자리를 가로나 세로로 인접! (상하죄우 탐색)
		 *  반드시 '이다솝파의 학생으로만 구성될 필요 X'
		 *  이다솜파의 학생이 적어도 4명이상 반드시 포함되어있어야 한다.
		 */
		
		seek(0,0);
	
		System.out.println(ans);
	}
	private static void seek(int idx, int cnt) {
		if(cnt == 7) {
		
			
//			for(int q = 0;q < n;q++) {
//				for(int w = 0; w < n;w++) 
//					System.out.print((vit[q][w]?1:0) + " ");
//				System.out.println();
//			}
//			System.out.println();
//		
			
			//System.out.println(i + " " + j + " " + cnt);
			if(check())
				ans++;
			
			return;
		}
		
		if(idx == 25)
			return;
		
		for(int q = idx; q < 25;q++) {
			if(!sel[q]) {
				test = q;
				sel[q] = true;
				seek(q+1,cnt+1);
				sel[q] = false;
			}
		}

	}
	private static boolean check() {
		int x = test/5;
		int y = test%5;


		Queue <pair> que = new ArrayDeque<pair>();
		
		boolean [][] arr = new boolean[5][5];
		
		
		que.add(new pair(x,y));
		arr[x][y] = true;
		int cnt = 1;
		int sy = 0;
		
		if(mp[x].charAt(y) == 'Y')
			sy++;
		
		while(!que.isEmpty()) {
			pair curr = que.poll();
			for(int i = 0; i < dx.length;i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
						
				if(nx < 0 || nx >= n || ny < 0 || ny >= n || !sel[nx*5 + ny] || arr[nx][ny])
					continue;
				
				arr[nx][ny] = true;
				if(mp[nx].charAt(ny) == 'Y')
					sy++;
				
				if(sy >= 4)
					return false;
				

				cnt++;
				que.add(new pair(nx,ny));	
			}
		}
//
//		if(cnt == 7)
//			System.out.println(sy + " " + cnt);

		
		return cnt==7?true:false;
	}
}