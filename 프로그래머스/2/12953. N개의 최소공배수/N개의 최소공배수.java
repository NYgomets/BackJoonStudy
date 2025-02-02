class Solution {
    public int solution(int[] arr) {
        int first = arr[0];
        for (int i=1; i<arr.length; i++) {
            int second = arr[i];
            int min = gcd(Math.max(first, second), Math.min(first, second));
            int max = (first*second)/min;
            first = max;
        }
        
        return first;
    }
    
    public int gcd(int max, int min) {
        if (max%min != 0) {
            int term = min;
            min = max%min;
            max = term;
            return gcd(max, min);
        } else {
            return min;
        }
    }
}