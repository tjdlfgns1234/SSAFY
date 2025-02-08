import java.io.*;
import java.util.*;

public class Solution {
	static int maxVal = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스
        for (int k = 0 ; k < t; k++) {
        	String[] input1 = br.readLine().split(" ");
        	int r = Integer.parseInt(input1[0]); // 행
        	int c = Integer.parseInt(input1[1]); // 열
        	String[][] map = new String[r][c];
        	for (int i = 0 ; i < r ; i++) {
        		String[] input2 = br.readLine().split("");
        		for (int j = 0 ; j < c ; j++) {
        			map[i][j] = input2[j];
        		}
        	}
        	search(r, c, map, k+1);
        }
    }

	private static void search(int r, int c, String[][] map, int t) {
		final int[] dx = {1, -1, 0, 0};
		final int[] dy = {0, 0, 1, -1};
		boolean[] checkArr = new boolean[26];
		maxVal = 0;
		checkArr[map[0][0].charAt(0)-'A'] = true;
		int tempSum = 0;
		dfs(0, 0, dx, dy, r, c, map, checkArr, tempSum);
		System.out.printf("#%d %d\n", t , maxVal+1);
	}

	private static void dfs(int x, int y, int[] dx, int[] dy, int r, int c, String[][] map, boolean[] checkArr, int tempSum) {	
		tempSum++;
		for (int i = 0 ; i < 4 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < r && ny >= 0 && ny < c && !(checkArr[map[nx][ny].charAt(0)-'A'])) {
				checkArr[map[nx][ny].charAt(0)-'A'] = true;
				maxVal = Math.max(tempSum, maxVal);
				dfs(nx, ny, dx, dy, r, c, map, checkArr, tempSum);
				checkArr[map[nx][ny].charAt(0)-'A'] = false;
			}
		}
		return;
	}
}
