import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] daysNeeded;
	static int[] income;
	static int finalResult = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); 	// 상담 가능한 날
		daysNeeded = new int[N];					// 해당 상담을 위해 써야 하는 날
		income = new int[N];						// 상담을 할 경우 받는 보수
		for (int i = 0 ; i < N ; i++) {
			String[] input = br.readLine().split(" ");
			daysNeeded[i] = Integer.parseInt(input[0]);
			income[i] = Integer.parseInt(input[1]);
		}
		int idx = 0;
		int continuous = 0;
		int daysLeft = N;
		int result = 0;
		recursive(idx, continuous, daysLeft, result);
		System.out.println(finalResult);
	}
	private static void recursive(int idx, int continuous, int daysLeft, int result) {
		if (idx == N) {
			finalResult = Math.max(finalResult, result);
			return;
		}
		
		if (continuous > 0) { // 상담이 끝나지 않은 경우
			recursive(idx+1, continuous-1, daysLeft-1, result);
		} else {
			if (daysLeft < daysNeeded[idx]) { // 남은 날짜보다 상담해야 하는 날이 더 많은 경우
				recursive(idx+1, continuous, daysLeft-1, result);
			} else {
				int newContinuous = daysNeeded[idx] - 1;
				recursive(idx+1, newContinuous, daysLeft-1, result + income[idx]);
				recursive(idx+1, 0, daysLeft-1, result);
			}
		}
	}
}
