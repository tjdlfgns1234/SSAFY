import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NQueen_9663_re {
	static int N, count;
	static int[] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		count = 0;

		map = new int[N]; // 인덱스는 행 값은 열

		bt(0);
		
		System.out.println(count);
	}
	
	public static void bt(int idx) {
		if (idx == map.length) {
			++count;
			return;
		}
		
		for (int c=0; c<map.length; ++c) {
			map[idx] = c;
			if (isPossible(idx)) {
				bt(idx+1);
			}
		}
	}
	
	public static boolean isPossible(int row) {
		for (int r=0; r<row; ++r) {
			// r번째 행과 row에 동일한 열에 놓여져 있는 경우 (r은 row 밑에 있는 행들)
			if (map[r] == map[row]) {
				return false;
			}
			
			// 대각선에 있는 경우 -> 행의 차이와 열의 차이가 같을 경우 대각선 상에 존재한다.
			if (Math.abs(map[r] - map[row]) == Math.abs(r - row)) {
				return false;
			}
		}
		
		return true;
	}
}
