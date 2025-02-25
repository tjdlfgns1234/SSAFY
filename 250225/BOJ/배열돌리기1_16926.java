import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열돌리기1_16926 {

	static int[][] arr;
	static int R;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int gap = 0; gap < (Math.min(N, M) + 1) / 2; ++gap) {
			 rotate(gap);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; ++i) {
			for (int j=0; j<M; ++j) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	}

	public static void rotate(int gap) {
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		int count = 2 * ((arr.length - 2 * gap) + (arr[0].length - 2 * gap) - 2);
		int total = R % count;
		
		for (int t = 0; t < total; ++t) {
			int idx = 0;
			int r = gap;
			int c = gap;
			int rotateCount = 0;
			int first = arr[gap][gap];
			while (rotateCount < count) {

				int nextR = r + dr[idx];
				int nextC = c + dc[idx];
				if (nextR < gap || nextR >= arr.length - gap || nextC < gap || nextC >= arr[nextR].length - gap) {
					idx = (idx+1) % 4;			
					continue;
				}
				
				arr[r][c] = arr[nextR][nextC];
				
				r = nextR;
				c = nextC;

				++rotateCount;
			}
			arr[gap+1][gap] = first;
		}
	}

}
