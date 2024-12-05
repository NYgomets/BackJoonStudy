import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int county;
        int gold;
        int silver;
        int bronze;


        public Node(int county, int gold, int silver, int bronze) {
            this.county = county;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Node> list = new ArrayList<>();

        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            list.add(new Node(i, gold, silver, bronze));
        }

        list.sort(((o1, o2) -> {
            if (o1.gold == o2.gold) {
                if (o1.silver == o2.silver) {
                    return o2.bronze - o1.bronze;
                } else {
                    return o2.silver - o1.silver;
                }
            } else {
                return o2.gold - o1.gold;
            }
        }));

        int rank = 1;
        for (int i=0; i<n; i++) {
            if (list.get(i).county == k) {
                System.out.println(rank);
                break;
            } else {
                rank++;
            }
        }
    }
}