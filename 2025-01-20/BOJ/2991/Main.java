import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
	
		int A = Integer.parseInt(st1.nextToken());
		int B = Integer.parseInt(st1.nextToken());
		int C = Integer.parseInt(st1.nextToken());
		int D = Integer.parseInt(st1.nextToken());
		
		int P = Integer.parseInt(st2.nextToken());
		int M = Integer.parseInt(st2.nextToken());
		int N = Integer.parseInt(st2.nextToken());
		
		System.out.println(cnt(A, B, C, D, P));
		System.out.println(cnt(A, B, C, D, M));
		System.out.println(cnt(A, B, C, D, N));
	}
	
	public static int cnt(int t1_1, int t1_2, int t2_1, int t2_2, int arrive_t) {
		int result = 0;
		if (arrive_t % (t1_1 + t1_2) > 0 && arrive_t % (t1_1 + t1_2) <= t1_1) {
			result ++;
		}
		if (arrive_t % (t2_1 + t2_2) > 0 && arrive_t % (t2_1 + t2_2) <= t2_1) {
			result ++;
		}
		return result;
	}
}
