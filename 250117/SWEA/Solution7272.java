import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution7272 {
    static String[] strings = new String[] {"CEFGHIJKLMNSTUVWXYZ", "ADOPQR", "B"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<=T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();

            String result = s1.length() == s2.length() ? "SAME" : "DIFF";

            for (int i=0; i<s1.length(); ++i) {
                if (result == "DIFF") {
                    break;
                }
                String sub1 = s1.substring(i, i+1);
                String sub2 = s2.substring(i, i+1);
                for (String string : strings) {
                    if (!((string.contains(sub1) && string.contains(sub2)) || (!string.contains(sub1) && !string.contains(sub2)))) {
                        result = "DIFF";
                        break;
                    }

                }
            }

            System.out.println("#" + t + " " + result);
        }


    }
}
