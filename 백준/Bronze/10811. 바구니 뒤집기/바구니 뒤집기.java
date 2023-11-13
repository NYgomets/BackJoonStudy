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

            do {
                int change = 0;
                change = arr[i - 1];
                arr[i - 1] = arr[j - 1];
                arr[j - 1] = change;
                i++;
                j--;
            } while (i < j);
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}