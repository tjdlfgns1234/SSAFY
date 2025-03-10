package SWEA;
import java.io.*;
import java.util.*;

class Pair {
    int x, y;

    Pair() {
    }

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static Pair[] virus = new Pair[10];
    static int[]dx = { 1,0,-1,0};
    static int[] dy = { 0,1,0,-1};
    static int mp[][];
    static boolean chk[][];
    static int n, m, ans = 0;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        mp = new int[n][m];

        for(int i = 0; i < n;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < m;j++) 
        		mp[i][j] =  Integer.parseInt(st.nextToken());
        }
        
        solve();
    	System.out.println(ans);
    }

    private static void solve() {
    	
    	makeWall(0);
    }

	private static void makeWall(int cnt) {
		if(cnt == 3) {
			
			ans = Math.max(checkSafeArea(), ans);
			
			return;
		}
		
		for(int i = 0; i < n;i++) 
			for(int j = 0; j < m;j++) 
				if(mp[i][j] == 0) {
					mp[i][j] = 1;
					makeWall(cnt+1);
					mp[i][j] = 0;
				}
	}

	private static int checkSafeArea() {
        chk = new boolean[n][m];
		
		Queue <Pair> q = new ArrayDeque<>();
		for(int i = 0; i < n;i++) 
			for(int j = 0; j < m;j++) 
				if(mp[i][j] == 2)
					q.offer(new Pair(i,j));
		
		while(!q.isEmpty()) {
			Pair curr = q.poll();
			
			for(int i = 0; i < dx.length;i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >=m )
					continue;
				
				if(chk[nx][ny] || mp[nx][ny] != 0)
					continue;
				
				chk[nx][ny] = true;
				q.add(new Pair(nx,ny));
			}
		}
		
		int ret = 0;
        
		for(int i = 0; i < n;i++) 
			for(int j = 0; j < m;j++) 
				if(!chk[i][j] && mp[i][j] == 0 )
					ret++;
		
		
		return ret;
	}



}
