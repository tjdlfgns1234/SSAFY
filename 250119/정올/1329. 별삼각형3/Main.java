import java.io.*;
// import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int mid = n / 2;
		if (n%2==0 || n > 100 || n < 0) {
			bw.write("INPUT ERROR!");
		} else {
			for (int i = 0 ; i < n ; i++) {
				if (i <= mid) {
					for (int j = 0 ; j <= i-1 ; j++) {
						bw.write(" ");
					}
					for (int j = 0 ; j <= i*2 ; j++) {
						bw.write("*");
					}
				} else {
					for (int j = n-1 ; j > i ; j--) {
						bw.write(" ");
					}
					for (int j = 2*n-1 ; j > i*2 ; j--) {
						bw.write("*");
					}
				}
				bw.write("\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
