class Solution {
    public String solution(int a, int b) {
        String[] weekday = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] day31 = {1, 3, 5, 7, 8, 10, 12};
        int[] day30 = {4, 6, 9, 11};
        
        int day = 0;
        for (int i : day31) {
            if (i<a) {
                day += 31;
            }
        }
        
        for (int i : day30) {
            if (i<a) {
                day += 30;
            }
        }
        
        if (2<a) {
            day += 29;
        }
        
        day += b;
        
        int reminder = (day-1)%7;
        return weekday[reminder];
    }
}