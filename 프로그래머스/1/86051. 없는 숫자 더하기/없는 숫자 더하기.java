class Solution {
    public int solution(int[] numbers) {
        int result = 45;
        for (int i : numbers) {
            result -= i;
        }
        
        return result;
    }
}