import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0 ; i < t ; i++) {
        	int c = Integer.parseInt(br.readLine()); // 커맨드 횟수
        	int result = 0;
        	int speedDiff = 0;
        	for (int j = 0 ; j < c ; j++) {
        		String[] input = br.readLine().split(" ");
        		int status = Integer.parseInt(input[0]);
        		if (status == 1) { 			// 가속
        			speedDiff += Integer.parseInt(input[1]);
        			result += speedDiff;
        		} else if (status == 2) { 	// 감속
        			speedDiff -= Integer.parseInt(input[1]);
        			if (speedDiff < 0) {
        				speedDiff = 0;
        			}
        			result += speedDiff;
        		} else { 					// 유지
        			result += speedDiff;
        		}
        	}
        	resultArr.add(result);
        }
        for (int i = 0 ; i < t ; i++) {
        	System.out.printf("#%d %d\n", i+1, resultArr.get(i));
        }
    }
}
