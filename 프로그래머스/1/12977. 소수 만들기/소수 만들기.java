import java.util.*;

class Solution {
    static int[] arr;
    static List<Integer> list;
    public int solution(int[] nums) {
        list = new LinkedList<>();
        int max = 0;
        for (int i : nums) {
            max += i;
        }
        arr = new int[max+1];
        for (int i=2; i<=max; i++) {
            arr[i] = i;
        }
        erasto(max);
        dfs(nums, 0, 0, 0);
        
        int result = 0;
        for (int i : list) {
            if (arr[i] != 0) {
                result++;
            }
        }
        return result;
    }
    
    public void dfs(int[] nums, int count, int sum, int idx) {
        if (count == 3) {
            list.add(sum);
            return;
        }
        if (idx >= nums.length) {
            return;
        }
        
        dfs(nums, count+1, sum+nums[idx], idx+1);
        dfs(nums, count, sum, idx+1);
    }
    
    public void erasto(int max) {
        for (int i=2; i<=Math.sqrt(max); i++) {
            if (arr[i] == 0) {
                continue;
            }
            
            for (int j=i*i; j<=max; j+=i) {
                arr[j] = 0;
            }
        }
    }
}