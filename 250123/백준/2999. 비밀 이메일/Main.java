import java.io.*;
//import java.util.*;

// 행 R 열 C
// R이 C를 넘지 않으면서 R이 최대인 값을 찾고
// i j 순서를 바꿔서 행렬에 대입

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("");
		// R이 C를 넘지 않으면서, R이 최대인 값 구하기
		int setR = 0;
		int setC = 0;
		for (int i = 0 ; i < input.length ; i++) {
			for (int j = input.length ; j >= i ; j--) { // i는 0부터 j는 반대에서 줄어들게
				if (i * j == input.length) { // i j 곱이 입력된 길이와 같다면 진입
					setR = i;
					setC = j;
				}
			}
		}
		// 결과 배열
		int idx = 0; // input 배열을 위한 인덱스
		String[][] resultArr = new String[setR][setC]; // 결과를 담을 배열 생성
		for (int j = 0 ; j < setC ; j++) {
			for (int i = 0 ; i < setR ; i++) {
				resultArr[i][j] = input[idx];
				idx++;
			}
		}
		// 출력
		for (int i = 0 ; i < setR ; i++) {
			for (int j = 0 ; j < setC ; j++) {
				System.out.print(resultArr[i][j]);
			}
		}
	}
}
