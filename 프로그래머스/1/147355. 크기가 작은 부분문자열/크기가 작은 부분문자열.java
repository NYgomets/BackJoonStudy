class Solution {
    public int solution(String t, String p) {
        int length = p.length();
        int result = 0;
        for (int i=0; i<=t.length()-length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=i; j<i+length; j++) {
                sb.append(t.substring(j, j+1));
            }
            if (Long.parseLong(sb.toString()) <= Long.parseLong(p)) {
                result++;
            }
        }
        
        return result;
    }
}