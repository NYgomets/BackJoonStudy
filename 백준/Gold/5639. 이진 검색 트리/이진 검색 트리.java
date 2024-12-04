import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }
    static Node root;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String string = br.readLine();
            if (string == null || string.isEmpty()) {
                break;
            }
            int value = Integer.parseInt(string);
            root = insert(root, value);
        }

        postOrder(root);
        System.out.println(sb);
    }

    private static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        
        postOrder(root.left);
        postOrder(root.right);
        sb.append(root.value).append("\n");
    }

    private static Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        } else {
            if (value < root.value) {
                root.left = insert(root.left, value);
            } else {
                root.right = insert(root.right, value);
            }
        }
        
        return root;
    }


}