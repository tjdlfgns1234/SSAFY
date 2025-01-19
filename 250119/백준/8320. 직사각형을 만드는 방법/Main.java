import java.io.*;
// import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 입력
		
		int sum = 0;
		for(int i=1; i<=n; i++) {  // 한 변 최대 길이는 n과 동일
			for(int j=1; j<=i; j++) {  // j 가 i보다 작거나 같으므로 3, 2는 나올 수 있으나 2, 3은 나올 수 없음.
				if(i*j <= n) {
					sum++;
				}
			}
		}
		
		System.out.println(sum);
	}
}
