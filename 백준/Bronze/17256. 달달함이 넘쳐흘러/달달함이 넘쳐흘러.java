import java.util.Scanner;

public class Main {
    public static String soSweet(String a, String c) {
        String[] aParts = a.split(" ");
        String[] cParts = c.split(" ");
        
        int a_x = Integer.parseInt(aParts[0]);
        int a_y = Integer.parseInt(aParts[1]);
        int a_z = Integer.parseInt(aParts[2]);
        
        int c_x = Integer.parseInt(cParts[0]);
        int c_y = Integer.parseInt(cParts[1]);
        int c_z = Integer.parseInt(cParts[2]);
        
        int resultX = c_x - a_z;
        int resultY = c_y / a_y;
        int resultZ = c_z - a_x;
        
        return resultX + " " + resultY + " " + resultZ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String c = sc.nextLine();
        
        System.out.println(soSweet(a, c));
    }
}
