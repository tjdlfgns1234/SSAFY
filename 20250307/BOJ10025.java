import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		HashMap<Integer, Integer> h = new HashMap<>();
		
		int max = 0;
		int end = 0;
		
		int N = Integer.parseInt(st.nextToken());
		int range = Integer.parseInt(st.nextToken());
		int sp = 0;
		int ep = range*2;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int tmpIce = Integer.parseInt(st.nextToken());
			int tmpGph = Integer.parseInt(st.nextToken());
			end = Math.max(end, tmpGph);
			h.put(tmpGph, tmpIce);
		}
		
		int sum=0;
		for(int i=0; i<ep; i++) {
			if(h.containsKey(i))
				sum+=h.get(i);
		}
		max = sum;
		
		for(int i=0; i<end-range*2; i++) {
			if(h.containsKey(sp-1))
				sum-=h.get(sp-1);
			if(h.containsKey(ep)) {
				sum+=h.get(ep);
				max = Math.max(max, sum);
			}
			
			sp++;
			ep++;
		}
		System.out.println(max);
	}
}
