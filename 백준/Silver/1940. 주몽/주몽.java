import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int N= s.nextInt();
        int M = s.nextInt();
        int[] checkArray = new int[N+1];

        for (int i=1; i<=N; i++) {
            checkArray[i] = s.nextInt();
        }

        Arrays.sort(checkArray);

        int count = 0;

        int sum = 0;
        int start_index = 1;
        int end_index = N;

        while (start_index < end_index) {
            sum = checkArray[start_index] + checkArray[end_index];
            if (sum < M) {
                sum = 0;
                start_index++;
            } else if (sum > M) {
                sum = 0;
                end_index--;
            } else {
                count++;
                start_index++;
            }
        }

        System.out.println(count);
    }
}