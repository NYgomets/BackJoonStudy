class Solution {
    public int solution(String[] babbling) {
        String[] arr = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        for (String str : babbling) {
            boolean find = true;
            for (int i=0; i<arr.length; i++) {
                str = str.replaceAll(arr[i], String.valueOf(i));
            }
            
            if (str.charAt(0)<'0' || str.charAt(0)>'3') {
                find = false;
            } else {
                char last = str.charAt(0);
                for (int i=1; i<str.length(); i++) {
                    if (str.charAt(i)<'0' || str.charAt(i)>'3') {
                        find = false;
                        break;
                    }
                    
                    char current = str.charAt(i);
                    if (last == current) {
                        find = false;
                        break;
                    } else {
                        last = current;
                    }
                }
            }
            
            if (find) {
                answer++;
            }
        }
        return answer;
    }
}