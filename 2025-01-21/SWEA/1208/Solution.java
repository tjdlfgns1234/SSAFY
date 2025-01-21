import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t < 11; t++) {
			
			int n = Integer.parseInt(br.readLine());
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int i = 0; i < n; i++) {
				Arrays.sort(arr);
				arr[99] -= 1;
				arr[0] += 1;
			}
			Arrays.sort(arr);
			System.out.printf("#%d %d\n",t, arr[99] - arr[0]);
			arr = null;
		}
	}
}
