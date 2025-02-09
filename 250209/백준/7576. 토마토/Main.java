import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int m = Integer.parseInt(input1[0]); // 열
        int n = Integer.parseInt(input1[1]); // 행
        int[][] arr = new int[n][m];
        
        for (int i = 0 ; i < n ; i++) {
        	String[] input2 = br.readLine().split(" ");
        	for (int j = 0 ; j < m ; j++) {
        		arr[i][j] = Integer.parseInt(input2[j]);
        	}
        }
        search(n, m, arr);
    }

	private static void search(int n, int m, int[][] arr) {
		final int[] dx = {1, -1, 0, 0};
		final int[] dy = {0, 0, 1, -1};
		
		ArrayList<int[]> startArr = new ArrayList<>();
		
		int count1 = 0;
		int countM1 = 0;
		
		for (int i = 0 ; i < n ; i++) {
			for (int j = 0 ; j < m ; j++) {
				if (arr[i][j] == 1) {
					count1++;
					startArr.add(new int[] {i, j});
				} else if (arr[i][j] == -1) {
					countM1++;
				}
			}
		}
		
		if (count1 + countM1 == n * m) { // 시작부터 전부 익었다면
			System.out.println(0);
		} else {
			bfs(n, m, arr, dx, dy, startArr);
		}
	}

	private static void bfs(int n, int m, int[][] arr, int[] dx, int[] dy, ArrayList<int[]> startArr) {
	    ArrayDeque<int[]> queue = new ArrayDeque<>();
	    for (int i = 0 ; i < startArr.size() ; i++) {
	        int[] tmp = startArr.get(i);
	        int x = tmp[0];
	        int y = tmp[1];
	        queue.offer(new int[] {x, y});
	    }
	    
	    int count = -1;
	    while (!queue.isEmpty()) {
	        int size = queue.size();
	        count++; // 하루 증가

	        for (int i = 0; i < size; i++) { // 하루 진행
	            int[] node = queue.poll();
	            int x = node[0];
	            int y = node[1];

	            for (int j = 0 ; j < 4 ; j++) {
	                int nx = x + dx[j];
	                int ny = y + dy[j];

	                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !(arr[nx][ny] == -1) && !(arr[nx][ny] == 1)) {
	                    queue.offer(new int[] {nx, ny});
	                    arr[nx][ny] = 1;
	                }
	            }
	        }
	    }

	    for (int i = 0 ; i < n ; i++) {
	        for (int j = 0 ; j < m ; j++) {
//	            System.out.printf("%d ", arr[i][j]);
	            if (arr[i][j] == 0) {
	                count = -1;
	                break;
	            }
	        }
//	        System.out.println();
	    }
	    System.out.println(count);
	}

}
