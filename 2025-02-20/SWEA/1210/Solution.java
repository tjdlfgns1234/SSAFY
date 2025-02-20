import java.util.*;
import java.io.*;

public class Solution {
    static int[][] map;
    static int[] result = new int[10];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 0; t < 10; t++) {
            int T = Integer.parseInt(br.readLine());
            map = new int[100][100];
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int y = 0;
            for (int i = 0; i < 100; i++) {
                if(map[99][i] == 2) {
                    y = i;
                    break;
                }
            }

            for (int i = 98; i > 0; i--) {
                if(y - 1 >= 0 && map[i][y-1] == 1){
                    while(map[i][y] != 0){
                        y -= 1;
                        if (y < 0) break;
                    }
                    y += 1;
                }
                else if(y + 1 < 100 && map[i][y+1] == 1){
                    while(map[i][y] != 0){
                        y += 1;
                        if (y > 99) break;
                    }
                    y -= 1;
                }
            }
            result[t] = y;

        }

        for (int i = 0; i < 10; i++) {
            System.out.printf("#%d %d\n", i+1, result[i]);
        }
    }



}
