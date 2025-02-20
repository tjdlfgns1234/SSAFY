import java.io.*;
import java.util.*;

// 0으로 시작 불가
// 중복 순열

public class Main {
	static String[] A;
	static long maxVal = -10;
	static int B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		A = input[0].split("");
		B = Integer.parseInt(input[1]);
		boolean[] visited = new boolean[A.length];
		ArrayList<String> resultArr = new ArrayList<>();
		recursive(visited, resultArr, 0, A.length-1);
		if (maxVal == -10) {
			System.out.println(-1);
		} else {
			System.out.println(maxVal);
		}
	}
	private static void recursive(boolean[] visited, ArrayList<String> resultArr, int sum, int mul) {
		if (resultArr.size() == A.length) {
			if (sum > B) {
				return;
			}
			maxVal = Math.max(sum, maxVal);
			return;
		}
		
		if (resultArr.size() == 1 && resultArr.get(0).equals("0")) {
			return;
		}
		
		for (int i = 0 ; i < A.length ; i++) {
			if (!visited[i]) {
				visited[i] = true;
				resultArr.add(A[i]);
				int addNum = Integer.parseInt(A[i]) * (int) Math.pow(10, mul);
				recursive(visited, resultArr, sum + addNum, mul-1);
				visited[i] = false;
				resultArr.remove(resultArr.size()-1);
			}
		}
	}
}
