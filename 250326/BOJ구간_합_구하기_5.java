import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class BOJ구간_합_구하기_5{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        int[][] map = new int[n][n];
        for(int i = 0; i < n; i++){
            line = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        int[][] gugan = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                gugan[i][j] = map[i][j] + (i > 0? gugan[i-1][j]:0) + (j>0?gugan[i][j-1]:0) - (i >0 && j >0?gugan[i-1][j-1]: 0);
            }
        }

        for(int i = 0; i < m ;i++){
            line = br.readLine().split(" ");
            int x1 = Integer.parseInt(line[0])-1;
            int y1 = Integer.parseInt(line[1])-1;
            int x2 = Integer.parseInt(line[2])-1;
            int y2 = Integer.parseInt(line[3])-1;
            
            System.out.println(gugan[x2][y2]
            - (y1 > 0 ? gugan[x2][y1-1] : 0)
            - (x1 > 0 ? gugan[x1-1][y2] : 0)
            + (x1 > 0 && y1 > 0 ? gugan[x1-1][y1-1] : 0));
            
        }
    }
}