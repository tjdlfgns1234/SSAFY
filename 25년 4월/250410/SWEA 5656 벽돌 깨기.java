import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static final int INF = 987654321;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[][] arr;
    static int[][] cpy;
    static int[] sel = new int[13];
    static int n, w,h, ans = 0;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        
        for(int testcase = 1; testcase <= t; testcase++) {
        	st = new StringTokenizer(br.readLine());
    		n = Integer.parseInt(st.nextToken());
    		w = Integer.parseInt(st.nextToken());
    		h = Integer.parseInt(st.nextToken());
    		
    		arr = new int[h][w];
    		ans = INF;

	        for(int i = 0; i < h;i++) {
	        	st = new StringTokenizer(br.readLine());
	        	   for(int j = 0; j < w;j++) 
	        		   arr[i][j] = Integer.parseInt(st.nextToken());
	        }
	        
	        
	        solve();

        	System.out.println("#" + testcase + " " + ans);
        	
        }
        br.close();
        bw.close();
    }
    public static void solve() {
    	setPos(0);
    }
	private static void setPos(int cnt) {
		// 폭탄의 위치를 설정하는 함수
		if(cnt == n) {		
			Simulation();
			return;
		}
		
		for(int i = 0; i < w;i++) {
			sel[cnt] = i;
			setPos(cnt+1);
			sel[cnt] = -1;// 초기화
		}
		
	}
	private static void Simulation() {
		// 배열 복사
		cpy = new int[h][w];
        for(int i = 0; i < h;i++) 
        	for(int j = 0; j < w;j++)       
        		cpy[i][j] = arr[i][j];
        
        // 복사된 배열로 시뮬레이션 시작
		
        boolean f = false;
		for(int i = 0; i < n;i++) {
			if(makeExplosion(i)) {
				f = true;
				break;
			}
			gravity();
		}		
		ans = Math.min(ans, calcScore());
	}
	private static boolean makeExplosion(int stage) {
		// 벽돌을 없애는 함수
		// 불가능한 경우도 포함해야함
		
		// 터트릴 위치의 폭탄 찾기
		int x = -1, y = sel[stage]; // 지금 단계에서 터트릴 행
		for(int i = h-1; i >= 0;i--) 
			if(cpy[i][y] != 0) 
				x = i; // 터트릴 블록의 좌표


		if(x == -1) // 불가능한 경우임
			return true;

		// 연쇄 폭발 가능
		int boom = cpy[x][y];

		
		EXPLOSION(x, y, boom);
		return false;
	}
	private static void EXPLOSION(int x, int y, int boom) {
		// EXPLOSION!
		for(int i = 0; i < boom;i++) {
			for(int j = 0; j < dx.length; j++) {
				int nx = x + dx[j]*i;
				int ny = y + dy[j]*i;
	
				if(nx<0 || nx >=h || ny < 0 || ny >= w)
					continue;
				
				if(cpy[nx][ny] >= 2) {
					int boom2 = cpy[nx][ny];
					cpy[nx][ny] = 0;
					EXPLOSION(nx, ny, boom2);
				}
				cpy[nx][ny] = 0;
			}
		}
	}

	private static void gravity() {
		// 벽돌이 없어지고나서 중력이 작용하는 함수
		int[][] cpy2 = new int[h][w];
      
		int x = h-1, y = 0;// cpy2의 인덱스
	     for(int j = 0; j < w;j++) {
	    	x = h-1;
	    	for(int i = h-1; i >= 0;i--) {
	    		if(cpy[i][j] != 0) 
	    		  cpy2[x--][j] = cpy[i][j];		   
	    	}
	     }
		for(int i = 0; i < h;i++) 
		       for(int j = 0; j < w;j++) 
		    	   cpy[i][j] = cpy2[i][j];
	}

	private static int calcScore() {
		// 남은 벽돌의 개수를 저장하는 함수		
		
		int ret = 0;
		for(int i = 0; i < h;i++) 
		       for(int j = 0; j < w;j++)
		    	   if(cpy[i][j] != 0)
		    		   ret++;
		return ret;
	}
}