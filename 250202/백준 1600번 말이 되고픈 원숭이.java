package Algorithm;
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


    static int n, m, k;
    static int[][] mp = new int[201][201];
    static int[][][] chk;
    static int ans = -1;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    
    public static void main(String[] args) throws IOException {
		System.setIn(Main.class.getResourceAsStream("/Algorithm/input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
		
	    k =Integer.parseInt(st.nextToken());


		st =  new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        chk = new int[201][201][31];
        solve();
		
    }

    public static void solve() throws IOException {
        // 입력부
	        for(int i = 1; i <= n;i++){
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            for(int j = 1; j <= m; j++) {
	                mp[i][j] = Integer.parseInt(st.nextToken());
	            }
	        }
    	
        
        seek(1,1,0,0); 
//        
//        for(int l = k; l <= k;l++) {
//	        for(int i= 1; i <= n;i++) {
//	        	for(int j = 1; j <= m;j++) 
//	        		System.out.print(mp[i][j]+ " ");
//	        	System.out.println();
//	        }
//        }
//        
        System.out.println(ans);
   }
    

	private static void seek(int x, int y, int z, int cost) {
		int dx[] = {1,-1,0,0, 2 ,2, -2, -2, 1,-1,1,-1};
		int dy[] = {0,0, 1,-1, 1, -1,1 ,-1, 2, 2,-2, -2};
		
		Pair tmp = new Pair();
		Queue <Pair> q = new LinkedList<>();

		q.add(new Pair(x,y,z,cost));
		
		// System.out.println("------------------");
		while(q.isEmpty() == false) {
			tmp = q.poll();					
		
			if(tmp.x == n && tmp.y == m){
				ans = tmp.cost;
				return;
			}
			
			
			for(int i = 0; i <4;i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				// System.out.println(nx + " " + ny);
				
				if(nx <= 0 || nx > n ||  ny <= 0 || ny > m)
					continue;
		
				if(mp[nx][ny] != 0 || chk[nx][ny][tmp.z] != 0)
					continue;
				
				chk[nx][ny][tmp.z] = tmp.cost+1;
				q.add(new Pair(nx,ny, tmp.z,tmp.cost + 1));
			}
			
			// 나이트 처럼 이동
			for(int i = 4; i <dx.length;i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				// System.out.println(nx + " " + ny);
				
				if(nx <= 0 || nx > n ||  ny <= 0 || ny > m || tmp.z+1 > k)
					continue;
		
				if(mp[nx][ny] != 0 || chk[nx][ny][tmp.z+1] != 0)
					continue;
				
				chk[nx][ny][tmp.z+1] = tmp.cost+1;
				q.add(new Pair(nx,ny, tmp.z+1,tmp.cost + 1));
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