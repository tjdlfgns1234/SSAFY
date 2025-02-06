package solving.baekjoon7576;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/*
 * baekjoon 7576
 * 토마토
 * 이차원 배열로 받은 토마토
 * 이미 익어 있는 경우 사방 한칸 익힌다.
 * -1은 익지 않은 토마토
 * 모두 익힐 수 없다면 -1 출력, 기본은 토마토가 모두 익는 최소 날짜 출력
 * 배열을 한번 순회 하여 익은 토마토의 근처를 익히는 반복? O(N^2 * days) ?
 * 위에건 개떡같은 코드 그냥 일반 bfs를 하며,
 * 익은 날짜는 별도의 배열 또는 객체의 값으로 사용하면 된다. O(N^2);
 * 
 */
public class Main {
    private static int[] dr = { -1, 0, 1, 0 };
    private static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            String[] line = br.readLine().trim().split(" ");
            int row = Integer.parseInt(line[1]);
            int col = Integer.parseInt(line[0]);

            int[][] box = new int[row][col];
            for (int i = 0; i < row; i++) {
                line = br.readLine().trim().split(" ");
                for (int j = 0; j < col; j++) {
                    box[i][j] = Integer.parseInt(line[j]);
                }
            }

            Deque<Point> deque = new ArrayDeque<>();
            // 익혀지는 날짜 확인 배열
            int[][] day = new int[row][col];
            // boolean[][] checkedTomato = new boolean[row][col];
            int notRiped = 0;
            for (int i = 0; i < box.length; i++) {
                for (int j = 0; j < box[0].length; j++) {
                    if (box[i][j] == 1) {
                        deque.add(new Point(i, j));
                        // checkedTomato[i][j] = true;
                    } else if (box[i][j] == 0) {
                        notRiped += 1;
                    }
                }
            }

            int maxDay = 0;
            // 큐에 넣은 토마토 주변 익히기
            while (!deque.isEmpty()) {
                Point now = deque.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = now.x + dr[i];
                    int nc = now.y + dc[i];
                    if (isInBox(nr, nc, box) && box[nr][nc] == 0) {
                        box[nr][nc] = 1;
                        maxDay = day[nr][nc] = day[now.x][now.y] + 1;
                        notRiped -= 1;
                        deque.add(new Point(nr, nc));
                    }
                }
            }
            System.out.println(notRiped == 0 ? maxDay : -1);
        }
    }

    private static boolean isInBox(int nr, int nc, int[][] box) {
        return (nr >= 0 && nr < box.length && nc >= 0 && nc < box[0].length);
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
