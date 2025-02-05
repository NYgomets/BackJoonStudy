import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int routine = 0;
        while (routine < elements.length) {
            routine++;
            for (int i=0; i<elements.length; i++) {
                count(routine, i, set, elements);
            }
        }
        return set.size();
    }
    
    public void count(int routine, int start, Set<Integer> set, int[] elements) {
        int sum = 0;
        for (int i=0; i<routine; i++) {
            sum += elements[(start+i)%elements.length];
        }
        set.add(sum);
    }
}