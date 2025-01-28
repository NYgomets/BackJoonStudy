class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String check = s.toLowerCase();
        boolean next = true;
        for (char c : check.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
                next = true;
            } else if (next) {
                sb.append(Character.toUpperCase(c));
                next = false;
            } else {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}