import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 초기
        List<String> blank1 = Arrays.asList("A", "D", "O", "P", "Q", "R");
        List<String> blank0 = Arrays.asList("C", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "S", "T", "U", "V", "W", "X", "Y", "Z");
        
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스
        ArrayList<ArrayList<String>> arr = new ArrayList<>();
    	for (int j = 0 ; j < t ; j++) {
        	arr.add(new ArrayList<>()); // arr 초기화
        }
        for (int i = 0 ; i < t ; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                for (String tmp : token.split("")) {
                    if (blank0.contains(tmp)) {
                        token = token.replace(tmp, "0");
                    } else if (blank1.contains(tmp)) {
                    	token = token.replace(tmp, "1");
                    } else {
                    	token = token.replace(tmp, "2");
                    }
                }
                arr.get(i).add(token);
            }
        }
        int a = 1;
        for (ArrayList<String> i : arr) {
        	if(i.get(0).equals(i.get(1))) {
        		bw.write("#"+a+" "+"SAME" + "\n");
        	} else {
        		bw.write("#"+a+" "+"DIFF" + "\n");
        	}
        	a++;
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
