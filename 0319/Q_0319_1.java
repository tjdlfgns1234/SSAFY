import java.util.*;
import java.io.*;

public class Q_0319_1 {
    static int time;
    static int ans;
    static int[][] map;
    static int N,M,B;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        time = Integer.MAX_VALUE;
        ans = -1;
        for (int i = 256; i >= 0; i--) {
            trim(i);
        }
        System.out.printf("%d %d\n",time,ans);
    }

    static void trim(int h) {
        int t = 0;
        int add = 0; //새로 쌓아야하는 블록
        int sub = B; //인벤토리 블록 개수
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > h) {
                    sub += (map[i][j] - h);
                    t += ((map[i][j] - h)* 2);
                }
                else if (map[i][j] < h) {
                    add += (h - map[i][j]);
                    t += (h - map[i][j]);
                }
            }
        }
        if (sub >= add)  {
            if (t < time) {
                time = t;
                ans = h;
            }
        }
    }
}
