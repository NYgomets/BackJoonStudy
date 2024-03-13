import java.io.*;
import java.util.*;

class Check {
    int a_Abs;
    int a;

    public Check(int a_Abs, int a) {
        this.a_Abs = a_Abs;
        this.a = a;
    }
}

class CheckComparator implements Comparator<Check> {

    @Override
    public int compare(Check o1, Check o2) {
        if (o1.a_Abs == o2.a_Abs) {
            return o1.a - o2.a;
        } else {
            return o1.a_Abs - o2.a_Abs;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        PriorityQueue<Check> pq = new PriorityQueue<>(1, new CheckComparator());

        int N = s.nextInt();
        for (int i=0; i<N; i++) {
            int x = s.nextInt();
            if (x != 0) {
                pq.add(new Check(Math.abs(x), x));
            } else {
                if (!pq.isEmpty()) {
                    Check p = pq.poll();
                    System.out.println(p.a);
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}