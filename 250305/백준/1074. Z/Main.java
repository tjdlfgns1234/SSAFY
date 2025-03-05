import java.io.*;

public class Z {
    static int row, col;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        row = Integer.parseInt(input[1]);
        col = Integer.parseInt(input[2]);

        int N2 = (int) Math.pow(2, N); // 2^N
        recursive(0, 0, N2);
    }

    private static void recursive(int startRow, int startCol, int size) {
        if (size == 1) { // 1x1 크기에서 찾으면 종료
            System.out.println(count);
            return;
        }

        int newSize = size / 2;
        int area = newSize * newSize; // 한 영역의 개수

        if (row < startRow + newSize && col < startCol + newSize) { // 왼쪽 위
            recursive(startRow, startCol, newSize);
        }
        else if (row < startRow + newSize && col >= startCol + newSize) { // 오른쪽 위
            count += area; // 지나온 거리
            recursive(startRow, startCol + newSize, newSize);
        }
        else if (row >= startRow + newSize && col < startCol + newSize) {
            count += 2 * area;
            recursive(startRow + newSize, startCol, newSize);
        }
        else {
            count += 3 * area;
            recursive(startRow + newSize, startCol + newSize, newSize);
        }
    }
}
