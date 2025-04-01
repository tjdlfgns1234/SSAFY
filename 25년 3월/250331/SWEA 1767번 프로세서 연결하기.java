import java.util.*;
import java.io.*;

class Pair{
    int x,y;
    
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}


public class Solution {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static final int INF = 987654321;
    static boolean sel[];
    static int n,m, ans = 0, v;
    static int[][] arr;
    static Pair[] chips = new Pair[13];
    static int cidx = 0;
    static int chk = 0;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t= 10;
        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        for(int testcase = 1; testcase<= t;testcase++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            
            cidx = 0;
            v = 0;
            arr = new int[n][n];
            ans = INF;
            for(int i = 0; i < n;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n;j++) {
                    arr[i][j] =  Integer.parseInt(st.nextToken()); 
                    
                    if(arr[i][j]==1) 
                    	if(i != 0 && i != n-1 && j != 0 && j !=n-1) 
                    		chips[cidx++] = new Pair(i,j); 
                }
            }
            solve();
              
            System.out.println("#" + testcase + " " + ans);
        }    
    }
    public static void solve() {
        dfs(0,0,0);
    }
    private static void dfs(int idx, int cnt, int cost) {
        if(idx == cidx) {        
        
        	if(v < cnt) {
        		v = cnt;
        		ans = cost;
        	}
        	else if(v == cnt) {
        		ans = Math.min(ans, cost);
        	}

            return;
        }
        
		dfs(idx+1,cnt,cost);
        
        for(int i = 0; i < 4;i++) {
        	// 한방향으로 뻣어나감
        	int c = 0;
        	int nx = chips[idx].x;
        	int ny = chips[idx].y;
        	boolean f = false;
        	while(true) {
        		nx = nx + dx[i];
             	ny = ny + dy[i];
             	
        	 	if(nx < 0 || nx >= n || ny < 0 || ny>= n ) {
            		break;
        	 	}
        	 	if(arr[nx][ny]!=0) {
        	 	    f = true;
        	 	    break;
        	 	}
        	 	
        	 	c++;
        	 	arr[nx][ny] = 2;
        	}
        	
        	if(!f)
        		dfs(idx+1,cnt+1,c+cost);
        	
        	while(true) {
        		nx = nx - dx[i];
             	ny = ny - dy[i];
             	
        	 	if(nx < 0 || nx >= n || ny < 0 || ny>= n)
            		break;
        	 	
        		if(arr[nx][ny] !=2) {
        	 	    break;
        	 	}
        	 	arr[nx][ny] = 0;
        	} 	
        }
    }


}