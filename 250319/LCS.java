import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LCS {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] lcs;

    public static void main(String[] args) throws Exception{
        String a = br.readLine();
        String b = br.readLine();
        lcs = new int[a.length()+1][b.length()+1];

        for(int i=1;i<=a.length();i++){
            for(int j=1;j<=b.length();j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    lcs[i][j] = lcs[i-1][j-1]+1;
                }
                else{
                    lcs[i][j] = Math.max(lcs[i][j-1],lcs[i-1][j]);
                }
            }
        }

        System.out.println(lcs[a.length()][b.length()]);

    }

}
