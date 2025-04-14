import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class BOJ사격내기{
	static int[] score = new int[10];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		
		score[0] = 1;
		for(int i = 1; i < score.length; i++) {
			score[i] = score[i-1] * 2;
		}
		
		int[] a = new int[10];
		int[] b = new int[10];
		
		int aScore = Integer.parseInt(line[0]);
		int bScore = Integer.parseInt(line[1]);
		
		for(int i = 9; i >= 0; i--) {
			int aShare = aScore / score[i];
			if(aShare == 1) {
				aScore -= score[i];
				a[i] = 1;
			}
			
			int bShare = bScore / score[i];
			if(bShare == 1) {
				bScore -= score[i];
				b[i] = 1;
			}
		}
		
		int[] sum = new int[10];
		for(int i = 0; i < 10; i++) {
			sum[i] = a[i] + b[i];
		}
		
		int result = 0;
		for(int i = 0; i < 10; i++) {
			if(sum[i] == 1) {
				result += score[i];
			}
		}
		
		System.out.println(result);
	}
}