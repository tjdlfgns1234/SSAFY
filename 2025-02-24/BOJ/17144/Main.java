import java.util.*;
import java.io.*;

public class Main {

    static class dust{
        int x, y, cost;
        dust(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static int R, T, C;
    static int main_x1, main_y1, main_x2, main_y2;
    static int result;
    static int[][] map;

    // 위, 오른, 아래, 왼
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        main_x1 = 0;
        main_y1 = 0;
        int num;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num == -1) {
                    if (main_x1 != 0) {
                        main_x2 = i;
                        main_y2 = j;
                    } else {
                        main_x1 = i;
                        main_y1 = j;
                    }
                }
            }
        }

        for (int i = 0; i < T; i++) {
            spread();
            blow();
        }
        result = 0;
        calc();
        System.out.println(result);

    }

    //확산 후 공기청정기
    static void spread(){
        Queue<dust> q = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == -1 || map[i][j] <= 4) continue;
                q.add(new dust(i, j, map[i][j]));
            }
        }

        int x, y, amount, nx, ny, cost;
        dust p;
        while (!q.isEmpty()){
            p = q.poll();
            x = p.x;
            y = p.y;
            cost = p.cost;
            amount = 0;
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if(nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == -1) continue;

                map[nx][ny] +=  cost / 5;
                amount += cost / 5;
            }

            map[x][y] = map[x][y] - amount;
        }
    }

    static void blow(){
        //공청 위에
        for (int x = main_x1-1; x > 0; x--) {
            map[x][0] = map[x-1][0];
        }

        for (int y = 0; y < C-1; y++) {
//            if(main_x1 == 0) continue;
            map[0][y] = map[0][y+1];
        }

        for (int x = 0; x < main_x1; x++) {
            map[x][C-1] = map[x+1][C-1];
        }

        for (int i = C-1; i > 1; i--) {
            map[main_x1][i] = map[main_x1][i-1];
        }
        map[main_x1][1] = 0;

        //공청 아래
        for (int x = main_x1+2; x < R-1; x++) {
            map[x][0] = map[x+1][0];
        }

        for (int y = 0; y < C-1; y++) {
//            if(main_x1 == 0) continue;
            map[R-1][y] = map[R-1][y+1];
        }

        for (int x = R-1; x > main_x2; x--) {
            map[x][C-1] = map[x-1][C-1];
        }

        for (int i = C-1; i > 1; i--) {
            map[main_x2][i] = map[main_x2][i-1];
        }
        map[main_x2][1] = 0;
    }

    static void print(){
        System.out.println();
        for (int i = 0; i < R; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }
    static void calc(){
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == -1) continue;
                sum += map[i][j];
            }
        }
        result = sum;
    }

}


