import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static long[][] shortest;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        shortest = new long[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i==j) {
                    shortest[i][j] = 0;
                } else {
                    shortest[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i=0; i<n; i++) {
            String string = br.readLine();
            for (int j=0; j<n; j++) {
                String substring = string.substring(j, j + 1);
                if (substring.equals("Y")) {
                    shortest[i][j] = 1;
                    shortest[j][i] = 1;
                }
            }
        }

        floyd();

        int max = 0;
        for (int i=0; i<n; i++) {
            int count = 0;
            for (int j=0; j<n; j++) {
                if (shortest[i][j] == 1 || shortest[i][j] == 2) {
                    count++;
                }
            }
            max = Math.max(max, count);
        }

        System.out.println(max);
    }

    private static void floyd() {
        for (int k=0; k<n; k++) {
            for (int s=0; s<n; s++) {
                for (int e=0; e<n; e++) {
                    shortest[s][e] = Math.min(shortest[s][e], shortest[s][k]+shortest[k][e]);
                }
            }
        }
    }
}