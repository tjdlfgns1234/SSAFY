import java.io.*;
import java.util.*;
// 1부터 n까지 스위치
// 남학생은 받은 수의 배수
// 여학생은 좌우 대칭만큼
public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine()); // 스위치 개수
    	ArrayList<Integer> arr = new ArrayList<>(); // 스위치 내용을 담을 ArrayList
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	while (st.hasMoreTokens()) {
    		int tmp = Integer.parseInt(st.nextToken());
    		arr.add(tmp);
    	}
    	int student = Integer.parseInt(br.readLine()); // 학생 수만큼 반복
    	for (int i = 0 ; i < student ; i++) {
    		String[] input = br.readLine().split(" ");
    		if (Integer.parseInt(input[0]) == 1) { 	// 남자인 경우
    			arr = boy(arr, Integer.parseInt(input[1]));
    		} else { 								// 여자인 경우
    			arr = girl(arr, Integer.parseInt(input[1]));
    		}
    	}
    	int count = 0;
    	for (int i = 0 ; i < n ; i++) {
    		if (count%20 == 0 && i != 0) // 20이 넘으면 println
    			System.out.println();
    		System.out.printf("%d ", arr.get(i));
    		count++;
    	}
    }

	private static ArrayList<Integer> boy(ArrayList<Integer> arr, int n) {
		int temp = n;
		while (n-1 < arr.size()) { // 인덱스는 0부터, 실제는 1부터이므로 -1
			arr.set(n-1, switch01(arr.get(n-1)));
			n = n+temp; // 배수 계산
		}
		return arr;
	}
	
	private static ArrayList<Integer> girl(ArrayList<Integer> arr, int n) {
		n = n-1; // 역시 인덱스는 0부터
		int times = 1;
		while (true) {
			if (n-times < 0 || n+times >= arr.size()) {
				break;
			}
			if (arr.get(n-times) != arr.get(n+times)) {
				break;
			}
			times++; // 인덱스 범위를 넘지 않고 대칭 구조라면 times 증가
		}
		for ( int j = n-times+1 ; j < n+times ; j++) { // times 범위를 더하고 뺀 만큼 for문 돌림
			arr.set(j, switch01(arr.get(j)));
		}
		return arr;
	}

	private static int switch01(int a) {
		if (a == 0)
			a = 1;
		else
			a = 0;
		return a;
	}
}
