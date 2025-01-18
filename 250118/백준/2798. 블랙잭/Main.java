import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(input[0]); // 카드의 개수
        int m = Integer.parseInt(input[1]); // 기준 (m을 넘으면 안됨)
        
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) {
        	arr.add(Integer.parseInt(st.nextToken()));
        }
        
        int max = 0;
        for (int x = 0 ; x < n ; x++) {
        	for (int y = x + 1 ; y < n ; y++) {
        		for (int z = y + 1 ; z < n ; z++) { 	// 안겹치게 탐색
        			int sum = arr.get(x) + arr.get(y) + arr.get(z);
        			if (sum <= m && sum > max) {
        				max = sum;
        			} else {
        				continue;
        			}
        		}
        	}
        }
        System.out.println(max);
        
        br.close();
    }
}
