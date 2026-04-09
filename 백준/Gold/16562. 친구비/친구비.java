import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k;
    static int[] prices;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = i;
        }
        prices = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        int[] check = new int[n+1];
        int result = 0;
        for (int i=1; i<=n; i++) {
            int num = find(i);
            if (check[num] == 0) {
                check[num] = 1;
                result += prices[num];
            }
        }

        if (result <= k) {
            System.out.println(result);
        } else {
            System.out.println("Oh no");
        }
    }

    private static void union(int first, int second) {
        int a = find(first);
        int b = find(second);

        if (prices[a] < prices[b]) {
            arr[b] = a;
        } else {
            arr[a] = b;
        }
    }

    private static int find(int num) {
        if (num != arr[num]) {
            arr[num] = find(arr[num]);
        }

        return arr[num];
    }
}
