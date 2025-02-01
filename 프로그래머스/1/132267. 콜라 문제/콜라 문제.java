class Solution {
    public int solution(int a, int b, int n) {
        int result = 0;
        while (n/a != 0) {
            result += (n/a)*b;
            n = (n-(n/a)*a)+(n/a)*b;
        }
        return result;
    }
}