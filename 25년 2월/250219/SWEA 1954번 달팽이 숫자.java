import java.io.*;
import java.util.*;

public class Solution {
    static int n;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    static StringTokenizer st;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
		// System.setIn(Main.class.getResourceAsStream("/Algorithm/input2.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
	    st = new StringTokenizer(br.readLine());
		
	    int t =Integer.parseInt(st.nextToken());

	    for(int testcase = 1; testcase<= t; testcase++) {
			st =  new StringTokenizer(br.readLine());
	        n = Integer.parseInt(st.nextToken());
            arr = new int[n][n];
	        solve();
	        
	        sb.append("#" + testcase + '\n');

            for(int i = 0; i < n;i++){
                 for(int j = 0; j < n;j++)
                    sb.append(arr[i][j] + " ");
                 sb.append('\n');
            }
            
		  }
	    bw.write(sb.toString());
	    bw.flush();
    }

    public static void solve() throws IOException {
        int[] dx = {0,-1,0,1};
        int[] dy = {1,0,-1,0};

        int x = 0, y = 0, cnt = 1;
        arr[x][y] = cnt++;
         while(true){
            for(int i = 0;i < 4; i++){
                while(true){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
    
                   if(cnt == n*n+1)
                        break;
                    
                    if(nx < 0 || nx >= n || ny < 0 || ny >=n || arr[nx][ny] != 0)
                        break;
    
                    x = nx;
                    y = ny;
                    arr[x][y] = cnt++;
                }
            }  
            if(cnt == n*n+1)
                break;
        }
    }
	
}