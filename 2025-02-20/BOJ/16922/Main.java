import java.util.*;
import java.io.*;

public class Main {
	static int[] nums = {1, 5, 10, 50};
	static int[] sel;
	static int n;
	static Set<Integer> set;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		sel = new int[n];
		set = new HashSet<>();
		dfs(0, 0);
		
		System.out.println(set.size());
		
	}
	private static void dfs(int depth, int idx) {
		if(n == depth) {
			int sum = calc();
			set.add(sum);
			return;
		}
		
		for (int i = idx; i < 4; i++) {
			sel[depth] = nums[i];
			dfs(depth + 1, i);
		}
	}
	
	private static int calc() {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += sel[i];
		}
		return sum;
	}
}
