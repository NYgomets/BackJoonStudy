import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       Scanner s = new Scanner(System.in);

       int king = s.nextInt();
       int queen = s.nextInt();
       int look = s.nextInt();
       int sh = s.nextInt();
       int night = s.nextInt();
       int pon = s.nextInt();

       int k = 1 - king;
       int q = 1 - queen;
       int l = 2 - look;
       int b = 2 - sh;
       int n = 2 - night;
       int p = 8 - pon;

       System.out.println(k + " " + q + " " + l + " " + b + " " + n + " " + p);
    }
}