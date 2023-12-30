import java.math.BigInteger;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        for (int i=0; i<3; i++) {
            int num = s.nextInt();
            BigInteger sum = BigInteger.ZERO;
            for (int j=0; j<num; j++) {
                BigInteger a = new BigInteger(s.next());
                sum = sum.add(a);
            }

            int comparison = sum.compareTo(BigInteger.ZERO);

            if (comparison > 0) {
                System.out.println("+");
            } else if (comparison < 0) {
                System.out.println("-");
            } else {
                System.out.println("0");
            }
        }
    }
}