import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String a;
        int num;

        Scanner s = new Scanner(System.in);

        a = s.next();
        num = s.nextInt();

        char c = a.charAt(num - 1);
        System.out.println(c);

    }
}