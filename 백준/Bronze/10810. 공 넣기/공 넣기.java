import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] arr = new int[N];

        for (int x=0; x<M; x++) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            int k = scanner.nextInt();

            for (int q=i-1; q<j; q++) {
                arr[q] = k;
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}