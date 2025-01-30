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
 * 하지만 가장 왼쪽의 가장 작은 값이 x 축 위에 있을 경우에는 정상동작하지 못한다!
 * 
 * 그냥 y 의 값이 x축의 아래인 경우를 시작점으로.
 */

public class Improve {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Interval {
        int left, right; // 봉우리의 구간 [left, right]
        int parent = -1; // 부모 봉우리 인덱스(없으면 -1)
        int childCount = 0; // 자식 봉우리(포함하고 있는 봉우리) 개수

        Interval(int left, int right) {
            this.left = Math.min(left, right);
            this.right = Math.max(left, right);
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

            int yUnderXAxixIndex = -1;

            for (int i = 0; i < numOfPoint; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                points.add(new Point(x, y));

                if (yUnderXAxixIndex == -1 && y < 0) {
                    yUnderXAxixIndex = i;
                }
            }

            List<Point> rotatedPoints = new ArrayList<>(numOfPoint);
            rotatedPoints.addAll(points.subList(yUnderXAxixIndex, numOfPoint));
            rotatedPoints.addAll(points.subList(0, yUnderXAxixIndex));

            List<Interval> peaks = new ArrayList<>();
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
                    peaks.add(new Interval(startX, endX));
                    inPeak = false;
                }
            }

            Collections.sort(peaks, (a, b) -> {
                if (a.left != b.left) {
                    return Integer.compare(a.left, b.left);
                } else {
                    // left가 같으면 right 큰 순으로
                    return Integer.compare(b.right, a.right);
                }
            });

            Deque<Integer> stack = new ArrayDeque<>();
            // stack에는 봉우리의 인덱스(i)를 저장

            for (int i = 0; i < peaks.size(); i++) {
                int currRight = peaks.get(i).right;

                // 스택 top의 right <= currRight면 pop
                // => 더 이상 현재 봉우리를 포함할 수 없다.
                while (!stack.isEmpty()) {
                    int top = stack.peek();
                    if (peaks.get(top).right <= currRight) {
                        stack.pop();
                    } else {
                        break;
                    }
                }

                // 스택에 남아있는 top이 있다면 => 그것이 현재(i)를 포함
                if (!stack.isEmpty()) {
                    int parentIdx = stack.peek();
                    peaks.get(i).parent = parentIdx;
                    peaks.get(parentIdx).childCount++;
                }

                // 현재 봉우리 push
                stack.push(i);
            }
            int rootCount = 0;
            int leafCount = 0;

            for (int i = 0; i < peaks.size(); i++) {
                if (peaks.get(i).parent == -1) {
                    rootCount++;
                }
                if (peaks.get(i).childCount == 0) {
                    leafCount++;
                }
            }

            System.out.println(rootCount + " " + leafCount);
        }
        sc.close();
    }
}
