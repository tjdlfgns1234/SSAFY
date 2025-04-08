import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최장증가부분수열 {
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] arr ,lis;
	static int num=1;
	
	static int binarySearch(int l , int r , int target) {
		
		while(l<r) {
			int mid = (l+r)/2;
			if(target>lis[mid]) {
				l = mid+1;
			}
			else {
				r = mid;
			}
		}
		return r;
		
	}
	
	static void logic() throws IOException {
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		lis = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int j=0;
		int i=1;
		lis[0] = arr[0];
		while(i<N) {
			if(lis[j]<arr[i]) {
				lis[j+1]=arr[i];
				j++;
			}
			else {
				int pos = binarySearch(0,j,arr[i]);
				lis[pos] = arr[i];
			}
			i++;
		}
		System.out.println("#"+(num++)+" "+(j+1));
		
	}
	
	public static void main(String[] args) throws IOException {
		int tc = Integer.parseInt(br.readLine());
		for(int i=0;i<tc;i++) {
			logic();
		}

	}
	
}
