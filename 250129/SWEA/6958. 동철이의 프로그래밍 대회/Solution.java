import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스
        for (int k = 0 ; k < t ; k++) {
        	String[] tmp = br.readLine().split(" ");
        	int n = Integer.parseInt(tmp[0]); // n명의 사람
        	int m = Integer.parseInt(tmp[1]); // m개의 문제
        	int solvedProblem = 0; // 1등이 푼 문제 수 = 1등이 바뀔 때마다 푼 문제 수도 바뀔 예정
        	int topRank = 0; // 1위의 수
        	for (int i = 0 ; i < n ; i++) {
        		String[] input = br.readLine().split(" ");
        		int comp = 0; // 문제 수 비교를 위한 변수
        		for (int j = 0 ; j < m ; j++) {
        			if (input[j].equals("1")) {
        				comp++;
        			}
        		}
        		if (comp > solvedProblem) {
        			topRank = 1; // 다시 1로 리셋
        			solvedProblem = comp;
        		} else if (comp == solvedProblem) {
        			topRank++;
        		} else {
        			continue;
        		}
        	}
        	if (solvedProblem == 0) {
        		topRank = n; // 문제를 푼 사람이 아무도 없을 경우 1위는 참가자 전원
        	}
        	System.out.printf("#%d %d %d\n", k+1, topRank, solvedProblem);
        }
    }
}
