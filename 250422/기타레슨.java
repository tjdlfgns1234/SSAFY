package cotest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타레슨 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static int[] arr;
	
	static int isCheck(int mid) {
		int sum=0;
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>mid)return Integer.MAX_VALUE;
			sum+=arr[i];
			 if(sum>mid) {
				 count++;
				 sum=0; i--;
			 }
		}

		return count+1;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		int max=0 , result=Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max+=arr[i];
		}
		int l=1, r = max;
		while(l<=r) {
			int mid = (l+r)/2;
			int count = isCheck(mid);
			if(count<=M) {
				r=mid-1;
				result = Math.min(result, mid);
			}
			else if(count>M) {
				l = mid+1;
			}
		}

		System.out.println(result);
	}

}
