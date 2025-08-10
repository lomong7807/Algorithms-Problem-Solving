import java.io.*;
import java.util.*;
/*
 * 문제: 이진트리를 전위순회와 후위순회를 연습해보자.
           1
         /  \
        2    3
       / \  / \
      4  5  6  7
 * 입력: X
 * 출력: 전위순회 출력: 1 2 4 5 3 6 7
 *      중위순회 출력: 4 2 5 1 6 3 7
 *      후위순회 출력: 4 5 2 6 7 3 1
 * 풀이후기:
 *  - 재귀함수를 싫어했는데, 여기선 오히려 재귀함수로 구현하니 너무 간단했다.
 * */



public class Main {

    public static void preorderDfsR(Node node) {
        if(node == null) return;

        System.out.print(node.val + " ");
        preorderDfsR(node.lt);
        preorderDfsR(node.rt);
    }

    public static void preorderDfsS(Node root) {
        Deque<Node> stack = new ArrayDeque<>();
        
        stack.push(root);

        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            
            System.out.print(cur.val + " ");
            if(cur.rt != null) stack.push(cur.rt);
            if(cur.lt != null) stack.push(cur.lt);
        }
    }

    public static void inorderDfsR(Node node) {
        if(node == null) return;

        inorderDfsR(node.lt);
        System.out.print(node.val + " ");
        inorderDfsR(node.rt);
    }

    public static void inorderDfsS(Node root) {
        Deque<Node> stack = new ArrayDeque<>();
        Node current = root;

        while(current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.push(current);
                current = current.lt;
            }
            
            current = stack.pop();
            System.out.print(current.val + " ");
            current = current.rt;
        }
    }

    public static void main(String[] args) throws IOException {

    }
}

class Node {
    int val;
    Node lt;
    Node rt;

    Node(int val, Node lt, Node rt) {
        this.val = val;
        this.lt = lt;
        this.rt = rt;
    }
}


















class Node {
    int val;
    Node lt;
    Node rt;

    Node(int val, Node lt, Node rt) {
        this.val = val;
        this.lt = lt;
        this.rt = rt;
    }
}

public class Main {

    static ArrayList<ArrayList<Node>> tree = new ArrayList<>();

    public static void preorderRecursive(Node node) {
        if(node == null) return;

        System.out.print(node.val + " ");
        preorderRecursive(node.lt);
        preorderRecursive(node.rt);
    }

    public static void preorderStack(Node root) {
        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()) {
            Node current = stack.pop();

            System.out.print(current.val + " ");
            if(current.rt != null) stack.push(current.rt);
            if(current.lt != null) stack.push(current.lt);
        }
    }

    public static void main(String[] args) throws IOException {

    }
}































public class Main {

    public static void main(String[] args) {
        // 예시 트리 생성
        TreeNode root = new TreeNode(1);
        root.lt = new TreeNode(2);
        root.rt = new TreeNode(3);
        root.lt.lt = new TreeNode(4);
        root.lt.rt = new TreeNode(5);
        root.rt.lt = new TreeNode(6);
        root.rt.rt = new TreeNode(7);

        System.out.println("=== 재귀 방식 ===");
        System.out.print("전위순회: ");
        preorder(root);
        System.out.println();

        System.out.print("중위순회: ");
        inorder(root);
        System.out.println();

        System.out.print("후위순회: ");
        postorder(root);
        System.out.println();

        System.out.println("\n=== 반복 방식 ===");
        System.out.print("전위순회: ");
        preorderIterative(root);
        System.out.println();

        System.out.print("중위순회: ");
        inorderIterative(root);
        System.out.println();

        System.out.print("후위순회: ");
        postorderIterative(root);
        System.out.println();
    }

    public static void preorder(TreeNode node) {
        if(node == null) return;

        System.out.print(node.val + " ");   // 1. 루트 먼저 방문
        preorder(node.lt);                 // 2. 왼쪽 서브트리
        preorder(node.rt);                 // 3. 오른쪽 서브트리
    }

    public static void inorder(TreeNode node) {
        if(node == null) return;

        inorder(node.lt);                   // 1. 왼쪽 서브트리 먼저
        System.out.print(node.val + " ");   // 2. 루트 방문
        inorder(node.rt);                   // 3. 오른쪽 서브트리
    }

    public static void postorder(TreeNode node) {
        if(node == null) return;

        postorder(node.lt);                 // 1. 왼쪽 서브트리 먼저
        postorder(node.rt);                 // 2. 오른쪽 서브트리
        System.out.print(node.val + " ");   // 3. 루트 마지막에 방문
    }

    public static void preorderIterative(TreeNode root) {
        if(root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.print(current.val + " ");

            if(current.rt != null) stack.push(current.rt);
            if(current.lt != null) stack.push(current.lt);
        }
    }

    public static void inorderIterative(TreeNode root) {
        if(root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while(current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.push(current);
                current = current.lt;
            }

            current = stack.pop();
            System.out.print(current.val + " ");

            current = current.rt;
        }
    }

    public static void postorderIterative(TreeNode root) {
        if(root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisited = null;
        TreeNode current = root;

        while(current != null || !stack.isEmpty()) {
            if(current != null) {
                stack.push(current);
                current = current.lt;
            }else {
                TreeNode peekNode = stack.peek();
                // 오른쪽 자식이 있고 아직 방문하지 않았다면
                if(peekNode.rt != null && lastVisited != peekNode.rt) {
                    current = peekNode.rt;
                }else {
                    // 방문
                    System.out.print(peekNode.val + " ");
                    lastVisited = stack.pop();
                }
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode lt;
    TreeNode rt;

    TreeNode(int val) {
        this.val = val;
        this.lt = null;
        this.rt = null;
    }
}


// 전위순회
// public class Main {

//     static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
//     static boolean[] visited;

//     public static void dfsRecursive(int node) {
//         visited[node] = true;

//         for(int next : graph.get(node)) {
//             if(!visited[next]) {
//                 dfsRecursive(next);
//             }
//         }
//     }

//     public static void dfsStack(int node) {
//         Stack<Integer> stack = new Stack<>();
//         boolean[] visited = new boolean[7];

//         stack.push(node);

//         while(!stack.isEmpty()) {
//             int current = stack.pop();

//             if(!visited[current]) {
//                 visited[current] = true;

//                 for(int i = graph.get(current).size() - 1; 0 <= i; i--) {
//                     int next = graph.get(current).get(i);

//                     if(!visited[next]) {
//                         stack.push(next);
//                     }
//                 }
//             }
//         }
//     }

//     public static void main(String[] args) {
//         visited = new boolean[8];
//         for(int i = 0; i <= 8; i++) {
//             graph.add(new ArrayList<>());
//         }

//         graph.get(1).add(2);
//         graph.get(1).add(3);

//         graph.get(2).add(4);
//         graph.get(2).add(5);

//         graph.get(3).add(6);
//         graph.get(3).add(7);

//         for(ArrayList<Integer> list : graph) {
//             System.out.println(list);
//         }
//     }
// }