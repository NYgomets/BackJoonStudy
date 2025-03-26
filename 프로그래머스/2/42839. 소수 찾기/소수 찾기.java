import java.util.*;

class Solution {
    public int solution(String numbers) {
        Set<Integer> set = new HashSet<>();
        allFind(numbers.toCharArray(), new boolean[numbers.length()], "", set);
        int result = 0;
        for (int s : set) {
            if (checkNum(s)) {
                result++;
            }
        }
        return result;
    }
    
    public boolean checkNum(int num) {
        if (num < 2) {
            return false;
        }
        
        for (int i=2; i<=Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public void allFind(char[] arr, boolean[] visited, String num, Set<Integer> set) { 
        if (!num.isEmpty()) {
            set.add(Integer.parseInt(num));
        }
        
        for (int i=0; i<arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                allFind(arr, visited, num+arr[i], set);
                visited[i] = false;
            }
        }
    }
}