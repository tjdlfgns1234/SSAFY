import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class 통계학 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int L,N;
	static boolean[] arr;

	static HashMap<Integer, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		N = Integer.parseInt(br.readLine());
		
		int sum=0;
		int middle=0;
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		int countMax=0;
		
		List<Integer> l = new ArrayList<>();
		List<Integer> arr = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			int temp = Integer.parseInt(br.readLine());
			sum+=temp;
			min = Math.min(min, temp);
			max = Math.max(max, temp);
			arr.add(temp);
			if(map.containsKey(temp)) {
				int value = map.get(temp);
				value++;
				if(countMax<value) {
					l = new ArrayList<>();
					countMax = value;
					l.add(temp);
				}
				else if(countMax==value) {
					l.add(temp);
				}
				map.put(temp, value);
			}
			else {
				int value = 1;
				if(countMax<value) {
					l = new ArrayList<>();
					countMax = value;
					l.add(temp);
				}
				else if(countMax==value) {
					l.add(temp);
				}
				map.put(temp, value);
			}
			
			
		}
		Collections.sort(l);
		Collections.sort(arr);
		
		System.out.println(Math.round((float)sum/N));
		System.out.println(arr.get(N/2));
		if(l.size()==1) {
			System.out.println(l.get(0));
		}
		else {
			System.out.println(l.get(1));
		}

		System.out.println(max-min);
		
	}
}
