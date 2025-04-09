import java.util.*;
import java.io.*;
import java.math.BigInteger;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {
    static int n,m,k, cnt = 1, sum = 0, ans = 0;
    static int[][] arr;
    static int[][] dp;
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
	        ans = INF;
	        arr = new int[n][n];
	        for(int i = 0; i < n;i++)
	        	for(int j = 0; j < n;j++)
	        		arr[i][j] = Integer.parseInt(st.nextToken());
	        
	        solve();
	        
	        System.out.println("#" + testcase + " " + ans);
		  }
	    br.close();
	    bw.close();
	}

    public static void solve() throws IOException {
    	for(int i = 0; i < n;i++) 
        	for(int j = 0; j < n;j++)
        		if(arr[i][j] == 0)
        			arr[i][j] = INF;
    	
    	for(int k = 0; k < n;k++)
	    	for(int i = 0; i < n;i++) 
	        	for(int j = 0; j < n;j++)
	        		arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);

    	for(int i = 0; i < n;i++) {
    		int sum = 0;
        	for(int j = 0; j < n;j++)
    			if(i != j)
    				sum+= arr[i][j];
        	ans =Math.min(ans, sum);
    	}
    	
    	
//    	for(int i = 0; i < n;i++) {
//        	for(int j = 0; j < n;j++)
//        		System.out.print(arr[i][j] + " ");
//        	System.out.println();
//    	}
//    	System.out.println();
    }
}
