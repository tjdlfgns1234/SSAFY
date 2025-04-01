import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJHashing {
   public static void main(String[] args) throws NumberFormatException, IOException {
    int result = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    
    int[] arr = new int[n];
    int[] gop = new int[n];
    String line = br.readLine();
    for(int i = 0; i < n; i++){
        arr[i] = (int) line.charAt(i) -96;
    }

    int base = 31;
    gop[0] = 1;
    for(int i = 1; i < n; i++){
        gop[i] = gop[i-1]*base;
    }

    for(int i = 0; i < n; i++){
        result += arr[i] * gop[i];
    }
    
    System.out.println(result);
   }
}
