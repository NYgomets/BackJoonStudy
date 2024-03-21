import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int start_index = 1;
        int end_index = 1;
        int count = 0;
        int s = A[1];

        while (true) {
            if (s < M) {
                end_index++;
                if (end_index > N) {
                    break;
                }
                s += A[end_index];
            } else if (s > M) {
                s -= A[start_index];
                start_index++;
                if (start_index > N) {
                    break;
                }
            } else {
                count++;
                end_index++;
                if (end_index > N) {
                    break;
                }
                s += A[end_index];
            }
        }

        System.out.println(count);
    }
}