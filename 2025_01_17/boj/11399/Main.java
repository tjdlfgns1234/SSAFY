import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		
		int[] numarr = new int[n]; 
		String[] arr = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			numarr[i] = Integer.parseInt(arr[i]);
		}
		
		
		Arrays.sort(numarr);
		int result = 0;
		for (int i = 0; i < n; i++) {
			result += numarr[i] * (n - i);
		}
		System.out.println(result);
	}

}