import java.io.*;
import java.util.*;

class Pair{
	int x,y;
	
	Pair(){
	}
	
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
}

public class Solution {
    static int n,k, cnt = 1;
    static int[][] dp = new int[101][1001];
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    static StringTokenizer st;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
		// System.setIn(Main.class.getResourceAsStream("/Algorithm/input2.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
	    st = new StringTokenizer(br.readLine());
		
	    int t =Integer.parseInt(st.nextToken());

	    for(int testcase = 1; testcase<= t; testcase++) {
			st =  new StringTokenizer(br.readLine());
	        n = Integer.parseInt(st.nextToken());

	        sb.append("#" + testcase + " ");
	        solve();
	        
	        sb.append('\n');
		  }
	    bw.write(sb.toString());
	    bw.flush();
    }

    public static void solve() throws IOException {
        
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    	
    	// 쿼리 수야!
    	int q;
    	for(int i = 0; i < n;i++) {
			st =  new StringTokenizer(br.readLine());
	        q = Integer.parseInt(st.nextToken());
	        
	        if(q == 1) {
	        	int x = Integer.parseInt(st.nextToken());
	        	
	        	pq.add(-x);
	        }
	        else if(q == 2) {
	        	if(pq.isEmpty()) 
	        		sb.append(-1 + " ");
	        	else
	        		sb.append(-pq.poll() + " ");
	        }    			
  
    	}
    }
	
}