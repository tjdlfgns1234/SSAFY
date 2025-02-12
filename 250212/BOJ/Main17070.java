import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 현재 상태에 따라 움직일 수 있음
 * 시작 위치부터 인접한 지역까지의 이동할 수 있는 경우의 수 -> 한 칸씩 늘리기
 */

public class Main17070 {

    static class Pipe {
        int r;
        int c;
        int state;
        int count = 0;
        Pipe() {}
        Pipe(int r, int c, int state, int count) {
            this.r = r;
            this.c = c;
            this.state = state;
            this.count = count;
        }
    }

    static int N;
    static int[][] house;
    static int[][] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        house = new int[N][N];
        for (int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; ++j) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        System.out.println(dist[N-1][N-1]);
    }

    // state = 0은 가로 1은 대각선 2는 세로
    public static void bfs() {
        Queue<Pipe> q = new ArrayDeque<>();
        dist = new int[N][N]; //해당 위치까지 갈 수 있는 경우의 수
        dist[0][1] = 1;
        q.add(new Pipe(0, 1, 0, 1));

        while (!q.isEmpty()) {
            Pipe curr = q.poll();
            if (curr.state == 0) { // 현재 상태 가로
                if (isValid(curr.r, curr.c+1)) { // 오른쪽으로 밀기
                    ++dist[curr.r][curr.c+1];
                    q.add(new Pipe(curr.r, curr.c+1, curr.state, dist[curr.r][curr.c+1]));
                }
                if (isValid(curr.r+1, curr.c) && isValid(curr.r+1, curr.c+1) && isValid(curr.r, curr.c+1)) { // 대각선으로 밀기
                    ++dist[curr.r+1][curr.c+1];
                    q.add(new Pipe(curr.r+1, curr.c+1, curr.state+1, dist[curr.r+1][curr.c+1]));
                }
            }

            else if (curr.state == 1) { // 현재 상태 대각선
                if (isValid(curr.r, curr.c+1)) { // 오른쪽으로 밀기
                    ++dist[curr.r][curr.c+1];
                    q.add(new Pipe(curr.r, curr.c+1, curr.state-1, dist[curr.r][curr.c+1]));
                }
                if (isValid(curr.r+1, curr.c) && isValid(curr.r+1, curr.c+1) && isValid(curr.r, curr.c+1)) { // 대각선으로 밀기
                    ++dist[curr.r+1][curr.c+1];
                    q.add(new Pipe(curr.r+1, curr.c+1, curr.state, dist[curr.r+1][curr.c+1]));
                }
                if (isValid(curr.r+1, curr.c)) { // 아래로 밀기
                    ++dist[curr.r+1][curr.c];
                    q.add(new Pipe(curr.r+1, curr.c, curr.state+1, dist[curr.r+1][curr.c]));
                }
            }

            else if (curr.state == 2) { // 현재 상태 세로
                if (isValid(curr.r+1, curr.c) && isValid(curr.r+1, curr.c+1) && isValid(curr.r, curr.c+1)) { // 대각선으로 밀기
                    ++dist[curr.r+1][curr.c+1];
                    q.add(new Pipe(curr.r+1, curr.c+1, curr.state-1, dist[curr.r+1][curr.c+1]));
                }
                if (isValid(curr.r+1, curr.c)) { // 아래로 밀기
                    ++dist[curr.r+1][curr.c];
                    q.add(new Pipe(curr.r+1, curr.c, curr.state, dist[curr.r+1][curr.c]));
                }
            }

        }

    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N && house[r][c] == 0;
    }

}