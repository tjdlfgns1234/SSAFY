import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static ArrayList<Integer>[] friend;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		friend = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			friend[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			friend[s].add(e);
			friend[e].add(s);
		}
		
		bfs();
	}
	
	static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {1, 0});
		
		boolean[] v = new boolean[N+1];
		v[1] = true;
		int cnt=0;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			if(tmp[1]==2)
				break;
			for(int i=0; i<friend[tmp[0]].size(); i++) {
				if(v[friend[tmp[0]].get(i)])
					continue;
				
				v[friend[tmp[0]].get(i)] = true;
				q.add(new int[] {friend[tmp[0]].get(i), tmp[1]+1});
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
