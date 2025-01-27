import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main
{	
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[101][101];
        
        for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	for(int j = x; j < x + 10; j++) {
        		for (int k = y; k < y + 10; k++) {
        			board[j][k] = 1;
        		}
        	}
		}
        
        int result = 0;
        for(int i = 1; i < 101; i++) {
        	for (int j = 1; j < 101; j++ ) {
        		if (board[i][j] == 1) result += 1;
        	}
        }
        System.out.println(result);
        
    }
}
