class Solution {
    public int solution(int[][] sizes) {
        int first = 0;
        int second = 0;
        for (int i=0; i<sizes.length; i++) {
            int f = Math.max(sizes[i][0], sizes[i][1]);
            int s = Math.min(sizes[i][0], sizes[i][1]);
            first = Math.max(first, f);
            second = Math.max(second, s);
        }
        
        return first*second;
    }
}