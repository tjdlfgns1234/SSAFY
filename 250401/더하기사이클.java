import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 더하기사이클 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		String N = br.readLine();
		String result = N;
		int count=0;
		
		if(N.equals("0")) {
			System.out.println(1);
			return;
		}
		
		while(true) {
			count++;
			if(N.length()==1) {
				N=N+N;
			}
			else {
				char N1 = N.charAt(1);
				int tempInt = (N.charAt(0)-'0') + (N.charAt(1)-'0');
				N = "";
				if(N1 !='0') {
					N+=N1;
				}
				N+= (tempInt%10);
			}
			
			if(result.equals(N)) {
				break;
			}
			
		}
		
		System.out.println(count);
		
	}
}

// 6 8
