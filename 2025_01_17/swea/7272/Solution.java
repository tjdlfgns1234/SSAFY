import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
 
public class Solution
{
    public static void main(String args[]) throws Exception
    {   
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        List<Character> alpha0 = Arrays.asList('C','E','F','G','H','I','J','K','L','M','N','S','T','U','V','W','X','Y','Z');
        List<Character> alpha1 = Arrays.asList('A','D','O','P','Q','R');
         
        String result;
         
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
             
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            String temp1 = st.nextToken();
            String temp2 = st.nextToken();
            result = "SAME";
            if (temp1.length() != temp2.length()) {
                result = "DIFF";
            }
            else {
                for (int i = 0; i < temp1.length(); i++) {
                     
                    if(temp1.charAt(i) == 'B' && temp2.charAt(i) == 'B') {
                        continue;
                    }
                    else if(alpha1.contains(temp1.charAt(i)) && alpha1.contains(temp2.charAt(i))){
                        continue;
                    }
                    else if(alpha0.contains(temp1.charAt(i)) && alpha0.contains(temp2.charAt(i))) {
                        continue;
                    }
                    else {
                        result = "DIFF";
                        break;
                    }
                }
                 
            }
             
            System.out.printf("#%d %S\n", t + 1, result);
        }
         
         
         
         
          
    }
}