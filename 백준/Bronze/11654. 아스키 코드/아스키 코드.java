import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String letter;

        letter = s.next();

        char c = letter.charAt(0);

        System.out.println((int) c);

    }
}