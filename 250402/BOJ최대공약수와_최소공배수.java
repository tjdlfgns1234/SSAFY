import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ최대공약수와_최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        
        int gcdValue = gcd(n, m);
        //gcd
        System.out.println(gcdValue);

        //lcm
        System.out.println(n*m / gcdValue);
        
    }

    static int gcd(int n, int m){
        int remain = n % m;
        if(remain == 0){
            return m;
        }

        return gcd(m, remain);
    }
}
