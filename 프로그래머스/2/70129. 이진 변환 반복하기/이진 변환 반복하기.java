class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int routine = 0;
        int count = 0;
        while (!s.equals("1")) {
            int zeroCount = 0;
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeroCount++;
                }
            }
            count += zeroCount;
            int length = s.length()-zeroCount;
            s = Integer.toBinaryString(length);
            routine++;
        }
        
        answer[0] = routine;
        answer[1] = count;
        
        return answer;
    }
}