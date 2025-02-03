package solving.swea7733;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static class Point {
        public int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int row = Integer.parseInt(br.readLine());
            int[][] cheeses = new int[row][row];
            boolean[][] eat = new boolean[row][row];
            for (int i = 0; i < row; i++) {
                String[] line = br.readLine().trim().split(" ");
                for (int j = 0; j < row; j++) {
                    cheeses[i][j] = Integer.parseInt(line[j]);
                }
            }
            int maxChunk = 1; // 여기 틀리기 쉬운것 같습니다 maxChunk를 1로 잡는 이유는 처음에 모두 한덩이이기 때문입니다.
            for (int index = 1; index <= 100; index++) {
                eatCheeses(cheeses, eat, index);
                int chunkCount = cheesesCount(cheeses, eat);
                maxChunk = Math.max(maxChunk, chunkCount);
            }
            bw.write("#" + tc + " " + maxChunk);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }

    private static void eatCheeses(int[][] cheeses, boolean[][] eat, int i) {
        for (int j = 0; j < eat.length; j++) {
            for (int k = 0; k < eat[0].length; k++) {
                if (cheeses[j][k] == i) {
                    eat[j][k] = true;
                }
            }
        }
    }

    private static int cheesesCount(int[][] cheeses, boolean[][] eat) {
        boolean[][] visit = new boolean[eat.length][eat.length];
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        int chunk = 0;
        // for (int i = 0; i < visit.length; i++) {
        // visit[i] = Arrays.copyOf(eat[i], eat[i].length);
        // }
        Deque<Point> deque = new ArrayDeque<>();
        for (int i = 0; i < cheeses.length; i++) {
            for (int j = 0; j < cheeses[0].length; j++) {
                if (eat[i][j] == false && visit[i][j] == false) {
                    deque.add(new Point(i, j));
                    visit[i][j] = true;
                    while (!deque.isEmpty()) {
                        Point now = deque.pollFirst();
                        for (int k = 0; k < 4; k++) {
                            int nx = now.x + dx[k];
                            int ny = now.y + dy[k];
                            if (isInArr(nx, ny, eat) && eat[nx][ny] == false && visit[nx][ny] == false) {
                                deque.add(new Point(nx, ny));
                                visit[nx][ny] = true;
                            }
                        }
                    }
                    chunk += 1;
                }
            }
        }
        return chunk;
    }

    private static boolean isInArr(int nx, int ny, boolean[][] eat) {
        return (nx >= 0 && nx < eat.length && ny >= 0 && ny < eat.length);
    }
}