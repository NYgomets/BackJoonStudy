import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        while (true) {
            int num = s.nextInt();
            List<Integer> list = new ArrayList<>();

            if (num == -1) {
                break;
            }

            for (int i=1; i<num; i++) {
                if (num%i == 0) {
                    list.add(i);
                }
            }

            int sum = 0;

            for (int i=0; i<list.size(); i++) {
                sum+=list.get(i);
            }

            if (num == sum) {
                System.out.print(num + " = ");
                for (int j=0; j<list.size(); j++) {
                    if (Objects.equals(list.get(j), list.get(list.size() - 1))) {
                        System.out.print(list.get(j));
                        break;
                    }
                    System.out.print(list.get(j) + " + ");
                }
                System.out.println();
            } else {
                System.out.println(num + " is NOT perfect.");
            }
        }
    }
}