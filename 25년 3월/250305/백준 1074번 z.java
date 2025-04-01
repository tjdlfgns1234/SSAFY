import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N,R, C;
	static int pow2n[] = { 1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768 };
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R= Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		solve();
	}

	private static void solve() {
		// 불가능한 경우는 입력으로 주어지지 않는다.
		System.out.println(z(N,R,C));
	}

	private static int z(int n, int r, int c) {
		// 불가능한 경우는 입력으로 주어지지 않는다.
		if(n == 1)
			return r*2+c;
		
		int div = pow2n[n-1];
		
		
		if(r < div){ // 2사분면과 1사분면
			if(c < div)
				return z(n-1,r,c);
			else
				return div*div + z(n-1,r,c-div);
		}
		else { // 3사분면과 4사분면
			if(c < div)
				return div*div*2 + z(n-1,r-div,c);
			else
				return div*div*3 + z(n-1,r-div,c-div);
		}
	}
}
