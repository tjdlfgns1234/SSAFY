import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		HashMap<Integer, Integer> h = new HashMap<>();
		
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int[] nums = new int[N];
		for(int i=0; i<N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(h.containsKey(tmp)) {
				h.replace(tmp, (h.get(tmp)+1));
			} else {
				h.put(tmp, 1);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(h.containsKey(tmp)) {
				sb.append(h.get(tmp));
				sb.append(" ");
			} else {
				sb.append("0 ");
			}
		}
		System.out.println(sb);
	}
}