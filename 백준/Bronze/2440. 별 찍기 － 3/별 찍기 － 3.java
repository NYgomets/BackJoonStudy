import java.math.BigInteger;
import java.util.Scanner;
import java.util.zip.CheckedOutputStream;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        for (int i=n; i>0; i--) {
            for (int j=0; j<i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}