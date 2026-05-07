class Solution {
    public int solution(int storey) {
        int answer = 0;
        while (storey > 0) {
            int check = storey % 10;
            
            if (check < 5) {
                answer += check;
                storey = storey/10;
            } else if (check > 5) {
                answer += (10-check);
                storey = storey/10;
                storey++;
            } else {
                answer += (10-check);
                storey = storey/10;
                
                if (storey % 10 >= 5) {
                    storey++;
                }
            }
        }
        
        return answer;
    }
}