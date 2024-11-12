import java.io.*;
import java.util.*;

public class Main {
    static long a;
    static long b;
    static int c = 0;
    static boolean check = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        result(a, b, c);

        if (!check) {
            System.out.println(-1);
        } else {
            System.out.println(c+1);
        }
    }

    private static void result(long start, long goal, int count) {
        if (start == goal) {
            check = true;
            c = count;
            return;
        } else if (start > goal) {
            return;
        }

        result(start*2, goal, count+1);
        result(Long.parseLong(String.valueOf(start)+1), goal, count+1);
    }
}