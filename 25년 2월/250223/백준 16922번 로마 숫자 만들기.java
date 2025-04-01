import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	static int n, ans = 0;
	static int[] arr = {1,5,10,50};
	static boolean[] vit = new boolean[1001];
	static Map<Integer,Integer> mp = new TreeMap<>();
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
		// System.setIn(Main.class.getResourceAsStream("/Algorithm/input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());

	    n = Integer.parseInt(st.nextToken());
	    
	    solve();
	    
	    bw.write(sb.toString());
	    bw.flush();
    }

    public static void solve() throws IOException {
    	dfs(0,0,0);
        sb.append(ans);
    }
    
    public static void dfs(int cnt, int d ,int sum) {
    	if(cnt == n) {
    		
    		if(vit[sum])
    			return;
    		
    		vit[sum] = true;
    		ans++;

    		mp.put(sum,1);
    		return;
    	}
    	
    	for(int i = d; i < 4;i++) 
    		dfs(cnt+1, i, sum+ arr[i]);
    }
}