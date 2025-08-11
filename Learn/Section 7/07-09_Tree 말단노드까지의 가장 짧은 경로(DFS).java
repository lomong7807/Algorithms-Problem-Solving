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
 *  - 최단 거리 알고리즘은 보통 bfs로 구현하지 dfs로 하지 않는다.
 *  - dfs 연습용으로 만들어본 내용임
 * */

public class Main {

    static Node root;
    public static int dfs(int L, Node root) {
        if(root.lt == null && root.rt == null){
            return L;
        }else {
            return Math.min(dfs(L + 1, root.lt), dfs(L + 1, root.rt));
        }
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        System.out.print(dfs(0, root));
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