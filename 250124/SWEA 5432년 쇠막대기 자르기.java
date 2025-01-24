import java.io.*;
import java.util.*;
 
public class Solution {
 
    static int ans = 0;
//  static int[] dy = {0,0, 1,-1};
// 
    // static int[][] map = new int[n][n];
     
    /*
     * 현재 선택이 미래의 선택에 영향을 주면 그리디 안됨!
     * 
     * */
     
     
    public static void main(String[] args) throws IOException {
        // System.setIn(Solution.class.getResourceAsStream("text.txt"));
        // Scanner sc = new Scanner(System.in);
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t =  Integer.parseInt(br.readLine());
         
        for(int testcase = 1; testcase <= t;testcase++) {
            String s = br.readLine();
            ans = 0;
            int sum = 0; // 지금까지 (의 수
            for(int i = 0; i < s.length();i++){
                // System.out.println(s.charAt(i) + " " + sum + " " + ans);
                 
                if(s.charAt(i) == '(') {
                    sum++;
                    if(i > 0 && s.charAt(i) == '(' && s.charAt(i-1) == '(') 
                        ans++;
                }
                else if(s.charAt(i) == ')' && s.charAt(i-1) == '('){
                    sum--;
                    ans+= sum;
                }
                else {
                    sum--;
                }
            }
            System.out.println("#" + testcase + " " + ans);
        }
 
    }
 
}