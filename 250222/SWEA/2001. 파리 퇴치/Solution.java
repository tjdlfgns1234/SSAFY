import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int M;
	static int[][] map;
	static int maxVal;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int k = 1 ; k <= T ; k++) {
        	String[] input1 = br.readLine().split(" ");
        	N = Integer.parseInt(input1[0]); // 맵의 크기
        	M = Integer.parseInt(input1[1]); // 파리채의 크기
        	map = new int[N][N];
        	for (int i = 0 ; i < N ; i++) {
        		String[] input2 = br.readLine().split(" ");
        		for (int j = 0 ; j < N ; j++) {
        			map[i][j] = Integer.parseInt(input2[j]);
        		}
        	}
    		maxVal = 0;
    		check();
    		System.out.printf("#%d %d\n", k, maxVal);
        }
    }
	private static void check() {
		for (int i = 0 ; i <= N - M ; i++) {
			for (int j = 0 ; j <= N - M ; j++) {
				getSum(i, j);
			}
		}
	}
	private static void getSum(int row, int col) {
		int sum = 0;
		for (int i = 0 ; i < M ; i++) {
			for (int j = 0 ; j < M ; j++) {
				sum += map[row + i][col + j];
			}
		}
		maxVal = Math.max(maxVal, sum);
	}
}
