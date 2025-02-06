import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {
	
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n, m, x, y;
		char ord;
		for (int t = 1; t < 11; t++) {
			n = sc.nextInt();
			
			ArrayList<Integer> num = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				num.add(sc.nextInt());
			}
			
			m = sc.nextInt();
			
			for (int i = 0; i < m; i++) {
				ord = sc.next().charAt(0);
				switch(ord) {
				case 'I':
					x = sc.nextInt();
					y = sc.nextInt();
					for (int j = x; j < x+y; j++) {
						num.add(j, sc.nextInt());
					}
					break;
				case 'D':
					x = sc.nextInt();
					y = sc.nextInt();
					for (int j = x; j < x+y; j++) {
						num.remove(j);
					}
					break;
				case 'A':
					y = sc.nextInt();
					for (int j = 0; j < y; j++) {
						num.add(sc.nextInt());
					}
					break;
				}
			}
			
			System.out.printf("#%d", t);
			for (int i = 0; i < 10; i++) {
				System.out.printf(" %d", num.get(i));
			}
			System.out.println();
		}
		
	}

}
