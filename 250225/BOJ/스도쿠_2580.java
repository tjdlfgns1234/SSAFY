import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스도쿠_2580 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[9][9];
        int count = 0;
        
        for (int i = 0; i < map.length; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    ++count;
                }
            }
        }
        
        dfs(map, 0, 0, count);
    }

    public static void dfs(int[][] map, int idxR, int idxC, int count) {
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
        
        if (map[idxR][idxC] == 0) {
        	for (int v=1; v<10; ++v) {
                if (verify(map, idxR, idxC, v)) {
                    map[idxR][idxC] = v;
                    if (idxC == map[idxR].length-1) {
                    	dfs(map, idxR+1, 0, count+1);
                    }
                    else {
                    	dfs(map, idxR, idxC+1, count+1);
                    }
                    map[idxR][idxC] = 0;
                }
            }
        }
        else {
        	if (idxC == map[idxR].length-1) {
            	dfs(map, idxR+1, 0, count);
            }
            else {
            	dfs(map, idxR, idxC+1, count);
            }
        }
    }

    public static boolean verify(int[][] map, int r, int c, int v) {
        return verifyRow(map, r, v) && verifyCol(map, c, v) && verifySquare(map, r, c, v);
    }

    public static boolean verifyRow(int[][] map, int r, int v) {
        for (int c=0; c<map[r].length; ++c) {
            if (map[r][c] == v) {
                return false;
            }
        }

        return true;
    }

    public static boolean verifyCol(int[][] map, int c, int v) {
        for (int r=0; r<map.length; ++r) {
            if (map[r][c] == v) {
                return false;
            }
        }

        return true;
    }

    public static boolean verifySquare(int[][] map, int r, int c, int v) {
        int[] idx = getIdx(r, c);

        for (int i = idx[0]; i < idx[0]+3; ++i) {
            for (int j = idx[1]; j < idx[1]+3; ++j) {
                if (map[i][j] == v) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int[] getIdx(int r, int c) {
        int[] idx = new int[2];
        if (r >= 0 && r <= 2) {
            idx[0] = 0;
            if (c >= 0 && c <= 2) {
                idx[1] = 0;
            }
            else if (c >= 3 && c <= 5) {
                idx[1] = 3;
            }
            else {
                idx[1] = 6;
            }
        }
        else if (r >= 3 && r <= 5) {
            idx[0] = 3;
            if (c >= 0 && c <= 2) {
                idx[1] = 0;
            }
            else if (c >= 3 && c <= 5) {
                idx[1] = 3;
            }
            else {
                idx[1] = 6;
            }
        }
        else {
            idx[0] = 6;
            if (c >= 0 && c <= 2) {
                idx[1] = 0;
            }
            else if (c >= 3 && c <= 5) {
                idx[1] = 3;
            }
            else {
                idx[1] = 6;
            }
        }

        return idx;
    }
}
