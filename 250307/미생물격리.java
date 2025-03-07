package cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
// 미생물 군집이 이동 후 약품이 칠해진 셀에 도착하면 군집 내 미생물의 절반이 죽고, 이동방향이 반대로 바뀐다. 
//군집의 이동방향은 상하좌우 4방향 중 한 방향을 가진다. (상: 1, 하: 2, 좌: 3, 우: 4)
public class 미생물격리 {
	
	static class pair{
		int y;
		int x;
		int c;
		int dir;
		int baseC; // Merge를 위한 비교값 변수
		public pair(int y, int x , int c, int dir , int baseC) {
			this.y=y;
			this.x=x;
			this.c=c;
			this.dir =dir;
			this.baseC =baseC;
		}
		
		public void setC() {
			baseC =c;
		}
	}
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N ,M , K;
	static List<pair> l; //미생물
	static int[] dy = {0,-1,1,0,0};
	static int[] dx = {0,0,0,-1,1};
	static int num=1;
	
	//나누기 모듈
	
	private static void divide(List<pair> list) {
		for(int i=0;i<list.size();i++) {
			pair p = l.get(i);
			if(p.y==0 || p.y==N-1 || p.x ==0 || p.x==N-1) {
				//나누기
				int div = p.c/2;
				if(div==0) {
					list.remove(i);
					i--;
					continue;
				}
				int nDir =0;
				if(p.dir==1 || p.dir==2) {
					nDir = p.dir==2?1:2;
				}
				else {
					nDir = p.dir==3?4:3;
				}
				l.set(i, new pair(p.y,p.x,div,nDir,div));
			}
		}
	}
	
	//합치기 모듈 (여기 조심 l 사이즈)
	private static void merge(List<pair> list) {
		// TODO Auto-generated method stub
		//리스트의 사이즈가 줄어듬에 따른 대체 boolean 값
		boolean isCheck[] = new boolean[l.size()];
		for(int i=0;i<l.size();i++) {
			if(isCheck[i]==true)continue;
			pair p = l.get(i);
			for(int j=i+1;j<l.size();j++) {
				pair tp = l.get(j);
				if(tp.y == p.y && tp.x == p.x) {
					if(tp.baseC>p.baseC) {
						//j가 살아남음
						l.set(j , new pair(tp.y,tp.x,tp.c+p.c,tp.dir,tp.c));
						isCheck[i]=true;

						break;
					}
					else {
						//i가 살아남음
						l.set(i , new pair(p.y,p.x,tp.c+p.c,p.dir,p.c));
						p = l.get(i);
						isCheck[j]=true;
					}
				}
			}
		}
		
		//isCheck 제거
		for(int i=isCheck.length-1;i>=0;i--) {
			if(isCheck[i]==true) {
				list.remove(i);
			}
		}
		//baseC = c 통일
		for(int i=0;i<list.size();i++) {
			l.get(i).setC();
		}
	}
	
	//이동 -> 나누기 -> 합치기
	static void logic()throws IOException  {
		st = new StringTokenizer(br.readLine());
		int count=0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		l = new ArrayList<>();
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int y= Integer.parseInt(st.nextToken());
			int x= Integer.parseInt(st.nextToken());
			int c= Integer.parseInt(st.nextToken());
			int dir= Integer.parseInt(st.nextToken());
			l.add(new pair(y,x,c,dir,c));
		}
		

		while(M>count) {
			for(int i=0;i<l.size();i++) {
				pair p =l.get(i);
				int ny = p.y+dy[p.dir];
				int nx = p.x+dx[p.dir];
				l.set(i, new pair(ny,nx,p.c,p.dir,p.c));
			}
			
			//나누기
			divide(l);
			//합치기
			merge(l);
			count++;
//			System.out.println(count);
//			for(pair p : l) {
//				System.out.println(p.y+" "+p.x+" "+p.c+" "+p.baseC+" "+p.dir);
//			}
//			System.out.println();
		}
		
		int result=0;
		for(int i=0;i<l.size();i++) {
			result+=l.get(i).c;
		}
		System.out.println("#"+(num++)+" "+result);
	}


	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		
		int tc = Integer.parseInt(br.readLine());
		for(int i=0;i<tc;i++) {
			logic();
		}
		
	}

}
