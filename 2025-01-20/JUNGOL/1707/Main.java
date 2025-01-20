import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] numarr = new int[n][n]; 
		int x = 0;
		int y = 0;
		
		boolean x_flag = false;
		boolean y_flag = false;
		int cnt = 1;
		
		
		if (n == 1){
			System.out.println(1);
		}
		else {
		while(true) {
			if (x_flag == false && y_flag == false) {
				
				numarr[y][x++] = cnt++;
				if (x > n-1 || numarr[y][x] != 0 ) {
					x--;
					y++;
					x_flag = true;
				}
			}
			
			else if (x_flag == true && y_flag == false) {
				numarr[y++][x] = cnt++;
				if (y > n-1 || numarr[y][x] != 0) {
					y--;
					x--;
					y_flag = true;
				}
			}
			
			else if(x_flag == true && y_flag == true) {
				numarr[y][x--] = cnt++;
				if (x < 0 || numarr[y][x] != 0 ) {
					x++;
					y--;
					x_flag = false;
				}
			}
			
			
			else if(x_flag == false && y_flag == true) {
				numarr[y--][x] = cnt++;
				if (y < 0 || numarr[y][x] != 0 ) {
					y++;
					x++;
					y_flag = false;
				}
			}
			
			
			if (numarr[y][x] != 0) {
				break;
			}
			
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%d ", numarr[i][j]);
			}
			System.out.println();
		}
		}
		
	}
	

}
