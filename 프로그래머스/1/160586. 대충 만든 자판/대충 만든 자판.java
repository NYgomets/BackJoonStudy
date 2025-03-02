import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();
        for (String key : keymap) {
            for (int i=0; i<key.length(); i++) {
                char c = key.charAt(i);
                if (!map.containsKey(c)) {
                    map.put(c, i+1);
                } else {
                    int idx = map.get(c);
                    int min = Math.min(idx, i+1);
                    map.put(c, min);
                }
            }
        }
        
        int idx = 0;
        for (String s : targets) {
            int count = 0;
            for (int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                if (!map.containsKey(c)) {
                    count = -1;
                    break;
                } else {
                    int num = map.get(c);
                    count += num;
                }
            }
            answer[idx++] = count;
        }
        
        return answer;
    }
}