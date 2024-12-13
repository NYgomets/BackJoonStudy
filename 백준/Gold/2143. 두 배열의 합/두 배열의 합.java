import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int t;
    static int n;
    static int[] first;
    static int m;
    static int[] second;
    static long result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        first = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            first[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        second = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++) {
            second[i] = Integer.parseInt(st.nextToken());
        }

        List<Long> firstSum = new ArrayList<>();
        for (int i=0; i<n; i++) {
            long sum = 0;
            for (int j=i; j<n; j++) {
                sum += first[j];
                firstSum.add(sum);
            }
        }

        List<Long> secondSum = new ArrayList<>();
        for (int i=0; i<m; i++) {
            long sum = 0;
            for (int j=i; j<m; j++) {
                sum += second[j];
                secondSum.add(sum);
            }
        }

        Collections.sort(secondSum);

        for (long fir : firstSum) {
            long check = t-fir;

            int low = lowerBound(secondSum, check);
            int high = upperBound(secondSum, check);

            result += high-low;
        }

        System.out.println(result);
    }

    private static int upperBound(List<Long> secondSum, long check) {
        int start = 0;
        int end = secondSum.size();

        while (start<end) {
            int mid = (start+end)/2;

            if (secondSum.get(mid) > check) {
                end = mid;
            } else {
                start = mid+1;
            }
        }

        return start;
    }

    private static int lowerBound(List<Long> secondSum, long check) {
        int start = 0;
        int end = secondSum.size();

        while (start<end) {
            int mid = (start+end)/2;

            if (secondSum.get(mid) >= check) {
                end = mid;
            } else {
                start = mid+1;
            }
        }

        return start;
    }
}
