import java.io.*;
import java.util.*;

import Algorithm.Main;

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
    static int[] arr = new int[10];
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    static StringTokenizer st;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
		System.setIn(Main.class.getResourceAsStream("/Algorithm/input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
	    // st = new StringTokenizer(br.readLine());
		
	    // int t =Integer.parseInt(st.nextToken());
	    int t = 10;
	    
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
       	st =  new StringTokenizer(br.readLine());
       	
       	Deque<Integer> deque = new ArrayDeque();
       	
        for(int i = 0; i < 8;i++)
        	deque.add(Integer.parseInt(st.nextToken()));

        
        
    	
    	int idx = 0; // index
    	int add = 1;
    	int curr = 0;
    	
    	while(true) {
    		
    		curr = deque.poll();
    		if(curr - add <= 0) {
    			deque.addLast(0);
    			break;
    		}
    		else
    			deque.addLast(curr-add++);
	
    		if(add == 6)
    			add = 1;
    	}
    	
    	for(int i = 0; i < 8;i++) 
    		sb.append(deque.poll() + " ");
    
    	
    }
	
}