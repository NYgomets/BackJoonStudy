import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        long num;
        num = s.nextLong();
        int sum = 1;
        int idx = 0;
        int bang = 2;
        int prev = 0;
        int now = 1;
        List<Integer> list = new ArrayList<>();
        do {
            sum = (sum + (6 * idx));
            idx++;
            list.add(sum);
        } while (sum <= 1000000000);

        while(true) {
            if (num == 1) {
                System.out.println(1);
                break;
            }
            else if (list.get(prev) < num && num <=list.get(now)) {
                System.out.println(bang);
                break;
            } else {
                prev++;
                now++;
                bang++;
            }
        }

    }
}