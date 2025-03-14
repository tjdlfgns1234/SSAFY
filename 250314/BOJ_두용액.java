import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_두용액 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n]; 
        String[] line = br.readLine().split(" ");

        for(int i = 0; i < line.length; i++){
            arr[i] = Integer.parseInt(line[i]);
        }

        //정렬
        Arrays.sort(arr);
        
        int[] result = new int[2];
        int diff = Integer.MAX_VALUE;

        
        
        int right = n-1;
        int left = 0;
        while(right > left){
            int tempDiff = arr[right] + arr[left];
            if(Math.abs(tempDiff) < diff){
                result[0] = left;
                result[1] = right;
                diff = Math.abs(tempDiff);
            }
            if (tempDiff > 0){
                right--;
            }else{
                left++;
            }

        }
        System.out.println(arr[result[0]] + " "+ arr[result[1]]);
        
    }
    

    
}
