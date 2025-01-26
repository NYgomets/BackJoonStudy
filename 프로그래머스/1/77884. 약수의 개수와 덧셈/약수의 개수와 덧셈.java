class Solution {
    public int solution(int left, int right) {
        int result = 0;
        for (int i=left; i<=right; i++) {
            if (check(i)%2 == 0) {
                result +=i;
            } else {
                result -=i;
            }
        }
        
        return result;
    }
    
    public int check(int num) {
        int count = 0;
        for (int i=1; i<=Math.sqrt(num); i++) {
            if (num%i == 0) {
                count++;
                if (num/i != i) {
                    count++;
                }
            }
        }
        return count;
    }
}