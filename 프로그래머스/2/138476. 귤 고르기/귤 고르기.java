import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        
        int count = 0;
        int result = 0;
        for (int i : list) {
            if (count >= k) {
                break;
            }
            count += i;
            result++;
        }
        
        return result;
    }
}