class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown+yellow;
        
        int y = 0;
        int x = 0;
        for (int i=1; i<=total; i++) {
            if (total%i == 0) {
                int j = total/i;
                if (i >= j) {
                  int yi = i-2;
                  int yj = j-2;
                  if (yi*yj == yellow) {
                      y = i;
                      x = j;
                      break;
                  }
                }
            }
        }
        
        return new int[]{y, x};
    }
}