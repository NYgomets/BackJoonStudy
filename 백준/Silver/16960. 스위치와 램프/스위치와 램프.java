import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] lamp;
    static ArrayList<Integer>[] lists;
    static int check;

    private static boolean decode(int i) {
        boolean flag = true;
        for (int num : lists[i]) {
            lamp[num]--;
            if (lamp[num] <= 0) {
                flag = false;
            }
        }

        for (int num : lists[i]) {
            lamp[num]++;
        }

        return flag;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lists = new ArrayList[N+1];
        lamp = new int[M+1];
        check = 0;

        for (int i=1; i<=N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            for (int j=0; j<x; j++) {
                check = Integer.parseInt(st.nextToken());
                lists[i].add(check);
                lamp[check]++;
            }
        }

        for (int i=1; i<=N; i++) {
            if (decode(i)) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);

    }
}