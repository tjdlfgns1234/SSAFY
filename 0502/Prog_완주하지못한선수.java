import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> dict = new HashMap<>();
        for (String p : participant) {
            if (dict.containsKey(p)) {
                dict.put(p, dict.get(p)+1);
            }
            else {
                dict.put(p,1);
            }
        }
        
        for (String com : completion) {
            dict.put(com, dict.get(com)-1);
            if (dict.get(com) == 0) {
                dict.remove(com);
            }
        }
        
        for (String name : dict.keySet()) {
            return name;
        }
        return "";
    }
}
