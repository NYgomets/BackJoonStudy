import java.util.*;

class Solution {
    static double[] falseRate;
    public int[] solution(int N, int[] stages) {
        falseRate = new double[N+1];
        int person = stages.length;
        for (int i=1; i<=N; i++) {
            if (person == 0) {
                falseRate[i] = 0;
                continue;
            }
            int count = 0;
            for (int s : stages) {
                if (s == i) {
                    count++;
                }
            }
            falseRate[i] = (double) count/person;
            person -= count;
        }
        
        Integer[] check = new Integer[N];
        for (int i=0; i<N; i++) {
            check[i] = i+1;
        }
        Arrays.sort(check, (o1, o2) -> {
           if (falseRate[o1] == falseRate[o2]) {
              return o1 - o2;
           } else {
               return Double.compare(falseRate[o2], falseRate[o1]);
           }
        });
        
        int[] result = new int[N];
        for (int i=0; i<N; i++) {
            result[i] = check[i];
        }
        return result;
    }
}