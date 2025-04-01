import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
	static boolean[] vit;
	static int n,m, ans = 0;
	
	public static void main(String[] args) throws IOException{
		//--------------솔루션 코드를 작성하세요.--------------------------------
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
	
		int x, y;
		
		for(int i = 0; i <= n;i++)
			arr.add(new ArrayList<>());
		
		for(int i = 0; i < m;i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			// 양방향 처리
			arr.get(x).add(y);
			arr.get(y).add(x);
		}
		
		solve();
		
		System.out.println(ans);
	}

	private static void solve() {	
		bfs(1);
	}

	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		vit = new boolean[501];
		
		int ret = 0;
		vit[1] = true;
		for(int i = 0; i < arr.get(1).size();i++) {
			int next = arr.get(1).get(i);
			// System.out.println(next);
			if(!vit[next]) {
				vit[next] = true;
				q.add(next);
				ret++;
			}
		}
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for(int i : arr.get(curr)) 
				if(!vit[i]) {
					vit[i] = true; 
					ret++;
				}
		}
		ans = ret;
		
	}

}
