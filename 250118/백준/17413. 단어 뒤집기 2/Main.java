import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	String[] input = br.readLine().split("");
    	StringBuilder result = new StringBuilder();
    	StringBuilder tmp = new StringBuilder(); // 기본적으로 초기화되어 있음
    	
    	boolean check = false;
    	for (int i = 0 ; i < input.length ; i++) {
    		String str = input[i];
    		if (str.equals("<")) {
    			result.append(tmp.reverse());
    			tmp.setLength(0); // 초기화
    			check = true;
    			result.append("<");
    		} else if (str.equals(">")) {
    			check = false;
    			result.append(">");
    		} else if (str.equals(" ") && !check) { // 공백이고 < > 밖이면 진입
    			result.append(tmp.reverse());
                tmp.setLength(0);
                result.append(" "); // 공백 추가
    		} else {
                // 태그 안이거나 단어 모으기
                if (check) {
                    result.append(str); // 태그 내부 그대로 추가
                } else {
                    tmp.append(str); // 단어 모으기
                }
            }
    	}
    	result.append(tmp.reverse());
      System.out.println(result.toString());

      br.close();
    }
}
