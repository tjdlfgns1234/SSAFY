package test;

import java.io.*;
import java.util.*;

class Pair {
	int x,y;
	
	Pair(){}
	
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
}


public class Solution {
	static int n, m;
	static Pair start;
	static int [][] arr;
	static boolean [][] vit  = new boolean[1001][1001];;
 	static int ans = 0, ans2 = 0;
 	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
    	// st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(br.readLine());
        // int T = 10;
        for (int testcase = 1 ; testcase <= T ; testcase++) {
    		st = new StringTokenizer(br.readLine());
        	n = Integer.parseInt(st.nextToken());
        	arr = new int[n][n];
        	ans = 0;
        	for(int i = 0; i < n;i++) {
            	st = new StringTokenizer(br.readLine());
        		for(int j = 0; j < n;j++) 
        			arr[i][j] = Integer.parseInt(st.nextToken());
        	}        
        	
            solve();
           
        	// System.out.println(test);
        	
        	sb.append("#" + testcase + " "+ ans2  + " " + ans +  "\n");
        }
        System.out.print(sb.toString());
    }
    
    public static void solve() {
      	for(int i = 0; i < n;i++) {
    		for(int j = 0; j < n;j++) 
    		 	dfs(i,j,i,j, 1);
    	}   
    }

	private static void dfs(int sx, int sy, int x, int y, int num) {
		// 더이상 방문이 불가능 할 때 까지 탐색
		if(ans < num) {
			ans = num;
			ans2 = arr[sx][sy];
		}else if(ans == num) 
			if(arr[sx][sy] < ans2)
				ans2 = arr[sx][sy];
		
		
		vit[x][y] = true;
		for(int i = 0; i < dx.length;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= n || ny < 0 || ny >= n || vit[nx][ny])
				continue;
			
			if(arr[x][y] + 1 == arr[nx][ny])
				dfs(sx, sy, nx,ny, num+1);
		}
		vit[x][y] = false;
		
	}
}
