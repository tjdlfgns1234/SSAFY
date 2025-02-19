import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        
        for (int k = 1 ; k <= T ; k++) {
        	int N = Integer.parseInt(br.readLine());
            
            int[][] map = new int[N][N];
            int num = 1;
            int m = N;
            int row = 0;
            int col = -1;
            while (m > 0) {
            	 for (int i = 0 ; i < m ; i++) {
            		 col++;
            		 map[row][col] = num;
            		 num++;
            	 }
            	 m--;
            	 for (int i = 0 ; i < m ; i++) {
            		 row++;
            		 map[row][col] = num;
            		 num++;
            	 }
            	 for (int i = 0 ; i < m ; i++) {
            		 col--;
            		 map[row][col] = num;
            		 num++;
            	 }
            	 m--;
            	 for (int i = 0 ; i < m ; i++) {
            		 row--;
            		 map[row][col] = num;
            		 num++;
            	 }
            }
            
            bw.write("#" + k + "\n");
            for (int i = 0 ; i < N ; i++) {
            	for (int j = 0 ; j < N ; j++) {
            		bw.write(map[i][j] + " ");
            	}
            	bw.write("\n");
            }
            bw.flush();
        }
        

        br.close();
        bw.close();
    }
}
