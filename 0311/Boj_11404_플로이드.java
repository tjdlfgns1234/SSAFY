import java.util.*;
import java.io.*;

public class Boj_11404_플로이드 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //도시 -> 도시
        //모든 도시쌍 필요한 최솟값
        //1번 도시 -> 나머지 모든 도시 각각 출력
        int MAX_VALUE = 100_001 * N; //!!!!!!!!!!!!!!!!!!!!! 범위 조정 주의하기 문제 조건 잘 살피기

        int M = Integer.parseInt(br.readLine()); //버스 개수
        int[][] map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], MAX_VALUE);
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = Math.min(map[a][b], c);  //양방향 아님!
        }
        for (int i = 1; i <= N; i++) {
            map[i][i] = 0;
        }

        // i -> j k 거쳐서
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] >= MAX_VALUE) sb.append(0 + " ");
                else sb.append(map[i][j] + " ");
            }
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}
