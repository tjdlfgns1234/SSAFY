import java.util.*;
import java.io.*;


public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static int n, m, ans = 0;
    static ArrayList<ArrayList<Integer>> g;
    static ArrayList<ArrayList<Integer>> rev;
    
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        
        for(int testcase = 1; testcase <= t; testcase++) {
        	st = new StringTokenizer(br.readLine());
    		n = Integer.parseInt(st.nextToken());
    		
    		st = new StringTokenizer(br.readLine());
    		m = Integer.parseInt(st.nextToken());
    		
    		ans = 0;
    		g = new ArrayList<>();
    		rev = new ArrayList<>();
			for(int i = 0; i <= n;i++) {
				g.add(new ArrayList<>());
				rev.add(new ArrayList<>());
			}
			int x,y;
	        for(int i = 0; i < m;i++) {
	        	st = new StringTokenizer(br.readLine());
	        	x = Integer.parseInt(st.nextToken());
	        	y = Integer.parseInt(st.nextToken());
	        	
	        	// 역방향과 정방향
	        	g.get(x).add(y);
	        	rev.get(y).add(x);
	        }
	        
	        
	        solve();
        
        	System.out.println("#" + testcase + " " + ans);
        	
        }
        br.close();
        bw.close();
    }
    public static void solve() {
    	for(int i =1; i <= n;i++) {
    		// System.out.println(bfs(i) +" " + rbfs(i));
    		if(bfs(i) + rbfs(i) == n-1)
    			ans++;
    	}
    }
	private static int rbfs(int i) {
		boolean[] vit = new boolean[n+1];
		
		Queue <Integer> q = new ArrayDeque<>(); 
		q.add(i);
		vit[i] = true;
		int ret = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next : rev.get(cur)) 
				if(!vit[next]) {
					q.add(next);
					vit[next] = true;
					ret++;
				}	
		}

		return ret;
	}
	private static int bfs(int i) {
		boolean[] vit = new boolean[n+1];
		
		Queue <Integer> q = new ArrayDeque<>(); 
		q.add(i);
		vit[i] = true;
		int ret = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next : g.get(cur)) 
				if(!vit[next]) {
					q.add(next);
					vit[next] = true;
					ret++;
				}	
		}
		return ret;
	}
}