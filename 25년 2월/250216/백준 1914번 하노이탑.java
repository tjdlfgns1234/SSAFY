import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	static int n;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
		// System.setIn(Main.class.getResourceAsStream("/Algorithm/input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());

	    n = Integer.parseInt(st.nextToken());
	    
	    BigInteger ans = BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE);
	    
	    sb.append(ans.toString() + '\n');
	    
	    if(n <=20)
	    	solve();
	    
	    bw.write(sb.toString());
	    bw.flush();
    }

    public static void solve() throws IOException {
    	 hanoi(n, 1,2,3);
    }
    static void move(int from, int to)
    {
    	sb.append(from + " " + to + '\n');
    }
    public static void hanoi(int n, int from, int by, int to) throws IOException {
	    if(n == 0) return;
	    hanoi(n - 1, from, to, by);
	    move(from, to);
	    hanoi(n - 1, by, from, to);
    	
    }
	
	
}