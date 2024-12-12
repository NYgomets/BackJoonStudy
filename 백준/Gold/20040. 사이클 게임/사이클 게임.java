import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = i;
        }

        int result = 0;
        for (int i=1; i<=m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (find(a) == find(b)) {
                result = i;
                break;
            } else {
                union(a, b);
            }
        }

        System.out.println(result);
    }

    public static void union(int a, int b) {
        int first = find(a);
        int second = find(b);

        if (first!=second) {
            if (first>second) {
                arr[first] = second;
            } else {
                arr[second] = first;
            }
        }
    }

    private static int find(int a) {
        if (arr[a] != a) {
            arr[a] = find(arr[a]);
        }

        return arr[a];
    }
}
