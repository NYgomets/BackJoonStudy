import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int first = s.nextInt();
        int second = s.nextInt();
        int third = s.nextInt();

        if (first+second+third != 180) {
            System.out.println("Error");
        } else {
            if (first == second && second == third) {
                System.out.println("Equilateral");
            } else if (first == second || first == third || second == third) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
    }
}