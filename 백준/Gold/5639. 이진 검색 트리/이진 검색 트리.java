import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }
    static Node root;
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
    }

    private static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }

    private static Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        } else {
            if (value < node.value) {
                node.left = insert(node.left, value);
            } else {
                node.right = insert(node.right, value);
            }
        }
        return node;
    }
}