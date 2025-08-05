import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] maze;
    static int RESULT = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        maze = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=n; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        subset();
        System.out.println(RESULT);
    }

    private static void subset() {
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                for (int k=1; k<n; k++) {
                    for (int l=1; l<n; l++) {
                        if (isProper(i, j, k, l)) {
                            divideAndCalc(i, j, k, l);
                        }
                    }
                }
            }
        }
    }

    private static void divideAndCalc(int startX, int startY, int d1, int d2) {
        int[][] region = new int[n+1][n+1];
        for (int i=0; i<=d1; i++) {
            region[startX+i][startY-i] = 5;
            region[startX+d2+i][startY+d2-i] = 5;
        }
        for (int i=0; i<=d2; i++) {
            region[startX+i][startY+i] = 5;
            region[startX+d1+i][startY-d1+i] = 5;
        }

        for (int i=startX+1; i<startX+d1+d2; i++) {
            boolean inside = false;
            for (int j=1; j<=n; j++) {
                if (region[i][j] == 5) {
                    inside = !inside;
                    continue;
                }
                if (inside) {
                    region[i][j] = 5;
                }
            }
        }

        int[] people = new int[6];
        for (int i=1; i<startX+d1; i++) {
            for (int j=1; j<=startY; j++) {
                if (region[i][j] == 5) {
                    continue;
                }
                region[i][j] = 1;
                people[1] += maze[i][j];
            }
        }

        for (int i=1; i<=startX+d2; i++) {
            for (int j=startY+1; j<=n; j++) {
                if (region[i][j] == 5) {
                    continue;
                }
                region[i][j] = 2;
                people[2] += maze[i][j];
            }
        }

        for (int i=startX+d1; i<=n; i++) {
            for (int j=1; j<startY-d1+d2; j++) {
                if (region[i][j] == 5) {
                    continue;
                }
                region[i][j] = 3;
                people[3] += maze[i][j];
            }
        }

        for (int i=startX+d2+1; i<=n; i++) {
            for (int j=startY-d1+d2; j<=n; j++) {
                if (region[i][j] == 5) {
                    continue;
                }
                region[i][j] = 4;
                people[4] += maze[i][j];
            }
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (region[i][j] == 5) {
                    people[5] += maze[i][j];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i=1; i<=5; i++) {
            min = Math.min(min, people[i]);
            max = Math.max(max, people[i]);
        }

        RESULT = Math.min(RESULT, max-min);
    }

    private static boolean isProper(int startX, int startY, int d1, int d2) {
        int leftX = startX+d1;
        int leftY = startY-d1;
        int rightX = startX+d2;
        int rightY = startY+d2;
        int bottomX = leftX+d2;
        int bottomY = leftY+d2;

        if (0<leftX && leftX<=n) {
            if (0<leftY && leftY<=n) {
                if (0<rightX && rightX<=n) {
                    if (0<rightY && rightY<=n) {
                        if (0<bottomX && bottomX<=n) {
                            if (0<bottomY && bottomY<=n) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}