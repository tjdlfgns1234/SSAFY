import java.util.*;
import java.io.*;

class Pair{
    int x,y;
    
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}


public class Solution {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static final int INF = 987654321;
    static boolean sel[];
    static int n,m, ans = 0;
    static int[][] arr;
    static int pidx, sidx;
    static int st1, st2;
    static int chk = 0;
    static Pair[] person = new Pair[10];
    static Pair[] stair = new Pair[2];
    
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t= 10;
        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        for(int testcase = 1; testcase<= t;testcase++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            
            pidx = 0;
            sidx = 0;
            arr = new int[n][n];
            ans = INF;
            for(int i = 0; i < n;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n;j++) {
                    arr[i][j] =  Integer.parseInt(st.nextToken());;                        
                    if(arr[i][j] == 1)
                        person[pidx++] = new Pair(i,j);
                    else if(arr[i][j] >= 2) {
                        stair[sidx] = new Pair(i,j);  
                        if(sidx == 0)
                        	st1 = arr[i][j];
                        else
                        	st2 = arr[i][j];
                       sidx++;
                    }
                }
            }
            sel = new boolean[pidx];

            solve();
            
            // System.out.println(chk);
            
          
            System.out.println("#" + testcase + " " + ans);
        }    
    }
    public static void solve() {
        dfs(0,pidx);
    }
    private static void dfs(int idx, int cnt) {
        if(idx == cnt) {        
            ans = Math.min(ans, simulation());
            // System.out.println(ans);
            // chk++;
            return;
        }
        
        sel[idx] = true;
        dfs(idx+1, cnt);
        sel[idx] = false;
        dfs(idx+1, cnt);
    }
    private static int simulation() {
        int[] p = new int[10]; // 각 사람과의 거리
        
        // 각 계단 까지의 거리 저장
        for(int i = 0; i < pidx;i++) 
            if(sel[i]) 
                p[i] = dist(stair[1], person[i]);
            else
                p[i] = dist(stair[0], person[i]);
        
        return move(p);
    }
    private static int move(int[] p) {
    	// 계단을 내려가는 사람
    	Queue <Integer> s1 = new ArrayDeque();
    	Queue <Integer> s2 = new ArrayDeque();
    	
    	
    	int ret = 0;
    	
    	// System.out.println();
    	
    	
        for(int time = 0; ; time++) {
           
        	// 계단에 있는 사람이 내려감
        	if(!s1.isEmpty()) {
        		int s = s1.size();
        		
        		for(int i = 0; i < s; i++) {
        			int tmp = s1.poll() - 1;
        			if(tmp > 0) 
        				s1.add(tmp);
        			else
        				ret++;
        		}
        	}
        	if(!s2.isEmpty()) {
        		int s = s2.size();
         		for(int i = 0; i < s; i++) {
        			int tmp = s2.poll() - 1;
        			if(tmp > 0) 
        				s2.add(tmp);
        			else
        				ret++;
        		}
        	}
        	
        	if(ret == pidx)
        		return time;
        	
        	for(int i = 0; i < pidx;i++) { // 계단으로 가서 이동
            	if(p[i] >=0)
            		p[i]--;
            	else if(p[i] == -1) 
            		if(sel[i]) {
	            		if(s1.size() < 3) {
	            			s1.add(st2);
	            			p[i] = -2; // 계단 내려감
	            		}
            		}
            		else {
            			if(s2.size() < 3) {
	            			s2.add(st1); 
	            			p[i] = -2; // 계단 내려감
            			}
            		}
        	}
        	
//        	for(int i = 0; i < pidx;i++) {
//        		System.out.print(p[i] + " ");
//        	}
//        	 System.out.println();
//        	 System.out.println(st1 + " " + st2);
//        	System.out.println(s1.size() + " " + s2.size());
//        	
        }
    }
    public static int dist(Pair a, Pair b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
}