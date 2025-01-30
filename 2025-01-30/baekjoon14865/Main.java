package solving.baekjoon14865;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

/*
 * 입력받고 x축 교차(y=0) 를 확인해 봉우리들의 start와 end 를 저장
 * 저장한 봉우리들의 포함 관계를 계산
 * 일단 실패 ㅠㅠ
 * 
 * 처음 입력 들어오는 지점이 어디일지 알 수 없다.
 * 다만 시계방향으로 주어지는 것은 문제 조건에 있다.
 * 
 * 입력지점을 알 수 없다면. 가장 좌측에서 가장 아랫 값을 알 수 있을 때 까지 큐를 순환?
 * 
 * 큐를 순환하기 위해 가장 좌측 가장 아랫값을 찾아서 조건 비교를 하지 말고
 * 인덱스를 저장해서 해당 인덱스만큼 반복?
 * 
 * 인덱스만큼 반복하지 말고 인덱스만큼 뚝 잘라서 뒤에 가져다 붙이기?
 */

public class Main {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Peak implements Comparable<Peak> {
        int startX, endX;

        public Peak(int startX, int endX) {
            this.startX = startX;
            this.endX = endX;
        }

        // Comparable<Peak> 인터페이스를 사용하여 Peak끼리 비교가능하게
        @Override
        public int compareTo(Peak other) {
            return Integer.compare(this.startX, other.startX);
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            // 좌표는 최대 +- 10억이므로 int 도 OK?
            int numOfPoint = sc.nextInt();
            // Deque<Point> points = new ArrayDeque<>();
            List<Point> points = new ArrayList<>();

            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;
            int minIndex = 0;

            for (int i = 0; i < numOfPoint; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                points.add(new Point(x, y));

                if (x < minX || (x == minX && y < minY)) {
                    minX = x;
                    minY = y;
                    minIndex = i;
                }
            }

            List<Point> rotatedPoints = new ArrayList<>(numOfPoint);
            rotatedPoints.addAll(points.subList(minIndex, numOfPoint));
            rotatedPoints.addAll(points.subList(0, minIndex));

            List<Peak> peaks = new ArrayList<>();
            int startX = 0, endX = 0;
            boolean inPeak = false;

            for (int i = 0; i < numOfPoint; i++) {
                Point current = rotatedPoints.get(i);
                Point next = rotatedPoints.get((i + 1) % numOfPoint);

                if (current.y < 0 && next.y > 0) {
                    startX = next.x;
                    inPeak = true;
                } else if (current.y > 0 && next.y < 0 && inPeak) {
                    endX = next.x;
                    // 항상 작은 값을 startX로, 큰 값을 endX로
                    peaks.add(new Peak(Math.min(startX, endX), Math.max(startX, endX)));
                    inPeak = false;
                }
            }

            Collections.sort(peaks);

            int notContainedCount = 0;
            int notContainingCount = 0;

            Deque<Integer> stack = new ArrayDeque<>();
            for (Peak peak : peaks) {
                while (!stack.isEmpty() && stack.peek() < peak.endX) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    notContainedCount++;
                }
                stack.push(peak.endX);
            }

            int beforeEndX = Integer.MAX_VALUE; // 가장 왼쪽 봉우리의 endX 값을 추적

            for (int i = peaks.size() - 1; i >= 0; i--) { // 뒤에서 앞으로 순회
                Peak peak = peaks.get(i);
                if (peak.endX < beforeEndX) {
                    notContainingCount++;
                    beforeEndX = peak.endX;
                } else {
                    beforeEndX = peak.endX;
                }
            }

            System.out.println(notContainedCount + " " + notContainingCount);
        }
        sc.close();
    }
}
