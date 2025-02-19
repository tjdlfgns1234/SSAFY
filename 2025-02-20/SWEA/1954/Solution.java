import java.util.*;
import java.io.*;
 
public class Solution {
     
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] board;
        for (int t = 1; t < T+1; t++) {
            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            int idx = 0;
            int cnt = 1;
            int x = 0;
            int y = 0;
            int nx, ny;
            board[0][0] = cnt;
             
            while(cnt < n * n) {
                cnt += 1;
                nx = x + dx[idx];
                ny = y + dy[idx];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    idx = (1 + idx) % 4;
                     
                    nx = x + dx[idx];
                    ny = y + dy[idx];
                }
                if(board[nx][ny] != 0) {
                    idx = (1 + idx) % 4;
                    nx = x + dx[idx];
                    ny = y + dy[idx];
                }
                board[nx][ny] = cnt;
                x = nx;
                y = ny;
//              print(board);
//              System.out.println();
            }
             
            System.out.println("#" + t);
            print(board);
        }
 
    }
    static void print(int[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", board[i][j]);
            }
            System.out.println();
        }
    }
 
}
