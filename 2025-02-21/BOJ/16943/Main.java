import java.util.*;
import java.io.*;

public class Main {
	
	static boolean result = false;
	static int result_max = -1; 
	static int num, len;
	static String A;
	static boolean[] visit;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = st.nextToken();
		String B = st.nextToken();
		
		if(A.length() > B.length()) {
			System.out.println(-1);
			return;
		}
		
		num = Integer.parseInt(B);
		len = A.length();
		visit = new boolean[len];
		arr = new int[len];
		permutation(0);
		System.out.println(result_max);
		
	}
	private static void permutation(int cnt) {
		if(cnt == len) {
			if(arr[0] == 0) return;
			int temp = calc();
			if(num > temp && result_max < temp) {
				result_max = temp;
			}
			return;
		}
		
		
		for (int i = 0; i < len; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[i] = A.charAt(cnt) - '0';
				permutation(cnt+1);
				visit[i] = false;
			}
		}
	}
	private static int calc() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			sb.append(arr[i]);
		}
		return Integer.parseInt(sb.toString());
	}
	
}
