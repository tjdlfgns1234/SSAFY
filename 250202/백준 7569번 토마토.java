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


    static int n, m, h;
    static int[][][] mp = new int[101][101][101];
    static int[][][] chk;
    static int ans = -1;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    
    public static void main(String[] args) throws IOException {
		// System.setIn(Main.class.getResourceAsStream("/Algorithm/input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
        // while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            chk = new int[101][101][101];
            solve();
        // }
    }

    public static void solve() throws IOException {
        // 입력부
    	for(int k = 1; k<= h; k++) {
	        for(int i = 1; i <= n;i++){
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            for(int j = 1; j <= m; j++) {
	                mp[i][j][k] = Integer.parseInt(st.nextToken());
	            }
	        }
    	}
        
        seek(1,1,1,0); 
        for(int k = 1; k<= h; k++) {
	        for(int i= 1; i <= n;i++) {
	        	for(int j = 1; j <= m;j++) 
	        		if(chk[i][j][k] == 0 && mp[i][j][k] == 0) {
	        			ans = -1;
	        		    System.out.println(ans);
	        		    return;
	        		}
	        		else
	        			ans = Math.max(ans, chk[i][j][k]);
	        }
        }
//        
//        for(int k = 1; k <= h;k++) {
//	        for(int i= 1; i <= n;i++) {
//	        	for(int j = 1; j <= m;j++) 
//	        		System.out.print(chk[i][j][k]+ " ");
//	        	System.out.println();
//	        }
//        }
        
        System.out.println(ans);
   }
    

	private static void seek(int x, int y, int z, int cost) {
		int dx[] = {1,-1,0,0, 0 ,0};
		int dy[] = {0,0, 1,-1, 0, 0};
		int dz[] = {0,0, 0,0, 1,-1 };
		Pair tmp = new Pair();
		Queue <Pair> q = new LinkedList<>();
		
		for(int k = 1; k <= h;k++) {
			for(int i = 1; i<= n;i++)
				for(int j = 1; j <= m;j++) 
					if(mp[i][j][k] == 1) {
						chk[i][j][k] = cost;
						q.add(new Pair(i,j,k,cost));
					}
		}

		
		// System.out.println("------------------");
		while(q.isEmpty() == false) {
			tmp = q.poll();					
		
			for(int i = 0; i < dx.length;i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				int nz = tmp.z + dz[i];
				// System.out.println(nx + " " + ny);
				
				if(nx <= 0 || nx > n ||  ny <= 0 || ny > m || nz <= 0 || nz>h)
					continue;
		
				if(mp[nx][ny][nz] != 0 || chk[nx][ny][nz] != 0)
					continue;
				
				chk[nx][ny][nz] = tmp.cost+1;
				q.add(new Pair(nx,ny, nz,tmp.cost + 1));
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