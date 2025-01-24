import java.io.*;
import java.util.*;

// n장의 카드 1~N까지의 번호
// 1번 제일 위, N 제일 아래 (순서대로)
// 다음 동작을 1장이 남을때까지 반복
// 1. 제일 위 카드 버림
// 2, 제일 위 카드-> 제일 아래로
// 마지막에 남은 카드 출력

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		LinkedList<Integer> arr= new LinkedList<>();
		for (int i = 1 ; i <= n ; i++) { // arr에 1부터 N까지 순서대로 입력
			arr.add(i);
		}

		while (arr.size() > 1) { 	// 2개 이상일 때 진입
			int tmp = arr.get(1); 	// 1번 인덱스 tmp에 담고
			arr.remove(0);			// 제일 위 제거
			if (arr.size() == 1) {
				break;
			}
			arr.remove(1); 			// 1번 제일 뒤로 이동
			arr.add(tmp);
		}
		bw.write(arr.get(0) + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}
