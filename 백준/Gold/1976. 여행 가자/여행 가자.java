import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = i;
        }
        for (int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=1; j<=n; j++) {
                int check = Integer.parseInt(st.nextToken());
                union(i, j, check);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = find(Integer.parseInt(st.nextToken()));
        boolean travel = true;
        for (int k=1; k<m; k++) {
            if (result != find(Integer.parseInt(st.nextToken()))) {
                travel = false;
            }
        }

        if (travel) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void union(int i, int j, int check) {
        if (check == 1) {
            int first = find(i);
            int second = find(j);

            if (first != second) {
                arr[first] = second;
            }
        }
    }

    public static int find(int num) {
        if (arr[num] != num) {
            return arr[num] = find(arr[num]);
        }

        return num;
    }
}