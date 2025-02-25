import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> feeMap = new HashMap<>();
        Map<String, String> timeMap = new HashMap<>();
        Map<String, Integer> minMap = new HashMap<>();
        for (String str : records) {
            String[] split = str.split(" ");
            String time = split[0];
            String car = split[1];
            String inOut = split[2];
            if (inOut.equals("IN")) {
                if (!feeMap.containsKey(car)) {
                    feeMap.put(car, 0);
                    minMap.put(car, 0);
                }
                timeMap.put(car, time);
            } else if (inOut.equals("OUT")) {
                String prevTime = timeMap.get(car);
                int num = minMap.get(car);
                
                String[] first = prevTime.split(":");
                int firstHour = Integer.parseInt(first[0]);
                int firstMin = Integer.parseInt(first[1]);
                
                String[] second = time.split(":");
                int secondHour = Integer.parseInt(second[0]);
                int secondMin = Integer.parseInt(second[1]);
                
                int min = 0;
                min += (secondHour-firstHour)*60;
                min += (secondMin-firstMin);
                
                minMap.put(car, num+min);
                timeMap.remove(car);
            }
        }
        
        for (String car : timeMap.keySet()) {
             String prevTime = timeMap.get(car);
             int num = minMap.get(car);
                
             String[] first = prevTime.split(":");
             int firstHour = Integer.parseInt(first[0]);
             int firstMin = Integer.parseInt(first[1]);
                
             int min = 0;
             min += (23-firstHour)*60;
             min += (59-firstMin);
            
             minMap.put(car, num+min);
        }
        
        for (String s : minMap.keySet()) {
            int a = fees[0];
            int min = minMap.get(s);
            
            if (a>=min) {
                feeMap.put(s, fees[1]);
            } else {
                int current = (int) (fees[1] + Math.ceil((double) (min-a)/fees[2])*fees[3]);
                feeMap.put(s, current);
            }
        }
        
        List<String> list = new ArrayList<>(feeMap.keySet());
        Collections.sort(list);
        int[] result = new int[list.size()];
        for (int i=0; i<result.length; i++) {
            String check = list.get(i);
            int num = feeMap.get(check);
            result[i] = num;
        }
        
        return result;
    }
}