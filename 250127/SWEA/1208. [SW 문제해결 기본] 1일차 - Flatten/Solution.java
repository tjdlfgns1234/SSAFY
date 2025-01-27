import java.io.*;
import java.util.*;
// 덤프 횟수만큼 돌면서 배열 요소 하나하나 비교하며 최대 최소 찾는 방식
public class Solution {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
    	ArrayList<Integer> resultArr = new ArrayList<>();
    	for (int k = 0 ; k < 10 ; k++) {
        	int dump = Integer.parseInt(br.readLine()); // 덤프 횟수
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	ArrayList<Integer> arr = new ArrayList<>();
        	while(st.hasMoreTokens()) {
        		int tmp = Integer.parseInt(st.nextToken());
        		arr.add(tmp);
        	}
        	int result = 0;
        	for(int i = 0 ; i < dump ; i++) { // 덤프 횟수
            	int maxVal = Integer.MIN_VALUE;
            	int maxIdx = 0;
            	int minVal = Integer.MAX_VALUE;
            	int minIdx = 0;
        		for (int j = 0 ; j < 100 ; j++) { // 배열
        			if (arr.get(j) > maxVal) {
        				maxVal = arr.get(j);
        				maxIdx = j;
        			}
        			if (arr.get(j) < minVal) {
        				minVal = arr.get(j);
        				minIdx = j;
        			}
        		}
        		arr.set(maxIdx, maxVal-1);
        		arr.set(minIdx, minVal+1);
        		// result = maxVal - minVal;
        	}
        	int maxVal = Integer.MIN_VALUE;
        	int maxIdx = 0;
        	int minVal = Integer.MAX_VALUE;
        	int minIdx = 0;
        	for (int j = 0 ; j < 100 ; j++) {
    			if (arr.get(j) > maxVal) {
    				maxVal = arr.get(j);
    			}
    			if (arr.get(j) < minVal) {
    				minVal = arr.get(j);
    			}
        	}
        	result = maxVal - minVal;
        	resultArr.add(result);
    	}
    	for (int i = 0 ; i < 10 ; i++) {
    		System.out.printf("#%d %d\n", i+1, resultArr.get(i));
    	}
    }
}
