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
        arr = new int[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = i;
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int check = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (check == 0) {
                union(a, b);
            }
            if (check == 1) {
                if (find(a) == find(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static int find(int num) {
        if (arr[num] != num) {
            arr[num] = find(arr[num]);
        }

        return arr[num];
    }

    private static void union(int first, int second) {
        int a = find(first);
        int b = find(second);

        if (a < b) {
            arr[b] = a;
        } else {
            arr[a] = b;
        }
    }
}
