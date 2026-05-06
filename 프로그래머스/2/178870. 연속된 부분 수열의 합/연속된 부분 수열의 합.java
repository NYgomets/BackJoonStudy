class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0;
        int right = 0;
        int sum = 0;
        int check = sequence.length+1;
        
        while (true) {
            if (sum < k) {
                if (right >= sequence.length) {
                    break;
                }
                sum += sequence[right];
                right++;
            } else if (sum == k) {
                if (right-left < check) {
                    check = right-left;
                    answer[0] = left;
                    answer[1] = right-1;
                }
                sum -= sequence[left];
                left++;
            } else {
                sum -= sequence[left];
                left++;
            }
        }
        
        return answer;
    }
}