class Solution {
    public int solution(int n) {
        int first = Integer.bitCount(n);
        int next = n+1;
        while (Integer.bitCount(next) != first) {
            next++;
        }
        return next;
    }
}