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
		int l = Integer.parseInt(st.nextToken());
		
		int[] ball = new int[n];
		int cnt= 0;
		int index = 0;
		
		while(true) {
			ball[index] += 1;
			if (ball[index] == m) {
				break;
			}
			
			index += l;
			if (index >= n) {
				index %= n;
			}
			
			cnt += 1;
			
		}
		
		System.out.println(cnt);
		
	}

}