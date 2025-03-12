
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ플로이드 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(map[i], 100_000_000);
        }

        for(int i = 0; i < n; i++){
            map[i][i] = 0;
        }

        for(int i = 0; i < m; i++){
            String[] line = br.readLine().split(" ");

            int a = Integer.parseInt(line[0]) -1;
            int b = Integer.parseInt(line[1]) -1;
            int c = Integer.parseInt(line[2]);

            map[a][b] = Math.min(c, map[a][b]);
        }

        for(int k = 0; k < n; k++){
            for(int a = 0; a < n; a++){
                for(int b = 0; b < n; b++){
                    map[a][b] = Math.min(map[a][b], map[a][k] + map[k][b]);
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print((map[i][j] == 100_000_000 ? 0 : map[i][j]) + " ");
            }
            System.out.println();
        }

        
    }


}
