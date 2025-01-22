import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String password = br.readLine();
		int n = password.length();
		int r = 1;
		int c = 1;
		for(int i = 1; i <= Math.sqrt(n); i++) {
			if(n % i == 0) {
				r = i;
			}
		}
		c = n / r;
		char[][] result = new char[r][c]; 
		int idx = 0;
		
		for(int i = 0; i < c; i++) {
			for(int j = 0; j < r; j++) {
				result[j][i] = password.charAt(idx++); 
			}
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0; j < c; j++) {
				System.out.print(result[i][j]);
			}
		}
		System.out.println();
	}
	
}
