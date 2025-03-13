import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ동전_0 {

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    int n = Integer.parseInt(line[0]);
    int k = Integer.parseInt(line[1]);

    int[] cost = new int[n];
    for(int i = 0; i < n; i++){
        cost[i] = Integer.parseInt(br.readLine());
    }

    int result = 0;
    for(int i = n-1; i >= 0; i--){
        result += k / cost[i];
        k = k%cost[i];
    }

    System.out.println(result);
}

}
