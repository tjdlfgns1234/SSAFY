import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int ans = 0;
	static int n,m;
	static boolean[] vit = new boolean[1001];
	static int [][] arr;
	
	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][2];
		
		int x,y;
		for(int i = 0; i < n;i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			arr[i][0] = x;
			arr[i][1] = y;
		}
		
		solve();
	}
	public static void solve() {	
		Arrays.sort(arr, (o1,o2) -> {
			if(o1[0] == o2[0])
				return o1[1] - o2[1];
			return o1[0] - o2[0];
			});
		
		for(int i = 0; i < n;i++)
			sb.append(arr[i][0] + " " + arr[i][1] + "\n");
		
		System.out.print(sb.toString());
	}
}
