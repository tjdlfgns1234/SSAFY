
import java.util.Scanner;


public class BOJ_퀴드트리 {
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            String line = sc.next();
            for(int j = 0; j < line.length(); j++){
                map[i][j] = (int) line.charAt(j) - 48;
            }
        }

        System.out.println(divide(0, 0, n));

    }
    
    static String divide(int x, int y, int size){
        int firstElem = map[x][y];
        boolean check = true;
        for(int i = x; i < x+ size; i++){
            for(int j = y; j < y+size; j++){
                if(map[i][j] != firstElem){
                    check = false;
                    break ;
                }
            }
            if (!check) break;
        }

        if(check) return String.valueOf(firstElem);
        else{
            int half = size/2;
            String topLeft = divide(x, y, half);
            String topRight = divide(x, y+half, half);
            String bottomLeft = divide(x+half, y, half);
            String bottomRight = divide(x+half, y+half, half);
            return "(" + topLeft + topRight + bottomLeft + bottomRight + ")";
        }
        
    }
}
