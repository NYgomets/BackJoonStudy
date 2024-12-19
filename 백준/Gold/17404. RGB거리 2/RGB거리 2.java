import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static long[][] house;
    static Long[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new Long[n+1][4][4];

        house = new long[n+1][4];
        for (int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());
            house[i][1] = red;
            house[i][2] = green;
            house[i][3] = blue;
        }

        long min = Integer.MAX_VALUE;
        for (int i=1; i<=3; i++) {
            min = Math.min(min, findMintCost(1, i, i));
        }

        System.out.println(min);
    }

    private static long findMintCost(int count, int color, int first) {
        if (count == n) {
            if (first==color) {
                return Integer.MAX_VALUE;
            }
        }

        if (count == n+1) {
            return 0;
        }

        if (dp[count][color][first] != null) {
            return dp[count][color][first];
        }

        long minCost = Integer.MAX_VALUE;

        if (color == 1) {
            minCost = Math.min(minCost, house[count][color]+findMintCost(count+1, 2, first));
            minCost = Math.min(minCost, house[count][color]+findMintCost(count+1, 3, first));
        } else if (color == 2) {
            minCost = Math.min(minCost, house[count][color]+findMintCost(count+1, 1, first));
            minCost = Math.min(minCost, house[count][color]+findMintCost(count+1, 3, first));
        } else {
            minCost = Math.min(minCost, house[count][color]+findMintCost(count+1, 1, first));
            minCost = Math.min(minCost, house[count][color]+findMintCost(count+1, 2, first));
        }

        dp[count][color][first] = minCost;

        return minCost;
    }
}