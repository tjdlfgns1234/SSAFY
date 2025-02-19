package algorithm_test;

import java.util.*;
import java.io.*;

public class Solution {
	
	static class Node{
		int num, child1, child2;
		char word;
		
		Node(int num, int child1, int child2, char word){
			this.num = num;
			this.child1 = child1;
			this.child2 = child2;
			this.word = word;
		}
//		@Override
//		public String toString() {
//			StringBuilder sb = new StringBuilder();
//			sb.append(num);
//			sb.append(word);
//			sb.append(child1);
//			sb.append(child2);
//			return sb.toString();
//		}
	}
	
	static Node[] node; 
	static StringBuilder result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N, num, child1, child2;
		char word;
		
		for (int t = 1; t < 11; t++) {
			N = Integer.parseInt(br.readLine());
			node = new Node[N+1];
			result = new StringBuilder();
			for (int i = 1; i < N+1; i++) {
				child1 = 0;
				child2 = 0;
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				num = Integer.parseInt(st.nextToken());
				word = st.nextToken().charAt(0);
				if(st.countTokens() == 2) {
					child1 = Integer.parseInt(st.nextToken());
					child2 = Integer.parseInt(st.nextToken());
				}
				else if (st.countTokens() == 1) {
					child1 = Integer.parseInt(st.nextToken());
				}
				
				node[i] = new Node(num, child1, child2, word);
			}
			
			
			inorder(1);
			System.out.println("#" + t + " "+result.toString());
		}
		
	}
	private static void inorder(int i) {
		if(i == 0) return;
		
		inorder(node[i].child1);
		result.append(node[i].word);
		inorder(node[i].child2);
	}

}
