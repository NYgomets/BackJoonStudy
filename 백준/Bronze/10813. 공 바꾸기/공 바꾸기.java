import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] arr = new int[N];

        for (int x=0; x<N; x++) {
            arr[x] = x+1;
        }

        for (int r=0; r<M; r++) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();

            int change = 0;

            change = arr[i-1];
            arr[i-1] = arr[j-1];
            arr[j-1] = change;
        }

        for (int q=0; q<arr.length; q++) {
            System.out.print(arr[q] + " ");
        }
    }
}