import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] nums;
    static int[] operation;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        operation = new int[4];
        StringTokenizer st  = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<4; i++) {
            operation[i] = Integer.parseInt(st.nextToken());
        }

        dfs(nums[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int num, int idx) {
        if (idx == n) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        for (int i=0; i<operation.length; i++) {
            if (operation[i] > 0) {
                operation[i]--;
                if (i == 0) {
                    dfs(num + nums[idx], idx + 1);
                } else if (i == 1) {
                    dfs(num - nums[idx], idx + 1);
                } else if (i == 2) {
                    dfs(num * nums[idx], idx + 1);
                } else if (i == 3) {
                    if (num < 0) {
                        int abs = Math.abs(num);
                        int re = abs / nums[idx];
                        dfs(-re, idx + 1);
                    } else {
                        dfs(num / nums[idx], idx + 1);
                    }
                }
                operation[i]++;
            }
        }
    }
}
