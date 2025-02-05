import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        String[][] maze = new String[n][n];
        for (int i=0; i<n; i++) {
            Arrays.fill(maze[i], " ");
        }
        int idx = 0;
        for (int arr : arr1) {
            String binary = String.format("%"+n+"s", Integer.toBinaryString(arr));
            for (int i=0; i<binary.length(); i++) {
                int num = binary.charAt(i)-'0';
                if (num == 1) {
                    maze[idx][i] = "#";
                }
            }
            idx++;
        }
        
        idx = 0;
        for (int arr : arr2) {
            String binary = String.format("%"+n+"s", Integer.toBinaryString(arr));
            for (int i=0; i<binary.length(); i++) {
                int num = binary.charAt(i)-'0';
                if (num == 1) {
                    maze[idx][i] = "#";
                }
            }
            idx++;
        }
        
        for (int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<n; j++) {
                sb.append(maze[i][j]);
            }
            result[i] = sb.toString();
        }
        
        return result;
    }
}