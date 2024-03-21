import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class PushSet {

    int x;
    int y;

    public PushSet(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<PushSet> set = new TreeSet<>(new Comparator<PushSet>() {
            @Override
            public int compare(PushSet o1, PushSet o2) {
                if (o1.y == o2.y) {
                    return o1.x - o2.x;
                } else {
                    return o1.y - o2.y;
                }
            }
        });

        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            set.add(new PushSet(x, y));
        }

        for (PushSet see:set) {
            System.out.println(see.x + " " + see.y);
        }
    }
}