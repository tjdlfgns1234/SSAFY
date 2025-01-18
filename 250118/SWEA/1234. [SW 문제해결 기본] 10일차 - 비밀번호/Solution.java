import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = 10; // 테스트 케이스
        
        for (int k = 0 ; k < t ; k++) {
        	String[] input = br.readLine().split(" ");
            int len = Integer.parseInt(input[0]); // 비번 길이
            String[] pwd = input[1].split("");
            ArrayList<Integer> pwdList = new ArrayList<>();
            for (int i = 0 ; i < len ; i++) {
            	pwdList.add(Integer.parseInt(pwd[i]));
            }
            boolean changed = true;

            // 리스트가 변할 때마다 반복
            while (changed) {
                changed = false; // if문에 들어가지 않으면 false라서 while문 끝남
                for (int i = 0; i < pwdList.size() - 1; i++) {
                    if (pwdList.get(i).equals(pwdList.get(i + 1))) {
                        pwdList.remove(i); // 현재 요소 제거
                        pwdList.remove(i); // 다음 요소 제거 (리스트가 줄어들었으므로 같은 인덱스)
                        changed = true; // 리스트가 변경되었음을 표시
                        break; // 리스트가 변경되었으므로 루프를 다시 시작
                    }
                }
            }
            StringBuilder result = new StringBuilder();
            for (int a : pwdList) {
                result.append(a); // [1,2,3,4] -> 1234로 출력
            }
            bw.write("#" + (k+1) + " " + result + "\n");
        }
        
        
        bw.flush();
        br.close();
        bw.close();
    }
}
