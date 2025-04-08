
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class BOJ가장_긴_감소하는_부분_수열 {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
       
       String[] line = br.readLine().split(" ");
       int[] arr = new int[n];
       int count = arr.length-1;
       for(int i = 0; i < n; i++) {
    	   arr[count] = Integer.parseInt(line[i]);
    	   count--;
       }
       
       int[] lis = new int[n];
       Arrays.fill(lis, 1);
       
       for(int i = 0; i < n; i++) {
    	   for(int j = 0; j < i; j++) {
    		   if(arr[j] < arr[i] && lis[i] < lis[j] + 1) {
    			   lis[i] = lis[j] +1;
    		   }
    	   }
       }
       
       int max = 0;
       for(int i = 0; i < n; i++) {
    	   max = Math.max(lis[i], max);
       }
       
       System.out.println(max);
       
       
       
    }
}
