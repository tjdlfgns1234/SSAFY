import java.io.*;
import java.util.*;

class Pair {
	int x,y;
	
	Pair(){}
	
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
}


public class Main {
	static int[][] arr = new int[301][301];
	static int n, m, r;
	static int[] dx = {0,0,-1};
	static int[] dy = {1,-1,0};
	static Pair start;
 	static int ans = 0, q;
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
    	// System.setIn(Main.class.getResourceAsStream("input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
    	st = new StringTokenizer(br.readLine());

    	n = Integer.parseInt(st.nextToken());
     	m = Integer.parseInt(st.nextToken());
     	r = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < n;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < m;j++) 
        		arr[i][j] = Integer.parseInt(st.nextToken());
        }
        
        ans = 0;
        solve();
       	
        System.out.print(sb.toString());
    }
    
    public static void solve() {
    	// 배열 돌리기
    	// 반시계 방향 => 죄상에서 시작
    	
    	for(int i = 0; i < r;i++) 
    		for (int j = 0; j < Math.min(n, m)/2;j++)
    			rotate(j);

        for(int i = 0; i < n;i++) {
        	for(int j = 0; j < m;j++) 
        		sb.append(arr[i][j] + " ");
        	sb.append("\n");
        }
        
    	
    }
    public static void rotate(int cnt) {
    	// 둘중 하나는 무조건 짝수
    	
    	int tmp = arr[cnt][cnt];
    	int tmp2 = 0;
    	// 아래쪽으로 내려감
    	int x = cnt, y = cnt;
    	
    	for(int i = cnt; i <n - 1 - cnt;i++) {
    		tmp2 = arr[i+1][cnt];
    		arr[i+1][cnt] = tmp;
    		tmp = tmp2;
    	}

    
    	// 오른쪽으로 감
    	x = n-1 - cnt;
    	for(int i = cnt + 1; i <m - cnt;i++) {
    		tmp2 = arr[x][i];
    		arr[x][i] = tmp;
    		tmp = tmp2;
    	}

  	
    	// 위로감
    	y = m-1 - cnt;
     	for(int i = 1; i <n - 1 - 2*cnt ;i++) {
    		tmp2 = arr[x-i][y];
    		arr[x-i][y] = tmp;
    		tmp = tmp2;
    	}

     	

     	// 왼쪽으로 감
     	x = cnt;
     	for(int i = 0; i <m - 1 - 2*cnt;i++) {
     		tmp2 = arr[x][y-i];
    		arr[x][y-i] = tmp;
    		tmp = tmp2;
  
    	}
  		// System.out.println(tmp);
    	y = cnt;
     	arr[x][y] = tmp;
     	
    }
}
