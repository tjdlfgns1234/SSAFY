import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
 
public class Solution
{
    public static void main(String args[]) throws Exception
    {   
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            ArrayList<Integer> numarr = new ArrayList<Integer>();
             
            for (char temp : st.nextToken().toCharArray()) {
                numarr.add(temp - '0');
            }
            int index = 0;
            while(true) {
                if (index >= numarr.size() - 1) {
                    break;
                }
                else if(numarr.get(index).equals(numarr.get(index + 1))) {
                    numarr.remove(index);
                    numarr.remove(index);
                    index = 0;
                }
                else {
                    index ++;
                }
            }
            System.out.printf("#%d ", t);
            for(int temp : numarr) {
                System.out.printf("%d", temp);
            }
            System.out.println();
        }
    }
}