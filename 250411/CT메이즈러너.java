import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Array;
import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class CT메이즈러너{
	static int[][] map;
	//출구
	static int ex, ey;
	static int[][] exitMap;
	//참가자
	static List<Person> people = new ArrayList<>();
	static List<Person> outPeople = new ArrayList<>();
	
	//static 변수
	static int n; //미로의 크기
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static class Person{
		int idx;
		int x;
		int y;
		int dist;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		// n 미로의 크기, m 참가자 수, k 게임 시간
		n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		int k = Integer.parseInt(line[2]);
		
		//맵 입력
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			line = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		//참가자 입력
		for(int i = 0; i < m; i++) {
			line = br.readLine().split(" ");
			Person p = new Person();
			p.idx = i;
			p.x = Integer.parseInt(line[0])-1;
			p.y = Integer.parseInt(line[1])-1;
			p.dist = 0;
			people.add(p);
		}
		
		//출구 좌표 입력
		line = br.readLine().split(" ");
		ex = Integer.parseInt(line[0])-1;
		ey = Integer.parseInt(line[1])-1;
		
		exitMap = new int[n][n];
		exitMap[ex][ey] = 1;
		
//		System.out.println("처음");
//		debugPrint();
		
		//--------------------------------
		for(int t = 1; t <= k; t++) {
//			System.out.println(t + "번째");
//			showPeople(people);
			//참가자 이동
			for(Person p : people) {
				movePerson(p);
			}
//			showPeople(people);
			
//			System.out.println("참가자 이동");
//			debugPrint();
			
			//출구에 도달한 사람 있는지 확인
			checkExitPeople();
			
			
			//미로 회전
			int[] racInfo = findSmallRac();
			if(racInfo[0] != -1) {
				rotateRac(racInfo);
			}
			
			
			//만약 people에 아무도 없으면 종료
			if(people.size() == 0) break;
			
//			System.out.println("회전");
//			debugPrint();
//			
//
//			System.out.println("최종 결과");
//			debugPrint();
		}
		
		int sum = 0;
		for(Person p : outPeople) {
			sum += p.dist;
		}
		for(Person p : people) {
			sum += p.dist;
		}
		
		System.out.println(sum);
		System.out.println((ex+1) + " " + (ey+1));

		
		
		
		
	}
	
	static void debugPrint() {
		int[][] newMap = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {					
				newMap[i][j] = map[i][j];
				
				for(Person p : people ) {
					if(p.x == i && p.y == j) {
						newMap[i][j] = 22;
					}
				}
				
				if(i == ex && j == ey) {
					newMap[i][j] = 99;
				}
				
			}
		}
		print2dime(newMap);
	}
	static void checkExitPeople(){
		List<Integer> removeIdx = new ArrayList<>();
		for(int i = 0; i < people.size(); i++) {
			Person p = people.get(i);
			if(p.x == ex && p.y == ey) {
				outPeople.add(p);
				removeIdx.add(i);
			}
		}
		//people 삭제
		for(int i = removeIdx.size() -1; i >= 0; i--) {
			int idx = removeIdx.get(i);
			people.remove(idx);
		}
	}
	
	static void rotateRac(int[] racInfo) {
        int sx = racInfo[0];
        int sy = racInfo[1];
        int size = racInfo[2];

        int[][][] peopleMap = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                peopleMap[i][j] = new int[] { -1, -1 };
            }
        }
        for (Person p : people) {
            peopleMap[p.x][p.y] = new int[] { p.x, p.y };
        }

        int[][] copyMap = new int[size][size];
        int[][] copyExit = new int[size][size];
        int[][][] copyPeopleMap = new int[size][size][2];

        for (int i = sx; i < sx + size; i++) {
            for (int j = sy; j < sy + size; j++) {
                // 내구도 1씩 감소
                if (map[i][j] > 0) {
                    map[i][j]--;
                }
                copyMap[i - sx][j - sy] = map[i][j];
                copyExit[i - sx][j - sy] = exitMap[i][j];
                copyPeopleMap[i - sx][j - sy] = peopleMap[i][j];
            }
        }

        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                map[i + sx][j + sy] = copyMap[size - 1 - j][i];
                exitMap[i + sx][j + sy] = copyExit[size - 1 - j][i];
                peopleMap[i + sx][j + sy] = copyPeopleMap[size - 1 - j][i];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (exitMap[i][j] == 1) {
                    ex = i;
                    ey = j;
                    break;
                }
            }
        }

        // ★ 수정됨: 회전 영역 내 참가자의 좌표를 직접 변환하여 업데이트
        for (Person p : people) {
            if (p.x >= sx && p.x < sx + size && p.y >= sy && p.y < sy + size) {
                // 좌표 변환 공식: (x, y) -> (sx + (y - sy), sy + (size - 1 - (x - sx)))
                int newX = sx + (p.y - sy);
                int newY = sy + (size - 1 - (p.x - sx));
                p.x = newX;
                p.y = newY;
            }
        }
    }
	
	static int[] findSmallRac() {
		//1 명 이상의 참가자 출구를 포함해야 함
		//크기는 2~n
		for(int i = 2; i <= n; i++) {
			
			for(int j = 0; j <= n-i; j++) {
				for(int k = 0; k <= n-i; k++) {
					boolean hasPerson = false;
					boolean hasExit = false;
					
					for(int q = j; q < j+i; q++) {
						for(int p = k; p < k+i; p++) {
							if(q == ex && p == ey) {
								hasExit =true;
							}
							
							for(Person person : people) {
								int px = person.x;
								int py = person.y;
								if(px == q && py == p) {
									hasPerson = true;
									break;
								}
							}
							
							if(hasExit && hasPerson) {
								//sx, sy, size
								return new int[] {j, k, i};
							}
							
						}
					}
					
				}
			}
			
		}
		return new int[] {-1,-1,-1};
	}
	
	static void movePerson(Person person) {
		int cx = person.x;
		int cy = person.y;
		
		int cDiff = Math.abs(cx - ex) + Math.abs(cy - ey);
		List<int[]> vaildPos = new ArrayList<>();
		//상하좌우로 이동
		for(int i = 0; i < 4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];
			if(checkBound(nx, ny)) {
				//벽이 없어야 한다. 출구까지 최단 거리가 가까워야 한다.
				boolean isWall = checkWall(nx, ny);
				int nDiff = Math.abs(nx - ex) + Math.abs(ny - ey);
				if(!isWall && nDiff < cDiff) {
					vaildPos.add(new int[] {nx,ny});
				}
			}
		}
		
//		System.out.print(vaildPos.size() + " ");
		
		
		//이동
		 if(vaildPos.size() >= 1) {
			for(int i = 0; i < vaildPos.size(); i++) {
				changePersonPos(vaildPos.get(i)[0], vaildPos.get(i)[1], person);
				break;
			}
		}
		
	}
	
	static void changePersonPos(int x, int y, Person person) {
		person.x = x;
		person.y = y;
		person.dist++;
	}
	
	static boolean checkWall(int x, int y) {
		if(map[x][y] > 0) {
			return true;
		}
		return false;
	}
	
	static boolean checkBound(int x, int y) {
		if(x >= 0 && x < n && y >= 0 && y< n) {
			return true;
		}
		return false;
	}
	
	static void print2dime(int[][] map) {
		for(int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}
	static void showPeople(List<Person> people) {
		int[][] newMap = new int[n][n];
		for(Person p : people) {
			newMap[p.x][p.y] = 1;
		}
		
		print2dime(newMap);
	}
}
	
