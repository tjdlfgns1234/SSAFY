import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 0 1 2
 * 3 4 5
 * 6 7 8
 */

public class 스도쿠_2580_re {
	
	static int[][] map;
	static boolean[][][] used;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		used = new boolean[3][10][10]; // 0은 row 1은 col 2는 3*3		
		int count = 0;
		
		for (int i=0; i<map.length; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<map[i].length; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					++count;
					used[0][i][map[i][j]] = true;
					used[1][j][map[i][j]] = true;
					int idx = getIdx(i, j);
					used[2][idx][map[i][j]] = true;
				}
			}
		}
		
		dfs(0, 0, count);
	}
	
	public static boolean isPossible(int i, int j, int v) {
		return !used[0][i][v] && !used[1][j][v] && !used[2][getIdx(i, j)][v];
	}
	
	public static void dfs(int idxI, int idxJ, int count) {
if (count == map.length * map[0].length) {
            
        	StringBuilder sb = new StringBuilder();
            for (int i=0; i<map.length; ++i) {
                for (int j=0; j<map[i].length; ++j) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
        	
            System.exit(0);
        }
		
		if (map[idxI][idxJ] == 0) {
			for (int v=1; v<10; ++v) {
		        if (isPossible(idxI, idxJ, v)) {
		            map[idxI][idxJ] = v;
	            	used[0][idxI][map[idxI][idxJ]] = true;
	            	used[1][idxJ][map[idxI][idxJ]] = true;
	            	int idx = getIdx(idxI, idxJ);
	            	used[2][idx][map[idxI][idxJ]] = true;
		            if (idxJ == map[idxI].length-1) {
		            	dfs(idxI+1, 0, count+1);
		            }
		            else {
		            	dfs(idxI, idxJ+1, count+1);
		            }
	            	used[0][idxI][map[idxI][idxJ]] = false;
	            	used[1][idxJ][map[idxI][idxJ]] = false;
	            	used[2][idx][map[idxI][idxJ]] = false;
		            map[idxI][idxJ] = 0;
		        }
		    }
		}
		else {
			if (idxJ == map[idxI].length-1) {
		    	dfs(idxI+1, 0, count);
		    }
		    else {
		    	dfs(idxI, idxJ+1, count);
		    }
		}
	}
	
	public static int getIdx(int r, int c) {
		int idx = 0;
		
		if (r >= 0 && r <= 2) {
			if (c >= 0 && c <= 2) {
				idx = 0;
			}
			else if (c >= 3 && c <= 5) {
				idx = 1;
			}
			else if (c >= 6 && c <= 8) {
				idx = 2;
			}
		}
		else if (r >= 3 && r <= 5) {
			if (c >= 0 && c <= 2) {
				idx = 3;
			}
			else if (c >= 3 && c <= 5) {
				idx = 4;
			}
			else if (c >= 6 && c <= 8) {
				idx = 5;
			}
		}
		else if (r >= 6 && r <= 8) {
			if (c >= 0 && c <= 2) {
				idx = 6;
			}
			else if (c >= 3 && c <= 5) {
				idx = 7;
			}
			else if (c >= 6 && c <= 8) {
				idx = 8;
			}
		}
		
		
		return idx;
	}

}
