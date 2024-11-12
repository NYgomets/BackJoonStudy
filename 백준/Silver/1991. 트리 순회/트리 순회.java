import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        String parent;
        Node left;
        Node right;

        public Node(String parent) {
            this.parent = parent;
        }

        public String getParent() {
            return parent;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
    static int n;
    static HashMap<String, Node> hashMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String current = st.nextToken();
            String leftChild = st.nextToken();
            String rightChild = st.nextToken();

            Node node = hashMap.getOrDefault(current, new Node(current));
            hashMap.put(current, node);

            if (!leftChild.equals(".")) {
                Node left = hashMap.getOrDefault(leftChild, new Node(leftChild));
                node.setLeft(left);
                hashMap.put(leftChild, left);
            }
            if (!rightChild.equals(".")) {
                Node right = hashMap.getOrDefault(rightChild, new Node(rightChild));
                node.setRight(right);
                hashMap.put(rightChild, right);
            }
        }

        preOrder(hashMap.get("A"));
        System.out.println();
        inOrder(hashMap.get("A"));
        System.out.println();
        postOrder(hashMap.get("A"));
    }

    private static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(node.getParent());
    }

    private static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft());
        System.out.print(node.getParent());
        inOrder(node.getRight());
    }

    private static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getParent());
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }
}