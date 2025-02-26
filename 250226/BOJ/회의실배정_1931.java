import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 회의실배정_1931 {
	
	static class Meeting {
		int start;
		int end;
		
		Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<Meeting> meetings = new ArrayList<>();
		
		for (int i=0; i<N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			meetings.add(new Meeting(s, e));
		}
		
		Collections.sort(meetings, (o1, o2) -> {
			if (o1.end == o2.end) {
				return Integer.compare(o1.start, o2.start);
			}
			
			return Integer.compare(o1.end, o2.end);
		});
		
		int result = 1;
		int prev = meetings.get(0).end;
		for (int i=1; i<meetings.size(); ++i) {
			if (meetings.get(i).start >= prev) {
				++result;
				prev = meetings.get(i).end;
			}
		}
		
		System.out.println(result);
		
	}

}
