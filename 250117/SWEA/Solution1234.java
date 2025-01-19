import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1234 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t=1; t<=10; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(0));
            for (int i=1; i<s.length(); ++i) {
                if (sb.length() == 0) {
                    sb.append(s.charAt(i));
                }
                else if (sb.charAt(sb.length()-1) == s.charAt(i)) {
                    sb.deleteCharAt(sb.length()-1);
                }
                else {
                    sb.append(s.charAt(i));
                }
            }

            System.out.println("#" + t + " " + sb.toString());
        }
    }
}
