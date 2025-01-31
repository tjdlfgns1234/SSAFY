import java.io.*;
import java.util.*;

public class Solution {
	static int[] currentCoord = new int[2]; // 전차의 좌표
	static String currentDirection; 		// 전차의 방향
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스
        for (int k = 0 ; k < t ; k++) {
        	String[] input = br.readLine().split(" ");
        	int height = Integer.parseInt(input[0]); 	// 높이
        	int width = Integer.parseInt(input[1]);		// 너비
        	String[][] map = new String[height][width];	// 맵
        	for (int i = 0 ; i < height ; i++) {
        		String[] input2 = br.readLine().split("");
        		for (int j = 0 ; j < width ; j++) {
        			map[i][j] = input2[j];
        			// 시작 좌표 담기
        			if (map[i][j].equals("<") || map[i][j].equals(">") || map[i][j].equals("^") || map[i][j].equals("v")) {
        				currentCoord[0] = i;
        				currentCoord[1] = j;
        			}
        		}
        	}
        	int n = Integer.parseInt(br.readLine()); 	// 제공되는 커맨드 길이
        	String[] command = br.readLine().split("");	// 커맨드 배열
        	// 여기까지 입력부
        	currentDirection = map[currentCoord[0]][currentCoord[1]]; // 전차의 방향 업데이트
        	for (int i = 0 ; i < n ; i++) {
        		String currentCommand = command[i];
        		if (currentCommand.equals("S")) {
        			map = shoot(map, currentCoord, currentDirection, height);
        		} else if (currentCommand.equals("U")) {
        			map = moveUp(map, currentCoord);
        		} else if (currentCommand.equals("D")) {
        			map = moveDown(map, currentCoord, height);
        		} else if (currentCommand.equals("L")) {
        			map = moveLeft(map, currentCoord, height);
        		} else if (currentCommand.equals("R")) {
        			map = moveRight(map, currentCoord, height);
        		} else {
        			System.out.println("커맨드 오류");
        		}
        	}

        	bw.write("#" + (k+1) + " ");
        	for (int i = 0 ; i < height ; i++) {
        		for (int j = 0 ; j < width ; j++) {
        			bw.write(map[i][j]);
        		}
        		bw.write("\n");
        	}
        	bw.flush();
        }
        bw.flush();
    	br.close();
    	bw.close();
    }
    
	private static String[][] shoot(String[][] map, int[] currentCoord2, String currentDirection2, int height) {
		int x = currentCoord2[0];
		int y = currentCoord2[1];
		if (currentDirection2.equals("<")) {
			for (int i = y ; i >= 0 ; i--) {
				if (map[x][i].equals("*")) { // 벽돌은 부숨
					map[x][i] = ".";
					break;
				} else if (map[x][i].equals("#")) { // 강철은 못 뚫음
					break;
				} else {
					continue;
				}
			}
		} else if (currentDirection2.equals(">")) {
			for (int i = y ; i < map[x].length ; i++) {
				if (map[x][i].equals("*")) {
					map[x][i] = ".";
					break;
				} else if (map[x][i].equals("#")) {
					break;
				} else {
					continue;
				}
			}
		} else if (currentDirection2.equals("^")) {
			for (int i = x ; i >= 0 ; i--) {
				if (map[i][y].equals("*")) {
					map[i][y] = ".";
					break;
				} else if (map[i][y].equals("#")) {
					break;
				} else {
					continue;
				}
			}
		} else if (currentDirection2.equals("v")) {
			for (int i = x ; i < height ; i++) {
				if (map[i][y].equals("*")) {
					map[i][y] = ".";
					break;
				} else if (map[i][y].equals("#")) {
					break;
				} else {
					continue;
				}
			}
		}
		return map;
	}
	private static String[][] moveUp(String[][] map, int[] currentCoord2) {
		int x = currentCoord2[0];
		int y = currentCoord2[1];
		map[x][y] = "^";
		currentDirection = "^";
		if (x-1 >= 0 && map[x-1][y].equals(".")) {
			map[x-1][y] = "^";
			currentCoord[0] = x-1;
			map[x][y] = ".";
		}
		return map;
	}
	private static String[][] moveDown(String[][] map, int[] currentCoord2, int height) {
		int x = currentCoord2[0];
		int y = currentCoord2[1];
		map[x][y] = "v";
		currentDirection = "v";
		if (x+1 < height && map[x+1][y].equals(".")) {
			map[x+1][y] = "v";
			currentCoord[0] = x+1;
			map[x][y] = ".";
		}
		return map;
	}
	private static String[][] moveLeft(String[][] map, int[] currentCoord2, int height) {
		int x = currentCoord2[0];
		int y = currentCoord2[1];
		map[x][y] = "<";
		currentDirection = "<";
		if (y-1 >= 0 && map[x][y-1].equals(".")) {
			map[x][y-1] = "<";
			currentCoord[1] = y-1;
			map[x][y] = ".";
		}
		return map;
	}
	private static String[][] moveRight(String[][] map, int[] currentCoord2, int height) {
		int x = currentCoord2[0];
		int y = currentCoord2[1];
		map[x][y] = ">";
		currentDirection = ">";
		if (y+1 < map[x].length && map[x][y+1].equals(".")) {
			map[x][y+1] = ">";
			currentCoord[1] = y+1;
			map[x][y] = ".";
		}
		return map;
	}
}
