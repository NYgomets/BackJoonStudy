import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int result = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        for (int i=0; i<10; i++) {
            String s = discount[i];
            if (map.containsKey(s)) {
                map.put(s, map.get(s)-1);
            }
        }
        if (check(map)) {
            result++;
        }
        
        for (int i=0; i<discount.length-10; i++) {
            String front = discount[i];
            if (map.containsKey(front)) {
                map.put(front, map.get(front)+1);
            }
            String back = discount[i+10];
            if (map.containsKey(back)) {
                map.put(back, map.get(back)-1);
            }
            if (check(map)) {
            result++;
            }
        }
        
        return result;
    }
    
    public boolean check(Map<String, Integer> map) {
        List<Integer> list = new ArrayList<>(map.values());
        for (int i : list) {
            if (i != 0) {
                return false;
            }
        }
        
        return true;
    }
}