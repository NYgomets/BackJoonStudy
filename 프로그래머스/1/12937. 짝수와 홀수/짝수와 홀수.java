class Solution {
    public String solution(int num) {
        StringBuilder sb = new StringBuilder();
        if (num%2==0) {
            sb.append("Even");
        } else {
            sb.append("Odd");
        }
        
        return sb.toString();
    }
}