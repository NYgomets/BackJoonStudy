class Solution {
    static Integer[][] dp;
    public int solution(int[][] triangle) {
        int high = triangle.length;
        int width = triangle[high-1].length;
        dp = new Integer[high][width];
        return dfs(triangle, 0, 0);
    }
    
    public int dfs(int[][] triangle, int high, int width) {
        if (high >= triangle.length) {
            return 0;
        }
        
        if (dp[high][width] != null) {
            return dp[high][width];
        }
        
        int max = Integer.MIN_VALUE;
        max = Math.max(max, triangle[high][width]+dfs(triangle, high+1, width));
        if (width < triangle[high].length) {
            max = Math.max(max, triangle[high][width]+dfs(triangle, high+1, width+1));
        }
        
        dp[high][width] = max;
        
        return max;
    }
}