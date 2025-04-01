import java.io.*;
import java.util.*;

//SEWA 2월 2일 기준 JAVA 실행시간 1등! 99ms

public class Solution {
    static int r,c, cnt = 1;
    static String[] mp = new String[21];
    static int ans = -1;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
    static BufferedReader br;
    
    public static void main(String[] args) throws IOException {
		// System.setIn(Main.class.getResourceAsStream("/Algorithm/input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
		
	    int t =Integer.parseInt(st.nextToken());

	    for(int testcase = 1; testcase<= t; testcase++) {
			st =  new StringTokenizer(br.readLine());
	        r = Integer.parseInt(st.nextToken());
	        c = Integer.parseInt(st.nextToken());
	        ans = 0;

	        solve();
		  }
    }

    public static void solve() throws IOException {
        // 입력부
	    for(int i = 0; i < r;i++){
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        mp[i] = st.nextToken(); 
	        
	    }
	    dfs(0,0,1, (1 <<(mp[0].charAt(0) - 'A')));

        System.out.println("#" + cnt++ + " " + ans);
   }
	
	private static void dfs(int x, int y, int cnt, int chk) {
		ans = Math.max(ans,cnt);
		
        if(ans == 26)
            return;

	    for(int i = 0; i < dx.length; i++) {
	    	int nx = x + dx[i];
	    	int ny = y + dy[i];
	    	
	    	if(nx < 0 || nx >= r || ny < 0 || ny >= c)
	    		continue;
	    	
	    	int value = mp[nx].charAt(ny) - 'A';
	    	
	    	if((chk & (1<< value)) == 0){
                dfs(nx,ny,cnt+1,chk | (1<< value));
            }
	    }
	}
}