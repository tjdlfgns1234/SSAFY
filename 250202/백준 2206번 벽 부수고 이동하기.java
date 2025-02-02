// package Algorithm;
import java.io.*;
import java.util.*;

class Pair{
	int x,y,z,cost;
	
	Pair(){}
	
	Pair(int x, int y, int z, int cost) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.cost =cost;
	}
}

public class Main {


    static int n, m;
    static int[][] mp = new int[1001][1001];
    static int[][][] chk;
    static int ans = 987654321;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    
    public static void main(String[] args) throws IOException {
		// System.setIn(Main.class.getResourceAsStream("/Algorithm/input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
        // while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            chk = new int[1001][1001][2];
            solve();
        // }
    }

    public static void solve() throws IOException {
        // 입력부
        for(int i = 1; i <= n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String token = st.nextToken();
            for(int j = 1; j <= m; j++) {
                mp[i][j] = token.charAt(j-1) - '0';
            }
        }
        
        seek(1,1,0,1); 
        
        if(ans == 987654321)
        	ans = -1;
//        
//        for(int i= 1; i <= n;i++) {
//        	for(int j = 1; j <= m;j++) 
//        		System.out.print(chk[i][j][0] + " ");
//        	System.out.println();
//        }
//        
        System.out.println(ans);
   }
    

	private static void seek(int x, int y, int z, int cost) {
		int dx[] = {1,-1,0,0};
		int dy[] = {0,0, 1,-1};
		
		Queue <Pair> q = new LinkedList<>();
		
		Pair tmp = new Pair();
		chk[x][y][0] = cost;
		q.add(new Pair(x,y,z, cost));
		
		// System.out.println("------------------");
		while(q.isEmpty() == false) {
			tmp = q.poll();		
				
			if(tmp.x == n && tmp.y == m) {

				// System.out.println(tmp.x + " " + tmp.y + " " + tmp.cost);
			
				ans = Math.min(tmp.cost,ans);
				return;
			}
			
		
			for(int i = 0; i < dx.length;i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				
				// System.out.println(nx + " " + ny);
				
				if(nx <= 0 || nx > n ||  ny <= 0 || ny > m || chk[nx][ny][tmp.z] != 0)
					continue;
			
				if(mp[nx][ny] == 1) {
					if(tmp.z == 0) {
						chk[nx][ny][tmp.z+1] = tmp.cost+1;
						q.add(new Pair(nx,ny, tmp.z+1,tmp.cost + 1));
						continue;
					}
					else
						continue;
				}
				
				chk[nx][ny][tmp.z] = tmp.cost+1;
				q.add(new Pair(nx,ny, tmp.z,tmp.cost + 1));
			}

	    }
        // 출력 확인
//	      System.out.println("------------------------------");
//	      for(int i = 0; i < h;i++){
//	          for(int j = 0; j < w; j++)
//	              System.out.print(chk[i][j] +" ");
//	          System.out.println();
//	      }
	      
	}
}