import java.io.*;
//import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int k = 0 ; k < t ; k++) {
            String[] input1 = br.readLine().split(" ");
            int n = Integer.parseInt(input1[0]); // 보드 크기
            int[][] map = new int[n + 2][n + 2];

            int mid = n / 2;
            map[mid][mid] = 2;
            map[mid + 1][mid + 1] = 2;
            map[mid][mid + 1] = 1;
            map[mid + 1][mid] = 1;

            int m = Integer.parseInt(input1[1]); // 돌을 놓는 횟수
            for (int i = 0 ; i < m ; i++) {
                String[] input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                int d = Integer.parseInt(input[2]);

                map[x][y] = d;
                map = search(x, y, d, map);
            }

            int countBlack = 0;
            int countWhite = 0;
            for (int i = 1 ; i <= n ; i++) {
                for (int j = 1 ; j <= n ; j++) {
                    if (map[i][j] == 1) {
                        countBlack++;
                    } else if (map[i][j] == 2) {
                        countWhite++;
                    }
                }
            }
            System.out.printf("#%d %d %d\n", k+1, countBlack, countWhite);
        }
        br.close();
    }

    private static int[][] search(int x, int y, int d, int[][] map) {
    	int op;
    	if (d == 1) {
    	    op = 2;
    	} else {
    	    op = 1;
    	}

        // 아래
        if (map[x + 1][y] == op) {
            int count = 0;
            int i = 0;
            while (true) {
                count++;
                i++;
                if (map[x + i][y] == 0)
                	break;
                if (map[x + i][y] == d) {
                    for (int j = 1 ; j < count ; j++) {
                        map[x + j][y] = d;
                    }
                    break;
                }
            }
        }

        // 위
        if (map[x - 1][y] == op) {
            int count = 0;
            int i = 0;
            while (true) {
                count++;
                i++;
                if (map[x - i][y] == 0)
                	break;
                if (map[x - i][y] == d) {
                    for (int j = 1 ; j < count ; j++) {
                        map[x - j][y] = d;
                    }
                    break;
                }
            }
        }

        // 왼쪽
        if (map[x][y - 1] == op) {
            int count = 0;
            int i = 0;
            while (true) {
                count++;
                i++;
                if (map[x][y - i] == 0)
                	break;
                if (map[x][y - i] == d) {
                    for (int j = 1 ; j < count ; j++) {
                        map[x][y - j] = d;
                    }
                    break;
                }
            }
        }

        // 오른쪽
        if (map[x][y + 1] == op) {
            int count = 0;
            int i = 0;
            while (true) {
                count++;
                i++;
                if (map[x][y + i] == 0)
                	break;
                if (map[x][y + i] == d) {
                    for (int j = 1 ; j < count ; j++) {
                        map[x][y + j] = d;
                    }
                    break;
                }
            }
        }

        // 오른쪽 아래
        if (map[x + 1][y + 1] == op) {
            int count = 0;
            int i = 0;
            while (true) {
                count++;
                i++;
                if (map[x + i][y + i] == 0)
                	break;
                if (map[x + i][y + i] == d) {
                    for (int j = 1 ; j < count ; j++) {
                        map[x + j][y + j] = d;
                    }
                    break;
                }
            }
        }

        // 왼쪽 아래
        if (map[x + 1][y - 1] == op) {
            int count = 0;
            int i = 0;
            while (true) {
                count++;
                i++;
                if (map[x + i][y - i] == 0)
                	break;
                if (map[x + i][y - i] == d) {
                    for (int j = 1 ; j < count ; j++) {
                        map[x + j][y - j] = d;
                    }
                    break;
                }
            }
        }

        // 오른쪽 위
        if (map[x - 1][y + 1] == op) {
            int count = 0;
            int i = 0;
            while (true) {
                count++;
                i++;
                if (map[x - i][y + i] == 0)
                	break;
                if (map[x - i][y + i] == d) {
                    for (int j = 1 ; j < count ; j++) {
                        map[x - j][y + j] = d;
                    }
                    break;
                }
            }
        }

        // 왼쪽 위
        if (map[x - 1][y - 1] == op) {
            int count = 0;
            int i = 0;
            while (true) {
                count++;
                i++;
                if (map[x - i][y - i] == 0)
                	break;
                if (map[x - i][y - i] == d) {
                    for (int j = 1 ; j < count ; j++) {
                        map[x - j][y - j] = d;
                    }
                    break;
                }
            }
        }
        return map;
    }
}
