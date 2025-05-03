import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {
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
		st =  new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
	    for(int testcase = 1; testcase<= t; testcase++) {
			st =  new StringTokenizer(br.readLine());
	        n = Integer.parseInt(st.nextToken());
	 
	        arr = new int[n];
	        dp = new int[n];
			st =  new StringTokenizer(br.readLine());
	        for(int i = 0; i < n;i++)
	            arr[i] = Integer.parseInt(st.nextToken());
	        
	        solve();

	        System.out.println("#" + testcase + " " + ans);
	       //  System.out.println(sb);
		  }
	    br.close();
	    bw.close();
	}

    public static void solve() throws IOException {
    	ArrayList<Integer> list = new ArrayList<>();
    	
    	 for(int i = 0; i < n;i++) {
    		 if(list.isEmpty()) {
    			 list.add(arr[i]);
    			 dp[i] = i;
    		 }
    		 else if(list.get(0)> arr[i]) {
    			 list.set(0,arr[i]);
    			 dp[i] = 0;
    		 }
    		 else if(list.get(list.size()-1) < arr[i]) {
    			 list.add(arr[i]);
    			 dp[i] = list.size()-1;
    		 }
    		 else {
    			int idx = upperBound(list,arr[i]-1);
    			list.set(idx, arr[i]);
    			dp[i] = idx;
    		 }
    	 }
    	 
    	 ans = list.size();
//    	 int idx = ans-1;
//    	 Stack <Integer> s = new Stack<>();
//    	 for(int i = n-1; i >= 0;i--) {
//    		if(dp[i] == idx) {
//    			s.add(list.get(idx));
//    			idx--;
//    		}
//    	 }
//    	 sb = new StringBuilder();
//    	 while(!s.isEmpty()) 
//    		 sb.append(s.pop() + " "); 
//    	 
    		 
    }
   
    public static int upperBound(ArrayList<Integer> list, int target) {
    	int l = 0, r = list.size()-1;
    	
    	int ret = 0;
    	while(l<=r) {
    		int mid = (l+r)/2;
    		// System.out.println(mid);
    		if(target < list.get(mid)) {
    			ret = mid;
    			r = mid -1;
    		}
    		else
    			l = mid+1;
    	}
    	return ret;
    }
    
    

}
