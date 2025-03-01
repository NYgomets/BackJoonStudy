class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        char[] skipArr = new char[skip.length()];
        for (int i=0; i<skip.length(); i++) {
            skipArr[i] = skip.charAt(i);
        }
        
        for (int i=0; i<s.length(); i++) {
            char start = s.charAt(i);
            int count = 0;
            while (true) {
                if (count == index) {
                    answer += start;
                    break;
                }
                start = (char) (start+1);
                if (start > 'z') {
                    start = 'a';
                }
                boolean find = false;
                for (char c : skipArr) {
                    if (start == c) {
                        find = true;
                        break;
                    }
                }
                if (!find) {
                    count++;
                }
            }
        }
        return answer;
    }
}