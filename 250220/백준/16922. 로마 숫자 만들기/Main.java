import java.io.*;
import java.util.*;

public class Main {
	static String[] roman = {"I", "V", "X", "L"};
	static int[] eachNum = {1, 5, 10, 50};
	static int N;
	static ArrayList<Integer> check = new ArrayList<>();
	static int finalResult = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int idx = 0;
		ArrayList<String> resultArr = new ArrayList<>();
		int sum = 0;
		recursive(idx, resultArr, sum);
		System.out.println(finalResult);
	}
	
	private static void recursive(int idx, ArrayList<String> resultArr, int sum) {
		if (resultArr.size() == N) {
			if (check.contains(sum)) {
				return;
			}
			finalResult++;
			check.add(sum);
			return;
		}
		
		if (idx >= 4) {
			return;
		}
		
		resultArr.add(roman[idx]);
		recursive(idx, resultArr, sum+eachNum[idx]);
		resultArr.remove(resultArr.size()-1);
		recursive(idx+1, resultArr, sum);
	}
}
