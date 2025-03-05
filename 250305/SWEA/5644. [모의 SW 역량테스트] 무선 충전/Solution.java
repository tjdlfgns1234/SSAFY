import java.io.*;
import java.util.*;

public class Solution {
	static int N = 10;
	static int T, A, M;
	static int[] moveA, moveB;
	static int[][] AP;
	static int[][][] map;
	static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        for (int t = 1 ; t <= T ; t++) {
        	String[] input1 = br.readLine().split(" ");
        	M = Integer.parseInt(input1[0]); // 이동 정보
        	A = Integer.parseInt(input1[1]); // AP 수
        	moveA = new int[M];
        	moveB = new int[M];
        	for (int i = 0 ; i < 2 ; i++) {
        		String[] input2 = br.readLine().split(" ");
        		for (int j = 0 ; j < M ; j++) {
        			if (i == 0) {
        				moveA[j] = Integer.parseInt(input2[j]);
        			} else {
        				moveB[j] = Integer.parseInt(input2[j]);
        			}
        		}
        	}
        	
        	AP = new int[A][4]; // X 좌표, Y 좌표, 충전 범위, 충전량
        	for (int i = 0 ; i < A ; i++) {
        		String[] input3 = br.readLine().split(" ");
        		AP[i][0] = Integer.parseInt(input3[1]) - 1; // x <-> y 바꾸고 -1
        		AP[i][1] = Integer.parseInt(input3[0]) - 1;
        		AP[i][2] = Integer.parseInt(input3[2]);
        		AP[i][3] = Integer.parseInt(input3[3]);
        	}
        	
        	map = new int[10][10][A]; // AP 개수에 따라 지도 차원 늘리기 (A는 최대 8)
        	
        	result = 0;
        	drawMap(); // 지도 그리기
        	move();
        	System.out.printf("#%d %d\n", t, result);
        }
    }

	private static void drawMap() { // 지도 그리기
		for (int k = 0 ; k < A ; k++) {
			int centerRow = AP[k][0];
			int centerCol = AP[k][1];
			int dist = AP[k][2];
			int charge = AP[k][3];
			
			// 위로
			for (int i = 0 ; i <= dist ; i++) {
				int currentRow = centerRow - i;
				int startCol = centerCol - dist + i;
				int endCol = centerCol + dist - i;
				for (int j = startCol ; j <= endCol ; j++) {
					if (currentRow >= 0 && currentRow < N && j >= 0 && j < N) {
						map[currentRow][j][k] = charge;
					}
				}
			}
			
			// 아래로
			for (int i = 1 ; i <= dist ; i++) {
				int currentRow = centerRow + i;
				int startCol = centerCol - dist + i;
				int endCol = centerCol + dist - i;
				for (int j = startCol ; j <= endCol ; j++) {
					if (currentRow >= 0 && currentRow < N && j >= 0 && j < N) {
						map[currentRow][j][k] = charge;
					}
				}
			}
		}
	}
	
	private static void move() { // 움직이기
		int[] currentA = {0, 0};
		int[] currentB = {9, 9};
		charge(currentA, currentB); // 첫 좌표에서부터 충전 가능
		
		for (int i = 0 ; i < M ; i++) {
			int A = moveA[i];
			int B = moveB[i];
			
			currentA = returnCoord(A, currentA);
			currentB = returnCoord(B, currentB);
			
			charge(currentA, currentB);
		}
	}

	private static int[] returnCoord(int dir, int[] coord) { // 움직인 좌표 반환
		if (dir == 0) { // 그대로
			{}
		} else if (dir == 1) { // 상
			coord[0]--;
		} else if (dir == 2) { // 우
			coord[1]++;
		} else if (dir == 3) { // 하
			coord[0]++;
		} else if (dir == 4) { // 좌
			coord[1]--;
		}
		
		return coord;
	}
	
	private static void charge(int[] currentA, int[] currentB) {
		int xA = currentA[0];
		int yA = currentA[1];
		int xB = currentB[0];
		int yB = currentB[1];
		
		int tempA = 0;
		int tempB = 0;
		
		
		int[] arrA = new int[A];
		int[] arrB = new int[A];
		
		for (int i = 0 ; i < A ; i++) {
			tempA = map[xA][yA][i];
			tempB = map[xB][yB][i];
			
			arrA[i] = tempA;
			arrB[i] = tempB;
		}
		
		int maxSum = 0;
		for (int i = 0 ; i < A ; i++) {
			for (int j = 0 ; j < A ; j++) {
				int a;
				int b;
				if (i == j && A != 1) {
					a = arrA[i] / 2;
					b = arrB[j] / 2;
				} else {
					a = arrA[i];
					b = arrB[j];
				}
				maxSum = Math.max(maxSum, a + b);
			}
		}

		result += maxSum;
	}
}
