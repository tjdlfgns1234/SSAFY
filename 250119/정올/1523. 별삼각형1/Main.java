import java.io.*;
// import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]); // 100 이하 자연수
		int m = Integer.parseInt(input[1]); // 1~3
		
		if (n > 100 || (m < 1 || m > 3)) {
			System.out.println("INPUT ERROR!");
		} else {
			if (m == 1) {
				for (int i = 0 ; i < n ; i++) {
					for (int j = 0 ; j <= i ; j++) {
						bw.write("*");
					}
					bw.write("\n");
				}
			} else if (m == 2) {
				for (int i = 0 ; i < n ; i++) {
					for (int j = n ; j > i ; j--) {
						bw.write("*");
					}
					bw.write("\n");
				}
			} else {
				for (int i = 0 ; i < n ; i++) {
					int blank = n;
					for (int j = 0 ; j <= i*2 ; j++) {
						while (blank > i+1) {
							bw.write(" ");
							blank--;
						}
						bw.write("*");
					}
					bw.write("\n");
				}
				
			}
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
}
