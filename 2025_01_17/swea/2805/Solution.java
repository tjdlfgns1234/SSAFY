import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
 
public class Solution
{
    public static void main(String args[]) throws Exception
    {   
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for(int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] numarr = new int[n][n];
             
            for (int i = 0; i < n; i++) {
                int[] temp = new int[n];
                String str = br.readLine();
                for (int j = 0; j < n; j++) {
                    temp[j] = str.charAt(j) - '0';
                }
                numarr[i] = temp;
            }
             
            int result = 0;
             
            for (int i = 0; i <= n / 2; i++) {
                for (int j = n / 2 - i; j <= n / 2 + i + 1 / 2; j++) {
                    result += numarr[i][j];
                }
            }
 
            for (int i = n / 2 + 1; i < n; i++) {
                for (int j = i - n / 2; j < n - i + n / 2; j++) {
                    result += numarr[i][j];
                }
            }
            System.out.printf("#%d %d\n", t + 1, result);
        }
    }
}