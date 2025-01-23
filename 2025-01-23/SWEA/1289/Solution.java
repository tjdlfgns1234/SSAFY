import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t < T + 1; t++) {
            String str = br.readLine();
            int[] bit = new int[str.length()];
            for(int i = 0; i < str.length(); i++){
                bit[i] = str.charAt(i) - '0';
            }
            int[] result = new int[str.length()];
            int cnt = 0;

            for(int i = 0; i < str.length(); i++){
                if(result[i] != bit[i]){
                    cnt ++;
                    if(result[i] == 1){
                        for(int j = i; j < str.length(); j++){
                            result[j] = 0;
                        }
                    }
                    else{
                        for(int j = i; j < str.length(); j++){
                            result[j] = 1;
                        }
                    }
                }
            }
            System.out.printf("#%d %d",t, cnt);
        }
    }
}
