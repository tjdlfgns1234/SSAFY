//import java.util.*;
//import java.io.*;
//
//public class Swea_2382_미생물격리 {
//    static int[][] map;
//    static int N,M;
//    static class Misang implements Comparable<Misang>{
//        int idx;
//        int r;
//        int c;
//        int cnt;
//        int dir;
//
//        public Misang(int idx, int r, int c, int cnt, int dir) {
//            this.idx = idx;
//            this.r = r;
//            this.c = c;
//            this.cnt = cnt;
//            this.dir = dir;
//        }
//
//        @Override
//        public int compareTo(Misang m) {
//            return Integer.compare(m.cnt, this.cnt);
//        }
//    }
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//        for (int t = 1; t <= T; t++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            N = Integer.parseInt(st.nextToken()); //가로 세로
//            M = Integer.parseInt(st.nextToken()); //M시간
//            int K = Integer.parseInt(st.nextToken()); //미생물 군집 개수
//
//            map = new int[N][N];
//            PriorityQueue<Misang> pq = new PriorityQueue<>();
//            int[] dr = {0,-1,1,0,0};
//            int[] dc = {0,0,0,-1,1};
//            HashMap<Integer, Integer> directions = new HashMap<>();
//            directions.put(1,2);
//            directions.put(2,1);
//            directions.put(3,4);
//            directions.put(4,3);
//
//            for (int i = 1; i <= K; i++) {
//                st = new StringTokenizer(br.readLine());
//                int r = Integer.parseInt(st.nextToken());
//                int c = Integer.parseInt(st.nextToken());
//                int cnt = Integer.parseInt(st.nextToken());
//                int dir = Integer.parseInt(st.nextToken());
//                map[r][c] = i;
//                pq.add(new Misang(i,r,c,cnt,dir));
//            }
//
//            //M시간동안 반복
//            for (int i = 0; i < M; i++) {
//                int copy[][] = new int[N][N];
//                PriorityQueue<Misang> temp = new PriorityQueue<>();
//                while (!pq.isEmpty()) {
//                    Misang curr = pq.poll();
//                    map[curr.r][curr.c] = 0; //이동
//                    curr.r += dr[curr.dir];
//                    curr.c += dc[curr.dir];
//                    //가장 자리 확인
//                    if (isEdge(curr.r,curr.c)) {
//                        curr.cnt = curr.cnt / 2;
//                        if (curr.cnt == 0) {
//                            //사라짐
//                            continue;
//                        }
//                        //방향 반대
//                        curr.dir = directions.get(curr.dir);
//                    }
//                    //겹치는지 확인
//                    if (copy[curr.r][curr.c] > 0) {
//                        for (Misang m : temp) {
//                            if (m.idx == copy[curr.r][curr.c]) {
//                                m.cnt += curr.cnt;
//                                break;
//                            }
//                        }
//                        continue;
//                    }
//                    copy[curr.r][curr.c] = curr.idx;
//                    temp.add(curr);
//                }
//                pq = temp;
//                map = copy;
//            }
//
//            int ans = 0;
//            for (Misang m : pq) {
//                ans += m.cnt;
//            }
//            System.out.printf("#%d %d\n", t,ans);
//        }
//    }
//
//    static boolean isEdge(int r, int c) {
//        return r == 0 || r == N -1 || c == 0 || c == N -1;
//    }
//}
import java.util.*;
import java.io.*;

public class Swea_2382_미생물격리 {
    static int N, M;
    static int[] dr = {0, -1, 1, 0, 0}; // 방향
    static int[] dc = {0, 0, 0, -1, 1};
    static HashMap<Integer, Integer> reverseDir = new HashMap<>();

    static class Misang {
        int r, c, cnt, dir;

        public Misang(int r, int c, int cnt, int dir) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        reverseDir.put(1,2);
        reverseDir.put(2,1);
        reverseDir.put(3,4);
        reverseDir.put(4,3);

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 격자 크기
            M = Integer.parseInt(st.nextToken()); // 격리 시간
            int K = Integer.parseInt(st.nextToken()); // 미생물 군집 개수

            List<Misang> misangList = new ArrayList<>();

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                misangList.add(new Misang(r, c, cnt, dir));
            }

            // M시간 동안 이동
            for (int time = 0; time < M; time++) {
                Map<String, List<Misang>> map = new HashMap<>(); //위치별로 미생물 저장

                // 1. 미생물 이동
                for (Misang m : misangList) {
                    m.r += dr[m.dir];
                    m.c += dc[m.dir];

                    // 가장자리라면
                    if (isEdge(m.r, m.c)) {
                        m.cnt /= 2; // 절반으로 감소
                        if (m.cnt == 0) continue; // 사라지면 추가 안 함
                        m.dir = reverseDir.get(m.dir); // 방향 반대
                    }

                    String key = m.r + "," + m.c;  //위치
                    map.putIfAbsent(key, new ArrayList<>());
                    map.get(key).add(m);
                }

                // 2. 같은 위치의 미생물 합치기
                misangList.clear();
                for (List<Misang> group : map.values()) {
                    if (group.size() == 1) {
                        misangList.add(group.get(0));
                        continue;
                    }

                    group.sort((a, b) -> b.cnt - a.cnt); // 내림차순 정렬 (큰 군집이 대표)
                    Misang largest = group.get(0);

                    for (int i = 1; i < group.size(); i++) {
                        largest.cnt += group.get(i).cnt; // 군집 합치기
                    }

                    misangList.add(largest);
                }
            }

            // 최종 남아있는 미생물 수 계산
            int ans = 0;
            for (Misang m : misangList) {
                ans += m.cnt;
            }
            System.out.printf("#%d %d\n", t, ans);
        }
    }

    static boolean isEdge(int r, int c) {
        return r == 0 || r == N - 1 || c == 0 || c == N - 1;
    }
}
