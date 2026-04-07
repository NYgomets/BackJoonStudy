import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, money;
    private static int[] prices;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine().trim());
        prices = new int[N];
        String[] inputLine = bf.readLine().trim().split("\\s+");
        for (int i = 0; i < N; i++) prices[i] = Integer.parseInt(inputLine[i]);
        money = Integer.parseInt(bf.readLine().trim());

        solve();
    }

    private static void solve() {
        // 1) 비0 중 최소 가격 (동률이면 큰 숫자 우선)
        int minNoZero = Integer.MAX_VALUE;
        int minNoZeroIdx = -1;
        for (int i = 1; i < N; i++) {
            if (prices[i] < minNoZero || (prices[i] == minNoZero && i > minNoZeroIdx)) {
                minNoZero = prices[i];
                minNoZeroIdx = i;
            }
        }

        // 2) 전체 최소 가격 (0 포함, 동률이면 큰 숫자 우선)
        int minWithZero = Integer.MAX_VALUE;
        int minWithZeroIdx = -1;
        for (int i = 0; i < N; i++) {
            if (prices[i] < minWithZero || (prices[i] == minWithZero && i > minWithZeroIdx)) {
                minWithZero = prices[i];
                minWithZeroIdx = i;
            }
        }

        // 비0 하나도 살 수 없으면 0 출력
        if (minNoZeroIdx == -1 || money < minNoZero) {
            System.out.println(0);
            return;
        }

        // 3) 초기 구성: 비0 하나 확보, 나머지는 전체 최저가로 최대한 채움
        List<Integer> digits = new ArrayList<>();
        digits.add(minNoZeroIdx);
        money -= minNoZero;

        while (money >= minWithZero) {
            digits.add(minWithZeroIdx);
            money -= minWithZero;
        }

        // 4) 업그레이드: 앞자리(0번)부터 큰 숫자 우선으로 교체 시도
        for (int i = 0; i < digits.size(); i++) {
            // 현재 자리의 숫자
            int cur = digits.get(i);
            // 큰 숫자부터 시도
            for (int d = N - 1; d > cur; d--) {
                int need = prices[d] - prices[cur];
                if (need <= money) {
                    // 업그레이드 가능
                    money -= need;
                    digits.set(i, d);
                    break;
                }
            }
        }

        // 5) 출력: 자리 순서대로(앞자리 우선) 이어붙임
        StringBuilder sb = new StringBuilder();
        for (int x : digits) sb.append(x);
        System.out.println(sb.toString());
    }
}
