package cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import cote.미생물격리.pair;

public class 감시 {
	
	//0은 빈 칸, 6은 벽, 1~5는 CCTV를 나타내고, 문제에서 설명한 CCTV의 종류이다. 
	//방향에 대한 쏴주는 거 , 
	
	static class pair{
		int y;
		int x;
		int d;
		public pair(int y , int x , int d) {
			this.y=y;
			this.x=x;
			this.d=d;
		}
	}
	

	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N ,M;
	static int map[][];
	static int dir[]; // 
	static List<pair> l = new ArrayList<>();
	static int[] dy = {0,1,0,-1};
	static int[] dx = {1,0,-1,0};
	static int result = Integer.MAX_VALUE;
	
	static void move_1(int map[][] , int dir , pair p) {
		int ny = p.y;
		int nx = p.x;
		while(true) {
			ny +=dy[dir];
			nx +=dx[dir];
			if(ny<0||ny>=N||nx<0||nx>=M)return;
			if(map[ny][nx]==6)return;
			map[ny][nx] = 7;
		}
	}
	
	static void move_2(int map[][] , int dir , pair p) {
		int ny = p.y;
		int nx = p.x;
		while(true) {
			ny +=dy[dir];
			nx +=dx[dir];
			if(ny<0||ny>=N||nx<0||nx>=M)break;
			if(map[ny][nx]==6)break;
			map[ny][nx] = 7;
		}
		
		ny = p.y;
		nx = p.x;
		while(true) {
			ny +=dy[(dir+2)%4];
			nx +=dx[(dir+2)%4];
			if(ny<0||ny>=N||nx<0||nx>=M)break;
			if(map[ny][nx]==6)break;
			map[ny][nx] = 7;
		}
	}
	
	static void move_3(int map[][] , int dir , pair p) {
		int ny = p.y;
		int nx = p.x;
		while(true) {
			ny +=dy[dir];
			nx +=dx[dir];
			if(ny<0||ny>=N||nx<0||nx>=M)break;
			if(map[ny][nx]==6)break;
			map[ny][nx] = 7;
		}
		
		ny = p.y;
		nx = p.x;
		while(true) {
			ny +=dy[(dir+3)%4];
			nx +=dx[(dir+3)%4];
			if(ny<0||ny>=N||nx<0||nx>=M)break;
			if(map[ny][nx]==6)break;
			map[ny][nx] = 7;
		}
	}
	
	static void move_4(int map[][] , int dir , pair p) {
		int ny = p.y;
		int nx = p.x;
		while(true) {
			ny +=dy[dir];
			nx +=dx[dir];
			if(ny<0||ny>=N||nx<0||nx>=M)break;
			if(map[ny][nx]==6)break;
			map[ny][nx] = 7;
		}
		
		ny = p.y;
		nx = p.x;
		while(true) {
			ny +=dy[(dir+2)%4];
			nx +=dx[(dir+2)%4];
			if(ny<0||ny>=N||nx<0||nx>=M)break;
			if(map[ny][nx]==6)break;
			map[ny][nx] = 7;
		}
		
		ny = p.y;
		nx = p.x;
		while(true) {
			ny +=dy[(dir+3)%4];
			nx +=dx[(dir+3)%4];
			if(ny<0||ny>=N||nx<0||nx>=M)break;
			if(map[ny][nx]==6)break;
			map[ny][nx] = 7;
		}
	}
	
	static void move_All(int map[][] , int y , int x) {
		int ny = y;
		int nx = x;
		
		pair p = new pair(y,x,0);
		while(true) {
			ny +=dy[0];
			nx +=dx[0];
			if(ny<0||ny>=N||nx<0||nx>=M)break;
			if(map[ny][nx]==6)break;
			map[ny][nx] = 7;
		}
		
		ny = p.y;
		nx = p.x;
		while(true) {
			ny +=dy[1];
			nx +=dx[1];
			if(ny<0||ny>=N||nx<0||nx>=M)break;
			if(map[ny][nx]==6)break;
			map[ny][nx] = 7;
		}
		
		ny = p.y;
		nx = p.x;
		while(true) {
			ny +=dy[2];
			nx +=dx[2];
			if(ny<0||ny>=N||nx<0||nx>=M)break;
			if(map[ny][nx]==6)break;
			map[ny][nx] = 7;
		}
		
		ny = p.y;
		nx = p.x;
		while(true) {
			ny +=dy[3];
			nx +=dx[3];
			if(ny<0||ny>=N||nx<0||nx>=M)break;
			if(map[ny][nx]==6)break;
			map[ny][nx] = 7;
		}
	}
	
	
	static int calcu() {
		int copy[][] = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				copy[i][j] = map[i][j];
			}
		}
		
		for(int i=0;i<l.size();i++) {
			pair p =l.get(i);
			if(p.d==5) {
				move_All(copy,p.y,p.x);
			}
			else if(p.d==1) {
				move_1(copy, dir[i], p);
			}
			else if(p.d==2) {
				move_2(copy, dir[i], p);
			}
			else if(p.d==3) {
				move_3(copy, dir[i], p);
			}
			else if(p.d==4) {
				move_4(copy, dir[i], p);
			}
		}
		
		int sum=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copy[i][j]==0)sum++;
			}
		}
		//System.out.println();
		
//		for(int i=0;i<N;i++) {
//			System.out.println(Arrays.toString(copy[i]));
//		}
//		System.out.println(sum);
		//System.out.println(sum);
		return sum;
		
	}
	
	
	
	static void recursive(int k) {
		if(k==l.size()) {
			result = Math.min(calcu() ,result);
			return;
		}
		dir[k] =0;
		recursive(k+1);
		dir[k] =1;
		recursive(k+1);
		dir[k] =2;
		recursive(k+1);
		dir[k] =3;
		recursive(k+1);
	}
	
	public static void main(String[] args)throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M]; 
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]!=0 && map[i][j]!=6) {
					l.add(new pair(i,j,map[i][j]));
				}
			}
		}
		dir = new int[l.size()];
		recursive(0);
		System.out.println(result);
	}
}
