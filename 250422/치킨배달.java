package cotest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달 {
	
	static class pair{
		int y;
		int x;
		public pair(int y,int x) {
			this.y=y;
			this.x=x;
		}
	}
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static List<pair> chicken = new ArrayList<>();
	static List<pair> home = new ArrayList<>();
	static int result = Integer.MAX_VALUE;
	
	private static int calcu(int[] st) {
		// TODO Auto-generated method stub
		int sum=0;
		for(int i=0;i<home.size();i++) {
			int min = Integer.MAX_VALUE;
			pair h = home.get(i);
			for(int j=0;j<st.length;j++) {
				pair c = chicken.get(st[j]);
				min = Math.min(min, Math.abs(c.y-h.y)+Math.abs(c.x-h.x));
			}
			sum+=min;
		}
		return sum;
	}
	
	public static void combi(int idx , int k , int st[]) {
		if(k==M) {
			result = Math.min(result,calcu(st));
			return;
		}
		if(idx>=chicken.size())return;
		
		st[k]=idx;
		combi(idx+1,k+1,st);
		combi(idx+1,k,st);
	}
	
	
	




	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp==1) {
					home.add(new pair(i,j));
				}
				else if(temp==2) {
					chicken.add(new pair(i,j));
				}
			}
		}
		
		
		combi(0,0,new int[M]);
		System.out.println(result);
		
	}

}
