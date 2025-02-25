import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int M = Integer.parseInt(input1[1]);
        
        arr = new int[N+1];
        for (int i = 1 ; i < N + 1 ; i++) { // 초기 설정 : 각 집합엔 자기 자신만
        	arr[i] = i;
        }
        
//        System.out.println(Arrays.toString(arr));
        
        for (int k = 0 ; k < M ; k++) {
        	String[] input2 = br.readLine().split(" ");
        	int S = Integer.parseInt(input2[0]);
        	int A = Integer.parseInt(input2[1]);
        	int B = Integer.parseInt(input2[2]);
        	
        	if (S == 0) { // 연결
        		unionParent(A, B);
        	} else if (S == 1) { // 확인
        		findParent(A, B);
        	}
        }
	}

	// 두 부모 노드를 합치는 합수
    private static void unionParent(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		
		if (a < b) { // 이 부분도 임의 설정, 여기선 그냥 작은 걸로 통일
			arr[b] = a;
		} else {
			arr[a] = b;
		}
	}

	// 부모를 찾는 함수
	private static int getParent(int num) {
		if (arr[num] == num) {
			return num;
		}
		return arr[num] = getParent(arr[num]);
	}
    
    // 같은 부모를 가지는지 확인하는 함수
    private static void findParent(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		if (a == b) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
	}
}
