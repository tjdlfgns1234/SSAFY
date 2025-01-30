import java.io.*;
import java.util.*;
// n일 동안의 매매가 알고 있음
// 하루 최대 1만큼 구입 + 판매는 항상 가능
// 최대 이득을 얻자
// 처음엔 재귀로 생각했는데 아니었다.
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스
        ArrayList<Long> resultArr = new ArrayList<>();
        for (int i = 0 ; i < t ; i++) {
        	int n = Integer.parseInt(br.readLine()); // n일
        	String[] input = br.readLine().split(" ");
        	ArrayList<Integer> mainArr = new ArrayList<>(); // 주어진 날짜별 정보
        	for (int j = 0 ; j < input.length ; j++) {
        		mainArr.add(Integer.parseInt(input[j]));
        	}
        	long maxPrice = mainArr.get(mainArr.size()-1);
        	long result = 0;
        	for (int j = mainArr.size()-2 ; j >= 0 ; j--) { // 뒤로 가야 편하다
        		long num = mainArr.get(j);
        		if (num > maxPrice) { 	// 현재 maxPrice보다 크면 갱신하고 넘김
        			maxPrice = num;
        			continue;
        		} else { 				// 아니라면 차익을 result에 더함
        			result = result + (maxPrice - num);
        		}
        	}
        	resultArr.add(result);
        }
        for (int i = 0 ; i < t ; i++) {
        	System.out.printf("#%d %d\n", i+1, resultArr.get(i));
        }
    }
}
