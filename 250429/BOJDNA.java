import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class BOJDNA {
	static char[] data = new char[] {'A','C','G','T'};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		char[][] lines = new char[n][m];
		for(int i = 0; i < n; i++) {
			lines[i] = br.readLine().toCharArray();
		}
		int[][] info = new int[m][4];
		
		for(int i = 0;i < m; i++) {
			for(int j = 0; j < n; j++) {
				char target = lines[j][i];
				if(target == 'A') {
					info[i][0]++;
				}else if(target == 'T') {
					info[i][3]++;
				}else if(target == 'G') {
					info[i][2]++;
				}else {
					info[i][1]++;
				}
			}
		}
		
		StringBuffer sb = new StringBuffer();
		int sum = 0;
		for(int i = 0; i < m; i++) {
			int max = 0;
			int idx = 0;
			for(int j = 0; j < 4; j++) {
				if(max < info[i][j]) {
					max = info[i][j];
					idx = j;
				}
			}
			
//			System.out.println(max + " " + data[idx]);
			sb.append(data[idx]);
			sum += n - max;
		}
		
		System.out.println(sb.toString());
		System.out.println(sum);
	}

}