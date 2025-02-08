import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int f = find(first, answers);
        int s = find(second, answers);
        int t = find(third, answers);
        
        int max = Math.max(f, Math.max(s, t));
        List<Integer> list = new ArrayList<>();
        
        if (max == f) {
            list.add(1);
        }
        if (max == s) {
            list.add(2);
        }
        if (max == t) {
            list.add(3);
        }
        Collections.sort(list);
        int[] result = new int[list.size()];
        for (int i=0; i<result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    
    public int find(int[] nums, int[] answers) {
        int correct = 0;
        for (int i=0; i<answers.length; i++) {
            if (answers[i] == nums[i%nums.length]) {
                correct++;
            }
        }
        return correct;
    }
}