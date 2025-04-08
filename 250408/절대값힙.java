import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 절대값힙 {
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static List<List<Integer>> triangle = new ArrayList<>();
	static StringBuffer sb = new StringBuffer();
	
	//0 아닐 경우 배열에 x라는 값을 넣는(추가하는) 연산
	//x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(
				(o1, o2) ->{
					if(Math.abs(o1) == Math.abs(o2)) {
						return o1 - o2;
					}
					else {
						return Math.abs(o1) -  Math.abs(o2);
					}
				} );
		
		for(int i=0;i<n;i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp==0) {
				if(pq.isEmpty()) {
					sb.append(0+"\n");
				}
				else {
					sb.append(pq.poll()+"\n");
				}
			}
			else {
				pq.add(temp);
			}
			
		}
		
		System.out.println(sb);

	}
	
}
