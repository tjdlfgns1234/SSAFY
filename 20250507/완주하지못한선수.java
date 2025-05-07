import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<Integer, Integer> map = new HashMap<>();
        for(String s:completion) {
            int res=0;
            for(int i=0; i<s.length(); i++) {
                res += (s.charAt(i)-'A')*((int) Math.pow(10, i));
            }
            if(map.containsKey(res)) {
                map.replace(res, map.get(res)+1);
            } else {
                map.put(res, 1);
            }
        }
        
        for(String s:participant) {
            int res=0;
            for(int i=0; i<s.length(); i++) {
                res += (s.charAt(i)-'A')*((int) Math.pow(10, i));
            }
            if(map.containsKey(res)) {
                if(map.get(res)==1) {
                    map.remove(res);
                } else {
                    map.replace(res, map.get(res)-1);
                }
            } else {
                return s;
            }
        }
        return answer;
    }
}