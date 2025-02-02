class Solution {
    static Long[] dp;
    public long solution(int n) {
        dp = new Long[n+1];
        long result = dfs(0, n);
        return result;
    }
    public long dfs(int current, int goal) {
        if (current == goal) {
            return 1;
        }
        if (current > goal) {
            return 0;
        }
        
        if (dp[current] != null) {
            return dp[current];
        }
        
        long num = dfs(current+1, goal) + dfs(current+2, goal);
        num %= 1234567;
        
        dp[current]=num;
        
        return num;
    } 
}