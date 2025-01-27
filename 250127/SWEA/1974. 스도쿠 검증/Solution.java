import java.io.*;
import java.util.*;
// 스도쿠가 맞을 경우 1, 아닐 경우 0 출력
// 합이 45가 아닐 경우 스도쿠가 아니라고 판별
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스
        ArrayList<Integer> resultArr = new ArrayList<>();
        
        for (int k = 0 ; k < t ; k++) {
        	ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

            for (int i = 0 ; i < 9 ; i++) {
            	arr.add(new ArrayList<>());
            	String[] tmpArr = br.readLine().split(" ");
            	for (int j = 0 ; j < 9 ; j++) {
            		arr.get(i).add(Integer.parseInt(tmpArr[j]));
            	}
            }
            
            boolean notSudoku = false;
            ArrayList<ArrayList<Integer>> arr3x3 = new ArrayList<>(); // 9행 3열
            // 가로로 이동할 때 3개씩 더한 걸 ArrayList에 넣고
            // 나중에 이 arr3x3을 세로로 3개씩 더하면 3x3 격자 합을 구할 수 있음
            
            for (int i = 0 ; i < 9 ; i++) { // 가로
            	arr3x3.add(new ArrayList<>());
            	int sum = 0;
            	int sum3x3 = 0;
            	int count = 0;
            	for (int j = 0 ; j < 9 ; j++) {
            		sum += arr.get(i).get(j); // 여기서부터 아래 if문까지는 arr3x3을 위한 영역
            		sum3x3 += arr.get(i).get(j);
            		count++;
            		if (count == 3) {
            			arr3x3.get(i).add(sum3x3);
            			count = 0;
            			sum3x3 = 0;
            		}
            	}
            	if (sum != 45) {
            		notSudoku = true;
            		break;
            	}
            }
            
            for (int j = 0 ; j < 9 ; j++) { // 세로
            	if (notSudoku == true) {
            		break;
            	}
            	int sum = 0;
            	for (int i = 0 ; i < 9 ; i++) {
            		sum += arr.get(i).get(j);
            	}
            	if (sum != 45) {
            		notSudoku = true;
            		break;
            	}
            }
            
            for (int i = 0 ; i < 3 ; i++) { // 3x3
            	if (notSudoku == true) {
            		break;
            	}
            	int count = 0;
            	int sum = 0;
            	for (int j = 0 ; j < 9 ; j++) {
            		sum += arr3x3.get(j).get(i);
            		count++;
            		if (count == 3) {
            			if (sum != 45) {
            				notSudoku = true;
            				break;
            			}
            			count = 0;
            			sum = 0;
            		}
            	}
            }
            if (notSudoku == false) {
            	resultArr.add(1);
            } else {
            	resultArr.add(0);
            }
        }
        
        for (int i = 0 ; i < t ; i++) {
        	System.out.printf("#%d %d\n", i+1, resultArr.get(i));
        }
    }
}
