import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int k = 1 ; k <= 10 ; k++) {
        	br.readLine();
        	ArrayDeque<Integer> queue = new ArrayDeque<>();
        	String[] input = br.readLine().split(" ");
        	for (int i = 0 ; i < 8 ; i++) {
        		int temp = Integer.parseInt(input[i]);
        		queue.offer(temp);
        	}
        	int cycle = 1;
        	while (queue.getLast() > 0) {
        		int front = queue.poll();
        		queue.offer(front  - cycle);
        		cycle++;
        		if (cycle == 6) {
        			cycle = 1;
        		}
        	}
        	
        	queue.pollLast();
        	queue.offerLast(0);
        	
        	System.out.printf("#%d ", k);
        	for (int i = 0 ; i < 8 ; i++) {
        		int a = queue.poll();
        		System.out.printf("%d ", a);
        	}
        	System.out.println();
        }
    }
}
