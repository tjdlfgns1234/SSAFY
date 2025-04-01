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
	static int[][] arr = new int[101][101];
	static int[][] vit;
	static int n = 100;
	static int[] dx = {0,0,-1};
	static int[] dy = {1,-1,0};
	static Pair start;
 	static int ans = 0, q;
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        // int T = Integer.parseInt(br.readLine());
        int T = 10;
        for (int testcase = 1 ; testcase <= T ; testcase++) {
    		st = new StringTokenizer(br.readLine());
        	q = Integer.parseInt(st.nextToken());
        	for(int i = 0; i < 100;i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j = 0; j < 100;j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        			if(arr[i][j] == 2)
        				start = new Pair(i,j);
        		}
        	}
        	
        	vit = new int[101][101];
        	ans = 0;
            solve();
        	
        	sb.append("#" + testcase + " " + ans +  "\n");
        }
        System.out.print(sb.toString());
    }
    
    public static void solve() {
    	// 사다리 타기
    	
    	int x = start.x;
    	int y = start.y;
		vit[x][y] = 1;
    	while(true) {
    		
    		if(x == 0) {
    			ans = y;
    			break;
    		}
    		
    		for(int i = 0; i < 3;i++) {
    			int nx = x + dx[i];
    			int ny = y + dy[i]; 
    			
    			if(nx< 0 || nx >= n || ny < 0 || ny >=n || arr[nx][ny] == 0 || vit[nx][ny] == 1) 
    				continue;
    			vit[nx][ny] = 1;
    			x = nx;
    			y = ny;
    			
    			break;
    		}
    	}    	
    }
}
