import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int K;
	static int[][] map;
	static ArrayList<int[]> rotateList;
	static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        N = Integer.parseInt(input1[0]); // 행
        M = Integer.parseInt(input1[1]); // 열
        K = Integer.parseInt(input1[2]); // 회전 횟수
        map = new int[N][M];
        for (int i = 0 ; i < N ; i++) { // map 입력
        	String[] input2 = br.readLine().split(" ");
        	for (int j = 0 ; j < M ; j++) {
        		map[i][j] = Integer.parseInt(input2[j]);
        	}
        }
        rotateList = new ArrayList<>();
        for (int i = 0 ; i < K ; i++) { // 회전 정보 입력
        	String[] input3 = br.readLine().split(" ");
        	int rRow = Integer.parseInt(input3[0]) - 1; // 입력은 시작 좌표가 1부터라서 -1로 맞춰줌
        	int rCol = Integer.parseInt(input3[1]) - 1;
        	int rDist = Integer.parseInt(input3[2]);
        	
        	rotateList.add(new int[] {rRow, rCol, rDist});
        }
        ArrayList<int[]> orderedList = new ArrayList<>();
        boolean[] visited = new boolean[K];
        int idx = 0;
        orderRotate(orderedList, idx, visited); // 회전 순서
        System.out.println(result);
    }
    
	private static void orderRotate(ArrayList<int[]> orderedList, int idx, boolean[] visited) {
		if (orderedList.size() == K) {
			rotate(orderedList);
			return;
		}
		
		// inductive
		for (int i = 0 ; i < K ; i++) {
			if (visited[i] == true) {
				continue;
			}
			orderedList.add(rotateList.get(i));
			visited[i] = true;
			orderRotate(orderedList, idx+1, visited);
			orderedList.remove(orderedList.size()-1);
			visited[i] = false;
		}
	}

	private static void rotate(ArrayList<int[]> orderedList) {
		int[][] newMap = new int[N][M];
		for (int i = 0; i < N; i++) {
		    newMap[i] = map[i].clone(); // 깊은 복사
		}
		
		for (int i = 0 ; i < K ; i++) {
			int centerRow = orderedList.get(i)[0];
			int centerCol = orderedList.get(i)[1];
			int rotateDist = orderedList.get(i)[2];
			
			int layer = 0;
			while(layer < rotateDist) {
				int startRow = centerRow - rotateDist + layer;
				int startCol = centerCol - rotateDist + layer;
				int endRow = centerRow + rotateDist - layer;
				int endCol = centerCol + rotateDist - layer;
				
				ArrayDeque<Integer> rotateList = new ArrayDeque<>();
				for (int j = startCol ; j <= endCol ; j++) { // 가로 (열 변동)
					rotateList.add(newMap[startRow][j]);
				}
				for (int j = startRow + 1 ; j <= endRow ; j++) { // 세로 (행 변동)
					rotateList.add(newMap[j][endCol]);
				}
				for (int j = endCol -1 ; j >= startCol ; j--) { // 가로 (열 변동)
					rotateList.add(newMap[endRow][j]);
				}
				for (int j = endRow - 1 ; j >= startRow + 1 ; j--) { // 세로 (행 변동)
					rotateList.add(newMap[j][startCol]);
				}
				
				rotateList.offerFirst(rotateList.pollLast()); // 회전
				
				for (int j = startCol ; j <= endCol ; j++) {
					newMap[startRow][j] = rotateList.pollFirst();
				}
				for (int j = startRow + 1 ; j <= endRow ; j++) {
					newMap[j][endCol] = rotateList.pollFirst();
				}
				for (int j = endCol -1 ; j >= startCol ; j--) {
					newMap[endRow][j] = rotateList.pollFirst();
				}
				for (int j = endRow - 1 ; j >= startRow + 1 ; j--) {
					newMap[j][startCol] = rotateList.pollFirst();
				}
				
				layer++; // 내부 layer로 진입하기 위함
			}
		}
		getMinVal(newMap);
	}

	private static void getMinVal(int[][] newMap) {
		int mapMin = Integer.MAX_VALUE;
		for (int i = 0 ; i < N ; i++) {
			int rowSum = 0;
			for (int j = 0 ; j < M ; j++) {
				rowSum += newMap[i][j];
			}
			mapMin = Math.min(mapMin, rowSum);
		}
		result = Math.min(mapMin, result);
	}
}
