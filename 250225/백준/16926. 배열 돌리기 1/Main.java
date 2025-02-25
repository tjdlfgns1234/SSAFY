import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int[][] resultMap;
    static int N;
    static int M;
    static int R;
    static int mid;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input1 = br.readLine().split(" ");
        N = Integer.parseInt(input1[0]);
        M = Integer.parseInt(input1[1]);
        R = Integer.parseInt(input1[2]);
        int midR = N / 2;
        int midC = M / 2;
        mid = Math.min(midR, midC);
        
        map = new int[N][M];
        resultMap = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input2[j]);
            }
        }
        
        rotate();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.printf("%d ", resultMap[i][j]);
            }
            System.out.println();
        }
    }

    private static void rotate() {
        for (int k = 0; k < mid; k++) {
            ArrayDeque<Integer> arr = new ArrayDeque<>();
            
            for (int i = k; i < M - k; i++) {
                arr.offer(map[k][i]);
            }
            for (int i = k + 1; i < N - k; i++) {
                arr.offer(map[i][M - k - 1]);
            }
            for (int i = M - k - 2; i >= k; i--) {
                arr.offer(map[N - k - 1][i]);
            }
            for (int i = N - k - 2; i > k; i--) {
                arr.offer(map[i][k]);
            }
            // 회전
            for (int i = 0; i < R; i++) {
                int temp = arr.poll();
                arr.offer(temp);
            }
            for (int i = k; i < M - k; i++) {
                resultMap[k][i] = arr.poll();
            }
            for (int i = k + 1; i < N - k; i++) {
                resultMap[i][M - k - 1] = arr.poll();
            }
            for (int i = M - k - 2; i >= k; i--) {
                resultMap[N - k - 1][i] = arr.poll();
            }
            for (int i = N - k - 2; i > k; i--) {
                resultMap[i][k] = arr.poll();
            }
        }
    }
}
