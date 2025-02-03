import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        int idx = 0;
        int[] result = new int[photo.length];
        for (String[] strArr : photo) {
            int sum = 0;
            for (String str : strArr) {
                if (map.containsKey(str)) {
                    sum += map.get(str);
                }
            }
            result[idx++] = sum;
        }
        
        return result;
    }
}