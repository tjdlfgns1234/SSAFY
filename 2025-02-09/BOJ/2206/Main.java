import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;



public class Main
{
    static class path{
        int x, y, result;
        boolean boom_check;

        public path(int x, int y, int result, boolean boom_check){
            this.x = x;
            this.y = y;
            this.result = result;
            this.boom_check = boom_check;
        }
    }

    static int N, M;
    static int[][] board;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];


        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = temp.charAt(j) - '0';
            }
        }

        bfs(0, 0, 1);

    }

    private static void bfs(int x, int y, int dist) {
        Queue<path> q = new LinkedList<>();
        q.add(new path(x, y, dist, false));
        path temp;
        int nx, ny;

        boolean[][][] visited = new boolean[N][M][2];
        
        while (!q.isEmpty()){
            temp = q.poll();
            x = temp.x;
            y = temp.y;

            if(x == N - 1 && y == M - 1){
                System.out.println(temp.result);
                return;
            }

            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                if(0 > nx || nx >= N || ny < 0 || ny >= M) continue;

                if(board[nx][ny] == 0){
                    if(!temp.boom_check && !visited[nx][ny][0]){
                        q.add(new path(nx, ny, temp.result + 1, false));
                        visited[nx][ny][0] = true;
                    } else if (!visited[nx][ny][1]) {
                        q.add(new path(nx, ny, temp.result + 1, true));
                        visited[nx][ny][1] = true;
                    }
                }
                else{
                    if(!temp.boom_check){
                        q.add(new path(nx, ny, temp.result + 1, true));
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
