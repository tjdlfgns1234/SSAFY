package cotest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 선긋기 {
	
	static class pair implements Comparable<pair>{
		int s;
		int e;
		public pair(int s , int e) {
			this.s=s;
			this.e=e;
		}
		
		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return s-o.s;
		}
		
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static List<pair> arr = new ArrayList<>();
	static long result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr.add(new pair(s,e));
		}
		
		Collections.sort(arr);
		
		long l=arr.get(0).s,r=arr.get(0).e;
		for(int i=1;i<arr.size();i++) {
			pair p =arr.get(i);
			if(r>=p.s && r<p.e) {
				r = p.e;
			}
			else if(r<p.s) {
				result+=r-l;
				l = p.s;
				r = p.e;
			}
			
		}
		
		System.out.println(result+(r-l));
		
	}
	
}
