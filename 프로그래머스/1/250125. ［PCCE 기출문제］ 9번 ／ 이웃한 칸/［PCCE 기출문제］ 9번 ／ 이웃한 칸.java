class Solution {
    static int[] directionX = {-1, 1, 0, 0};
    static int[] directionY = {0, 0, -1, 1};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String color = board[h][w];
        for (int i=0; i<4; i++) {
            int nextX = h+directionX[i];
            int nextY = w+directionY[i];
            
            if (nextX<0||nextX>=board.length||nextY<0||nextY>=board[0].length) {
                continue;
            }
            
            if (color.equals(board[nextX][nextY])) {
                answer++;
            }
        }
        return answer;
    }
}