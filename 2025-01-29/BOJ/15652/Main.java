import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main
{	
	static int n, m;
	static boolean[] visited;
	static int[] sel;
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
       
        sel = new int [m];
        visited = new boolean [n];
        recursive(1, 0);
        System.out.println(sb);
        
    }

	private static void recursive(int idx, int depth) {
		if(depth == m) {
			for (int i = 0; i < m; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = idx; i <= n; i++) {
			sel[depth] = i; 
			recursive(i, depth + 1);
		}
		
		
		
	}

	
	
    
    
}
