import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> leftQueue = new LinkedList<>();
        for (int i : queue1) {
            leftQueue.add(i);
        }
        long leftSum = 0;
        for (int i : queue1) {
            leftSum += i;
        }
        Queue<Integer> rightQueue = new LinkedList<>();
        for (int i : queue2) {
            rightQueue.add(i);
        }
        long rightSum = 0;
        for (int i : queue2) {
            rightSum += i;
        }
        int answer = 0;
        int size = queue1.length*3;
        
        while (true) {
            if (answer > size) {
                break;
            }
            
            if (leftSum > rightSum) {
                int num = leftQueue.poll();
                rightQueue.add(num);
                leftSum -= num;
                rightSum += num;
                answer++;
            } else if (leftSum == rightSum) {
                return answer;
            } else {
                int num = rightQueue.poll();
                leftQueue.add(num);
                rightSum -= num;
                leftSum += num;
                answer++;
            }
        }
        
        return -1;
    }
}