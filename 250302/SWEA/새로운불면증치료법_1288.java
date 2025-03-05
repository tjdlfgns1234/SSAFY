import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 새로운불면증치료법_1288 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<=T; ++t) {
            int N = Integer.parseInt(br.readLine());
            int chk = 0; // 1024면 끝?
            int i = 1;

            while(chk < 1023) {
                int sheep = N * i;
                while (sheep > 0) {
                    int tmp = sheep % 10;
                    sheep /= 10;
                    chk = chk | (1 << tmp);
                }
                ++i;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(N*(i-1)).append("\n");
//            System.out.println(sb);
            bw.write(sb.toString());
            bw.flush();
        }
    }
}
