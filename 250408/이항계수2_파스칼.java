import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 이항계수2 {
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static List<List<Integer>> triangle = new ArrayList<>();
	static int modul = 10007;
	
	static void pascal(int numRow) {
		for(int i=0;i<=numRow;i++) {
			List<Integer> l = new ArrayList<>();
			for(int j=0;j<=i;j++) {
				if(j==0 || j==i) {
					l.add(1);
				}
				else {
					int num = triangle.get(i-1).get(j-1)%modul+ triangle.get(i-1).get(j)%modul;
					l.add(num%modul);
				}
			}
			
			triangle.add(l);
		}
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		pascal(n);
//		for(int i=0;i<=n;i++) {
//			List<Integer> l = triangle.get(i);
//			for(int j=0;j<l.size();j++) {
//				System.out.print(l.get(j)+" ");
//			}
//			System.out.println();
//		}
		
		System.out.println(triangle.get(n).get(k));
		
		
	}
	
}
