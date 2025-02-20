import java.util.*;
import java.io.*;

public class Solution3 {
	
	static int[] first_list;
	static int[] second_list;
	static int result1, result2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		for (int t = 1; t < T+1; t++) {
			first_list = new int[9];
			second_list = new int[9];
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean[] check_first = new boolean[19];
			int temp_num = 0;
			for (int i = 0; i < 9; i++) {
				temp_num = Integer.parseInt(st.nextToken());
				first_list[i] = temp_num;
				check_first[temp_num] = true;
			}
			int idx = 0;
			for (int j = 1; j < 19; j++) {
				if(!check_first[j]) {
					second_list[idx++] = j;
				}
			}
			
			
			result1 = 0;
			result2 = 0;
			permutation(new int[9], 0, new boolean[9]);
			System.out.printf("#%d %d %d\n",t, result2, result1);
		}
	}
	
	public static void permutation(int[] deck_list, int depth, boolean[] visit) {
		if(depth == 9) {
			int num = check(deck_list); 
			if(num == 1) {
				result1 += 1;
			}
			else if(num == 2){
				result2 += 1;
			}
			
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if(!visit[i]) {
				visit[i] = true;
				deck_list[i] = second_list[depth];
				permutation(deck_list, depth + 1, visit);
				visit[i] = false;
			}
		}
		
		
	}

	private static int check(int[] deck_list) {
		//1 : 규영, 2 : 인영
		int temp1 = 0;
		int temp2 = 0;
		for (int i = 0; i < 9; i++) {
			if(deck_list[i] > first_list[i]) {
				temp1 += deck_list[i] + first_list[i];
			}
			else if(deck_list[i] < first_list[i]){
				temp2 += deck_list[i] + first_list[i]; 
			}
		}
		
		if(temp1 > temp2) return 1;
		else if(temp1 < temp2) return 2;
		return 0;
	}
}
