import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이진수표현_10726 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<=T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int chk = ((int) Math.pow(2, N)) - 1;

            String result = (M & chk) == chk ? "ON" : "OFF";
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(result);
            System.out.println(sb);
        }
    }
}
