import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(numbers);
        for (int i=0; i<numbers.length-1; i++) {
            for (int j=i+1; j<numbers.length; j++) {
                set.add(numbers[i]+numbers[j]);
            }
        }
        int[] result = new int[set.size()];
        int idx = 0;
        for (int i : set) {
            result[idx++] = i;
        }
        Arrays.sort(result);
        return result;
    }
}