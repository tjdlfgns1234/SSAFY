import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // n 이하 자연수
        int m = Integer.parseInt(input[1]); // m 몇개를 뽑을 건지
        int[] arr = new int[n];
        
        for (int i = 0 ; i < n ; i++) {
        	arr[i] = i+1;
        }
        ArrayList<Integer> resultArr = new ArrayList<>();
        recursive(n, m, arr, resultArr, bw);
        bw.flush();
        bw.close();
    }

	private static void recursive(int n, int m, int[] arr, ArrayList<Integer> resultArr, BufferedWriter bw) throws IOException {
		// basis
		if (resultArr.size() == m) { // m개를 선택한 경우
			for (int i = 0 ; i < resultArr.size() ; i++) {
				bw.write(resultArr.get(i) + " ");
			}
			bw.write("\n");
			return;
		}
		// inductive
		for (int i = 0 ; i < n ; i++) {
			resultArr.add(arr[i]);
			recursive(n, m, arr, resultArr, bw);
			resultArr.remove(resultArr.size() - 1);
		}
	}
}
