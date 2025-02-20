package beakjoon7569;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static byte[] dx = { -1, 0, 1, 0, 0, 0 };
    static byte[] dy = { 0, 1, 0, -1, 0, 0 };
    static byte[] dz = { 0, 0, 0, 0, 1, -1 };

    static class Point {
        byte x, y, z;

        public Point(byte x, byte y, byte z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

    }

    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            String[] line = br.readLine().trim().split(" ");
            byte M = Byte.parseByte(line[0]);
            byte N = Byte.parseByte(line[1]);
            byte H = Byte.parseByte(line[2]);

            byte[][][] boxes = new byte[H][N][M];
            int[][][] ripenDay = new int[H][N][M];
            int freshCount = 0;
            Deque<Point> dq = new ArrayDeque<>();

            for (int k = 0; k < H; k++) {
                for (int i = 0; i < N; i++) {
                    line = br.readLine().trim().split(" ");
                    for (int j = 0; j < M; j++) {
                        boxes[k][i][j] = Byte.parseByte(line[j]);
                        if (boxes[k][i][j] == 0)
                            freshCount += 1;
                        else if (boxes[k][i][j] == 1)
                            dq.add(new Point((byte) i, (byte) j, (byte) k));
                    }
                }
            }

            if (freshCount == 0) {
                // 다익었네
                System.out.println(0);
                continue;
            }

            int maxDay = 0;
            while (!dq.isEmpty()) {
                Point now = dq.pollFirst();
                byte nx, ny, nz;
                for (int i = 0; i < 6; i++) {
                    nx = (byte) (now.x + dx[i]);
                    ny = (byte) (now.y + dy[i]);
                    nz = (byte) (now.z + dz[i]);
                    if (isInBox(nx, ny, nz, N, M, H) && boxes[nz][nx][ny] == 0) {
                        boxes[nz][nx][ny] = 1;
                        maxDay = ripenDay[nz][nx][ny] = ripenDay[now.z][now.x][now.y] + 1;
                        dq.add(new Point(nx, ny, nz));
                        freshCount -= 1;
                    }
                }
            }
            if (freshCount != 0) {
                System.out.println(-1);
            } else {
                System.out.println(maxDay);
            }
        }
    }

    private static boolean isInBox(byte nx, byte ny, byte nz, int N, int M, int H) {
        return (nx >= 0 && ny >= 0 && nz >= 0 && nx < N && ny < M && nz < H);
    }
}
