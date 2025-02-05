package solving.baekjoon16562;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 친구비
 * 입력받은 친구 관계에 따라 그룹핑 하고, 그 그룹 내에서 가장 저렴한 친구관계를 맺는다.
 * 친구 방문배열을 만들고, 그에 따라서 처리
 * Set의 List 사용?
 */
public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            String[] line = br.readLine().trim().split(" ");

            int numStudents = Integer.parseInt(line[0]);
            int numRelation = Integer.parseInt(line[1]);
            int budget = Integer.parseInt(line[2]);

            // 친구비 배열 저장
            int[] friendFee = new int[numStudents];
            line = br.readLine().trim().split(" ");
            for (int i = 0; i < line.length; i++) {
                friendFee[i] = Integer.parseInt(line[i]);
            }

            // 해당 친구가 다른 친구와 연결 돼 있는지 확인하는 방문배열
            boolean[] visit = new boolean[numStudents];

            // 친구의 연결을 저장할 Set의 List
            List<Set<Integer>> group = new ArrayList<>();
            for (int i = 0; i < numRelation; i++) {

                line = br.readLine().trim().split(" ");
                int left = Integer.parseInt(line[0]) - 1;
                int right = Integer.parseInt(line[1]) - 1;

                // 방문처리
                visit[left] = true;
                visit[right] = true;

                // 합칠 셋의 인덱스를 저장할 리스트
                List<Integer> mergeList = new ArrayList<>();

                // 그룹을 순회하며 친구연결 추가
                for (int j = 0; j < group.size(); j++) {
                    Set<Integer> nowSet = group.get(j);
                    // set 내부에 있으면 add
                    if (nowSet.contains(left) || nowSet.contains(right)) {
                        nowSet.add(left);
                        nowSet.add(right);
                        mergeList.add(j);
                    }
                }

                if (mergeList.size() == 0) {
                    // 아무데도 안들어 갔으면 뉴셋 그룹에 추가
                    Set<Integer> newSet = new HashSet<>(Arrays.asList(left, right));
                    group.add(newSet);
                } else if (mergeList.size() >= 2) {
                    // 두개 이상의 셋에 들어간 경우에는 교집합!! 병합해준다
                    Set<Integer> newSet = new HashSet<>();

                    // 뒤에서부터 삭제? (out of bound 여기가 문제일지도)
                    for (int j = mergeList.size() - 1; j >= 0; j--) {
                        int index = mergeList.get(j);
                        newSet.addAll(group.get(index));
                        group.remove(index);
                    }
                    // 병합 후 추가!
                    group.add(newSet);
                }
            }

            // 아무 연결 없는 경우 그냥 셋 리스트에 넣는다 (무조건 친구비 납부)
            for (int i = 0; i < visit.length; i++) {
                if (!visit[i]) {
                    Set<Integer> newSet = new HashSet<>();
                    newSet.add(i);
                    group.add(newSet);
                }
            }

            int sumFriendFeeToPay = 0;
            boolean impossible = false;

            // 리스트 순회하며 셋 내부에 최저 친구비 찾아 더하기
            wallet: for (int i = 0; i < group.size(); i++) {
                Set<Integer> nowSet = group.get(i);
                int minFriendFee = Integer.MAX_VALUE;
                for (Integer integer : nowSet) {
                    minFriendFee = Math.min(minFriendFee, friendFee[integer]);
                }
                sumFriendFeeToPay += minFriendFee;
                if (sumFriendFeeToPay > budget) {
                    System.out.println("Oh no");
                    impossible = true;
                    break wallet;
                }
            }
            if (!impossible) {
                System.out.println(sumFriendFeeToPay);
            }
        }
    }
}
