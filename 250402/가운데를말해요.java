import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 가운데를말해요 {
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2)->{return o2-o1;});
		
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(minHeap.size()==maxHeap.size()) {
				maxHeap.add(temp);
			}
			else {
				minHeap.add(temp);
			}
			
			if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
				if(minHeap.peek()<maxHeap.peek()) {
					int t = minHeap.poll();
					minHeap.add(maxHeap.poll());
					maxHeap.add(t);
				}
			}
			
			sb.append(maxHeap.peek()+"\n");
			
			
		}
		
		System.out.println(sb);
		
	}
	
}
