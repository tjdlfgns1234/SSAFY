import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br;
	static BufferedWriter bw;
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static long[] arr;
	static boolean[] vit;
	static long b;
	static int n,a, ans = 0;
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		
		arr = new long[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i <n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(arr);
		
//		for(int i = 0; i < n;i++) {
//			System.out.print(arr[i] + " ");
//		}

		
		
		if(a != 0)
			solve();
		else {
			long cur = 0;
			int ret = 0; // 현재 선물 금액, 할인권을 사용한 횟수
			for(int i = 0; i< n;i++) {
				if(cur + arr[i] <= b) {
					cur += arr[i];
					ret++;
				}				
			}
			ans = ret;
		}
		
		System.out.println(ans);
	}

	private static void solve() throws IOException {
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		long cur = 0;
		int cnt = 0, ret = 0; // 현재 선물 금액, 할인권을 사용한 횟수
		for(int i = 0; i <n;i++) {
		
			if(cnt < a) {
				// 할인권을 사용할 수 있으면
				if(cur+arr[i]/2 <= b) {
					// 예산 안이면
					ret++;
					cnt++;
					pq.add(arr[i]);
					cur += arr[i]/2;
				
				}
			}
			else {
				// 할인권을 사용한 것 중에서 가장 작은 걸 바깥으로 뺌
				// System.out.println(cur + " " + pq.peek());
				if(cur+arr[i]/2+pq.peek()/2 <= b) {
					// 예산 안이면\
					
					ret++;
					cur += pq.poll()/2;
					pq.add(arr[i]);
					cur += arr[i]/2;
				}
			}
			ans = Math.max(ret, cnt);
		}	
	}
}
