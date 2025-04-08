import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class CT조삼모사{
	static int[][] mat;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		mat = new int[n][n];
		int[] list = new int[n];
		for(int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				mat[i][j] = Integer.parseInt(line[j]); 
				list[i] = i;
			}
		}
		
		
			comb(list, new int[n/2], 0,0);
		System.out.println(result);
			

	}
	
	static void comb(int[] list, int[] sel, int idx, int depth) {
		if(sel.length == depth) {
			int[] day = sel;
			int[] night;
			night = makeNight(list, sel);
			
			int cdSum = 0;
			int cnSum = 0;
			for(int q = 0; q < day.length; q++) {
				for(int p = q; p < day.length; p++) {
					cdSum += mat[day[q]][day[p]];
					cdSum += mat[day[p]][day[q]];
				}
			}
			
			for(int q = 0; q < night.length; q++) {
				for(int p = q; p< night.length; p++) {
					cnSum += mat[night[q]][night[p]];
					cnSum += mat[night[p]][night[q]];
				}
			}
			
			result = Math.min(result, Math.abs(cdSum - cnSum));
			return;
		}
		
		if(list.length == idx) return;
		
		sel[depth] = list[idx];
		comb(list, sel, idx+1, depth+1);
		
		comb(list, sel, idx+1, depth);
	}
	
	static int[] makeNight(int[] list, int[] day) {
		//night 생성
		int[] night = new int[list.length-day.length];
		
		int cnt = 0;
		for(int i = 0; i < list.length; i++) {
			boolean check = false;
			for(int j = 0; j < day.length; j++) {
				if(list[i] == day[j]) check = true;
			}
			if(check == false) {
				night[cnt] = list[i];
				cnt++;
			}
		}
		return night;
	}
}
