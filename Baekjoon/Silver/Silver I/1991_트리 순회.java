import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 트리 순회
 *  - 번호 : 1991
 *  - 링크 : https://www.acmicpc.net/problem/1991
 * 2. 풀이핵심
 *  - HashMap을 사용하여 각 노드를 저장하고 관리
 *  - 입력을 받아 트리를 구성한 후 각 순회 방식으로 탐색
 * 3. 풀이후기
 *  - 트리 구성이 핵심, 순회는 재귀로 간단하게 구현
 */

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void preorderDfs(Node node) {
        if(node == null) return;

        sb.append(node.val);
        preorderDfs(node.lt);
        preorderDfs(node.rt);
    }

    public static void inorderDfs(Node node) {
        if(node == null) return;

        inorderDfs(node.lt);
        sb.append(node.val);
        inorderDfs(node.rt);
    }

    public static void postorderDfs(Node node) {
        if(node == null) return;

        postorderDfs(node.lt);
        postorderDfs(node.rt);
        sb.append(node.val);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Character, Node> map = new HashMap<>();

        for(int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char lt = st.nextToken().charAt(0);
            char rt = st.nextToken().charAt(0);

            map.putIfAbsent(parent, new Node(parent));
            if(lt != '.') {
                map.putIfAbsent(lt, new Node(lt));
                map.get(parent).lt = map.get(lt);
            }

            if(rt != '.') {
                map.putIfAbsent(rt, new Node(rt));
                map.get(parent).rt = map.get(rt);
            }
        }

        Node root = map.get('A');
        
        preorderDfs(root);
        sb.append("\n");
        inorderDfs(root);
        sb.append("\n");
        postorderDfs(root);

        System.out.print(sb);
    }
}

class Node {
    char val;
    Node lt;
    Node rt;

    Node(char val) {
        this.val = val;
        this.lt = null;
        this.rt = null;
    }
}