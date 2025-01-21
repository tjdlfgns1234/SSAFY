import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t < 11; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[100];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < n; i++) {
				
				arr[find_max(arr)] -= 1;
				arr[find_min(arr)] += 1;
			}
			System.out.printf("#%d %d\n",t, arr[find_max(arr)] - arr[find_min(arr)]);
		}
	}
	
	static int find_min(int[] arr) {
		int idx = 0 ;
		int min = 101;
		for(int i = 0; i < 100; i++) {
			if(min > arr[i]) {
				idx = i;
				min = arr[i];
			}
		}
		return idx;
	}
	
	static int find_max(int[] arr) {
		int idx = 0 ;
		int max = 0;
		for(int i = 0; i < 100; i++) {
			if(max < arr[i]) {
				idx = i;
				max = arr[i];
			}
		}
		return idx;
	}
}
