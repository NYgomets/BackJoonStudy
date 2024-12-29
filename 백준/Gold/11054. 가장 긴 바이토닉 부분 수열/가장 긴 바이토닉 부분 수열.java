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

        dpDown[idx] = 1;
        for (int i=idx+1; i<n; i++) {
            if (arr[idx] > arr[i]) {
                dpDown[idx] = Math.max(dpDown[idx], 1+findDown(i));
            }
        }

        return dpDown[idx];
    }

    private static int findUp(int idx) {
        if (dpUp[idx] != null) {
            return dpUp[idx];
        }

        dpUp[idx] = 1;
        for (int i=0; i<idx; i++) {
            if (arr[i] < arr[idx]) {
                dpUp[idx] = Math.max(dpUp[idx], 1+findUp(i));
            }
        }

        return dpUp[idx];
    }
}