import java.util.*;
import java.io.*;

class Pair{
	int x,y;
	
	Pair(){
	}
	
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
    static int n,m,k, cnt = 1, sum = 0;
    static int[][] dp = new int[1001][10001];
    static int[] coin;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    static StringTokenizer st;
    static final int INF = 987654321;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
 
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
	    // st = new StringTokenizer(br.readLine());
		
	    int t =1;
		st =  new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
	    for(int testcase = 1; testcase<= t; testcase++) {
			st =  new StringTokenizer(br.readLine());
	        n = Integer.parseInt(st.nextToken());
	 
	        coin = new int[n+1];
	        st =  new StringTokenizer(br.readLine());
	        for(int i = 1; i <= n;i++)
	        	coin[i] = Integer.parseInt(st.nextToken());
	        
	        st =  new StringTokenizer(br.readLine());
	        k = Integer.parseInt(st.nextToken());
	        solve();

	        System.out.println(dp[n][k]);
		  }
	}

    public static void solve() throws IOException {
    	// 0으로 초기화야!
    	for(int i = 0; i <= n;i++)
    		Arrays.fill(dp[i], 0);

		for(int i = 0; i <=n;i++) 
			dp[i][0]=1;
    

		for(int i = 1; i <=n;i++) 
			for(int value = 1; value <= k;value++) {
				dp[i][value] = dp[i-1][value];
    			if(value - coin[i] >= 0) 
    				dp[i][value] += dp[i][value-coin[i]];

			}
	
//    	for(int i = 0; i <=n;i++) {
//    		for(int j = 0; j <= k;j++) 
//    			System.out.print(dp[i][j] + " ");
//    		System.out.println();
//    	}
    	
    	
    }

}
