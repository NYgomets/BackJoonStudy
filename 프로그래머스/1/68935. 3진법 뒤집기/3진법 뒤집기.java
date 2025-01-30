class Solution {
    public int solution(int n) {
        String three = change(n);
        String reverse = new StringBuilder(three).reverse().toString();
        int result = tenChange(reverse);
        return result;
    }
    
    public int tenChange(String reverse) {
        int length = reverse.length()-1;
        int sum = 0;
        for (int i=0; i<reverse.length(); i++) {
            int a = Integer.parseInt(reverse.substring(i, i+1));
            sum += Math.pow(3, length)*a;
            length--;
        }
        
        return sum;
    }
    
    public String change(int n) {
        if (n==0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while(n>0) {
            sb.insert(0, n%3);
            n/=3;
        }
        return sb.toString();
    }
}