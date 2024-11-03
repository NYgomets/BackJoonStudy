import org.w3c.dom.Node;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static class Node {
        int day;
        int money;

        public Node(int day, int money) {
            this.day = day;
            this.money = money;
        }

        public int getDay() {
            return day;
        }

        public int getMoney() {
            return money;
        }
    }
    static List<Node>[] table;
    static int n;
    static int cost = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        table = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            table[i] = new ArrayList<>();
        }

        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            table[i].add(new Node(t, p));
        }

        check(1, 0);

        System.out.println(cost);
    }

    private static void check(int start, int pay) {
        if (start > n) {
            cost = Math.max(cost, pay);
            return;
        }

        for (Node nodes : table[start]) {
            int node = start + nodes.getDay() - 1;
            if (node <= n) {
                int result = pay + nodes.getMoney();
                check(node+1, result);
            }
        }

        check(start+1, pay);
    }
}