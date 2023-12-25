import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        String l = s.next();
        int n = s.nextInt();
        long result = 0;
        int idx=0;
        int num=0;
        for (int i=l.length()-1; i>=0; i--) {
            char c = l.charAt(i);
            if (c>='0' && c<='9') {
                num = c - '0';
            } else {
                num = c - 55;
            }
            result += (long) (num * Math.pow(n, idx++));
        }
        System.out.println(result);
    }
}