class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = s.split(" ", -1);
        for (int idx = 0; idx < strArr.length; idx++) {
            String str = strArr[idx];
            for (int i = 0; i < str.length(); i++) {
                if (i % 2 == 0) {
                    sb.append(str.substring(i, i + 1).toUpperCase());
                } else {
                    sb.append(str.substring(i, i + 1).toLowerCase());
                }
            }
            if (idx < strArr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
