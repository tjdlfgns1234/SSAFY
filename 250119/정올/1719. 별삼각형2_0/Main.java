import java.io.*;
// import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]); // 100 이하 자연수
		int m = Integer.parseInt(input[1]); // 1~4
		int mid = n/2; // 중간값 (인덱스가 0이므로 +1 할 필요 X)
		
		if (n > 100 || n%2==0 || (m < 1 || m > 4)) { // 홀수만 가능
			System.out.println("INPUT ERROR!");
		} else {
			if (m == 1) {
				for (int i = 0 ; i < n ; i++) {
					if (i > mid) {
						for (int j = 0 ; j <= n-i-1 ; j++) {
							bw.write("*");
						}
					} else {
						for (int j = 0 ; j <= i ; j++) {
							bw.write("*");
						}
					}
					bw.write("\n");
				}
			} else if (m == 2) {
				for (int i = 0 ; i < n ; i++) {
					if (i > mid) { // 중간 이후
						for (int j = n ; j < n+i-mid ; j++) {
							bw.write(" ");
						}
						for (int j = 0 ; j <= n-i-1 ; j++) {
							bw.write("*");
						}
					} else {
						for (int j = mid ; j > i ; j--) {
							bw.write(" ");
						}
						for (int j = 0 ; j <= i ; j++) {
							bw.write("*");
						}
					}
					bw.write("\n");
				}
			} else if (m == 3) {
			    for (int i = 0; i < n; i++) {
			        if (i <= mid) { // 위쪽 삼각형 (중간 포함)
			            for (int j = 0; j < i; j++) {
			                bw.write(" ");
			            }
			            for (int j = 0; j < n - (i * 2); j++) {
			                bw.write("*");
			            }
			        } else { // 아래쪽 삼각형
			            for (int j = 0; j < n - i - 1; j++) {
			                bw.write(" ");
			            }
			            for (int j = 0; j < (i - mid) * 2 + 1; j++) {
			                bw.write("*");
			            }
			        }
			        bw.write("\n");
			    }
			} else {
			    for (int i = 0; i < n; i++) {
			        if (i <= mid) { // 위쪽 역삼각형 부분
			            for (int j = 0; j < i; j++) {
			                bw.write(" ");
			            }
			            for (int j = 0; j < mid - i + 1; j++) {
			                bw.write("*");
			            }
			        } else { // 아래쪽 정삼각형 부분
			            for (int j = 0; j < mid; j++) {
			                bw.write(" ");
			            }
			            for (int j = 0; j < i - mid + 1; j++) {
			                bw.write("*");
			            }
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
