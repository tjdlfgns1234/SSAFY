import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CT테트리스_블럭_안의_합_최대화_하기 {
	//-
	static int[] ee1x = {0,0,0,0};
	static int[] ee1y = {0,1,2,3};
	//l
	static int[] ee2x = {0,1,2,3};
	static int[] ee2y = {0,0,0,0};
	//|--
	static int[] nien1x = {0,1,2,2};
	static int[] nien1y = {0,0,0,1};
	//L
	static int[] nien2x = {0,0,0,-1};
	static int[] nien2y = {0,1,2,2};
	//--|
	static int[] nien3x = {0,0,1,2};
	static int[] nien3y = {0,1,1,1};
	//ㄱ
	static int[] nien4x = {0,1,0,0};
	static int[] nien4y = {0,0,1,2};
    //|--
	static int[] nien5x = {0,1,2,2};
	static int[] nien5y = {0,0,0,-1};
	//L
	static int[] nien6x = {0,0,0,1};
	static int[] nien6y = {0,1,2,2};
	//--|
	static int[] nien7x = {0,0,1,2};
	static int[] nien7y = {0,-1,-1,-1};
	//ㄱ
	static int[] nien8x = {0,-1,0,0};
	static int[] nien8y = {0,0,1,2};
	//ㅁ
	static int[] miumx = {0,0,1,1};
	static int[] miumy = {0,1,0,1};
	//ㄱㄴ
	static int[] riel1x = {0,1,1,2};
	static int[] riel1y = {0,0,1,1};
	//ㄱㄴ
	static int[] riel2x = {0,0,-1,-1};
	static int[] riel2y = {0,1,1,2};
    //ㄱㄴ 
    static int[] riel3x = {0,0,1,1};
	static int[] riel3y = {0,1,1,2};
    //ㄱㄴ 
    static int[] riel4x = {0,1,1,2};
	static int[] riel4y = {0,0,-1,-1};
	//ㅗ
	static int[] oh1x = {0,1,1,1};
	static int[] oh1y = {0,-1,0,1};
	//ㅏ
	static int[] oh2x = {0,1,1,2};
	static int[] oh2y = {0,0,1,0};
	//ㅜ
	static int[] oh3x = {0,0,0,1};
	static int[] oh3y = {0,1,2,1};
	//ㅓ
	static int[] oh4x = {0,-1,0,1};
	static int[] oh4y = {0,1,1,1};
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		
		int[][] map = new int[n][m];
		for(int i = 0; i < n; i++) {
			line = br.readLine().split(" ");
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		List<int[][]> blocks = new ArrayList<>();
		blocks.add(new int[][] {ee1x, ee1y});
		blocks.add(new int[][] {ee2x, ee2y});
		blocks.add(new int[][] {nien1x, nien1y});
		blocks.add(new int[][] {nien2x, nien2y});
		blocks.add(new int[][] {nien3x, nien3y});
		blocks.add(new int[][] {nien4x, nien4y});
		blocks.add(new int[][] {nien5x, nien5y});
		blocks.add(new int[][] {nien6x, nien6y});
		blocks.add(new int[][] {nien7x, nien7y});
		blocks.add(new int[][] {nien8x, nien8y});
		blocks.add(new int[][] {miumx, miumy});
		blocks.add(new int[][] {riel1x, riel1y});
		blocks.add(new int[][] {riel2x, riel2y});
        blocks.add(new int[][] {riel3x, riel3y});
		blocks.add(new int[][] {riel4x, riel4y});
		blocks.add(new int[][] {oh1x, oh1y});
		blocks.add(new int[][] {oh2x, oh2y});
		blocks.add(new int[][] {oh3x, oh3y});
		blocks.add(new int[][] {oh4x, oh4y});
		
		int result = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				int cx = i;
				int cy = j;

				for(int[][] block : blocks) {
					int[] dx = block[0];
					int[] dy = block[1];
					
					boolean check = true;
					int sum = 0;
					for(int k = 0; k < dx.length; k++) {
						int nx = cx + dx[k];
						int ny = cy + dy[k];
						if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
							sum+= map[nx][ny];
						}else {
							check = false;
							break;
						}
					}
					
					if(check) {
						result = Math.max(result, sum);
					}
				}
			}
		}
		
		System.out.println(result);
	} 
}
