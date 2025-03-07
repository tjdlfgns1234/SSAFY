import java.io.*;
import java.util.*;

class Virus {
    int x, y, size, dir;

    Virus() {
    }

    Virus(int x, int y, int size, int dir) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.dir = dir;
    }

}

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static Virus[] virus;
    static int[]dx = { 1,0,-1,0};
    static int[] dy = { 0,1,0,-1};
    static int mp[][];
    static int chk[][];
    static int n, m, ans;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = 987654321;
        
        mp = new int[n][m];
        chk = new int[n][m];
        for(int i = 0; i < n;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < m;j++) 
        		mp[i][j] =  Integer.parseInt(st.nextToken());
        }
        
        solve();
    	System.out.println(ans);
    }

    private static void solve() {
    	dfs(0, 0);
    }

	private static void dfs(int x, int y) {
		if(x == n && y == 0) {
			ans = Math.min(ans, Calc());
			return;
		}
		
		// CCTV를 돌리고 채워야 한다.
		// 표시는 -1로 표기함

		if(0 < mp[x][y] && mp[x][y] < 6) {
			//  CCTV 인 경우
			for(int i = 0; i< 4;i++) { // 0도, 90도, 180도, 270도 회전
				fillBlank(x, y, mp[x][y],i);
				
				if(y == m-1) 
					dfs(x+1, 0);
				else 
					dfs(x, y+1);
				
				makeBlank(x, y, mp[x][y],i);
			}
		}
		
		if(y == m-1) 
			dfs(x+1, 0);
		else 
			dfs(x, y+1);
	}

	private static void makeBlank(int x, int y, int type, int dir) {
		if(type == 1) {
			// 1번의 경우
			// 한 방향만 찍으면 됨
			blank(dir, x, y);
		}
		else if(type == 2) {
			// 2번의 경우
			// 두 방향을 찍어야함

			blank(dir, x, y);
			dir = (dir+2)%4;
			blank(dir, x, y);
			
		}	
		else if(type == 3) {
			// 3번의 경우			
			blank(dir, x, y);
			dir = (dir+1)%4;
			blank(dir, x, y);
			
		}
		else if(type == 4) {
			// 4번의 경우
			for(int i = 0; i < 3;i++) {
				blank(dir, x, y);	
				dir = (dir+1)%4;
			}
		}
		else if(type == 5) {
			// 5번의 경우
			for(int i = 0; i < 4;i++) {
				blank(dir, x, y);
				dir = (dir+1)%4;
			}
		}	
		
	}

	private static void fillBlank(int x, int y, int type, int dir) {
		if(type == 1) {
			// 1번의 경우
			// 한 방향만 찍으면 됨
			fill(dir, x, y);
		}
		else if(type == 2) {
			// 2번의 경우
			// 두 방향을 찍어야함
			fill(dir, x, y);
			dir = (dir+2)%4;
			fill(dir, x, y);
			
		}	
		else if(type == 3) {
			// 3번의 경우			
			fill(dir, x, y);
			dir = (dir+1)%4;
			fill(dir, x, y);
			
		}
		else if(type == 4) {
			// 4번의 경우
			for(int i = 0; i < 3;i++) {
				fill(dir, x, y);	
				dir = (dir+1)%4;
			}
		}
		else if(type == 5) {
			// 5번의 경우
			for(int i = 0; i < 4;i++) {
				fill(dir, x, y);
				dir = (dir+1)%4;
			}
		}	
	}

	private static void fill(int dir, int nx, int ny) {
		for(; ;) {
			nx = nx + dx[dir];
			ny = ny + dy[dir];
			
			if(nx < 0 || nx >= n || ny < 0 || ny >= m || mp[nx][ny] == 6 )
				break;
			
			chk[nx][ny]++;
		}
	}
	
	private static void blank(int dir, int nx, int ny) {
		for(; ;) {
			nx = nx + dx[dir];
			ny = ny + dy[dir];
			
			if(nx < 0 || nx >= n || ny < 0 || ny >= m || mp[nx][ny] == 6 )
				break;
			
			chk[nx][ny]--;
		}
	}


	private static int Calc() {
		int ret = 0;
		  for(int i = 0; i < n;i++) 
			   for(int j = 0; j < m;j++) 
				   if(mp[i][j] == 0 && chk[i][j] == 0)
					   ret++;
		return ret;
	}


}
