import java.io.*;
import java.util.*;

public class Main {
    static int result = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] map = new String[5][5];
        
        for (int i = 0 ; i < 5 ; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0 ; j < 5 ; j++) {
                map[i][j] = input[j];
            }
        }
        ArrayList<int[]> selected = new ArrayList<>();
        select(map, selected, 0, 0, 0);
        
        System.out.println(result);
    }

    private static void select(String[][] map, ArrayList<int[]> selected, int row, int col, int sCount) {
        if (selected.size() == 7) {
            if (sCount >= 4 && isConnected(selected)) {
                result++;
            }
            return;
        }

        if (row >= 5) {
            return;
        }

        int nextRow = row;
        int nextCol = col + 1;

        if (nextCol == 5) {  // 다음 행
            nextRow = row + 1;
            nextCol = 0;
        }


        selected.add(new int[] {row, col});
        if (map[row][col].equals("S")) {
            select(map, selected, nextRow, nextCol, sCount + 1);
        } else {
            select(map, selected, nextRow, nextCol, sCount);
        }
        selected.remove(selected.size() - 1);
        select(map, selected, nextRow, nextCol, sCount);
    }

    private static boolean isConnected(ArrayList<int[]> selected) {
        final int[] dx = {1, -1, 0, 0};
        final int[] dy = {0, 0, 1, -1};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];

        queue.offer(selected.get(0));
        visited[selected.get(0)[0]][selected.get(0)[1]] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0], y = node[1];

            for (int i = 0 ; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !visited[nx][ny]) {
                    for (int j = 0 ; j < selected.size() ; j++) {
                        int[] coord = selected.get(j);
                        if (coord[0] == nx && coord[1] == ny) {
                            visited[nx][ny] = true;
                            queue.offer(new int[] {nx, ny});
                            count++;
                        }
                    }
                }
            }
        }

        return count == 7; // true
    }
}
