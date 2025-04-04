import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ피보나치_수 {
    static int[] memo = new int[46];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(fibo(n));
        
    }
    
    static int fibo(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;

        int n1, n2;
        if(memo[n-1] == 0){
            n1 = fibo(n-1);
            memo[n-1] = n1;
        }else{
            n1 = memo[n-1];
        }

        if(memo[n-2] == 0){
            n2 = fibo(n-2);
            memo[n-2] = n2;
        }else{
            n2 = memo[n-2];
        }
        

        return n1 + n2;
    }
}
