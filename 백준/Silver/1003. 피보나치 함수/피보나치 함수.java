import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Node[] arr;
    static class Node {
        int z;
        int o;

        public Node(int z, int o) {
            this.z = z;
            this.o = o;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int l=0; l<t; l++) {
            int n = Integer.parseInt(br.readLine());
            arr = new Node[n+1];

            if (n == 0) {
                System.out.println(1 + " " + 0);
                continue;
            } else if (n==1) {
                System.out.println(0 + " " + 1);
                continue;
            }

            arr[0] = new Node(1, 0);
            arr[1] = new Node(0, 1);
            Node result = fibo(n);
            System.out.println(result.z + " " + result.o);
        }
    }

    private static Node fibo(int n) {
        if (arr[n]!=null) {
            return arr[n];
        }

        return arr[n] = new Node(fibo(n-1).z + fibo(n-2).z, fibo(n-1).o + fibo(n-2).o);
    }
}