class Solution {
    static int[] left = {3, 0};
    static int[] right = {3, 2};
    public String solution(int[] numbers, String hand) {
        String answer = "";
        for (int num : numbers) {
            if (num == 1) {
                answer += "L";
                left[0] = 0;
                left[1] = 0;
            } else if (num == 2) {
                int y = 0;
                int x = 1;
                int lnum = (Math.abs(y-left[0]) + Math.abs(x-left[1]));
                int rnum = (Math.abs(y-right[0]) + Math.abs(x-right[1]));
                if (lnum > rnum) {
                    answer += "R";
                    right[0] = 0;
                    right[1] = 1;
                } else if (lnum < rnum) {
                    answer += "L";
                    left[0] = 0;
                    left[1] = 1;
                } else {
                    if (hand.equals("right")) {
                        answer += "R";
                        right[0] = 0;
                        right[1] = 1;
                    } else {
                        answer += "L";
                        left[0] = 0;
                        left[1] = 1;
                    }
                }
            } else if (num == 3) {
                answer += "R";
                right[0] = 0;
                right[1] = 2;
            } else if (num == 4) {
                answer += "L";
                left[0] = 1;
                left[1] = 0;
            } else if (num == 5) {
                int y = 1;
                int x = 1;
                int lnum = (Math.abs(y-left[0]) + Math.abs(x-left[1]));
                int rnum = (Math.abs(y-right[0]) + Math.abs(x-right[1]));
                if (lnum > rnum) {
                    answer += "R";
                    right[0] = 1;
                    right[1] = 1;
                } else if (lnum < rnum) {
                    answer += "L";
                    left[0] = 1;
                    left[1] = 1;
                } else {
                    if (hand.equals("right")) {
                        answer += "R";
                        right[0] = 1;
                        right[1] = 1;
                    } else {
                        answer += "L";
                        left[0] = 1;
                        left[1] = 1;
                    }
                }
            } else if (num == 6) {
                answer += "R";
                right[0] = 1;
                right[1] = 2;
            } else if (num == 7) {
                answer += "L";
                left[0] = 2;
                left[1] = 0;
            } else if (num == 8) {
                int y = 2;
                int x = 1;
                int lnum = (Math.abs(y-left[0]) + Math.abs(x-left[1]));
                int rnum = (Math.abs(y-right[0]) + Math.abs(x-right[1]));
                if (lnum > rnum) {
                    answer += "R";
                    right[0] = 2;
                    right[1] = 1;
                } else if (lnum < rnum) {
                    answer += "L";
                    left[0] = 2;
                    left[1] = 1;
                } else {
                    if (hand.equals("right")) {
                        answer += "R";
                        right[0] = 2;
                        right[1] = 1;
                    } else {
                        answer += "L";
                        left[0] = 2;
                        left[1] = 1;
                    }
                }
            } else if (num == 9) {
                answer += "R";
                right[0] = 2;
                right[1] = 2;
            } else if (num == 0) {
                int y = 3;
                int x = 1;
                int lnum = (Math.abs(y-left[0]) + Math.abs(x-left[1]));
                int rnum = (Math.abs(y-right[0]) + Math.abs(x-right[1]));
                if (lnum > rnum) {
                    answer += "R";
                    right[0] = 3;
                    right[1] = 1;
                } else if (lnum < rnum) {
                    answer += "L";
                    left[0] = 3;
                    left[1] = 1;
                } else {
                    if (hand.equals("right")) {
                        answer += "R";
                        right[0] = 3;
                        right[1] = 1;
                    } else {
                        answer += "L";
                        left[0] = 3;
                        left[1] = 1;
                    }
                }
            }
        }
        
        return answer;
    }
}