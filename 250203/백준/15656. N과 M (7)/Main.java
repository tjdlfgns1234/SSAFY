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
        
        int i = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	i++;
        }
        
        Arrays.sort(arr);
        
        ArrayList<Integer> resultArr = new ArrayList<>();
        
        // 중복 순열
        recursive(n, m, arr, resultArr, bw);
        
        bw.flush();
        bw.close();
    }

	private static void recursive(int n, int m, int[] arr, ArrayList<Integer> resultArr, BufferedWriter bw) throws IOException {
		// basis
		if (resultArr.size() == m) {
			for (int i = 0 ; i < m ; i++) {
				bw.write(resultArr.get(i) + " ");
			}
			bw.write("\n");
			return;
		}
		
		// inductive
		for (int i = 0 ; i < n ; i++) {
			resultArr.add(arr[i]);
			recursive(n, m, arr, resultArr, bw);
			resultArr.remove(resultArr.size()-1);
		}
	}
}
