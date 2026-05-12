class Solution {
    public long solution(int w, int h) {
        long answer = (long)w*h;
        int max = Math.max(w, h);
        int min = Math.min(w, h);
        int gcd = gcd(max, min);
        int nw = w/gcd;
        int nh = h/gcd;
        
        long notUsed = (long)(nw+nh-1) * gcd;
        
        return answer - notUsed;
    }
    
    static public int gcd(int max, int min) {
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