import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class BOJ치킨_배달 {
	static class Chicken {
		int x, y;
	}

	static class House {
		int x, y;
	}

	static List<Chicken> clist;
	static List<House> hlist;
	static int minTotalDist = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);

		clist = new ArrayList<>();
		hlist = new ArrayList<>();
		int[][] map = new int[n][n];

		for (int i = 0; i < n; i++) {
			line = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(line[j]);

				if (map[i][j] == 2) {
					Chicken chicken = new Chicken();
					chicken.x = i;
					chicken.y = j;
					clist.add(chicken);
				}

				if (map[i][j] == 1) {
					House house = new House();
					house.x = i;
					house.y = j;
					hlist.add(house);
				}

			}
		}

		// idxArr 만들기
		int[] idxArr = new int[clist.size()];
		for (int i = 0; i < clist.size(); i++) {
			idxArr[i] = i;
		}
		
		for (int i = 1; i <= m; i++) {
			comb(idxArr, new int[i], 0, 0);
		}
		
		System.out.println(minTotalDist);

	}

	static void comb(int[] idxArr, int[] sel, int idx, int depth) {
		if (sel.length == depth) {
			//집집마다 전체 치킨 거리의 합
			int totalDist = 0;
			for(House h : hlist) {
				//모든 집에 대해서 현재 선택된 가계의 치킨 거리 구하기
				int minHnHDist = Integer.MAX_VALUE;
				for(int i : sel) {
					int hx = h.x;
					int hy = h.y;
					int cx = clist.get(i).x;
					int cy = clist.get(i).y;
					
					int dist = Math.abs(hx-cx)+Math.abs(hy-cy);
					minHnHDist = Math.min(dist, minHnHDist);
				}
				totalDist += minHnHDist;
			}
			
			minTotalDist = Math.min(minTotalDist, totalDist);
			return;
		}

		if (idxArr.length == idx)
			return;

		sel[depth] = idx;
		comb(idxArr, sel, idx + 1, depth + 1);

		comb(idxArr, sel, idx + 1, depth);
	}
}