import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine()); // 사람의 수
        StringTokenizer st = new StringTokenizer(br.readLine()); // 줄 순서 입력
        ArrayList<Integer> arr = new ArrayList<>();
        while(st.hasMoreTokens()) {
        	int tmp = Integer.parseInt(st.nextToken());
        	arr.add(tmp);
        }
        
        Collections.sort(arr); // 오름차순 정렬
        
        int result = 0;
        for (int i = n-1 ; i >= 0 ; i--) { // 인덱스 역순으로 (리스트 길이가 줄어도 괜찮도록)
        	int sum = 0;
        	for (int j : arr) {
        		sum += j;
        	}
        	result += sum;
        	arr.remove(i); // 가장 끝에서부터 제거
        }
        System.out.println(result);
        
        br.close();
    }
}
