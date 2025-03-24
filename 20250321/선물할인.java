import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		System.out.println(present(b, a));
	}
	
	static int present(int b, int a) {
		int sum=0;
		int cnt=0;
		for(int i=0; i<N; i++) {
			sum+=arr[i]/2;
			cnt++;
			if(cnt>a) {
				sum+=arr[i-(--cnt)]/2;
			}
			if(sum>b)
				return i;
		}
		
		return N;
	}
	
}
