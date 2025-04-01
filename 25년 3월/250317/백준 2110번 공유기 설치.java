import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int n,c, ans = 0;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		//--------------솔루션 코드를 작성하세요.--------------------------------
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
	
		arr = new int[n];
		
		int x;
		for(int i = 0; i < n;i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			arr[i] = x;
		}
		
		solve();
		
		System.out.println(ans);
	}

	private static void solve() {
		Arrays.sort(arr);
		
		int l = 0, r= 1000000000;

		while(l<=r) {
			int mid = r - (r-l)/2;
			
			// System.out.println(mid);
			if(chk(mid)) {
				ans =Math.max(ans, mid);
				l = mid +1;		
			}
			else
				r = mid-1;	
		}

	}

	private static boolean chk(int mid) {
		int sel = 0, cnt = 1;
		
		for(int i = 1; i < n;i++) 
			if(arr[i] - arr[sel] >= mid) {
				sel = i;
				cnt++;
			}
	
		
		if(cnt >= c)
			return true;
		else
			return false;
	}
}