import java.io.*;
import java.util.*;

public class Main {

	static int cnt = 1;        

	// static int[][] map = new int[n][n];
	
	public static void main(String[] args) {
		// System.setIn(Solution.class.getResourceAsStream("text.txt"));
		Scanner sc = new Scanner(System.in);

        
		int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
	
		for(int i = 0; i < n;i++) 
			arr[i] =sc.nextInt();
		
		int ans = 0;

        Arrays.sort(arr);

        // 10의 배수중 가장 작은 거 부터 처리해야 함
        // why? 30이 먼저 잘리면 20을 처리 못함.ㅡ
        // 10의 배수 인거 먼저 처리
        for(int i = 0; i < n;i++) 
            if(arr[i] % 10 == 0){
                if(arr[i] == 10){
                    ans++;
                    continue;
                }
                while(arr[i] > 10 && m > 0){
                    arr[i] -= 10;
                    ans++;
                    m--;
                }
                if(arr[i] == 10)
                    ans++;
            }
        // 10의 배수가 아닌 경우
        for(int i = 0; i < n;i++) {
           if(arr[i] % 10 != 0){
                while(arr[i] > 10 && m > 0){
                    arr[i] -= 10;
                    ans++;
                    m--;
                }
           }
        }

		System.out.print(ans);
	}
	
	// public static void print(int n) {
	// 	for(int j = 0; j < n;j++) {
	// 		for(int k = 0; k< n;k++) 
	// 			System.out.print(arr[j][k]+" ");
	// 		System.out.println();
	// 	}		

    	
	// public static void print(int n) {
	// 	for(int i = 0; i < n;i++) {
	// 		System.out.print(arr[i]+" ");
	// 	}		
	// }
	
//	public static void solve(int n) {
//			for(int i = 0; i < n-1;i++) {
//				if(arr[i+1] - arr[i] < 0) // 내려가기
//					low = Math.max(low, Math.abs(arr[i] - arr[i+1]));
//				if(arr[i+1] - arr[i] > 0) // 올라가기
//					high = Math.max(high, Math.abs(arr[i] - arr[i+1]));
//			}
//	}
}
