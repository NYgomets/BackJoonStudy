class Solution {
    public int solution(int[] number) {
        int answer = 0;
        for (int k=0; k<number.length-2; k++) {
            for (int i=k+1; i<number.length-1; i++) {
                for (int j=i+1; j<number.length; j++) {
                    if (number[k]+number[i]+number[j] == 0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}