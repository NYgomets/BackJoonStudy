import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        BigInteger a = new BigInteger(s.next());
        BigInteger b = new BigInteger(s.next());
        
        System.out.println((a.add(b)).multiply(a.subtract(b)));
    }
}