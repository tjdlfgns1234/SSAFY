import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[0]-o2[0]>0 ? 1 : -1);
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			q.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}

		PriorityQueue<int[]> q2 = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]>0 ? 1 : -1);
		
		q2.add(q.poll());
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			boolean isChanged = false;
			int[] tmp2 = q2.poll();
			if(tmp2[1] <= tmp[0]) {
				q2.add(new int[] {tmp2[0], tmp[1]});
				isChanged = true;
			} else
				q2.add(tmp2);
			if(!isChanged) {
				q2.add(tmp);
			}
		}
		
		System.out.println(q2.size());
	}
}
