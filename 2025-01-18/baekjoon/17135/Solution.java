import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./noj.am/BAEKJOON/solving/17135/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            String[] part = br.readLine().trim().split(" ");
            int N = Integer.parseInt(part[0]), M = Integer.parseInt(part[1]), D = Integer.parseInt(part[2]);
            int[][] map = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().trim().split(" ");
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(line[j]);
                }
            }
            int maxKill = 0;
            maxKill = simulateGame(map, N, M, D);
            System.out.println(maxKill);

        }
        br.close();
    }

    // 2차원 배열 맵 출력
    private void printMap(int[][] map) {
        System.out.println("Map:");
        for (int[] row : map) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

    }

    // 게임 시뮬레이션!
    private static int simulateGame(int[][] map, int N, int M, int D) {
        int maxKill = Integer.MIN_VALUE;
        boolean[][][] allDistMap = allDistanceMap(N, M, D);
        for (int i = 0; i < M - 2; i++) {
            for (int j = i + 1; j < M - 1; j++) {
                for (int k = j + 1; k < M; k++) {
                    int[] archers = { i, j, k };
                    int kill = enemyShootCount(map, N, M, archers, allDistMap);
                    maxKill = Math.max(maxKill, kill);
                }
            }
        }

        return maxKill;
    }

    // 사격 시뮬레이션
    private static int enemyShootCount(int[][] map, int N, int M, int[] archers, boolean[][][] allDistMap) {
        int enemyShootCount = 0;
        Deque<int[]> enemysToShoot = new ArrayDeque<>();
        int[][] copyMap = Arrays.stream(map).map(row -> Arrays.copyOf(row, row.length)).toArray(int[][]::new);

        boolean isMapEmpty = isMapEmpty(copyMap, N, M);

        while (!isMapEmpty) {
            // 쏠 좌표 확인
            for (int i = 0; i < 3; i++) {
                int[] enemyCoordinate = shoot(copyMap, N, M, archers[i], allDistMap);
                if (enemyCoordinate != null) {
                    enemysToShoot.add(enemyCoordinate);
                }
            }
            // 좌표에 맞춰 쏘고
            while (!enemysToShoot.isEmpty()) {
                int[] coordinate = enemysToShoot.poll();
                if (copyMap[coordinate[0]][coordinate[1]] == 1) {
                    copyMap[coordinate[0]][coordinate[1]] = 0;
                    enemyShootCount += 1;
                }
                copyMap[coordinate[0]][coordinate[1]] = 0;
            }
            // 맵 한칸 땡기기
            for (int i = N - 1; i > 0; i--) {
                copyMap[i] = copyMap[i - 1];
            }
            copyMap[0] = new int[M];

            isMapEmpty = isMapEmpty(copyMap, N, M);

        }

        return enemyShootCount;
    }

    // 쏠수있어!! 라면 좌표반환 아니라면 null반환
    private static int[] shoot(int[][] map, int N, int M, int archer, boolean[][][] allDistMap) {
        int[] coordinate = new int[2];
        int[] start = { N - 1, archer };
        boolean[][] visited = new boolean[N][M];
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(start);
        visited[start[0]][start[1]] = true;
        while (!deque.isEmpty()) {
            coordinate = deque.pollFirst();
            int x = coordinate[0], y = coordinate[1];

            // 사정거리 내일 경우
            if (allDistMap[archer][x][y] == true) {
                // 적이 있는지 확인하고 적이 있으면 좌표 리턴
                if (map[x][y] != 0) {
                    return coordinate;
                } else if (map[x][y] == 0) { // 적이 없으면 다음 사정거리의 적을 순서대로 큐에 추가하고 반환 (이미 검사했다면 추가안함)
                    // visited 배열 말고 해당 좌표가 지금 다음 사정거리로 큐에 들어있는지만 확인해도 되나? -> 이전 사정거리는 바로 측정이 안되는구나
                    if (y > 0 && (!visited[x][y - 1])) { // 왼쪽
                        int[] temp = { x, y - 1 };
                        deque.add(temp);
                        visited[x][y - 1] = true;
                    }
                    if (x > 0 && (!visited[x - 1][y])) { // 위쪽
                        int[] temp = { x - 1, y };
                        deque.add(temp);
                        visited[x - 1][y] = true;
                    }
                    if (y < M - 1 && (!visited[x][y + 1])) { // 오른쪽
                        int[] temp = { x, y + 1 };
                        deque.add(temp);
                        visited[x][y + 1] = true;
                    }
                } else {
                    // no action in here
                }
            }
        }
        // if no enemy to shoot -> return null
        return null;
    }

    private static boolean isMapEmpty(int[][] map, int N, int M) {
        boolean empty = true;

        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                if (map[i][j] != 0) {
                    empty = false;
                    return empty;
                }
            }
        }
        return empty;
    }

    // 모든 위치의 거리별 맵을 반환
    private static boolean[][][] allDistanceMap(int N, int M, int D) {
        boolean[][][] allDistMap = new boolean[M][N][M];
        for (int i = 0; i < M; i++) {
            allDistMap[i] = distanceMap(N, M, D, i);
        }
        return allDistMap;
    }

    // 궁수 별 공격범위 맵을 반환
    private static boolean[][] distanceMap(int N, int M, int D, int archer) {

        boolean[][] dMap = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int distance = calcDistance(i, j, N, archer);
                if (distance <= D) {
                    dMap[i][j] = true;
                } else if (distance > D) {
                    dMap[i][j] = false;
                } else {
                    // 이곳에는 아무것도 하지 않습니다.
                }
            }
        }
        return dMap;
    }

    private static int calcDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }
}
