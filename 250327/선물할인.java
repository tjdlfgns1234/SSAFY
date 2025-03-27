import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// dynamic
// 

public class 선물할인 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] map;
	static int N,B,A;
	static int ans;
	

	public static void main(String[] args)throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		map = new int[N];
		
		st = new StringTokenizer(br.readLine());

		for(int i=0;i<N;i++) {
			map[i] =  Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(map);
		
		int count=0;
		if(A==0) {
			for(int i=0;i<N;i++) {
				if(B>=map[i]) {
					B-=map[i];
					count++;
				}
				else {
					break;
				}
			}
			System.out.println(count);
			return;
		}
		
		int r=0;
		int ld=0;
		while(r<N) {
			if(A!=0) {
				if(B>=map[r]/2) {
					B-=map[r]/2;
					r++;
					A--;
				}
				else
					break;
				
			}
			else {
				B+=map[ld]/2;
				B-=map[ld];
				ld++;
				if(B>=map[r]/2) {
					B-=map[r]/2;
					r++;
				}
				else
					break;
			}
			
		}
		System.out.println(r);
		
	}
}	
