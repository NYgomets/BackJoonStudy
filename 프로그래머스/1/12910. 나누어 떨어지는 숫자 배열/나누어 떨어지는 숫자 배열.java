import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if (i%divisor == 0) {
                list.add(i);
            }
        }
        
        int[] result;
        if(list.isEmpty()) {
            result = new int[]{-1};
        } else {
            Collections.sort(list);
            result = new int[list.size()];
            for (int i=0; i<list.size(); i++) {
                result[i] = list.get(i);
            }
        }
        
        return result;
    }
}