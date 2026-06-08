class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        String[] nums = {"1", "2", "4"};
        
        while(n>0) {
            n--;
            sb.append(nums[n%3]);
            n /= 3;
        }
        
        return sb.reverse().toString();
    }
}