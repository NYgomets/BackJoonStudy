class Solution {
    public int solution(int n) {
        int answer = 1;
        for (int i=1; i<=n/2; i++) {
            if (check(i, n)) {
                answer++;
            }
        }
        return answer;
    }
    
    public boolean check(int n, int last) {
        int sum = 0;
        for (int i=n; i<=last; i++) {
            sum += i;
            if (sum == last) {
                return true;
            }  else if (sum > last) {
                break;
            }
        }
        
        return false;
    }
}