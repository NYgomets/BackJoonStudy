class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String str : skill_trees) {
            int idx = 0;
            int prevFind = -1;
            boolean find = true;
            for (int i=0; i<skill.length(); i++) {
                if (!find) {
                    break;
                }
                for (int j=0; j<str.length(); j++) {
                    if (skill.charAt(i) == str.charAt(j)) {
                        if (i-prevFind != 1) {
                            find = false;
                            break;
                        }
                        
                        if (i==0) {
                            idx = j;
                            prevFind = 0;
                        } else {
                            if (j <= idx) {
                                find = false;
                            } else {
                                idx = j;
                                prevFind = i;
                            }
                        }
                        break;
                    }
                }
            }
            if(find) {
                answer++;
            }
        }
        return answer;
    }
}