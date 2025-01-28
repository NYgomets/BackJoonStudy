class Solution {
    public int[] solution(int n, int m) {
        int min = Math.min(n, m);
        int max = Math.max(n, m);
        int first = gcd(max, min);
        int second = (n*m)/first;
        int[] result = new int[2];
        result[0] = first;
        result[1] = second;
        return result;
    }
    
    public int gcd(int max, int min) {
        if (max%min != 0) {
            int temp = min;
            min = max%min;
            max = temp;
            return gcd(max, min);
        } else {
            return min;
        }
    }
}