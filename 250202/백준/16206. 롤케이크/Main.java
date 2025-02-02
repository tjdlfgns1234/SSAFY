import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 롤케이크 개수 n
        int m = Integer.parseInt(input[1]); // 자를 수 있는 횟수
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = 0;
        while (st.hasMoreTokens()) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	i++;
        }
        
        Arrays.sort(arr);
        
        int cutCount = m;		// 자른 횟수 추적
        int rollCake = 0;
        
        for (i = 0 ; i < n ; i++) { // 10
        	if (arr[i] == 10) {
        		rollCake++;
        		arr[i] = -1; // 제외 시키기 위함
        	}
        }
        
        
        for (i = 0 ; i < n ; i++) { // 10의 배수
        	if (arr[i] == -1) {
        		continue;
        	}
        	if (arr[i] % 10 == 0) {
        		int tmp = arr[i];
        		arr[i] = -1; // 이후 계산에서 제외
        		while (cutCount > 0 && tmp != 10) {
        			cutCount--;
        			rollCake++;
        			tmp = tmp - 10;
        			if (tmp == 10) { // 위에서 한번 자르고 '남은게' 10이면 while문 break
        				rollCake++;
        				break;
        			}
        		}
        	}
        }
        
        if (cutCount > 0) {
            for (i = 0 ; i < n ; i++) {
            	if (arr[i] == -1) {
            		continue;
            	}
            	int tmp = arr[i];
            	while (cutCount > 0 && tmp > 10) {
            		cutCount--;
        			rollCake++;
        			tmp = tmp - 10;
            	}
            }
        }

        bw.write(rollCake + "\n");
        bw.flush();
        bw.close();
    }
}
