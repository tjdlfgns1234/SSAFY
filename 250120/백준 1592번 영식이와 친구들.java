import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" "); // 입력받은 값을 공백을 기준으로 나눔

	    int n = Integer.parseInt(input[0]); 
        int m = Integer.parseInt(input[1]); 
        int l = Integer.parseInt(input[2]); 
        
        int[] dp = new int[51];
        int ball = 0, ans = 0;

        while(true){
            dp[ball]++;

            if(dp[ball] == m)
                break;

            ans++;
            int nx;

            if(dp[ball] % 2 == 1)
                nx = (ball + l)%n;
            else
                nx = (ball -l + n)%n;

            ball = nx;
        }
        bw.write(ans);

	
        bw.flush();
        bw.close();
        br.close();
    }
}