import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class SWEA홈_방범_서비스 {
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };

    static int maxCount = 0;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);

            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                line = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(line[j]);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    for (int k = 1; k <= n + 1; k++) {
                        int houseCount = 0;
                        boolean[][] visited = new boolean[n][n];
                        Queue<int[]> queue = new ArrayDeque<>();
                        
                        // 시작점 초기화
                        queue.offer(new int[]{i, j});
                        visited[i][j] = true;
                        if(map[i][j] == 1) {
                            houseCount++;
                        }
                        

                        for (int level = 1; level < k; level++) {
                            int size = queue.size();
                            for (int s = 0; s < size; s++) {
                                int[] cur = queue.poll();
                                for (int d = 0; d < 4; d++) {
                                    int nx = cur[0] + dx[d];
                                    int ny = cur[1] + dy[d];
                                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                                        visited[nx][ny] = true;
                                        queue.offer(new int[]{nx, ny});
                                        if(map[nx][ny] == 1) {
                                            houseCount++;
                                        }
                                    }
                                }
                            }
                        }
                        
                        int cost = k * k + (k - 1) * (k - 1);
                        if (houseCount * m >= cost) {
                            maxCount = Math.max(maxCount, houseCount);
                        }
                    }
                }
            }
            
            System.out.println("#" + t + " " + maxCount);
            maxCount = 0;
        }
    }
}
