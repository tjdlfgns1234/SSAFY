import java.util.*;
import java.io.*;
public class Boj_11000_강의실배정 {
    static class Lecture implements Comparable<Lecture> {
        int start;
        int end;
        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture l) {
            return Integer.compare(this.end, l.end);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] info = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        //빨리 시작하는 순으로 정렬
        Arrays.sort(info, Comparator.comparingInt(i -> i[0]));
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(info[i]));
//        }

        PriorityQueue<Lecture> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            if (!pq.isEmpty() && pq.peek().end <= info[i][0]) {
                //강의 끝나는 시간 이후에 시작하는데 가장 빨리 끝나는 강의
                pq.poll();  //이전 강의 빼고
            }
            pq.add(new Lecture(info[i][0], info[i][1]));  //새 강의 넣기
        }
        //빨리 끝나는 강의 우선 배치
        //현재 강의실에서 배치할 수 있는거 일단 다 넣고
        //남은 강의 -> 새로운 강의실 써야되는 경우
        System.out.println(pq.size());
    }
}
