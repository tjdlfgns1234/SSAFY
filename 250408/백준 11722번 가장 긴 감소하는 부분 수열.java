import java.util.*;
import java.io.*;
import java.math.BigInteger;


public class Main {
    static int n,m,k, cnt = 1, sum = 0, ans = 0;
    static int[] arr, dp;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    static StringTokenizer st;
    static final int INF = 987654321;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
 
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
	    // st = new StringTokenizer(br.readLine());
		
	    int t =1;
		//st =  new StringTokenizer(br.readLine());
        //t = Integer.parseInt(st.nextToken());
	    for(int testcase = 1; testcase<= t; testcase++) {
			st =  new StringTokenizer(br.readLine());
	        n = Integer.parseInt(st.nextToken());
	 
	        arr = new int[n];
	        dp = new int[n];
			st =  new StringTokenizer(br.readLine());
	        for(int i = 0; i < n;i++)
	            arr[i] = Integer.parseInt(st.nextToken());
	        
	        solve();

	        System.out.println(ans+1);
		  }
	    br.close();
	    bw.close();
	}

    public static void solve() throws IOException {
    	
    	for(int i = 0; i < n;i++)
    		for(int j = i+1; j < n;j++)
    			if(arr[i] > arr[j])
    				dp[j] = Math.max(dp[j], dp[i] +1);
    	
    	for (int i = 0; i < n; i++)
    		ans = Math.max(ans, dp[i]);
    }
    

}
