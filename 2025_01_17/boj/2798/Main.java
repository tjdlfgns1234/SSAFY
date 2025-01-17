import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] numarr = new int[n]; 
		String[] arr = br.readLine().split(" ");
		
		for (int i = 0; i < n; i++) {
			numarr[i] = Integer.parseInt(arr[i]);
		}
		
		int max = 0;
		int temp;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					temp = numarr[i] + numarr[j] + numarr[k];
					if (temp <= m) {
						max = Math.max(max, temp);
					}
				}
			}
		}
		System.out.println(max);
		
		
	}

}
