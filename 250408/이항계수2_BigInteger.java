import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class 이항계수2_BigInteger {
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static List<List<Integer>> triangle = new ArrayList<>();
	static int modul = 10007;
	static BigInteger mo = BigInteger.ONE;
	static BigInteger ja = BigInteger.ONE;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		mo = factorial(n);
		ja = factorial(k).multiply(factorial(n-k));
		System.out.println(mo.divide(ja).mod(BigInteger.valueOf(modul)));
		
	}
	
	static BigInteger factorial(int num) {
		BigInteger big = BigInteger.ONE;
		for(int i=1;i<=num;i++) {
			big = big.multiply(BigInteger.valueOf(i));
		}
		
		return big;
	}
	
}
