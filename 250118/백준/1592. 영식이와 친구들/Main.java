import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt(); // 사람 수
    	int m = in.nextInt(); // 기준 횟수
    	int vl = in.nextInt(); // 홀수 시계 or 짝수 반시계로 vl번째
    	int[] arr = new int[n]; // n번째 사람 = n-1번째 인덱스
    	for (int i = 0 ; i < n ; i++) {
    		arr[i] = 0; // 모두 0으로 초기화
    	}

    	int loc = 0; // 초기 위치 0번 인덱스
    	int sum = -1; // 합 (처음 갖고 있을 때는 횟수가 0번이기 때문에 초기값은 -1로 시작)
    	while (true) {
    		sum += 1;
    		arr[loc] += 1; // 공 받은 횟수 +1
    		if (arr[loc] == m) {	// m회 될 경우 탈출
    			break;
    		}
    		if (arr[loc] % 2 == 1) {	// 홀수 시계
    			loc = loc + vl;
    			if (loc >= n) {
    				loc = loc - n; // n 보다 위치가 커질 경우
    			}
    		} else {	// 짝수 반시계
    			loc = loc - vl;
    			if (loc < 0) {
    				loc = loc + n; // 0 보다 작을 경우
    			}
    		}
    	}
    	System.out.println(sum);
    }
}
