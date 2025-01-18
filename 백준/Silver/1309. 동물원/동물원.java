import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static Integer[][] arr;
    static final int MOD = 9901;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new Integer[n+1][3];

        arr[1][0] = arr[1][1] = arr[1][2] = 1;
        for (int i=2; i<=n; i++) {
            arr[i][0] = (arr[i-1][0]+arr[i-1][1]+arr[i-1][2])%MOD;
            arr[i][1] = (arr[i-1][0]+arr[i-1][2])%MOD;
            arr[i][2] = (arr[i-1][0]+arr[i-1][1])%MOD;
        }

        int result = (arr[n][0]+arr[n][1]+arr[n][2])%MOD;
        System.out.println(result);
    }
}