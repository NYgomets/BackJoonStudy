import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        while(true) {
            int a = s.nextInt();
            int b = s.nextInt();
            if (a == 0 && b == 0) {
                break;
            }
            if (b%a == 0) {
                System.out.println("factor");
            } else if (a%b == 0) {
                System.out.println("multiple");
            } else {
                System.out.println("neither");
            }
        }
    }
}