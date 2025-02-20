import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution6808 {

    static int gyPoint, iyPoint;
    static boolean[] used;
    static int[] possible;
    static int[] gy;
    static int win, lose;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<=T; ++t) {
            gy = new int[9];
            StringTokenizer st = new StringTokenizer(br.readLine());
            used = new boolean[18+1];

            for (int i=0; i<9; ++i) {
                gy[i] = Integer.parseInt(st.nextToken());
                used[gy[i]] = true;
            }

            possible = new int[9];

            int idx = 0;
            for (int i=1; i<used.length; ++i) {
                if (!used[i]) {
                    possible[idx] = i;
                    ++idx;
                }
            }

            win = 0;
            lose = 0;

            recursive(new int[9], 0, 0, 0);

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(win).append(" ").append(lose);
            System.out.println(sb);
        }
    }

    public static void recursive(int[] iy, int idx, int gyPoint, int iyPoint) {

        if (idx == iy.length) {
            if (gyPoint > iyPoint) {
                ++win;
            }
            else if (iyPoint > gyPoint) {
                ++lose;
            }
            return;
        }

        for (int i=0; i<9; ++i) {
            if (!used[possible[i]]) {
                used[possible[i]] = true;
                iy[idx] = possible[i];

                int gCard = gy[idx];
                int iCard = iy[idx];

                int sum = gCard + iCard;
                if (gCard > iCard) {
                    recursive(iy, idx+1, gyPoint + sum, iyPoint);
                }
                else {
                    recursive(iy, idx+1, gyPoint, iyPoint + sum);
                }

                used[possible[i]] = false;
            }
        }

    }

}