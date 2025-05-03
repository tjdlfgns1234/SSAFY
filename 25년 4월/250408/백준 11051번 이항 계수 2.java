import java.util.*;
import java.io.*;
import java.math.BigInteger;


public class Main {
    static int n,m,k, cnt = 1, sum = 0, ans = 0;
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
	        k = Integer.parseInt(st.nextToken());
	 
	        solve();

	        System.out.println(Combination(n,k));
		  }
	}

    public static void solve() throws IOException {

    }
    
    public static BigInteger Combination(int n, int r) {
    	
    	
    	BigInteger num = BigInteger.ONE;
    	BigInteger den = BigInteger.ONE;
    
    	for(int i = 0; i < r;i++) {
    		num = num.multiply(BigInteger.valueOf(n-i));
    		den = den.multiply(BigInteger.valueOf(i+1));
    	}
    	
    	return num.divide(den).mod(BigInteger.valueOf(10007));
    }
    
    

}
