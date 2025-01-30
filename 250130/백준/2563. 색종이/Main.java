import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 색종이 개수
        int[][] backGround = new int[101][101]; // 전체 도화지

        for (int k = 0 ; k < n ; k++) {
        	String[] input = br.readLine().split(" ");
        	int x = Integer.parseInt(input[0]);
        	int y = Integer.parseInt(input[1]);
        	for (int i = x ; i < x+10 ; i++) {
        		for (int j = y ; j < y+10 ; j++) {
        			backGround[i][j]++;
        		}
        	}
        }
        int countAll = 0;
    	for (int i = 0 ; i < 101 ; i++) {
    		for (int j = 0 ; j < 101 ; j++) {
    			if (backGround[i][j] >= 1) { // 값이 1 이상인 모든 영역 구하기
    				countAll++;
    			}
    		}
    	}
    	System.out.println(countAll);
    }
}
