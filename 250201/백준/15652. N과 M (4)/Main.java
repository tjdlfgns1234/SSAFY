import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // n 이하 자연수
        int m = Integer.parseInt(input[1]); // m 몇개를 뽑을 건지
        int[] arr = new int[n];
        
        for (int i = 0 ; i < n ; i++) {
        	arr[i] = i+1;
        }
        ArrayList<Integer> resultArr = new ArrayList<>();
        recursive(n, m, 0, arr, resultArr);
    }

	private static void recursive(int n, int m, int idx, int[] arr, ArrayList<Integer> resultArr) {
		// basis
		if (resultArr.size() == m) { // m개를 선택한 경우
			for (int i = 0 ; i < resultArr.size() ; i++) {
				System.out.printf("%d ", resultArr.get(i));
			}
			System.out.println();
			return;
		}
		if (idx == n) { // 배열의 인덱스가 끝까지 간 경우
			return;
		}
		// inductive
		resultArr.add(arr[idx]);
		recursive(n, m, idx, arr, resultArr); // 선택한 경우
		resultArr.remove(resultArr.size()-1);
		recursive(n, m, idx+1, arr, resultArr); // 선택하지 않은 경우
	}
}
