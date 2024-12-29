import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static Integer[] dpUp;
    static Integer[] dpDown;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dpUp = new Integer[n];
        dpDown = new Integer[n];
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i=0; i<n; i++) {
            result = Math.max(result, findUp(i)+findDown(i)-1);
        }

        System.out.println(result);
    }

    private static int findDown(int idx) {
        if (dpDown[idx] != null) {
            return dpDown[idx];
        }

        int result = 1;
        for (int i=idx+1; i<n; i++) {
            if (arr[idx] > arr[i]) {
                result = Math.max(result, 1+findDown(i));
            }
        }

        dpDown[idx] = result;

        return result;
    }

    private static int findUp(int idx) {
        if (dpUp[idx] != null) {
            return dpUp[idx];
        }

        int result = 1;
        for (int i=0; i<idx; i++) {
            if (arr[i] < arr[idx]) {
                result = Math.max(result, 1+findUp(i));
            }
        }

        dpUp[idx] = result;

        return result;
    }
}