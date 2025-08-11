import java.io.*;
import java.util.*;
/*
 * 문제: 아래와 같은 이진트리에서 루트 노드 에서 말단노드까지의 길이 중 가장 짧은 길이를 구하는 프로그램을 작성하세요.
        각 경로의 길이는 루트노드에서 말단노드까지 가는데 이동하는 횟수를 즉 간선 에지 의 개수를 길이로 하겠습니다.
        1
       / \
      2   3
     / \
    4   5
 * 입력: -
 * 출력: 가장 짧은 길이는 3번 노드까지의 길이인 1이다.
 * 풀이후기:
 *  - 기본적인 bfs 구현에 약간의 변형만 준 것이다.
 * */

public class Main {

    static Node root;
    public static int bfs(Node root) {
        Deque<Node> Q = new ArrayDeque<>();
        Q.add(root);
        int L = 0;

        while(!Q.isEmpty()) {
            int len = Q.size();

            for(int i = 0; i < len; i++) {
                Node cur = Q.remove();
                if(cur.lt == null && cur.rt == null) return L;
                if(cur.lt != null) Q.add(cur.lt);
                if(cur.rt != null) Q.add(cur.rt);
            }
            L++;
        }

        return 0;
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        System.out.print(bfs(root));
    }
}

class Node {
    int val;
    Node lt;
    Node rt;

    Node(int val) {
        this.val = val;
        this.lt = null;
        this.rt = null;
    }
}