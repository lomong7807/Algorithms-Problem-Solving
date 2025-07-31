import java.io.*;
import java.util.*;
/*
 * 문제: 자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램
 * 입력: 첫 번째 줄에 자연수 N(1<=N<=10)
 * 출력: 첫 번째 줄부터 각 줄에 하나씩 부분집합을 아래와 출력예제와 같은 순서로 출력한다.
 *      단 공집합은 출력하지 않는다.
 * 풀이후기:
 *  - bfs가 dfs보다는 쉬운거 같다.
 *  - 레벨마다 전체 출력 구현
 *  - 각 레벨의 원소값들을 순회하며 출력하고 순회하며 그 하위 원소들을 큐에 차례대로 담아준다.
 * */

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void bfs(Node root) {
        Deque<Node> Q = new ArrayDeque<>();
        Q.add(root);

        int L = 0;
        while(!Q.isEmpty()) {
            int len = Q.size();

            sb.append(L).append(": ");
            for(int i = 0; i < len; i++) {
                Node cur = Q.remove();
                sb.append(cur.val).append(" ");

                if(cur.lt != null) Q.add(cur.lt);
                if(cur.rt != null) Q.add(cur.rt);
            }
            L++;
            sb.append("\n");
        }
    }

    public static void main(String[] args) throws IOException {

        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        bfs(root);
        System.out.print(sb);
    }
}

class Node {
    int val;
    Node lt;
    Node rt;

    Node (int val) {
        this.val = val;
        this.lt = null;
        this.rt = null;
    }
}