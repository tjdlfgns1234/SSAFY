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
    static int n,m, ans = 0;
    static int idx = 0;
    static int[] sel;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[][] arr;
    static int chk = 0;
    static Pair[] house = new Pair[401];
    
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t;
        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        for(int testcase = 1; testcase<= t;testcase++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            
            arr = new int[n][n];
            ans = 0;
            idx = 0;
            
            for(int i = 0; i < n;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    // 집 위치를 저장하기
                    if(arr[i][j] == 1) 
                    	house[idx++] = new Pair(i,j);
                }
           }
            solve();
            
            // System.out.println(chk);
            
          
            System.out.println("#" + testcase + " " +ans);
        }
        br.close();
        bw.close();
    }
    public static void solve() {
    	// 점을 먼저 찍음
    	for(int i = 0; i < n;i++)
    		for(int j = 0; j < n;j++)
    			for(int k = 1; k <= 21;k++)
    				ans = Math.max(ans, calc(i,j,k));
    }
	private static int calc(int x, int y, int k) {
		// m은 각 집이 낼수 있는 최대 비용
		int cost = k*k+(k-1) * (k-1);
		
		int cnt = 0;
		Pair service = new Pair(x,y);
		for(int i = 0; i < idx;i++) 
			if(dist(house[i], service) < k)
				cnt++;
//		if((cnt*m - cost) >= 0)
//			System.out.println(cnt*m + " " + cost + " " + cnt);
		
		if(0 <= cnt*m - cost) 
			return cnt;
		else
			return 0;
	}
	private static int dist(Pair a, Pair b){
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
}