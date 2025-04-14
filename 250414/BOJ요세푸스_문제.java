import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class BOJ요세푸스_문제{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int k = Integer.parseInt(line[1]);
		
		int[] perm = new int[n];
		Queue<Integer> queue = new ArrayDeque<>();
		
		for(int i = 1; i <= n; i++) {
			queue.offer(i);
		}
		
		int idx = 0;
		int cnt = 1;
		while(idx < n) {
			int cItem = queue.poll();
			if(cnt == k) {
				perm[idx] = cItem;
				idx++;
				cnt = 1;
			}else {
				cnt++;
				queue.offer(cItem);
			}
		}
		System.out.print("<");
		for(int i = 0; i < perm.length; i++) {
			if(i == perm.length-1) {
				System.out.println(perm[i] + ">");
			}else {
				System.out.print(perm[i]+", ");
			}
			
		}
	}
	
}