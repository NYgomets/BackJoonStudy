import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int n = nums.length/2;
        int answer = 0;
        if (n <= map.size()) {
            answer = n;
        } else {
            answer = map.size();
        }
        return answer;
    }
}