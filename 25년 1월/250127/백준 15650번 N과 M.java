import java.io.*;
import java.util.*;

public class Main {

	static int n = 1;
    static int m;
	static int ans = 0;
    static Scanner sc = new Scanner(System.in);
//	static int[] dx = {-1,1,0,0};
//	static int[] dy = {0,0, 1,-1};
// 
	// static int[][] map = new int[n][n];
	// 햄버거 다이어트
	
	public static void main(String[] args) {
		// System.setIn(Solution.class.getResourceAsStream("text.txt"));
		n = sc.nextInt();
        m = sc.nextInt();
 
        recursive(new boolean [n+1], 1, 0);
	}

	public static void recursive(boolean[] sel, int idx, int cnt) {
        // System.out.println(idx + " " + cnt);
        if(cnt == m){
            for(int i = 0; i < sel.length;i++)
                if(sel[i])
                    System.out.print(i + " ");
            System.out.println();
            return;
        }
        if(idx >= sel.length)
            return;
        
        

        sel[idx] = true;    
        recursive(sel, idx+1, cnt+1);
        sel[idx] = false;    
        recursive(sel, idx +1, cnt);
	}
}
