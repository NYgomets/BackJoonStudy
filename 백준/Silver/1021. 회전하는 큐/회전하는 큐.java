import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> deque = new LinkedList<Integer>();
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i=1; i<=N; i++) {
            deque.add(i);
        }

        int[] checkNum = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int j=0; j<K; j++) {
            checkNum[j] = Integer.parseInt(st.nextToken());
        }

        for (int a=0; a<checkNum.length; a++) {
            int check = checkNum[a];
            while (deque.contains(check)) {
                int mid = deque.size()/2;
                if (check != deque.getFirst()) {
                    if (deque.indexOf(check) <= mid) {
                        count++;
                        Integer first = deque.removeFirst();
                        deque.addLast(first);
                    } else {
                        count++;
                        Integer last = deque.removeLast();
                        deque.addFirst(last);
                    }
                } else {
                    deque.removeFirst();
                }
            }
        }

        System.out.println(count);
    }
}