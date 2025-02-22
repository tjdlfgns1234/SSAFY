import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 암호생성기_1225 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int t=1; t<=T; ++t) {
            int min = Integer.MAX_VALUE;

            br.readLine();
            int[] pass = new int[8];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0; i<8; ++i) {
                pass[i] = Integer.parseInt(st.nextToken());
                min = Math.min(min, pass[i] / 15);
            }

            for (int i=0; i<8; ++i) {
                pass[i] -= (15 * (min-1));
            }
//			System.out.println("min" + min);

            int idx = play(pass);
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");
            int count = 0;
            while (count < 8) {
                sb.append(pass[idx]).append(" ");
                idx = (idx+1) % 8;
                ++count;
            }

            System.out.println(sb);
        }
    }

    public static int play(int[] pass) {
        int idx = 0;
        int value = 0;

        while (true) {
            int gap = 1 + (value % 5);
            pass[idx] -= gap;
            if (pass[idx] <= 0) {
                pass[idx] = 0;
                break;
            }
            idx = (idx + 1) % 8;
            ++value;
        }

        return idx+1;

    }
}
