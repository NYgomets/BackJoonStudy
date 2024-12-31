import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int remove;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n];
        for (int i=0; i<n; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;
        for (int i=0; i<n; i++) {
            int state = Integer.parseInt(st.nextToken());

            if (state == -1) {
                root = i;
                continue;
            }

            list[state].add(i);
        }

        remove = Integer.parseInt(br.readLine());
        if (remove == root) {
            System.out.println(0);
            return;
        }

        removeTree(root, remove);
        int count = countLeaf(root);
        System.out.println(count);
    }

    private static int countLeaf(int start) {
        if (list[start].isEmpty()) {
            return 1;
        }

        int count = 0;
        for (int next : list[start]) {
            count += countLeaf(next);
        }

        return count;
    }

    private static void removeTree(int start, int goal) {
        List<Integer> child = list[start];
        child.remove(Integer.valueOf(goal));

        for (Integer next : child) {
            removeTree(next, goal);
        }
    }
}