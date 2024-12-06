import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long[][] shortest;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        shortest = new long[n+1][n+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (i==j) {
                    shortest[i][j] = 0;
                } else {
                    shortest[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) {
                break;
            }
            shortest[a][b] = 1;
            shortest[b][a] = 1;
        }

        floyd();
        List<Integer> list = new ArrayList<>();
        long grade = Integer.MAX_VALUE;
        int count = 0;
        for (int i=1; i<=n; i++) {
            long max = 0;
            for (int j=1; j<=n; j++) {
                if (shortest[i][j] != Integer.MAX_VALUE) {
                    if (max < shortest[i][j]) {
                        max = shortest[i][j];
                    }
                }
            }
            if (grade > max) {
                grade = max;
                list.clear();
                list.add(i);
                count = 1;
            } else if (grade == max) {
                list.add(i);
                count++;
            }
        }

        Collections.sort(list);
        System.out.println(grade + " " + count);
        for (long c : list) {
            System.out.print(c + " ");
        }
    }

    private static void floyd() {
        for (int k=1; k<=n; k++) {
            for (int s=1; s<=n; s++) {
                for (int e=1; e<=n; e++) {
                    if (shortest[s][e] > shortest[s][k] + shortest[k][e]) {
                        shortest[s][e] = shortest[s][k] + shortest[k][e];
                    }
                }
            }
        }
    }
}
