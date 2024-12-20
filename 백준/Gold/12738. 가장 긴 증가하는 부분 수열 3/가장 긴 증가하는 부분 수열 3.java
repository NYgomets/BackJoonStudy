import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] lis = new int[n];
        lis[0] = arr[0];
        int length = 1;
        for (int i=1; i<n; i++) {
            int key = arr[i];
            if (key > lis[length-1]) {
                lis[length] = key;
                length++;
            } else {
                int start = 0;
                int end = length-1;
                while (start<end) {
                    int mid = (start+end)/2;
                    int midV = lis[mid];

                    if (midV < key) {
                        start = mid+1;
                    } else {
                        end = mid;
                    }
                }

                lis[start] = key;
            }
        }

        System.out.println(length);
    }
}