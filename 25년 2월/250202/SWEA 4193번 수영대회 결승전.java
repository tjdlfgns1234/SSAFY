import java.io.*;
import java.util.*;

class Pair{
	int x,y;
	int time = 0;
	
	Pair(){}
	
	Pair(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}
}

public class Solution {
    static int n, cnt = 1;
    static int sx,sy, ex, ey;
    static int[][] mp = new int[15][15];
    static boolean[][] chk;
    static int ans = -1;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
		//System.setIn(Main.class.getResourceAsStream("/Algorithm/input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
		
	    int t =Integer.parseInt(st.nextToken());

	    for(int testcase = 1; testcase<= t; testcase++) {
			st =  new StringTokenizer(br.readLine());
	        n = Integer.parseInt(st.nextToken());
	        ans = -1;

	        solve();
		  }
    }

    public static void solve() throws IOException {
        // 입력부
	    for(int i = 0; i < n;i++){
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        for(int j = 0; j < n; j++)
	        	mp[i][j] = Integer.parseInt(st.nextToken()); 
	    }
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    sx = Integer.parseInt(st.nextToken()); 
	    sy = Integer.parseInt(st.nextToken());
	    
	    st = new StringTokenizer(br.readLine());
	    ex = Integer.parseInt(st.nextToken()); 
	    ey = Integer.parseInt(st.nextToken()); 
	    
	    bfs();
	    
        System.out.println("#" + cnt++ + " " + ans);
    }
	
    private static void bfs() {
		Queue <Pair> que = new LinkedList<>();
		que.add(new Pair(sx, sy,1));

		chk = new boolean[15][15];
		chk[sx][sy] = true;
			
		Pair curr = new Pair();
		
		while(que.isEmpty() == false) {
			curr = que.poll();
			
			if(curr.x == ex && curr.y == ey) {
				ans = curr.time-1;
				return;
			}
			
			for(int i = 0; i < dx.length; i++) {
				// 상하좌우
		    	int nx = curr.x + dx[i];
		    	int ny = curr.y + dy[i];
		    	
		    	if(nx < 0 || nx >= n || ny < 0 || ny >= n || mp[nx][ny] == 1 || chk[nx][ny])
		    		continue;
		    	
		    	if(mp[nx][ny] == 2) {
		    		// 소용 돌이 일 경우 
		    		if(curr.time%3 ==0) 
		    			que.add(new Pair(nx,ny,curr.time+1));
		    		else
		    			que.add(new Pair(curr.x,curr.y, curr.time+1));
		    		continue;
		    	}
		    	chk[nx][ny] = true;
				que.add(new Pair(nx,ny,curr.time+1));
			}
		}
	}
}