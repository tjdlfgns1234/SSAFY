import java.util.*;
import java.io.*;

public class Main {

    static int [] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            parent[i] = i;
        }
        int ord, a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            ord = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            switch(ord) {
                case 0:
                    union(a, b);
                    break;
                case 1:
                    System.out.println(isSame(a, b) ? "YES" : "NO");
                    break;
            }
        }

    }
    static int find(int x){
        if(x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y){
            if(x < y){
                parent[y] = x;
            }
            else{
                parent[x] = y;
            }
        }
    }

    static boolean isSame(int x, int y){
        x = find(x);
        y = find(y);

        if (x == y) return true;

        return false;
    }

}
