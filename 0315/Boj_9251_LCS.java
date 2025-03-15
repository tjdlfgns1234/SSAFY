import java.io.*;
import java.util.Arrays;

public class Boj_9251_LCS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] dp = new int[s1.length()+1][s2.length()+1];

        //두 문자열 길이 다를 수 있음
        for(int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else {
                    if (s1.charAt(i-1) == s2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] + 1;  //!!!!!
                    }
                    else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }

            }
        }
        for (int i = 0; i < s1.length()+1; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(dp[s1.length()][s2.length()]);
    }
}
