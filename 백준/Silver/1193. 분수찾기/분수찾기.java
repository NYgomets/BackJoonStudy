import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());

        int now = 0;
        int prev = 0;
        int b = 1;
        while (true) {
            now += b;
            if (prev < a && a <= now) {
                break;
            }
            prev = now;
            b++;
        }

        int check = prev + 1;

        if (b % 2 == 0) {
            int x = 1;
            int y = b;
            while (true) {
                if (check == a) {
                    System.out.println(x + "/" + y);
                    break;
                } else {
                    check++;
                    x++;
                    y--;
                }
            }
        } else {
            int x = b;
            int y = 1;
            while (true) {
                if (check == a) {
                    System.out.println(x + "/" + y);
                    break;
                } else {
                    check++;
                    x--;
                    y++;
                }
            }
        }
    }
}