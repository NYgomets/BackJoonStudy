import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static String[][] maze;
    static int checkW = Integer.MAX_VALUE;
    static int checkB = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new String[n][m];
        for (int i=0; i<n; i++) {
            String[] split = br.readLine().split("");
            for (int j=0; j<m; j++) {
                maze[i][j] = split[j];
            }
        }

        for (int i=0; i<n-7; i++) {
            for (int j=0; j<m-7; j++) {
                if (checkW > check(i, j, "W")) {
                    checkW = check(i, j, "W"); //왼쪽 상단이 W인 경우
                }
                if (checkB > check(i, j, "B")) {
                    checkB = check(i, j, "B"); //왼쪽 상단이 B인 경우
                }
            }
        }

        System.out.println(Math.min(checkW, checkB));
    }

    private static int check(int startX, int startY, String color) {
        int cost = 0;

        for (int k=0; k<8; k++) {
            for (int l=0; l<8; l++) {
                String expectColor;
                if ((k+l)%2==0) {
                    expectColor = color;
                } else {
                    if (color.equals("W")) {
                        expectColor = "B";
                    } else {
                        expectColor = "W";
                    }
                }

                if (!maze[k+startX][l+startY].equals(expectColor)) {
                    cost++;
                }
            }
        }
        return cost;
    }
}