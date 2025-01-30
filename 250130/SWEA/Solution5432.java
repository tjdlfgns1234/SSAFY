import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution5432 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<=T; ++t) {

            String s = br.readLine();

            int newPipe = 0;
            int oldPipe = 0;
            int pipeCount = 0;

            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '(') {
                    if (isLaser(s, i)) {
                        pipeCount += newPipe * 2;
                        pipeCount += oldPipe;
                        oldPipe += newPipe;
                        newPipe = 0;
                        ++i;
                    } else {
                        ++newPipe;
                    }
                } else {
                    if (newPipe == 0) {
                        --oldPipe;
                    } else {
                        --newPipe;
                    }
                }
            }

            System.out.println("#" + t + " " + pipeCount);
        }
    }

    public static boolean isLaser(String s, int idx) {
        return (idx != s.length()-1) && s.charAt(idx+1) == ')';
    }
}
