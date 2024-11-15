import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static String[] grade;
    static int[] power;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grade = new String[n];
        power = new int[n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            grade[i] = a;
            power[i] = b;
        }

        for (int i=0; i<m; i++) {
            int check = Integer.parseInt(br.readLine());
            binary(check);
        }

        System.out.println(sb);
    }

    private static void binary(int check) {
        int start = 0;
        int end = n-1;
        String result = "";
        while (start <= end) {
            int mid = (start+end) / 2;

            if (check > power[mid]) {
                start = mid+1;
            } else {
                result = grade[mid];
                end = mid-1;
            }
        }
        sb.append(result).append("\n");
    }
}
