import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N명의 점원, 각 점원의 키는 H[i]
 * 점원으로 이루어진 탑 -> 높이 B 이상인 탑 중 가장 낮은 탑
 */

public class 장훈이의높은선반_1486 {
	static int N, B;
	static int[] person;
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			result = Integer.MAX_VALUE;
			
			person = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; ++i) {
				person[i] = Integer.parseInt(st.nextToken());
			}
			
			recursive(0, 0);
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(result);
			System.out.println(sb);
			
		}
	}
	
	public static void recursive(int sum, int idx) {
		if (sum >= B) {
			//차이의 최솟값 구하기
			result = Math.min(result, sum-B);
			return;
		}
		
		if (idx == N) return;
		
		recursive(sum, idx+1);
		recursive(sum+person[idx], idx+1);
	}
}
