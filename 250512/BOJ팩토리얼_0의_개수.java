import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

class BOJ팩토리얼_0의_개수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		String result = fac(n).toString();
		
		long sum = 0;
		for(int i = result.length()-1; i >= 0; i--) {
			if(result.charAt(i) == '0') {
				sum++;
			}else {
				break;
			}
		}
		
		System.out.println(sum);
		
		
	}
	static BigInteger fac(long n) {
		if(n == 1 || n == 0) {
			return BigInteger.ONE;
		}
		
		return BigInteger.valueOf(n).multiply(fac(n-1));
	}

}