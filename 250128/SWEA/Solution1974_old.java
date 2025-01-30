import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution1974_old {

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<=T; ++t) {
            map = new int[9][9];
            Map<Integer, Set<Integer>> possibleMap = new HashMap<Integer, Set<Integer>>() {{
                put(0, new HashSet<>());
                put(1, new HashSet<>());
                put(2, new HashSet<>());
                put(3, new HashSet<>());
                put(4, new HashSet<>());
                put(5, new HashSet<>());
                put(6, new HashSet<>());
                put(7, new HashSet<>());
                put(8, new HashSet<>());
            }};

            boolean isPossible = true;

            for (int i=0; i<9; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                Set<Integer> possibleSet = new HashSet<>();
                for (int j=0; j<9; ++j) {
                    int num = Integer.parseInt(st.nextToken());
                    map[i][j] = num;
                    possibleMap.get(j).add(num);
                    possibleSet.add(num);
                }
                if (possibleSet.size() != 9) {
                    isPossible = false;
                }
            }

            for (int i : possibleMap.keySet()) {
                if (possibleMap.get(i).size() != 9) {
                    isPossible = false;
                }
            }

            System.out.print("#" + t + " ");

            if (!isPossible) {
                System.out.println(0);
                continue;
            }

            int idxR = 0;
            int idxC = 0;

            while (idxR < 9) {
                isPossible = solve(idxR, idxC);
                if (!isPossible) {
                    break;
                }
                idxC += 3;

                if (idxC == 9) {
                    idxR += 3;
                    idxC = 0;
                }
            }

            if (!isPossible) {
                System.out.println(0);
            }
            else {
                System.out.println(1);
            }




        }
    }

    public static boolean solve(int r, int c) {
        Set<Integer> possibleSet = new HashSet<>();

        for (int i=r; i<r+3; ++i) {
            for (int j=c; j<c+3; ++j) {
                possibleSet.add(map[i][j]);
            }
        }

        return possibleSet.size() == 9;
    }

}