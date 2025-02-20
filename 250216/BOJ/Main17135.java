import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17135 {
    static int N, M, D;
    static int targetNum; // 적 수
    static int count, max; // 각 경우 당 처치 수, 최댓값
    static class Target {
        int r;
        int c;
        Target(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[][] map;
    static int[][] dst;
    static int chk = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        targetNum = 0;
        max = Integer.MIN_VALUE;

        map = new int[N][M];
        dst = new int[N][M];
        for (int i=0; i<N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    ++targetNum;
                }
            }
        }

        recursive(new int[3], 0, 0);

        System.out.println(max);
    }

    // 0 ~ M-1 중 3개 뽑기
    public static void recursive(int[] sel, int idx, int curr) {
        if (idx == sel.length) {
            // 죽이는 적 카운트
            // 최댓값 비교
            count = 0;
            copyMap();
            play(sel);
//			System.out.println(Arrays.toString(sel));
            max = Math.max(max, count);
            return;
        }

        if (curr == M) {
            return;
        }

        sel[idx] = curr;
        recursive(sel, idx+1, curr+1);
        recursive(sel, idx, curr+1);
    }

    public static void play(int[] sel) {
        int plays = targetNum;
        while (plays > 0) {
//			System.out.println("target: " + plays);

            boolean[] attack = new boolean[3]; // true면 해당 궁수는 공격
            Target[] targets = new Target[3]; // 해당 위치에 있는 적 제거 -> 각각 i번 아처가 공격할 지점을 의미

            find(sel, attack, targets);

            Target prev = null;
            for (int i=0; i<attack.length; ++i) { // 공격
                if (attack[i]) {
                    Target curr = targets[i];

                    if (prev == null || curr.r != prev.r || curr.c != prev.c) {
                        ++count;
                        --plays;
                    }

                    dst[targets[i].r][targets[i].c] = 0;
                    prev = curr;
                }
            }

            // 이동
            for (int j=0; j<M; ++j) {
                if (dst[N-1][j] == 1) {
                    --plays;
                    dst[N-1][j] = 0;
                }
            }
            Arrays.fill(dst[N-1], 0);

            for (int i=N-2; i>=0; --i) {
                for (int j=0; j<M; ++j) {
                    dst[i+1][j] = dst[i][j];
                }
            }

            Arrays.fill(dst[0], 0);
        }
    }

    public static void find(int[] sel, boolean[] attack, Target[] targets) {
        // 좌 상 우 순서
        int[] dr = {0, -1, 0};
        int[] dc = {-1, 0, 1};

        if (chk == 5) {
            System.out.println(Arrays.toString(sel));
        }

        for (int i=0; i<sel.length; ++i) {
            int idxC = sel[i];
            boolean[][] visited = new boolean[N][M];
            Queue<Target> q = new ArrayDeque<>();
            q.add(new Target(N-1, idxC));
            visited[N-1][idxC] = true;

            while(!q.isEmpty()) {
                Target curr = q.poll();

                if (dst[curr.r][curr.c] == 1) {
                    attack[i] = true;
                    targets[i] = curr;
                    break;
                }

                for (int j=0; j<3; ++j) {
                    int nextR = curr.r + dr[j];
                    int nextC = curr.c + dc[j];

                    if (isValid(nextR, nextC) && !visited[nextR][nextC] && calcDist(nextR, nextC, idxC) <= D) {
                        visited[nextR][nextC] = true;
                        q.add(new Target(nextR, nextC));
                    }
                }
            }
        }

    }

    public static void copyMap() {
        for (int i=0; i<N; ++i) {
            for (int j=0; j<M; ++j) {
                dst[i][j] = map[i][j];
            }
        }
    }

    public static int calcDist(int r, int c, int archerC) {
        return (N-r) + Math.abs(archerC - c);
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
