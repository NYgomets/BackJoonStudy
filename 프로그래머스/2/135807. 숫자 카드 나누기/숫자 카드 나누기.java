class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = getGcd(arrayA);
        int gcdB = getGcd(arrayB);
        if (gcdA == 0 && gcdB == 0) {
            return 0;
        }
        
        boolean no1 = true;
        if (gcdA != 0) {
            for (int i : arrayB) {
                if (i % gcdA == 0) {
                    no1 = false;
                    break;
                } 
            }
        }
        if (!no1) {
            gcdA = 0;
        }
        
        boolean no2 = true;
        if (gcdB != 0) {
            for (int i : arrayA) {
                if (i % gcdB == 0) {
                    no2 = false;
                    break;
                } 
            }
        }
        if (!no2) {
            gcdB = 0;
        }
        
        if (gcdA != 0 || gcdB != 0) {
            return Math.max(gcdA, gcdB);
        }
        return 0;
    }
    
    static public int getGcd(int[] array) {
        int result = array[0];
        
        for (int i=1; i<array.length; i++) {
            result = gcd(result, array[i]);
        }
        
        return result;
    }
    
    static public int gcd(int a, int b) {
        int max = 0;
        int min = 0;
        if (a>b) {
            max = a;
            min = b;
        } else {
            max = b;
            min = a;
        }
        
        if (max%min != 0) {
            int temp = min;
            min = max%min;
            max = temp;
            return gcd(max, min);
        } else {
            return min;
        }
    }
}