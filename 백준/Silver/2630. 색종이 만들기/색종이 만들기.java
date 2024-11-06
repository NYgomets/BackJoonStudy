import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static int white = 0;
    static int blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        arr = new int[n][n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, n, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void divide(int startX, int endX, int startY, int endY) {
        if (count(startX, endX, startY, endY)) {
            return;
        }

        divide(startX, (startX+endX)/2, startY, (startY+endY)/2);
        divide((startX+endX)/2, endX, startY, (startY+endY)/2);
        divide(startX, (startX+endX)/2, (startY+endY)/2, endY);
        divide((startX+endX)/2, endX, (startY+endY)/2, endY);
    }

    private static boolean count(int startX, int endX, int startY, int endY) {
       boolean blueCheck = false;
       boolean whiteCheck = false;

       int flag = arr[startX][startY];

       for (int i=startX; i<endX; i++) {
           for (int j=startY; j<endY; j++) {
               if (flag == 1) {
                   if (arr[i][j] == flag) {
                        blueCheck = true;
                   } else {
                       blueCheck = false;
                       return blueCheck;
                   }
               } else {
                   if (arr[i][j] == flag) {
                       whiteCheck = true;
                   } else {
                       whiteCheck = false;
                       return whiteCheck;
                   }
               }
           }
       }
        if (blueCheck) {
            blue++;
            return blueCheck;
        } else {
            white++;
            return whiteCheck;
        }
    }
}