import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스
        for (int i = 0 ; i < t ; i++) {
        	int n = Integer.parseInt(br.readLine()); // 블록의 개수
        	String[] input = br.readLine().split(" ");
        	int comp = Integer.parseInt(input[0]); // 비교를 위해 변수
        	int upDiff = 0;		// 상승 최대 변화량을 담을 변수
        	int downDiff = 0;	// 하락 최대 변화량을 담을 변수
        	int tmpDiff; 		// 임시 변화량
        	for (int j = 1 ; j < n ; j++) {
        		int tmp = Integer.parseInt(input[j]);
        		if (tmp > comp) { // 상승
        			tmpDiff = tmp - comp;
        			if (tmpDiff > upDiff) { // 변화량이 기존 것보다 크면
        				upDiff = tmpDiff;
        			}
        			comp = tmp;
        		} else if (tmp < comp) { // 하강
        			tmpDiff = comp - tmp;
        			if (tmpDiff > downDiff) {
        				downDiff = tmpDiff;
        			}
        			comp = tmp;
        		} else { // 그대로
        			continue;
        		}
        	}
        	System.out.printf("#%d %d %d\n", i+1, upDiff, downDiff);
        }
    }
}
