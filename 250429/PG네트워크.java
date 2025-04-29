import java.util.*;

class PG네트워크 {
	public int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] v = new boolean[computers.length];

		for (int i = 0; i < n; i++) {
			// visited
			if (v[i] == true)
				continue;
			v[i] = true;
			answer += 1;
			Queue<Integer> queue = new ArrayDeque<>();
			for (int j = 0; j < n; j++) {
				if (computers[i][j] == 1 && !v[j]) {
					queue.offer(j);
					v[j] = true;
				}
			}
			while (!queue.isEmpty()) {
				int target = queue.poll();
				for (int j = 0; j < n; j++) {
					if (computers[target][j] == 1 && !v[j]) {
						queue.offer(j);
						v[j] = true;
					}
				}
			}
		}
		return answer;
	}
}