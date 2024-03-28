import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());

       int[][] A = new int[N][M];

       for (int i=0; i<N; i++) {
           st = new StringTokenizer(br.readLine());
           for (int j=0; j<M; j++) {
               A[i][j] = Integer.parseInt(st.nextToken());
           }
       }

       st = new StringTokenizer(br.readLine());
       int sN = Integer.parseInt(st.nextToken());
       int sM = Integer.parseInt(st.nextToken());

       int[][] B = new int[sN][sM];

        for (int i=0; i<sN; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <sM; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int[][] C = new int[N][sM];

        for (int k=0; k<N; k++) {
            for (int l=0; l<sM; l++) {
                for (int z=0; z<M; z++) {
                    C[k][l] += A[k][z] * B[z][l];
                }
            }
        }

        for (int c=0; c<N; c++) {
            for (int d=0; d<sM; d++) {
                System.out.print(C[c][d] + " ");
            }
            System.out.println();
        }
    }
}