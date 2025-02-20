import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static String[] input;
	static int[] resultArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int k = 1 ; k <= 10 ; k++) {
			N = Integer.parseInt(br.readLine());
			input = br.readLine().split("");
			resultArr = new int[8]; // ( ) //  [ ] // { } // < >
			
			count();
			int result = check();
			System.out.printf("#%d %d\n", k, result);
		}
	}

	private static void count() {
		for (int i = 0 ; i < N ; i++) {
			String temp = input[i];
			if (temp.equals("(")) resultArr[0]++;
			else if (temp.equals(")")) resultArr[1]++;
			else if (temp.equals("[")) resultArr[2]++;
			else if (temp.equals("]")) resultArr[3]++;
			else if (temp.equals("{")) resultArr[4]++;
			else if (temp.equals("}")) resultArr[5]++;
			else if (temp.equals("<")) resultArr[6]++;
			else if (temp.equals(">")) resultArr[7]++;
			else System.out.println("뭔가 잘못됨");
		}
	}
	
	private static int check() {
		if (resultArr[0]==resultArr[1] && resultArr[2]==resultArr[3] && resultArr[4]==resultArr[5] && resultArr[6]==resultArr[7])
			return 1;
		return 0;
	}
}
