import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] first;
    static int[] second;
    static int[] third;
    static int[] forth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        first = new int[n];
        second = new int[n];
        third = new int[n];
        forth = new int[n];
        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            first[i] = a;
            second[i] = b;
            third[i] = c;
            forth[i] = d;
        }

        int[] left = new int[n*n];
        calSum(first, second, left);
        int[] right = new int[n*n];
        calSum(third, forth, right);

        Arrays.sort(right);
        long result = 0;
        for (int c : left) {
            int check = -c;

            int low = lowerBound(right, check);
            int high = upperBound(right, check);

            result += high-low;
        }

        System.out.println(result);
    }

    private static int upperBound(int[] right, int check) {
        int start = 0;
        int end = right.length;

        while (start<end) {
            int mid = (start+end)/2;

            if (right[mid] > check) {
                end = mid;
            } else {
                start = mid+1;
            }
        }

        return start;
    }

    private static int lowerBound(int[] right, int check) {
        int start = 0;
        int end = right.length;

        while (start<end) {
            int mid = (start+end)/2;

            if (right[mid] >= check) {
                end = mid;
            } else {
                start = mid+1;
            }
        }

        return start;
    }

    private static void calSum(int[] arr1, int[] arr2, int[] arr) {
        int idx = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                arr[idx++] = arr1[i] + arr2[j];
            }
        }
    }

}
