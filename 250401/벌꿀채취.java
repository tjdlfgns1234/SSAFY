import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 벌꿀채취 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M,C;
	static int map[][];
	static int result[][];
	static int num=1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int tc = Integer.parseInt(br.readLine());
		for(int i=0;i<tc;i++) {
			logic();
		}
		
	}
	
	static int calcu(int[] arr){
		int c = C;
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>c)return 0;
			sum+=arr[i]*arr[i];
			c-=arr[i];
		}

		return sum;
	}

	private static int combi(int idx, int k, Integer[] arr , int[] sto) {
		int result = calcu(sto);
		if(idx==arr.length)return result;
		sto[k] = arr[idx];
		result= Math.max(combi(idx+1,k+1 ,arr , sto), result);
		sto[k] = 0;
		result = Math.max(combi(idx+1,k ,arr , sto), result);
		return result;
	}
	
	private static void search(int y, int x) {
		// TODO Auto-generated method stub
		Integer arr[] = new Integer[M];
		
		for(int i=x , k=0; i<x+M ; i++,k++) {
			if(i>=N)return;
			arr[k]=map[y][i];
		}
		int sum =combi(0,0,arr, new int[M]);
		result[y][x]=sum;
	}


	private static void logic() throws IOException {
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		result = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				search(i,j);
			}
		}
		
//		for(int i=0;i<N;i++) {
//			System.out.println(Arrays.toString(result[i]));
//		}
		
		int first=0;
		int maxPointY=0 ,maxPointX=0  ;
		int second=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(first<result[i][j]) {
					maxPointY = i;
					maxPointX=j;
					first = result[i][j];
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(maxPointY==i) {
					continue;
					//if(maxPointX<=j && j<maxPointX+M)continue;
				}
				
				if(second<result[i][j]) {
					second = result[i][j];
				}
				
			}
		}
		
		System.out.println("#"+(num++)+" "+(first+second));
		
	}



	
}
