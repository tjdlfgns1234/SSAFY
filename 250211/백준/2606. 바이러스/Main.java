import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList<Integer>> selectedArr = new ArrayList<>();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int m = Integer.parseInt(br.readLine());
    	int[][] arr = new int[n+1][m];
    	int[] count = new int[n+1]; // 인덱스용
    	for (int i = 0 ; i < m ; i++) {
    		String[] input = br.readLine().split(" ");
    		int a = Integer.parseInt(input[0]);
    		int b = Integer.parseInt(input[1]);
    		arr[a][count[a]] = b;
    		arr[b][count[b]] = a;
    		count[a]++;
    		count[b]++;
    	}
    	search(arr, m);
    }

	private static void search(int[][] arr, int m) {
		boolean[] visited = new boolean[arr.length];
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		
		queue.offer(1);
		
		int count = 0;
		while(!queue.isEmpty()) {
			int num = queue.poll();
			visited[num] = true;
			
			for (int i = 0 ; i < m ; i++) {
				int next = arr[num][i];
				if (next == 0) {
					continue;
				}
				if (!visited[next]) {
				    queue.offer(next);
				    visited[next] = true;
				    count++;
				}

			}
		}
		System.out.println(count);
	}
}
