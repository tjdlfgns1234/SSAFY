package cote;

import java.io.*;
import java.util.*;

public class 플로이드 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int M;
	static int[][] adj;
	
	public static void main(String[] args)throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		adj = new int[N+1][N+1];
		
		for(int i=0;i<adj.length;i++) {
			Arrays.fill(adj[i], Integer.MAX_VALUE);
		}
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[s][e] =Math.min(adj[s][e],w);
		}
		
		
		int[][] dist = new int[N+1][N+1];
		//디스트 초기화
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i==j) {
					dist[i][j]=0;
				}
				else
				{
					dist[i][j] = adj[i][j];
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				for(int k=1;k<=N;k++) {
					if(dist[j][i] == Integer.MAX_VALUE || dist[i][k] == Integer.MAX_VALUE)continue;
					dist[j][k] = Math.min(dist[j][k], dist[j][i] +  dist[i][k]);
				}
				
			}
		}
		
		for(int i=1;i<dist.length;i++) {
			for(int j=1;j<dist.length;j++) {
				if(dist[i][j]==Integer.MAX_VALUE)System.out.print(0+" ");
				else System.out.print(dist[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
