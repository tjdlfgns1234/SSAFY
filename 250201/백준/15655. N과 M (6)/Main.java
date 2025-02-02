import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // n 개 중에서
        int m = Integer.parseInt(input[1]); // m 몇개를 뽑을 건지
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int i = 0;
        while (st.hasMoreTokens()) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	i++;
        }
        
        Arrays.sort(arr); // 순서대로 놔야 하므로.
        
        ArrayList<Integer> resultArr = new ArrayList<>();
        int idx = 0;
        recursive(n, m, arr, idx, resultArr, bw);
        bw.flush();
        bw.close();
    }

	private static void recursive(int n, int m, int[] arr, int idx, ArrayList<Integer> resultArr, BufferedWriter bw) throws IOException {
		// basis
		if (resultArr.size() == m) {
			for (int i = 0 ; i < m ; i++) {
				bw.write(resultArr.get(i) + " ");
			}
			bw.write("\n");
			return;
		}
		
		if (idx == n) {
			return;
		}
		
		// inductive
		resultArr.add(arr[idx]);
		recursive(n, m, arr, idx+1, resultArr, bw);
		resultArr.remove(resultArr.size()-1);
		recursive(n, m, arr, idx+1, resultArr, bw);
	}
}
