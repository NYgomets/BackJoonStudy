import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 1;
        for (String[] cloth : clothes) {
            String a = cloth[0];
            String b = cloth[1];
            map.put(b, map.getOrDefault(b, 0)+1);
        }
        
        for (int i : map.values()) {
            answer *= (i+1);
        }
        
        return answer-1;
    }
}