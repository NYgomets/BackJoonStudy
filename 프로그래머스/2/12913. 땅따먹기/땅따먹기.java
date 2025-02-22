import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int n = land.length;
        int[][] dp = new int[n][4];

        // 첫 번째 행은 그대로 사용
        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }

        // DP 테이블 채우기
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                // 이전 행에서 같은 열(j)을 제외한 최대값을 찾기
                int maxPrev = 0;
                for (int k = 0; k < 4; k++) {
                    if (k != j) {
                        maxPrev = Math.max(maxPrev, dp[i - 1][k]);
                    }
                }
                dp[i][j] = land[i][j] + maxPrev;
            }
        }

        // 마지막 행에서 최대값 찾기
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[n - 1][i]);
        }

        return answer;
    }
}
