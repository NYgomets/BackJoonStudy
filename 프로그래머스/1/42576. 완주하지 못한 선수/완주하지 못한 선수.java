import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : completion) {
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        
        String result = "";
        for (String s : participant) {
            if (!map.containsKey(s) || map.get(s) == 0) {
                result = s;
                break;
            }
            map.put(s, map.get(s)-1);
        }
        return result;
    }
}