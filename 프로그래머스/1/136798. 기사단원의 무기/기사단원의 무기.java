class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i=1; i<=number; i++) {
            int num = find(i);
            if (num <= limit) {
                answer += num;
            } else {
                answer += power;
            }
        }
        
        return answer;
    }
    
    public int find(int person) {
        int result = 0;
        for (int i=1; i<=Math.sqrt(person); i++) {
            if (person%i == 0) {
                result ++;
                if (person/i != i) {
                    result++;
                }
            }
        }
        return result;
    }
}