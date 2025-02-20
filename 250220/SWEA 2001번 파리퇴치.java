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
	static int[][] arr = new int[16][16];
	static int n, m;
	static int[] dx = {0,0,-1};
	static int[] dy = {1,-1,0};
	static Pair start;
 	static int ans = 0, q;
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
          	m = Integer.parseInt(st.nextToken());
        	for(int i = 0; i < n;i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j = 0; j < n;j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	

        	ans = 0;
            solve();
        	
        	sb.append("#" + testcase + " " + ans +  "\n");
        }
        System.out.print(sb.toString());
    }
    
    public static void solve() {
    	for(int i = 0; i <= n- m;i++) 
    		for(int j = 0; j <= n - m;j++) 
    			ans = Math.max(ans, calc(i,j,i+m, j+m));
    	
    }
    public static int calc(int x, int y, int x2, int y2) {
    	int sum = 0;
    	for(int i = x; i < x2;i++) 
    		for(int j = y; j < y2;j++) 
    			sum += arr[i][j];

    	return sum;
    }
}
