import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); 	// n개의 시험장
		long[] cand = new long[N];					// 시험장별 응시자 수
		String[] input = br.readLine().split(" ");
		for (int i = 0 ; i < N ; i++) {
			cand[i] = Integer.parseInt(input[i]);
		}
		String[] input2 = br.readLine().split(" ");
		int B = Integer.parseInt(input2[0]);		// 총감독관의 감시 가능 인원
		int C = Integer.parseInt(input2[1]);		// 부감독관의 감시 가능 인원
		long result = 0;
		for (int i = 0 ; i < N ; i++) {
			long temp = cand[i];
			temp = temp - B;
			result++;
			if (temp <= 0) {
				continue;
			} else {
				result += temp / C;
				if (temp % C > 0) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
}
