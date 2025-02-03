import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int i = 0;
        while (st.hasMoreTokens()) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	i++;
        }
        
        Arrays.sort(arr);
        
        ArrayList<Integer> resultArr = new ArrayList<>();
        int idx = 0;
        // 중복 조합
        recursive(n, m, idx, arr, resultArr, bw);
        
        bw.flush();
        bw.close();
    }

	private static void recursive(int n, int m, int idx, int[] arr, ArrayList<Integer> resultArr, BufferedWriter bw) throws IOException {
		// basis
		if (resultArr.size() == m) {
			for (int i = 0 ; i < m ; i++) {
				bw.write(resultArr.get(i) + " ");
			}
			bw.write("\n");
			return ;
		}
		
		if (idx == n) {
			return ;
		}
		
		// inductive
		resultArr.add(arr[idx]);
		recursive(n, m, idx, arr, resultArr, bw);
		resultArr.remove(resultArr.size()-1);
		recursive(n, m, idx+1, arr, resultArr, bw);
	}
}
