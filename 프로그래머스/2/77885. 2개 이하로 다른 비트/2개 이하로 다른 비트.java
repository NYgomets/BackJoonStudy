class Solution {
    public long[] solution(long[] numbers) {
        long[] result = new long[numbers.length];
        int idx = 0;
        for (long num : numbers) {
            String first = toBinary(num);
            if (first.charAt(first.length()-1) == '0') {
                String check = first.substring(0, first.length()-1) + "1";
                long l = Long.parseLong(check, 2);
                result[idx++] = l;
            } else {
                int zero = 0;
                for (int i=0; i<first.length(); i++) {
                    if (first.charAt(i) == '0') {
                        zero = i;
                    }
                }
                
                if (zero == 0) {
                    String check = "10" + first.substring(1, first.length());
                    long l = Long.parseLong(check, 2);
                    result[idx++] = l;
                } else {
                    String check = first.substring(0, zero) + "10" + first.substring(zero+2, first.length());
                    long l = Long.parseLong(check, 2);
                    result[idx++] = l;
                }
            }
        }
        return result;
    }
    
    public String toBinary(long num) {
        if (num == 0) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            long check = num%2;
            sb.insert(0, check);
            num /= 2;
        }
        
        return sb.toString();
    }
}