import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : DFS와 BFS
 *  - 번호 : 1260
 *  - 링크 : https://www.acmicpc.net/problem/1260
 * 2. 풀이핵심
 *  - 인접행렬을 사용하려 그래프 표현
 *  - DFS는 재귀, BFS는 큐를 사용
 * 3. 풀이후기
 *  - visited 배열 초기화 주의, DFS 종료조건 설정
 *  - 처음에는 인접행렬로 구현했다가 인접리스트를 배워서 바로 인접리스트로 바꿔봤다.
 *  - 인접리스트가 시간복잡도나 공간복잡도 둘 다 앞선다.
 *  - 인접행렬 -> 인접리스트
 *    메모리: 22900~23700KB -> 20000KB
 *    시간: 224~228ms -> 204ms
 */

public class Main {

    static int n;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int v) {
        sb.append(v).append(" ");
        visited[v] = true;

        for(int nv : graph.get(v)) {
            if(!visited[nv]) {
                dfs(nv);
            }
        }
    }

    public static void bfs(int v) {
        sb.append("\n").append(v).append(" ");

        Deque<Integer> Q = new ArrayDeque<>();
        Q.add(v);
        visited[v] = true;

        while(!Q.isEmpty()) {

            int cur = Q.remove();

            for(int nv : graph.get(cur)) {
                if(!visited[nv]) {
                    Q.add(nv);
                    visited[nv] = true;
                    sb.append(nv).append(" ");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(ArrayList<Integer> list : graph) {
            Collections.sort(list);
        }

        dfs(v);
        visited = new boolean[n + 1];
        bfs(v);

        System.out.print(sb);
    }
}