import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

class BOJCollatz_Conjecture{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.print(n+" ");
		while(n != 1) {
			if(n%2 == 0) {
				n = n /2;
				System.out.print(n + " ");
				continue;
			}else {
				n = 3*n+1;
				System.out.print(n + " ");
				continue;
			}
		}
	}
	
}