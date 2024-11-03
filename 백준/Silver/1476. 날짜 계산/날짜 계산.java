import org.w3c.dom.Node;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int year = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        check(e, s, m);
        System.out.println(year);
    }

    private static void check(int e, int s, int m) {
        int eCount = 0;
        int sCount = 0;
        int mCount = 0;
        while (true) {
            year++;
            eCount++;
            if (eCount == 16) {
                eCount = 1;
            }
            sCount++;
            if (sCount == 29) {
                sCount = 1;
            }
            mCount++;
            if (mCount == 20) {
                mCount = 1;
            }
            if (eCount == e) {
                if (sCount == s) {
                    if (mCount == m) {
                        return;
                    }
                }
            }
        }
    }
}