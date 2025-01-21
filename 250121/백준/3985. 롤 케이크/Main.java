import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int L = Integer.parseInt(br.readLine()); // 롤케이크 길이
    	int N = Integer.parseInt(br.readLine()); // 방청객 수
    	// 조각은 0부터 L-1까지가 아니라 1부터 L까지
    	// 방청객 숫자 카운트도 1부터다.
    	
    	ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    	ArrayList<Integer> fill = new ArrayList<>();
    	for (int i = 0 ; i < L ; i++) {
    		fill.add(0); // 0으로 채우기
    	}
    	
    	for (int i = 0 ; i < N ; i++) {
    		arr.add(new ArrayList<>());
    		String[] temp = br.readLine().split(" ");
    		int a = Integer.parseInt(temp[0]);
    		int b = Integer.parseInt(temp[1]);
    		arr.get(i).add(a);
    		arr.get(i).add(b);
    		for (int j = a-1 ; j <= b-1 ; j++) {
    			if (fill.get(j) != 0) {
    				continue;
    			} else {
    				fill.set(j, i+1);
    			}
    		}
    	}
    	
    	int maxLoc = -1;
    	int realMaxVal = -1;
    	for (int i = 1 ; i <= N ; i++) {
    		int tempSum = 0;
    		for (int j = 0 ; j < fill.size() ; j++) {
        		if (fill.get(j) == i) {
        			tempSum++;
        		}
        	}
    		if (tempSum > realMaxVal) {
    			realMaxVal = tempSum;
    			maxLoc = i;
    		}
    	}
    	
    	
    	
    	int maxIdx = -1;
    	int tmp = -1;
    	for (int i = 0 ; i < N ; i++) {
    		int diff = Math.abs(arr.get(i).get(0) - arr.get(i).get(1));
    		if (diff > tmp) {
    			tmp = diff;
    			maxIdx = i + 1;
    		}
    	}
    	
    	System.out.println(maxIdx);
    	System.out.println(maxLoc);
    }
}
