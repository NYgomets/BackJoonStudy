import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        String checkNum = "";
        for (int i=0; i<dartResult.length(); i++) {
            if (dartResult.charAt(i) >= '0' && dartResult.charAt(i) <= '9') {
                checkNum += dartResult.charAt(i);
            } else {
                if (dartResult.charAt(i) == 'S') {
                    int num = Integer.parseInt(checkNum);
                    list.add(num);
                    checkNum = "";
                } else if (dartResult.charAt(i) == 'D') {
                    int num = Integer.parseInt(checkNum);
                    list.add(num*num);
                    checkNum = "";
                } else if (dartResult.charAt(i) == 'T') {
                    int num = Integer.parseInt(checkNum);
                    list.add(num*num*num);
                    checkNum = "";
                } else if (dartResult.charAt(i) == '*') {
                    if (list.size()==1) {
                        list.set(list.size()-1, list.get(list.size()-1)*2);
                    } else {
                        list.set(list.size()-2, list.get(list.size()-2)*2);
                        list.set(list.size()-1, list.get(list.size()-1)*2);
                    }
                } else if (dartResult.charAt(i) == '#') {
                    list.set(list.size()-1, list.get(list.size()-1)*-1);
                }
            }
        }
        
        for (int i : list) {
            answer += i;
        }
        return answer;
    }
}