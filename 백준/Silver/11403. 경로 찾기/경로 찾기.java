import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] shortestArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        shortestArr = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i == j) {
                    shortestArr[i][j] = 0;
                } else {
                    shortestArr[i][j] = 10000;
                }
            }
        }

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    shortestArr[i][j] = 1;
                }
            }
        }

        floyd();

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (shortestArr[i][j] == 1) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }

    private static void floyd() {
        for (int k=0; k<n; k++) {
            for (int s=0; s<n; s++) {
                for (int e=0; e<n; e++) {
                    if (shortestArr[s][k] == 1 && shortestArr[k][e] == 1) {
                        shortestArr[s][e] = 1;
                    }
                }
            }
        }
    }
}