import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0 ; i < t ; i++) {
            int n = Integer.parseInt(br.readLine()); // 노선 개수
            int[] busStops = new int[5001]; // 전체 정류장

            for (int j = 0 ; j < n ; j++) {
                String[] input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);

                for (int k = a ; k <= b ; k++) {
                    busStops[k]++;
                }
            }

            int p = Integer.parseInt(br.readLine()); // 출력할 정류장 개수
            System.out.printf("#%d ", i+1);
            for (int j = 0 ; j < p ; j++) {
                int stop = Integer.parseInt(br.readLine());
                System.out.printf("%d ", busStops[stop]);
            }
            System.out.println();
        }
    }
}
