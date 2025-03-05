import java.io.*;
import java.util.*;

public class Main {

	static int N, R, C;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int row = (int) Math.pow(2, N);
		
		int start_x = 0;
		int start_y = 0;
		
		int mid_x;
		int mid_y;
		
		int result = 0;
		
		int size = row;
		while(size > 1) {
			size /= 2;
			mid_x = start_x + size;
			mid_y = start_y + size;
			
			if(R < mid_x && C < mid_y) {
				continue;
			}
			if(R < mid_x && C >= mid_y) {
				// 2
				result += size * size;
				start_y += size;
			}
			else if (R >= mid_x && C < mid_y) {
				// 3
				result += 2 * size * size;
				start_x += size;
			}
			else {
				// 4
				result += 3 * size * size;
				start_x += size;
				start_y += size;
			}
			
			
			
		}
		
		System.out.println(result);
		
	}
}
