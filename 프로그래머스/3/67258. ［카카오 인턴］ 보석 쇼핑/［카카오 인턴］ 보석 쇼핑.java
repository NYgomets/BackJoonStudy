import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for (String gem : gems) {
            set.add(gem);
        }
        int kinds = set.size();
        
        int left = 0;
        int length = Integer.MAX_VALUE;
        int coLeft = 0;
        int coRight = 0;
        for (int right=0; right<gems.length; right++) {
            map.put(gems[right], map.getOrDefault(gems[right], 0)+1);
            
            while (map.size() == kinds) {
                if (right-left+1 < length) {
                    length = right-left+1;
                    coLeft = left;
                    coRight = right;
                }
                
                String gem = gems[left];
                if (map.get(gem) == 1) {
                    map.remove(gem);
                } else {
                    map.put(gem, map.get(gem)-1);
                }
                left++;
            }
        }
        
        return new int[]{coLeft+1, coRight+1};
    }   
}