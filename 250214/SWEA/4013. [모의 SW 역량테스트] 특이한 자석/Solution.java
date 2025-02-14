import java.io.*;
import java.util.*;

public class Solution {
	static LinkedList<Integer> mag1;
	static LinkedList<Integer> mag2;
	static LinkedList<Integer> mag3;
	static LinkedList<Integer> mag4;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int t = Integer.parseInt(br.readLine());
    	
    	for (int u = 1 ; u <= t ; u++) {
    		int K = Integer.parseInt(br.readLine());
    		String[] input1 = br.readLine().split(" ");
    		mag1 = new LinkedList<>();
    		for (int i = 0 ; i < 8 ; i++) {
    			mag1.add(Integer.parseInt(input1[i]));
    		}
    		String[] input2 = br.readLine().split(" ");
    		mag2 = new LinkedList<>();
    		for (int i = 0 ; i < 8 ; i++) {
    			mag2.add(Integer.parseInt(input2[i]));
    		}
    		String[] input3 = br.readLine().split(" ");
    		mag3 = new LinkedList<>();
    		for (int i = 0 ; i < 8 ; i++) {
    			mag3.add(Integer.parseInt(input3[i]));
    		}
    		String[] input4 = br.readLine().split(" ");
    		mag4 = new LinkedList<>();
    		for (int i = 0 ; i < 8 ; i++) {
    			mag4.add(Integer.parseInt(input4[i]));
    		}
    		int[][] rotateInfo = new int[K][2];
    		for (int i = 0 ; i < K ; i++) {
    			String[] input = br.readLine().split(" ");
    			rotateInfo[i][0] = Integer.parseInt(input[0]);
    			rotateInfo[i][1] = Integer.parseInt(input[1]);
    		}
    		
    		for (int i = 0 ; i < K ; i++) {
    			check(rotateInfo[i]);
    		}
			score(u);
    	}
    }
	private static void check(int[] rotateInfo) {
		int mag1R = mag1.get(2);
		int mag2L = mag2.get(6);
		boolean connect12 = (mag1R != mag2L); //  N-S가 만나면 true
		int mag2R = mag2.get(2);
		int mag3L = mag3.get(6);
		boolean connect23 = (mag2R != mag3L);
		int mag3R = mag3.get(2);
		int mag4L = mag4.get(6);
		boolean connect34 = (mag3R != mag4L);
		
		int startMag = rotateInfo[0];
		boolean rotateDirection;
		if (rotateInfo[1] == 1) { // 시계 방향 true, 반시계 방향 false
			rotateDirection = true;
		} else {
			rotateDirection = false;
		}
		
		if (startMag == 1) {
			if (connect12 && connect23 && connect34) {
				rotate(1, rotateDirection);
				rotate(2, !rotateDirection);
				rotate(3, rotateDirection);
				rotate(4, !rotateDirection);
			} else if (connect12 && connect23) {
				rotate(1, rotateDirection);
				rotate(2, !rotateDirection);
				rotate(3, rotateDirection);
			} else if (connect12) {
				rotate(1, rotateDirection);
				rotate(2, !rotateDirection);
			} else {
				rotate(1, rotateDirection);
			}
		} else if (startMag == 2) {
			if (connect12 && connect23 && connect34) {
				rotate(2, rotateDirection);
				rotate(1, !rotateDirection);
				rotate(3, !rotateDirection);
				rotate(4, rotateDirection);
			} else if (connect23 && connect34) { 
				rotate(2, rotateDirection);
				rotate(3, !rotateDirection);
				rotate(4, rotateDirection);
			} else if (connect12 && connect23) {
				rotate(2, rotateDirection);
				rotate(1, !rotateDirection);
				rotate(3, !rotateDirection);
			} else if (connect12) {
				rotate(2, rotateDirection);
				rotate(1, !rotateDirection);
			} else if (connect23) {
				rotate(2, rotateDirection);
				rotate(3, !rotateDirection);
			} else {
				rotate(2, rotateDirection);
			}
		} else if (startMag == 3) {
			if (connect12 && connect23 && connect34) {
				rotate(3, rotateDirection);
				rotate(2, !rotateDirection);
				rotate(4, !rotateDirection);
				rotate(1, rotateDirection);
			} else if (connect12 && connect23) {
				rotate(3, rotateDirection);
				rotate(2, !rotateDirection);
				rotate(1, rotateDirection);
			} else if (connect23 && connect34) { 
				rotate(3, rotateDirection);
				rotate(2, !rotateDirection);
				rotate(4, !rotateDirection);
			} else if (connect34) {
				rotate(3, rotateDirection);
				rotate(4, !rotateDirection);
			} else if (connect23) {
				rotate(3, rotateDirection);
				rotate(2, !rotateDirection);
			} else {
				rotate(3, rotateDirection);
			}
		} else {
			if (connect12 && connect23 && connect34) {
				rotate(4, rotateDirection);
				rotate(3, !rotateDirection);
				rotate(2, rotateDirection);
				rotate(1, !rotateDirection);
			} else if (connect34 && connect23) {
				rotate(4, rotateDirection);
				rotate(3, !rotateDirection);
				rotate(2, rotateDirection);
			} else if (connect34) {
				rotate(4, rotateDirection);
				rotate(3, !rotateDirection);
			} else {
				rotate(4, rotateDirection);
			}
		}
	}
	private static void rotate(int magNum, boolean rotateDirection) {
		LinkedList<Integer> mag;
		if (magNum == 1) {
			mag = mag1;
		} else if (magNum == 2) {
			mag = mag2;
		} else if (magNum == 3) {
			mag = mag3;
		} else {
			mag = mag4;
		}
		
		if (rotateDirection) { // 시계
			int tmp = mag.pollLast();
			mag.addFirst(tmp);
		} else { // 반시계
			int tmp = mag.pollFirst();
			mag.addLast(tmp);
		}
		
		if (magNum == 1) {
			mag1 = mag;
		} else if (magNum == 2) {
			mag2 = mag;
		} else if (magNum == 3) {
			mag3 = mag;
		} else {
			mag4 = mag;
		}
	}
	private static void score(int t) {
		int sum = 0;
		if (mag1.get(0) == 1) {
			sum += 1;
		}
		if (mag2.get(0) == 1) {
			sum += 2;
		}
		if (mag3.get(0) == 1) {
			sum += 4;
		}
		if (mag4.get(0) == 1) {
			sum += 8;
		}
		System.out.printf("#%d %d\n", t, sum);
	}
}
