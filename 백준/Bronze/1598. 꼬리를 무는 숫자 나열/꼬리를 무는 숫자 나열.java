import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int a = s.nextInt() - 1;
        int b = s.nextInt() - 1;

        int c = 0;

        c += Math.abs(a / 4 - b / 4);
        c += Math.abs(a % 4 - b % 4);

        System.out.println(c);
    }
}