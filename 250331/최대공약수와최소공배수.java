import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대공약수와최소공배수 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	private static int g1(int a , int b) {
		while(b!=0) {
			int temp = b;
			b = a%b;
			a=temp;
		}
		return a;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int high=0;
		if(N>M) {
			high = g1(N,M);
			System.out.println(high);
		}
		else {
			high = g1(M,N);
			System.out.println(high);
		}
		
		System.out.println((N*M)/high);
		
	}
}
