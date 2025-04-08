
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class SWEA최장_최장_증가_부분_수열 {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int T = Integer.parseInt(br.readLine());
       for(int t = 1; t<=T; t++) {
    	   int n = Integer.parseInt(br.readLine());
    	   
    	   int[] arr = new int[n];
    	   String[] line = br.readLine().split(" ");
    	   for(int i = 0; i < n; i++) {
    		   arr[i] = Integer.parseInt(line[i]);
    	   }
    	   
    	   int[] lis = new int[n];
    	   Arrays.fill(lis, 1);
    	   
    	   for(int i = 0; i < n; i++) {
    		   for(int j = 0; j < i; j++) {
    			   if(arr[j] < arr[i] && lis[i] < lis[j]+1) {
    				   lis[i] = lis[j] + 1;
    			   }
    		   }
    	   }
    	   
    	   int max = 0;
    	   for(int i = 0; i < n; i++) {
    		   if(max < lis[i]) {
    			   max = lis[i];
    		   }
    	   }
    	   System.out.println("#"+t+" "+max);
    	   
       }
    }
}
