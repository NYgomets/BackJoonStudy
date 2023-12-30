import java.math.BigInteger;
import java.util.Scanner;
import java.util.zip.CheckedOutputStream;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b = s.nextInt();
        
        System.out.println((2*b) - a);
    }
}