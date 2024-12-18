import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int k;
    static int n;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int l=0; l<t; l++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            arr = new int[k+1][n+1];
            for (int i=1; i<=n; i++) {
                arr[0][i] = i;
            }

            for (int i=1; i<=k; i++) {
                int prev = 0;
                for (int j=1; j<=n; j++) {
                    arr[i][j] = arr[i-1][j]+prev;
                    prev += arr[i-1][j];
                }
            }

            System.out.println(arr[k][n]);
        }
    }
}