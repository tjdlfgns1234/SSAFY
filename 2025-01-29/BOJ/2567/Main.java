import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main
{	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
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
        
        
        int nx, ny;
        int result = 0;
        for(int i = 0; i < 101; i++) {
        	for (int j = 0; j < 101; j++ ) {
        		if(board[i][j] == 1) {
        			for(int d = 0; d < 4; d++) {
            			 nx = i + dx[d];
            			 ny = j + dy[d];
            			 // 도화지의 경계선 또는 색종이의 경계선일 경우
            			 // 모서리의 경우 둘레 + 2 해줘야 해서 break 하면 안된다
            			 
            			 if(nx <= 0 || nx > 100 || ny <= 0 || ny > 100 || board[nx][ny]  == 0) {
            				 result += 1;
            			 }
            		}
        		}
        		
        	}
        }
        System.out.println(result);
        
    }
}
