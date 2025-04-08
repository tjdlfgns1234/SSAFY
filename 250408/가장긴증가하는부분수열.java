import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] arr;
	static int N;
	static int lis[];
	
	static int binarySearch(int l ,int r , int targer) {
		while(l<r) {
			int mid = (l+r)/2;
			if(lis[mid]<targer) {
				l = mid+1;
			}
			else {
				r=mid;
			}
		}
		
		return r;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		lis = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int i=1;
		int j=0;
		lis[0]=arr[0];

		while(i<N) {
			if(lis[j]<arr[i]) {
				lis[j+1]=arr[i];
				j++;
			}
			else {
				int p = binarySearch(0,j,arr[i]);
				lis[p] = arr[i];
			}
			i++;
		}
		
		System.out.println(j+1);
		
		
	}
	
	
}
