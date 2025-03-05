import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NQueen_9663 {

	static int N, count;
	static int[][] map;

	static int[] dr = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dc = { 1, 1, 0, -1, -1, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		count = 0;

		map = new int[N][N];

		bt(0, 0);

		System.out.println(count);
	}

	public static void bt(int r, int c) {

		if (r == N) { // r이 N까지 오면 모든 행에 1개씩 놓은거니까 성공
			++count;
			return;
		}

		if (c == N) { // c가 N까지 오면 해당 행에는 놓지 못한거니까 실패
			return;
		}

		if (map[r][c] == 0) {
			// 해당 위치에 퀸 놓음
			fill(r, c, 1);
			bt(r + 1, 0);
			fill(r, c, -1);

		}
		
		// 해당 위치에 퀸 안 놓음
		bt(r, c+1);
	}

	// flag가 1이면 채우기 -1이면 비우기
	public static void fill(int r, int c, int flag) {
		for (int d = 0; d < 8; ++d) {
			int nextR = r;
			int nextC = c;
			while (isValid(nextR, nextC)) {
				map[nextR][nextC] += flag;
				nextR += dr[d];
				nextC += dc[d];
			}
		}
	}

	public static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
