import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 색종이 개수
        int[][] backGround = new int[102][102]; // 전체 도화지 (살짝 넓게)

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
    		for (int j = 0 ; j < 101 ; j++) { 	// 아래는 4면 중 하나라도 0에 닿으면 count++
    			if (backGround[i][j] >= 1) { 	// else if가 아닌 이유는 0이 2개 닿으면 그 면은 2번 계산해야 하기 때문.
    				if (backGround[i+1][j] == 0) {
    					countAll++;
    				} 
    				if (backGround[i-1][j] == 0) {
    					countAll++;
    				} 
    				if (backGround[i][j+1] == 0) {
    					countAll++;
    				} 
    				if (backGround[i][j-1] == 0) {
    					countAll++;
    				}
    			}
    		}
    	}
    	System.out.println(countAll);

    }
}
