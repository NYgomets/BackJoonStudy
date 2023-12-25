import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int num = s.nextInt();

        for (int i=0; i<num; i++) {
            int money = s.nextInt();

            int q = money / 25;
            money %= 25;
            int d = money / 10;
            money %= 10;
            int n = money / 5;
            money %= 5;
            int p = money;

            System.out.println(q + " " + d + " " + n + " " + p);
        }
    }
}