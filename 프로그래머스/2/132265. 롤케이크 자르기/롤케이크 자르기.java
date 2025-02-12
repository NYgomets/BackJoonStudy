import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> second = new HashMap<>();
        for (int i=0; i<topping.length; i++) {
            second.put(topping[i], second.getOrDefault(topping[i], 0)+1);
        }
        
        int result = 0;
        for (int i=0; i<topping.length-1; i++) {
            first.put(topping[i], first.getOrDefault(topping[i], 0)+1);
            second.put(topping[i], second.get(topping[i])-1);
            
            if (second.get(topping[i]) == 0) {
                second.remove(topping[i]);
            }
            
            if (first.size() == second.size()) {
                result++;
            }
        }
        
        return result;
    }
}