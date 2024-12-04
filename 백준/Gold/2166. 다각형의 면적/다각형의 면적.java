import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        arr = new int[t][2];
        StringTokenizer st;
        for (int l=0; l<t; l++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[l][0] = a;
            arr[l][1] = b;
        }

        double sum = 0;
        for (int i=0; i<t; i++) {
            sum += (double) arr[i][0] * arr[(i+1)%t][1];
            sum -= (double) arr[i][1] * arr[(i+1)%t][0];
        }

        System.out.printf("%.1f", Math.abs(sum/2));
    }
}