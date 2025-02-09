import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int m = Integer.parseInt(input1[0]); // 열
        int n = Integer.parseInt(input1[1]); // 행
        int h = Integer.parseInt(input1[2]); // 높이
        int[][][] arr = new int[h][n][m];
        ArrayList<int[]> startCoord = new ArrayList<>();
        int count1 = 0;
        int countM1 = 0;
        
        for (int i = 0 ; i < h ; i++) {
        	for (int j = 0 ; j < n ; j++) {
        		String[] input2 = br.readLine().split(" ");
        		for (int k = 0 ; k < m ; k++) {
        			arr[i][j][k] = Integer.parseInt(input2[k]);
        			if (arr[i][j][k] == 1) {
        				count1++;
        				startCoord.add(new int[] {i, j, k});
        			} else if (arr[i][j][k] == -1) {
        				countM1++;
        			}
        		}
        	}
        }
        
        if (count1 + countM1 == h * n * m) {
        	System.out.println(0);
        } else {
        	search(h, n, m, arr, startCoord);
        }
    }

	private static void search(int h, int n, int m, int[][][] arr, ArrayList<int[]> startCoord) {
		int[] dx = {1, -1, 0, 0, 0, 0};
		int[] dy = {0, 0, 1, -1, 0, 0};
		int[] dz = {0, 0, 0, 0, 1, -1};
		
		bfs(h, n, m, arr, startCoord, dx, dy, dz);
	}

	private static void bfs(int h, int n, int m, int[][][] arr, ArrayList<int[]> startCoord, int[] dx, int[] dy, int[] dz) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		for (int i = 0 ; i < startCoord.size() ; i++) {
			queue.offer(startCoord.get(i));
		}
		
		int result = -1;
		while(!queue.isEmpty()) {
			int inDay = queue.size();
			result++;
			
			for (int i = 0 ; i < inDay ; i++) {
				int[] node = queue.poll();
				int x = node[0];
				int y = node[1];
				int z = node[2];
				
				for (int j = 0 ; j < 6 ; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					int nz = z + dz[j];
					
					if (nx >= 0 && nx < h && ny >= 0 && ny < n && nz >= 0 && nz < m && !(arr[nx][ny][nz]==-1) && !(arr[nx][ny][nz]==1)) {
						arr[nx][ny][nz]= 1;
						queue.offer(new int[] {nx, ny, nz});
					}
				}
			}
		}

		for (int i = 0 ; i < h ; i++) {
			for (int j = 0 ; j < n ; j++) {
				for (int k = 0 ; k < m ; k++) {
					if (arr[i][j][k] == 0) {
						result = -1;
						break;
					}
				}
			}
		}
		System.out.println(result);
		
	}
}
