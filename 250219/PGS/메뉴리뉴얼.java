import java.util.*;

public class 메뉴리뉴얼 {

    Map<String, Integer> map;
    int[] maxCount;

    public String[] solution(String[] orders, int[] course) {
        String[] answer;

        map = new HashMap<>();
        maxCount = new int[course[course.length-1]+1];

        for (String order: orders) {
            for (int i : course) {
                recursive(order, i, new StringBuilder(), 0);
            }
        }

        List<String> list = new ArrayList<>();

        for (String s : map.keySet()) { // key가 곧 길이
            int count = map.get(s);
            if (count == maxCount[s.length()] && count > 1) {
                list.add(s);
            }
        }

        Collections.sort(list);

        answer = list.toArray(new String[0]);

        return answer;
    }

    public void recursive(String order, int targetC, StringBuilder sb, int idx) {
        if (sb.length() == targetC) {
            char[] arr = sb.toString().toCharArray();
            Arrays.sort(arr);
            String s = String.valueOf(arr);
            if (map.containsKey(s)) {
                int count = map.get(s);
                map.put(s, count+1);
                if (maxCount[s.length()] < count+1) {
                    maxCount[s.length()] = count+1;
                }
            }
            else {
                map.put(s, 1);
            }
            return;
        }

        if (idx == order.length()) {
            return;
        }

        sb.append(order.charAt(idx));
        recursive(order, targetC, sb, idx+1);
        sb.deleteCharAt(sb.length()-1);
        recursive(order, targetC, sb, idx+1);

    }
}
