import java.math.BigInteger;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int d = s.nextInt();
        int h = s.nextInt();
        int w = s.nextInt();

        double a = Math.pow(d, 2) / (Math.pow(h, 2) + Math.pow(w, 2));
        double sqrt = Math.sqrt(a);
        System.out.println((int) (sqrt*h) + " " + (int) (sqrt*w));
    }
}