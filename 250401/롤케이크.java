import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 롤케이크 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int L,N;
	static boolean[] arr;
	
	private static int g1(int a , int b) {
		while(b!=0) {
			int temp = b;
			b = a%b;
			a=temp;
		}
		return a;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		L = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		int max = 0 , num=0; //기대
		int max1 = 0 , num1=0; //실질
		arr = new boolean[L+1];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			if(max<k-p+1) {
				max = k-p+1;
				num=i+1;
			}
			
			int count=0;
			for(int j=p;j<=k;j++) {
				if(arr[j])continue;
				arr[j]=true;
				count++;
			}

			if(max1<count) {
				max1 = count;
				num1=i+1;
			}
			
		}
		
		System.out.println(num);
		System.out.println(num1);
		
	}
}
