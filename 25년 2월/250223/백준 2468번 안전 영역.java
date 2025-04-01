import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.util.*;

class Pair{
	int x,y,cost;
	
	Pair(){}
	
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {


    static int n, k, cnt = 1;
    static int[][] mp = new int[101][101];
    static int[][]chk;
    static int ans = -1;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    
    public static void main(String[] args) throws IOException {
		System.setIn(Main.class.getResourceAsStream("/Algorithm/input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());

	    n = Integer.parseInt(st.nextToken());
	    ans = 0;

	    solve();
		  
    }

    public static void solve() throws IOException {
        // 입력부
	    for(int i = 1; i <= n;i++){
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        for(int j = 1; j <= n; j++) {
	            mp[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
    	
	    for(int day = 0; day <= 100; day++) {
	    	seek(1,1,day); 
			check(1,1);
		}
	    System.out.print(ans);
   }
	private static void seek(int x, int y, int day) {
		for(int i = x;i <= n ; i++)
			for(int j = y; j <= n; j++) 
				if(mp[i][j] == day)
					mp[i][j] = 0;
	}
	
	private static void check(int x, int y) {
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
        chk = new int[101][101];
		Queue <Pair> que = new LinkedList<>();
		int sum = 0;
		for(int i = x;i <= n ; i++)
			for(int j = y; j <= n; j++) 
				if(mp[i][j] != 0 && chk[i][j] == 0) {
					sum++;
					que.add(new Pair(i,j));
					
					Pair curr = new Pair();
					while(que.isEmpty() == false) {
						curr = que.poll();
						
						for(int k = 0; k < dx.length;k++) {
							int nx = curr.x + dx[k];
							int ny = curr.y + dy[k];
							
							if(nx > n || nx <= 0 || ny > n || ny <= 0 || mp[nx][ny] == 0 || chk[nx][ny] == 1)
								continue;
							chk[nx][ny] = 1;
							que.add(new Pair(nx,ny));							
						}
					}
				}
		ans = Math.max(sum,ans);
	}
}