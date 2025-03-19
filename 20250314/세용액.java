
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
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
		long ans = 3000000000L;
		int[] ansArr = new int[3];
		
		for(int i=0; i<N; i++) {
			int mid = i;
			int minP = 0;
			int maxP = N-1;
			
			while(true) {
				if(minP == mid)
					minP++;
				if(maxP == mid)
					maxP--;

				if(minP >= maxP)
					break;
				long tmp = (long)koi[maxP] + (long)koi[minP] + (long)koi[mid];
				if(Math.abs(tmp) < ans) {
					ans = Math.abs(tmp);
					ansArr[2] = koi[mid];
					ansArr[1] = koi[maxP];
					ansArr[0] = koi[minP];
				}
				
				if(tmp<0)
					minP++;
				else
					maxP--;
			}
		}
		Arrays.sort(ansArr);
		sb.append(ansArr[0]);
		sb.append(" ");
		sb.append(ansArr[1]);
		sb.append(" ");
		sb.append(ansArr[2]);
		System.out.println(sb);
	}
}
