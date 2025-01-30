class Solution {
    public int solution(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int first = 0;
        int second = 1;
        for (int i=2; i<=n; i++) {
            int temp = second;
            second = (first+second)%1234567;
            first = temp;
        }
        return second;
    }
}