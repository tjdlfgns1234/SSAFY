import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {
	
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N, M, L, idx;
		long temp;
		char ord;
		
		
		int T = sc.nextInt();
		for (int t = 1; t < T+1; t++) {
			ArrayList<Long> num = new ArrayList<>();
			N = sc.nextInt();
			M = sc.nextInt();
			L = sc.nextInt();
			
			for (int i = 0; i < N; i++) {
				num.add(sc.nextLong());
			}
			
			for (int i = 0; i < M; i++) {
				ord = sc.next().charAt(0);
				
				switch(ord) {
				case 'I':
					idx = sc.nextInt();
					temp = sc.nextLong();
					num.add(idx, temp);
					break;
				case 'D':
					idx = sc.nextInt();
					num.remove(idx);
					break;
				case 'C':
					idx = sc.nextInt();
					temp = sc.nextLong();
					num.remove(idx);
					num.add(idx, temp);
					break;
				}
				

			}
			if(num.size() < L) {
				System.out.printf("#%d %d\n",t, -1);
			}
			else {
				System.out.printf("#%d %d\n",t, num.get(L));
			}
			
		}
		
	}

}
