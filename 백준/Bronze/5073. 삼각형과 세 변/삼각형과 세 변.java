import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            int first = s.nextInt();
            int second = s.nextInt();
            int third = s.nextInt();

            if (first == 0 || second == 0 || third == 0) {
                break;
            }

            int max = Math.max(Math.max(first, second), third);
            int min = Math.min(Math.max(first, second), third);
            int medium = first + second + third - max - min;

            if (max >= medium + min) {
                System.out.println("Invalid");
            } else {
                if (min == medium && medium == max) {
                    System.out.println("Equilateral");
                } else if (min == medium || min == max || medium == max) {
                    System.out.println("Isosceles");
                } else {
                    System.out.println("Scalene");
                }
            }
        }

    }
}