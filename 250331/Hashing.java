import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int m = 1234567891 , r = 31;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		N = Integer.parseInt(br.readLine());
		String temp = br.readLine();
		
		long result=0;
		
		for(int i=0;i<temp.length();i++) {
			int t = temp.charAt(i)-'a';
			t++;
			result+=t*((int)Math.pow(r, i)%m);
		}
		System.out.println(result);
	}

}
