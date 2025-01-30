import java.io.*;
import java.util.*;
// 더하고 빼는 시점은 레이저() 혹은 마지막에 남은 막대기의 개수대로
// 더하는 건 ( -> 이거 왼쪽에 남은 개수대로
// ) -> 얘를 만나면 현재 레이저 말고 다음 레이저에서 그 조각 개수를 반영하도록
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스
        for (int i = 0 ; i < t ; i++) {
        	String[] input = br.readLine().split("");
        	int result = 0;			// 결과
        	int currentStatus = 0; 	// ( 의 개수
        	int afterNext = 0;		// 다음 레이저 이후 뺄 currentStatus의 개수 = )의 개수
        	for (int j = 0 ; j < input.length ; j++) {
        		if (input[j].equals("(") && input[j+1].equals(")")) { // 마지막은 "("로 끝날 수 없고 왼쪽이 false면 오른쪽은 검사하지 않아서 오류 발생 X
        			result += currentStatus; // 먼저 currentStatus를 넣어야 그 다음 레이저에서 afterNext를 뺄 수 있음
        			currentStatus -= afterNext;
        			afterNext = 0;
        			j++; // 인덱스 하나 넘겨도 됨 (어차피 다음은 ")"이고 무의미하기 때문)
        			continue;
        		} else {
        			if (input[j].equals("(")) {
        				currentStatus++;
        			} else {
        				afterNext++;
        			}
        		}
        	}
        	result += afterNext; // 레이저를 만나야 결과에 저장되도록 했기 때문에 남은 것들은 마지막에 추가
        	System.out.printf("#%d %d\n", i+1, result);
        }
    }
}
