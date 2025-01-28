import java.io.*;
import java.util.*;
// 깉이가 같지만 0으로 채워진 배열과 비교하면서 바꾼 횟수(count)를 저장하도록.
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int k = 0 ; k < t ; k++) {
        	String[] input = br.readLine().split("");
            int count = 0;
            String[] newArr = new String[input.length]; // 초기 arr
            for (int i = 0 ; i < input.length ; i++) {
            	newArr[i] = "0";
            }
            
            for (int i = 0 ; i < input.length ; i++) {
            	if (input[i].equals(newArr[i])) { // 값이 같을 경우 pass
            		continue;
            	} else {
            		count++;
            		for (int j = i ; j < input.length ; j++) { // 다를 경우 자기 자신부터 뒤까지 전부 바꿈.
            			if (newArr[j].equals("1")) {
            				newArr[j] = "0";
            			} else {
            				newArr[j] = "1";
            			}
            		}
            	}
            	
            }
            resultArr.add(count);
        }
        for (int i = 0 ; i < t ; i++) {
        	System.out.printf("#%d %d\n", i+1, resultArr.get(i));
        }
    }
}
