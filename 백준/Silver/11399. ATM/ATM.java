import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int person;
    static int[] time;
    static List<Integer> sum;
    static int prev;
    static int now;
    static int answer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        person = scanner.nextInt();
        time = new int[person];
        sum = new ArrayList<>();
        prev = 0;
        now = 0;
        answer = 0;

        for (int i=0; i<time.length; i++) {
            time[i] = scanner.nextInt();
        }

        Arrays.sort(time);

        for (int j : time) {
            now = j + prev;
            prev = now;
            sum.add(now);
        }

        for (Integer integer : sum) {
            answer += integer;
        }

        System.out.println(answer);
    }
}