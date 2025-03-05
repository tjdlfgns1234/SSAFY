import java.io.*;
import java.util.*;

public class Solution {
	static int[] std, diff;
	static int maxVal, daysCount1, daysCount2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1 ; t <= T ; t++) {
			int N = Integer.parseInt(br.readLine());
			
			std = new int[N];
			maxVal = 0;
			daysCount1 = 0;
			daysCount2 = 0;
			String[] input = br.readLine().split(" ");
			for (int i = 0 ; i < N ; i++) {
				std[i] = Integer.parseInt(input[i]);
				maxVal = Math.max(maxVal, std[i]);
			}
			
			diff = new int[N];
			for (int i = 0 ; i < N ; i++) {
				if (std[i] == maxVal) {
					continue;
				}
				daysCount2 += (maxVal - std[i]) / 2;
				daysCount1 += (maxVal - std[i]) % 2;
			}
			
			while (daysCount2 - daysCount1 >= 2) { //  차이가 2 이상이면 차이 줄이기
				daysCount2 -= 1;
				daysCount1 += 2;
			}
			
			int finalDay = 0;
			int idx = 0;
			while (daysCount1 != 0 || daysCount2 != 0) {
				idx++;
				finalDay++;
				if (idx % 2 == 1) { // 홀수 날 -> 1을 빼는 날
					if (daysCount1 == 0) {
						continue;
					} else {
						daysCount1--;
					}
				} else {
					if (daysCount2 == 0) {
						continue;
					} else {
						daysCount2--;
					}
				}
			}
			
			System.out.printf("#%d %d\n", t, finalDay);
		}
	}
}
