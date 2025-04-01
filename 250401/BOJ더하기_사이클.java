import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ더하기_사이클 {
   public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String line = br.readLine();
    char[] pre = new char[2];
    if(line.length() == 2){
        pre[0] = line.charAt(0);
        pre[1] = line.charAt(1);
    }else{
        pre[0] = '0';
        pre[1] = line.charAt(0);
    }
    
    

    int count = 0;
    while(true){
        count++;
        char[] next = new char[2];
        next[0] = pre[1];
        int sum = (pre[0] - '0') + (pre[1] - '0');
        next[1] = (char) ((sum % 10) + '0');

        if(line.length() == 2 && next[0] == line.charAt(0) && next[1] == line.charAt(1)){
            break;
        }else if(line.length() == 1 && next[0] == '0' && next[1] == line.charAt(0)){
            break;
        }else{
            pre[0] = next[0];
            pre[1] = next[1];
        }
    }

    System.out.println(count);
   }
}
