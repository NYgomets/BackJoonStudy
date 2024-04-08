import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int n = s.nextInt();
            int tot = 0;
            for (int j = 1; j <= n; j++) {
                tot += j * (j + 1) * (j + 2) / 2;
            }
            System.out.println(tot);
        }
    }
}