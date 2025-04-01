import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ롤_케이크 {
   public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] cake = new int[n];

    int maxIdx = -1;
    int maxValue = Integer.MIN_VALUE;

    int m = Integer.parseInt(br.readLine());
    int[][] bang = new int[m][3];
    for(int i = 1; i <= m; i++){
        int[] range = new int[3];
        String[] line = br.readLine().split(" ");
        range[0] = Integer.parseInt(line[0])-1;
        range[1] = Integer.parseInt(line[1])-1;
        range[2] = range[1] - range[0];

        if(range[2] > maxValue){
            maxIdx = i;
            maxValue = range[2];
        }
        
        for(int j = range[0]; j <= range[1]; j++){
            if(cake[j] == 0){
                cake[j] = i;
            }
        }

        bang[i-1] = range;

    }

    //index counting
    int[] counting = new int[m];
    for(int i = 0; i < cake.length; i++){
        if(cake[i] != 0){
            counting[cake[i]-1]++;
        }
    }

    int realMaxIdx = 1;
    int realMaxValue = counting[0];
    
    for(int i = 1; i < m ;i++){
        if(realMaxValue < counting[i] ){
            realMaxIdx = i+1;
            realMaxValue = counting[i];
        }
    }
    System.out.println(maxIdx);
    System.out.println(realMaxIdx);
    
   }
}
