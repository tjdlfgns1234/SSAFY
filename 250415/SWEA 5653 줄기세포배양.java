import java.util.*;
import java.io.*;

public class Solution {
	
	private class Cell{
		// 셋다 숫자로 받아서, 
		// 활성화 된 시점 + hp면 죽음처리
		int hp, isActive;
		
		Cell(){}
		
		Cell(int hp, int isActive){
			this.hp = hp;
			this.isActive = isActive;
		}
	}
	
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static final int INF = 987654321;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[][] arr;
    static int[][] time;
    
    
    
    // static int pad = 350; // 임시
    static int n, m,k, ans = 0;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        
        for(int testcase = 1; testcase <= t; testcase++) {
        	st = new StringTokenizer(br.readLine());
    		n = Integer.parseInt(st.nextToken());
    		m = Integer.parseInt(st.nextToken());
    		k = Integer.parseInt(st.nextToken());
    		
    		arr = new int[2*n + 2*k][2*m + 2*k];
      		time = new int[2*n + 2*k][2*m + 2*k];
    		ans = 0;
    		
	        for(int i = n+k; i < 2*n+k;i++) {
	        	st = new StringTokenizer(br.readLine());
	        	for(int j = m+k; j < 2*m + k;j++) {
	        		arr[i][j]  = Integer.parseInt(st.nextToken());
	        		
	        		if(arr[i][j] != 0)
	        			time[i][j] = 0;
	        	}
	        }
	        
	        n = 2*n + 2*k;
	        m = 2*m + 2*k;
	        
	   
	
	        solve();

        	System.out.println("#" + testcase + " " + ans);
        	
        }
        br.close();
        bw.close();
    }
    public static void solve() {
    	int t = 1;
    	
    	while(true) {
    		// System.out.println(k + " " + t);
    		Active(t); // 활성화 및 번식 죽이기
      		if(t == k)
    			break;
    		t++;
    	}
    	
    	calc(); // 정답 계산   	
    }
    private static void Active(int t) {
		// 활성화 상태면
        for(int x = 0; x < n;x++) 
	    	for(int y = 0; y < m;y++) {
	    		// System.out.println(x + " " + y);
	    		if(arr[x][y] == 0)
	    			continue;
	    		if(time[x][y] + arr[x][y] + 1 <= t && t<=time[x][y] + 2*arr[x][y]) 
	    			breeding(t, x, y);
	    	}
	}
	private static void breeding(int t, int x, int y) {
		for(int l = 0; l < dx.length;l++) {
			int nx = x + dx[l];
			int ny = y + dy[l];
			
			// 벽은 무한함
			// time은 활성화된 시간을 저장하는 배열
			// arr는 생명력을 저장하는 배열
			// 죽으면 죽은 상태로 차지하게됨
			if(nx < 0 || nx >= n || ny < 0 || ny>= m)
				continue;
	
			if(arr[nx][ny] == 0) {
				arr[nx][ny] = arr[x][y];
				time[nx][ny] = t;
			}
			else if(time[nx][ny] == t) {
				// 같은 시기에 번식하려고 하면 더큰걸 택함
				// 죽은걸 가져가지 않음
				arr[nx][ny] = Math.max(arr[nx][ny], arr[x][y]);
			}
			
		}
	}
	private static void calc() {
		int ret = 0;
		
	    for(int i = 0; i < n;i++) 
	    	for(int j = 0; j < m;j++) 
	    		if( k < time[i][j] + 2*arr[i][j])
	    			ret++;
	    
	    ans = ret;
	}
}