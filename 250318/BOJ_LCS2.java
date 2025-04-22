import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_LCS2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = " "+br.readLine();
        String str2 = " "+br.readLine();

        int[][] mat = new int[str1.length()][str2.length()];
        for(int i = 1; i < str1.length(); i++){
            for(int j = 1; j < str2.length(); j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    mat[i][j] = mat[i-1][j-1] + 1;
                }else{
                    mat[i][j] = Math.max(mat[i][j-1], mat[i-1][j]);
                }
            }
        }
        
        System.out.println(mat[str1.length()-1][str2.length()-1]);
        

    }
}