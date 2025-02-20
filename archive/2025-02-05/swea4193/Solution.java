package solving.swea4193;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 수영대회 결승전
 * 장애물과 소용돌이 시작점부터 끝점까지 갈 수 있는 최소경로 탐색
 * 무방향 최단시간 탐색이므로 bfs 가 적합할 것 같습니다.
 * 사방탐색과 제자리대기를 하며 5가짓수로 bfs 하는 방법 O(5^N)
 * 소용돌이 통과에 걸린 시간만큼 패널티를 먹이는 방법 O(4^N)
 * 수영장 크기가 최대 15 이므로 최대 5^(15*15)??? 너무 크지 않나?
 * 
 * 입력은
 * 수영장 크기
 * 수영장
 * 0은 이동가능 1은 장애물 2는 소용돌이
 * 시작점
 * 도착점
 * 
 * 출력은 #테케번호 최단이동시간
 * 만약 도착할 수 없다면 -1 출력
 * 
 * Point클래스를 선언하고 행, 열 좌표와 해당 포인트까지 걸린 시간을 측정
 * bfs 로 풀지만 일반적인 queue bfs로 풀 시 패널티를 먹고 이미 도착한 경우 방문처리 되어
 * 더 작은 시간으로 도착해도 값 갱신 불가 및 최소시간 보장 안됨
 * 이 경우에는 bfs를 주변 탐색 + 제자리 대기로 풀거나
 * 우선순위 큐를 사용해 걸린시간 기준으로 적은 시간부터 탐색한다.
 */

public class Solution {
    private static int[] dr = { -1, 0, 1, 0 };
    private static int[] dc = { 0, 1, 0, -1 };

    private static class Point {
        public int row, col, sec = 0;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public Point(int row, int col, int sec) {
            this(row, col);
            this.sec = sec;
        }

    }

    public static void main(String[] args) throws Exception {
        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int poolSize = Integer.parseInt(br.readLine().trim());
            int[][] pool = new int[poolSize][poolSize];
            String[] line;
            for (int i = 0; i < poolSize; i++) {
                line = br.readLine().trim().split(" ");
                for (int j = 0; j < poolSize; j++) {
                    pool[i][j] = Integer.parseInt(line[j]);
                }
            }
            line = br.readLine().trim().split(" ");
            Point start = new Point(Integer.parseInt(line[0]), Integer.parseInt(line[1]), 0);
            line = br.readLine().trim().split(" ");
            Point end = new Point(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
            int minTime = bfs(pool, start, end);
            System.out.println("#" + tc + " " + minTime);
        }
    }

    private static int bfs(int[][] pool, Point start, Point end) throws Exception {
        // Deque<Point> deque = new ArrayDeque<>();
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(point -> point.sec));
        boolean[][] visit = new boolean[pool.length][pool[0].length];
        pq.add(start);
        visit[start.row][start.col] = true;
        while (!pq.isEmpty()) {
            Point now = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now.row + dr[i];
                int nc = now.col + dc[i];
                if (isInPool(nr, nc, pool) && pool[nr][nc] != 1 && !visit[nr][nc]) {
                    int nextSec = now.sec + 1;
                    if (pool[nr][nc] == 2) {
                        nextSec += (pool[nr][nc] - (now.sec % 3));
                    }
                    if (nr == end.row && nc == end.col) {
                        pq.clear();
                        return nextSec;
                    }
                    pq.add(new Point(nr, nc, nextSec));
                    visit[nr][nc] = true;
                }
            }
        }

        return -1;
    }

    private static boolean isInPool(int nr, int nc, int[][] pool) {
        return (nr >= 0 && nr < pool.length && nc >= 0 && nc < pool[0].length);
    }
}
