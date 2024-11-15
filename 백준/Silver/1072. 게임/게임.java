import java.io.*;
import java.util.*;

public class Main {
    static long x;
    static long y;
    static int z;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Long.parseLong(st.nextToken());
        y = Long.parseLong(st.nextToken());
        z = (int) ((y*100) / x);
        if (z >= 99) {
            System.out.println(-1);
            return;
        }

        int start = 0;
        int end = 1000000000;
        int count = -1;
        while (start <= end) {
            int mid = (start+end) / 2;
            int check = (int) (((y+mid)*100) / (x+mid));

            if (check > z) {
                count = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        System.out.println(count);
    }
}