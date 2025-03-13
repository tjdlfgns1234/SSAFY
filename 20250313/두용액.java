import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		
		int[] koi = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			koi[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(koi);
		int minP = 0;
		int maxP = N-1;
		int ans = Integer.MAX_VALUE;
		int[] ansArr = new int[2];
		while(true) {
			if(minP == maxP)
				break;
			int tmp = koi[maxP] + koi[minP];
			if(Math.abs(tmp) < ans) {
				ans = Math.abs(tmp);
				ansArr[1] = koi[maxP];
				ansArr[0] = koi[minP];
			}
			
			if(tmp<0)
				minP++;
			else
				maxP--;
		}
		sb.append(ansArr[0]);
		sb.append(" ");
		sb.append(ansArr[1]);
		System.out.println(sb);
	}
}
