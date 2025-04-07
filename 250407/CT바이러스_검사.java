import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CT바이러스_검사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] line = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(line[i]);
		}
		
		line = br.readLine().split(" ");
		int m = Integer.parseInt(line[0]);
		int e = Integer.parseInt(line[1]);
		
		long count = 0;
		
		//팀장 빼기
		for(int i = 0; i < n; i++) {
			arr[i] -= m;
		}
		count = n;
		
		//팀원 빼기
		for(int i = 0; i < n; i++) {
			if(arr[i] > 0) {
				count += arr[i]/e;
				arr[i] = arr[i]%e;
			}
		}
		
		//팀원 남은 거 확인
		for(int i = 0; i < n; i++) {
			if(arr[i] > 0) {
				count ++;
			}
		}
		
		System.out.println(count);
		
	}
}
