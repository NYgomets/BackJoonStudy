import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][][] visited;
    static List<Integer> list;
    static int aMax;
    static int bMax;
    static int cMax;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        visited = new boolean[201][201][201];
        StringTokenizer st = new StringTokenizer(br.readLine());
        aMax = Integer.parseInt(st.nextToken());
        bMax = Integer.parseInt(st.nextToken());
        cMax = Integer.parseInt(st.nextToken());

        dfs(0, 0, cMax);

        Collections.sort(list);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    private static void dfs(int currentA, int currentB, int currentC) {
        if (visited[currentA][currentB][currentC]) {
            return;
        }
        visited[currentA][currentB][currentC] = true;

        if (currentA == 0) {
            list.add(currentC);
        }

        if (currentA != 0) {
            int gabB = bMax-currentB;
            if (gabB > 0) {
                if (currentA<=gabB) {
                    dfs(0, currentB+currentA, currentC);
                } else {
                    dfs(currentA-gabB, currentB+gabB, currentC);
                }
            }

            int gabC = cMax-currentC;
            if (gabC > 0) {
                if (currentA<=gabC) {
                    dfs(0, currentB, currentC+currentA);
                } else {
                    dfs(currentA-gabC, currentB, currentC+gabC);
                }
            }
        }

        if (currentB != 0) {
            int gabA = aMax-currentA;
            if (gabA > 0) {
                if (currentB<=gabA) {
                    dfs(currentA+currentB, 0, currentC);
                } else {
                    dfs(currentA+gabA, currentB-gabA, currentC);
                }
            }

            int gabC = cMax-currentC;
            if (gabC > 0) {
                if (currentB<=gabC) {
                    dfs(currentA, 0, currentC+currentB);
                } else {
                    dfs(currentA, currentB-gabC, currentC+gabC);
                }
            }
        }

        if (currentC != 0) {
            int gabA = aMax-currentA;
            if (gabA > 0) {
                if (currentC<=gabA) {
                    dfs(currentA+currentC, currentB, 0);
                } else {
                    dfs(currentA+gabA, currentB, currentC-gabA);
                }
            }

            int gabB = bMax-currentB;
            if (gabB > 0) {
                if (currentC<=gabB) {
                    dfs(currentA, currentB+currentC, 0);
                } else {
                    dfs(currentA, currentB+gabB, currentC-gabB);
                }
            }
        }
    }
}