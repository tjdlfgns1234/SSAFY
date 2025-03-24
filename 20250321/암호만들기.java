import java.io.*;
import java.util.*;

public class Main {
	static int L;
	static int C;
	static char[] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[C];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
		comb(0,0,new char[L]);
		System.out.println(sb);
	}
	
	static void comb(int idx, int dep, char[] sel) {
		if(dep==sel.length) {
			int cnt=0;
			for(int i=0; i<L; i++) {
				if(sel[i]=='a' || sel[i]=='e' || sel[i]=='i' || sel[i] =='o' || sel[i]=='u')
					cnt++;
			}
			
			if(cnt>=1 && (L-cnt)>=2) {
				for(int i=0; i<L; i++) {
					sb.append(sel[i]);
				}
				sb.append("\n");
			}
			return;
		}
		if(idx == arr.length)
			return;
		
		sel[dep] = arr[idx];
		comb(idx+1, dep+1, sel);
		comb(idx+1, dep, sel);
	}
}
