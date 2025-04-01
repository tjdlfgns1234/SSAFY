import java.io.*;
import java.util.*;

class Pair{
	int x,y;
	
	Pair(){}
	
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {


    static int h, w;
    static int[][] mp = new int[51][51];
    static boolean[][] chk;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    
    public static void main(String[] args) throws IOException {
		// System.setIn(Main.class.getResourceAsStream("/Algorithm/input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0)
                break;
            chk = new boolean[51][51];
            solve();
        }
    }

    public static void solve() throws IOException {
        // 입력부
        for(int i = 0; i < h;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j++)
                mp[i][j] = Integer.parseInt(st.nextToken());
        }
        
        int ans = 0;
        

        for(int i = 0; i < h;i++)
             for(int j = 0; j < w; j++)
                 if(mp[i][j] == 1) {
                	 if(chk[i][j] == false) {
	                	 seek(i,j); 
	                	 ans++;
                	 }
                 }
        
           
        System.out.println(ans);
   }
    

	private static void seek(int x, int y) {
		int dx[] = {1,-1,0,0, 1, 1, -1, -1};
		int dy[] = {0,0, 1,-1, 1, -1, 1, -1};
		
		Queue <Pair> q = new LinkedList<>();
		
		Pair tmp = new Pair();
		chk[x][y] = true;
		q.add(new Pair(x,y));
		
		// System.out.println("------------------");
		while(q.isEmpty() == false) {
			tmp = q.poll();		
		
			for(int i = 0; i < 8;i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				
				// System.out.println(nx + " " + ny);
				
				if(nx < 0 || nx >= h ||  ny < 0 || ny >= w || chk[nx][ny] == true || mp[nx][ny] == 0)
					continue;
				
				chk[nx][ny] = true;
				q.add(new Pair(nx,ny));
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