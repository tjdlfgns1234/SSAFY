import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class BOJ선_긋기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		List<int[]> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			int[] ab  = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();	
			list.add(ab);
		}
		
		list.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		
		int sum = 0;
		int s = 0;
		int e = 0;
		for(int[] ab: list) {
			
			//처음인 경우
			if(s == 0 && e == 0) {
				s = ab[0];
				e = ab[1];
			}else if(ab[0] >= s && ab[0] <= e && ab[1] > e) { // 포함 되지 않으며 겹치는 경우
				e = ab[1];
			}else if(ab[0] > e) {// 안겹치는 경우
				sum += Math.abs(e-s);
				s = ab[0];
				e = ab[1];
			}

		}
		
		//마지막 넣기
		sum += Math.abs(e-s);
		
		System.out.println(sum);
	}
}