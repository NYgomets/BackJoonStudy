import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> left = new ArrayList<>();
        subsetSum(arr, 0, n/2, 0, left);
        List<Integer> right = new ArrayList<>();
        subsetSum(arr, n/2, n, 0, right);

        Collections.sort(right);
        long count = 0;
        for (int c : left) {
            int check = s-c;

            int low = lowerBound(right, check);
            int high = upperBound(right, check);

            count += high-low;
        }

        if (s==0) {
            count--;
        }

        System.out.println(count);
    }

    private static int upperBound(List<Integer> right, int check) {
        int start = 0;
        int end = right.size();

        while (start<end) {
            int mid = (start+end)/2;
            if (right.get(mid) > check) {
                end = mid;
            } else {
                start = mid+1;
            }
        }

        return start;
    }

    private static int lowerBound(List<Integer> right, int check) {
        int start = 0;
        int end = right.size();

        while (start<end) {
            int mid = (start+end)/2;
            if (right.get(mid) >= check) {
                end = mid;
            } else {
                start = mid+1;
            }
        }

        return start;
    }

    private static void subsetSum(int[] arr, int start, int end, int currentSum, List<Integer> list) {
        if (start == end) {
            list.add(currentSum);
            return;
        }

        subsetSum(arr, start+1, end, currentSum, list);
        subsetSum(arr, start+1, end, currentSum+arr[start], list);
    }
}
