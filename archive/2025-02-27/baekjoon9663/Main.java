package solving.baekjoon9663;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int LIMIT;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().trim());
        LIMIT = 1 << N;
        int[] chessBoard = new int[N]; // 행은 비트마스킹 해볼까~ 그러면 같은 열 확인도 쉽고?

        int nQueenCount = nQueen(0, chessBoard);
        bw.write(nQueenCount + "\n");
        bw.flush();
    }

    private static int nQueen(int idx, int[] chessBoard) {
        if (idx == chessBoard.length) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < chessBoard.length; i++) {
            int thisRowQueen = 1 << i;
            if (!checkRow(idx, chessBoard, thisRowQueen)) {
                continue;
            }
            if (!checkDiagonal(idx, chessBoard, thisRowQueen)) {
                continue;
            }
            chessBoard[idx] = thisRowQueen;
            count += nQueen(idx + 1, chessBoard);
        }
        return count;
    }

    private static boolean checkDiagonal(int idx, int[] chessBoard, int thisRowQueen) {
        int leftDigonal = thisRowQueen, rightDigonal = thisRowQueen;
        for (int i = idx - 1; i >= 0; i--) {
            leftDigonal = leftDigonal >> 1;
            rightDigonal = rightDigonal << 1;
            if (leftDigonal > 0) {
                if (chessBoard[i] == leftDigonal) {
                    return false;
                }
            }
            if (rightDigonal < LIMIT) {
                if (chessBoard[i] == rightDigonal) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkRow(int idx, int[] chessBoard, int thisRowQueen) {
        for (int j = 0; j < idx; j++) {
            if (thisRowQueen == chessBoard[j]) {
                return false;
            }
        }
        return true;
    }
}
