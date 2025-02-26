import java.io.*;
import java.util.*;

public class Solution {
	static int[] arr;
	static int minVal;
	static int N;
	static int B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int k = 1 ; k <= T ; k++) {
        	String[] input1 = br.readLine().split(" ");
        	N = Integer.parseInt(input1[0]); // N명의 전원
        	B = Integer.parseInt(input1[1]); // B 이상인 탑 중 높이가 가장 낮은 탑
        	String[] input2 = br.readLine().split(" ");
        	arr = new int[N];
        	for (int i = 0 ; i < N ; i++) {
        		arr[i] = Integer.parseInt(input2[i]);
        	}
        	//Arrays.sort(arr);
        	ArrayList<Integer> resultArr = new ArrayList<>();
        	minVal = Integer.MAX_VALUE;
        	int idx = 0;
        	for (int i = 1 ; i <= N ; i++) {
        		if (minVal == B) {
        			break;
        		}
        		check(i, idx, resultArr);
        	}
        	System.out.printf("#%d %d\n", k, minVal-B);
        }
    }

	private static void check(int i, int idx, ArrayList<Integer> resultArr) {
		if (resultArr.size() >= i) {
			int tempSum = 0 ;
			for (int a : resultArr) {
				tempSum += a;
			}
			if (tempSum >= B) {
				minVal = Math.min(tempSum, minVal);
			}
			return;
		}
		
		if (idx == N) {
			return;
		}
		
		resultArr.add(arr[idx]);
		check(i, idx+1, resultArr);
		resultArr.remove(resultArr.size()-1);
		check(i, idx+1, resultArr);
	}
}
