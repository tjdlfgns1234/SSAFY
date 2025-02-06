import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	while (true) {
    		String[] input1 = br.readLine().split(" ");
    		int w = Integer.parseInt(input1[0]);
    		int h = Integer.parseInt(input1[1]);
    		if (w == 0 && h == 0) {
    			break;
    		}
    		int[][] map = new int[h][w];
    		for (int i = 0 ; i < h ; i++) { // 맵 입력부
    			StringTokenizer st = new StringTokenizer(br.readLine());
    			int j = 0;
    			while (st.hasMoreTokens()) {
    				int a = Integer.parseInt(st.nextToken());
    				map[i][j] = a;
    				j++;
    			}
    		}
    		
    		search(w, h, map);
    		
//    		int[][] newMap = search(w, h, map);
    		
//    		for (int i = 0 ; i < h ; i++) { // 테스트용 맵 출력부
//    			for (int j = 0 ; j < w ; j++) {
//    				System.out.print(newMap[i][j] + " ");
//    			}
//    			System.out.println();
//    		}
    	}
    }

	private static int[][] search(int w, int h, int[][] map) {
        final int[] dx = { -1, 1, 0, 0, 1, -1, 1, -1 };
        final int[] dy = { 0, 0, 1, -1, 1, -1, -1, 1 };
		
        int count = 0;
        for (int i = 0 ; i < h ; i++) {
        	for (int j = 0 ; j < w ; j++) {
        		if (map[i][j] == 1) {
        			map = dfs(i, j, map, dx, dy, w, h);
        			map[i][j] = 0;
        			count++;
        		}
        	}
        }
        System.out.println(count);
		return map;
	}

	private static int[][] dfs(int x, int y, int[][] map, int[] dx, int[] dy, int w, int h) {
		for (int k = 0 ; k < 8 ; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			
			if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
				if (map[nx][ny] == 1) {
					map[nx][ny] = 0;
					dfs(nx, ny, map, dx, dy, w, h);
				}
			}
		}
		return map;
	}
}
