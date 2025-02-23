package solving.baekjoon1600;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 다시한번 넣을 때 목표 도착 처리를 하는 경우, 처음 시작점도 같이 검사!!!!
 */

public class Main {
    static final int[] dr = { -1, 0, 1, 0 };
    static final int[] dc = { 0, 1, 0, -1 };
    static final int[] drHorse = { -2, -1, 1, 2, 2, 1, -1, -2 };
    static final int[] dcHorse = { 1, 2, 2, 1, -1, -2, -2, -1 };

    static class Monkey {
        int r, c, horse, move;

        public Monkey(int r, int c, int horse, int move) {
            this.r = r;
            this.c = c;
            this.horse = horse;
            this.move = move;
        }
    }

    static int horseMove, width, height, map[][], T;
    static String[] line;
    static boolean[][][] visit;
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            input(br);
            solution(bw);
        }
        output(bw);
    }

    private static void solution(BufferedWriter bw) throws Exception {
        if (1 == width && 1 == height) {
            bw.write(0 + "");
            bw.newLine();
            return;
        }
        Deque<Monkey> q = new ArrayDeque<>();
        q.offer(new Monkey(0, 0, horseMove, 0));
        visit[horseMove][0][0] = true;

        while (!q.isEmpty()) {
            Monkey now = q.poll();
            for (int direction = 0; direction < 4; direction++) {
                // 기본 사방탐색
                int nr = now.r + dr[direction];
                int nc = now.c + dc[direction];
                int nm = now.move + 1;

                if (isInMap(nr, nc, height, width) && map[nr][nc] == 0 && !visit[now.horse][nr][nc]) {
                    q.offer(new Monkey(nr, nc, now.horse, nm));
                    visit[now.horse][nr][nc] = true;
                    if (height - 1 == nr && width - 1 == nc) {
                        bw.write(nm + "");
                        bw.newLine();
                        return;
                    }
                }
            }
            if (now.horse > 0) {
                int nm = now.move + 1;
                int newHorse = now.horse - 1;
                for (int direction = 0; direction < 8; direction++) {
                    // 말무빙 팔방탐색
                    int nr = now.r + drHorse[direction];
                    int nc = now.c + dcHorse[direction];
                    if (isInMap(nr, nc, height, width) && map[nr][nc] == 0 && !visit[newHorse][nr][nc]) {
                        q.offer(new Monkey(nr, nc, newHorse, nm));
                        visit[newHorse][nr][nc] = true;
                        if (height - 1 == nr && width - 1 == nc) {
                            bw.write(nm + "");
                            bw.newLine();
                            return;
                        }
                    }
                }
            }
        }
        bw.write(-1 + "");
        bw.newLine();
    }

    private static boolean isInMap(int r, int c, int h, int w) {
        return (r >= 0 && c >= 0 && r < h && c < w);
    }

    private static void input(BufferedReader br) throws Exception {
        horseMove = Integer.parseInt(br.readLine().trim());
        line = br.readLine().trim().split(" ");
        width = Integer.parseInt(line[0]);
        height = Integer.parseInt(line[1]);
        map = new int[height][width];
        visit = new boolean[horseMove + 1][height][width];

        for (int i = 0; i < height; i++) {
            line = br.readLine().trim().split(" ");
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
    }

    private static void output(BufferedWriter bw) throws Exception {
        bw.flush();
        bw.close();
    }
}
