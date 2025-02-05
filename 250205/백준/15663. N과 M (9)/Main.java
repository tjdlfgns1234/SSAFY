import java.io.*;
import java.util.*;

public class Main {
	static HashSet<List<Integer>> compareArr = new HashSet<>(); // 속도를 위해 ArrayList를 HashSet으로 변경
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	String[] input = br.readLine().split(" ");
    	int n = Integer.parseInt(input[0]);
    	int m = Integer.parseInt(input[1]);
    	int[] arr = new int[n];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int i = 0;
    	while (st.hasMoreTokens()) {
    		arr[i] = Integer.parseInt(st.nextToken());
    		i++;
    	}
    	
    	Arrays.sort(arr);
    	
    	// 중복 순열
    	boolean[] visited = new boolean[n];
    	ArrayList<Integer> resultArr = new ArrayList<>();
    	recursive(n, m, arr, visited, resultArr, bw);
    	bw.flush();
    	bw.close();
    }

	private static void recursive(int n, int m, int[] arr, boolean[] visited, ArrayList<Integer> resultArr, BufferedWriter bw) throws IOException {
		// basis
		if (resultArr.size() == m) {
			ArrayList<Integer> tmpArr = new ArrayList<>(); // 임시로 데이터를 저장하고 비교에 쓰기 위한 ArrayList
			for (int i = 0 ; i < resultArr.size() ; i++) {
				tmpArr.add(resultArr.get(i)); 	// tmpArr에 임시로 값을 넣고
			}
			if (compareArr.contains(tmpArr)) { 	// compareArr가 갖고 있으면 return
				return;
			} else {							// 갖고 있지 않다면 compareArr에 저장해두고 값을 출력
				compareArr.add(tmpArr);
				for (int i = 0 ; i < resultArr.size() ; i++) {
					bw.write(resultArr.get(i) + " ");
				}
				bw.write("\n");
			}
			return;
		}
		
		
		// inductive
		for (int i = 0 ; i < n ; i++) {
			if (!visited[i]) {
				visited[i] = true;
				resultArr.add(arr[i]);
				recursive(n, m, arr, visited, resultArr, bw);
				visited[i] = false;
				resultArr.remove(resultArr.size()-1);
			}
		}
		
	}
}

