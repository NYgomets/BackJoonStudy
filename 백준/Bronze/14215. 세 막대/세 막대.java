import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int first = s.nextInt();
        int second = s.nextInt();
        int third = s.nextInt();

        int max = Math.max(Math.max(first, second), third);
        int min = Math.min(Math.max(first, second), third);
        int medium = first + second + third - max - min;

        while (true) {
            if (max >= min + medium) {
                max--;
            } else {
                break;
            }
        }

        System.out.println(min+medium+max);

    }
}