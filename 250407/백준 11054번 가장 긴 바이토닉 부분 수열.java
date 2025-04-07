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
    static int n,m,k, cnt = 1, sum = 0, ans = 0;
    static int[] dp = new int[1001];
    static int[] dp2 = new int[1001];
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    static StringTokenizer st;
    static final int INF = 987654321;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
 
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
	    // st = new StringTokenizer(br.readLine());
		
	    int t =1;
//		st =  new StringTokenizer(br.readLine());
//        t = Integer.parseInt(st.nextToken());
	    for(int testcase = 1; testcase<= t; testcase++) {
			st =  new StringTokenizer(br.readLine());
	        n = Integer.parseInt(st.nextToken());
	 
	        arr = new int[n+1];
	        st =  new StringTokenizer(br.readLine());
	        for(int i = 1; i <= n;i++)
	        	arr[i] = Integer.parseInt(st.nextToken());
	        
	        solve();

	        System.out.println(ans);
		  }
	}

    public static void solve() throws IOException {
    	// 1으로 초기화야!
    	Arrays.fill(dp,1);
    	Arrays.fill(dp2,1);

    	for(int i = 1; i <= n;i++) {
    	  	for(int j = 1; j <= i;j++) {
        		if(arr[j] < arr[i])
        			if(dp[i] < dp[j] + 1)
        				dp[i] = dp[j] + 1;
        	}
    	}
    	
    	for(int i = n; i >= 1;i--) {
	    	for(int j = n; j >= i;j--) {
	    		if(arr[j] < arr[i])
	    			if(dp2[i] < dp2[j] + 1)
	    				dp2[i] = dp2[j] + 1;
	    	}
    	}
    	
    	for(int i = 1; i <= n;i++) {
	    	ans = Math.max(dp[i]+dp2[i] - 1 , ans);
    	}

//    	for(int i = 1; i <=n;i++) 
//    		System.out.print(dp[i] + " ");
//    	System.out.println();
//       	for(int i = 1; i <=n;i++) 
//    		System.out.print(dp2[i] + " ");
//       	System.out.println();
    }

}
