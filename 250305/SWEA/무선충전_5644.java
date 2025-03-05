import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 무선충전_5644 {

	static class Charger {
		int r;
		int c;
		int range;
		int p;

		Charger(int r, int c, int range, int p) {
			this.r = r;
			this.c = c;
			this.range = range;
			this.p = p;
		}
	}

	static class Person {
		int r;
		int c;

		Person(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[][] move = { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static Charger[] chargers;
	static int[][] person;
	static int max;
	static Person p1, p2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); // 총 이동 시간
			int A = Integer.parseInt(st.nextToken()); // 충전기 수

			person = new int[2][M];

			for (int i = 0; i < 2; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; ++m) {
					person[i][m] = Integer.parseInt(st.nextToken());
				}
			}

			chargers = new Charger[A];
			for (int a = 0; a < A; ++a) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int range = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());

				chargers[a] = new Charger(r, c, range, p);
			}

			p1 = new Person(1, 1);
			p2 = new Person(10, 10);

			int result = 0;

			for (int i = 0; i < M; ++i) {
				max = 0;

				recursive(new int[2], 0);

				p1.r += move[person[0][i]][0];
				p1.c += move[person[0][i]][1];

				p2.r += move[person[1][i]][0];
				p2.c += move[person[1][i]][1];
				result += max;
			}

			max = 0;
			recursive(new int[2], 0);
			result += max;

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(result);
			System.out.println(sb);
		}
	}

	public static void recursive(int[] sel, int idx) {
		if (idx == sel.length) {
			// 최댓값 검사
			Charger c1 = chargers[sel[0]];
			Charger c2 = chargers[sel[1]];
			int v1 = 0;
			int v2 = 0;

			if (getDistance(p1.r, p1.c, c1.r, c1.c) <= c1.range) {
				v1 = c1.p;
			}
			if (getDistance(p2.r, p2.c, c2.r, c2.c) <= c2.range) {
				v2 = c2.p;
			}
			
			int sum = v1 + v2;
			if (v1 != 0 && v2 != 0 && sel[0] == sel[1]) {
				sum /= 2;
			}

			max = Math.max(max, sum);

			return;
		}

		for (int i = 0; i < chargers.length; ++i) {
			sel[idx] = i;
			recursive(sel, idx + 1);
		}
	}

	public static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}
