import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main
{	
	static int n, m;
	static boolean[] visited;
	static int[] sel;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
        Arrays.sort(arr);
        sel = new int [m];
        visited = new boolean [n];
        recursive(0, 0);
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
		
		if(idx == n) return;
		
		sel[depth] = arr[idx];
		recursive(idx + 1, depth + 1);
		recursive(idx + 1, depth);
		
		
		
		
	}

	
	
    
    
}
