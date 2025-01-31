class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown+yellow;
        for (int i=3; i<=total; i++) {
            int width = total/i;
            if (width>=i) {
                if ((i-2)*(width-2) == yellow) {
                    return new int[]{width, i};
                }
            }
        }
        
        return new int[]{0};
    }
}