import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2805 {

    public static void main(String[] args) throws IOException {
        //2n + 1
        //n/2-i ~ n/2+i

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<=T; ++t) {
            int N = Integer.parseInt(br.readLine());

            String[] map = new String[N];
            for (int i=0; i<N; ++i) {
                map[i] = br.readLine();
            }

            int result = 0;
            for (int i=0; i<N; ++i) {
                int gap = Math.abs(N/2 - i);
                for (int j=gap; j<N - gap; ++j) {
                    result += getNum(map[i].charAt(j));
                }
            }

            System.out.println("#" + t + " " + result);
        }


    }

    public static int getNum(char c) {
        return Integer.parseInt(Character.toString(c));
    }
}
