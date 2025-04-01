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
    static int n,m, ans = 0, idx =0;
    static int[] sel;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[][] arr;
    static int[][] cost;
    static int chk = 0;
    
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t;
        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        for(int testcase = 1; testcase<= t;testcase++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            
            arr = new int[n][n];
            cost = new int[n][n];
            ans = INF;
            for(int i = 0; i < n;i++) {
                String tmp = br.readLine();
                for(int j = 0; j < n;j++) 
                    arr[i][j] =  tmp.charAt(j) - '0';
            }
            for(int i = 0; i < n;i++) 
                for(int j = 0; j < n;j++) 
                	cost[i][j] = INF;

            solve();
            
            // System.out.println(chk);
            
          
            System.out.println("#" + testcase + " " + cost[n-1][n-1]);
        }
        br.close();
        bw.close();
    }
    public static void solve() {
//        for(int i = 0; i < n;i++) {
//            for(int j = 0; j < n;j++) 
//               System.out.print(arr[i][j] + " ");
//            System.out.println();
//        }
//        
        Queue <Pair> q = new ArrayDeque<>();
        q.add(new Pair(0,0));
        cost[0][0] = 0;
        while(!q.isEmpty()) {
        	Pair cur = q.poll();
        		
        	for(int i = 0; i < dx.length;i++) {
        		int nx = cur.x + dx[i];
        		int ny = cur.y + dy[i];
        		
        		if(nx < 0 || nx >= n || ny < 0 || ny >= n)
        			continue;
        		
        		if(cost[cur.x][cur.y] + arr[nx][ny] < cost[nx][ny]) {
        			q.add(new Pair(nx,ny));
        			cost[nx][ny] = cost[cur.x][cur.y] + arr[nx][ny];
        		}
        	}
        	
        }
    	
    }

}
