import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int num = s.nextInt();

        int minx = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE;
        int miny = Integer.MAX_VALUE;
        int maxy = Integer.MIN_VALUE;

        for (int i=0; i<num; i++) {
            int x = s.nextInt();
            int y = s.nextInt();

            if (minx >= x) {
                minx = x;
            }
            if (x >= maxx ) {
                maxx = x;
            }

            if (miny >= y) {
                miny = y;
            }
            if (y >= maxy) {
                maxy = y;
            }
        }
        
        int d = (maxx - minx) * (maxy - miny);
        
        System.out.println(d);
        
    }
}