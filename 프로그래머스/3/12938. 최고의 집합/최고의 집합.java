class Solution {
    public int[] solution(int n, int s) {
        if (s < n) {
            return new int[]{-1};
        }
        
        int[] answer = new int[n];
        int num = s/n;
        for (int i=0; i<n; i++) {
            answer[i] = num;
        }
        int reminder = s%n;
        for (int i=n-1; i>=0; i--) {
            if (reminder > 0) {
                reminder--;
                answer[i]++;
            }
        }
        return answer;
    }
}