import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        String letter;

        int num;

        num = s.nextInt();

        for (int i=0; i<num; i++) {
            letter = s.next();
            list.add(letter);
        }

        for (int i=0; i<num; i++) {
            String p = list.get(i);
            char first = p.charAt(0);
            int length = p.length();
            char last = p.charAt(length-1);
            System.out.print(first);
            System.out.print(last);
            System.out.println();
        }

    }
}