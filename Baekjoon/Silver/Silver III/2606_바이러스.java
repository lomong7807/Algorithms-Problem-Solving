import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 바이러스
 *  - 번호 : 2606
 *  - 링크 : https://www.acmicpc.net/problem/2606
 * 2. 풀이핵심
 *  - dfs/bfs
 *  - 연결요소찾기
 * 3. 풀이후기
 *  - 단순한 "연결 요소 찾기" 문제라서 DFS가 조금 더 적절할 수 있지만, BFS로 풀어도 전혀 문제없다.
 *  - 범위가 그렇게 크지 않아서 실제로 성능은 비슷함
 */

public class Main {

    static int n;
    static int answer = 0;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void dfs(int v) {
        for(int nv : graph.get(v)) {
            if(!visited[nv]) {
                visited[nv] = true;
                answer++;
                dfs(nv);
            }
        }
    }

    public static void bfs(int v) {
        Deque<Integer> Q = new ArrayDeque<>();
        Q.add(v);
        visited[v] = true;

        while(!Q.isEmpty()) {
            int cur = Q.remove();

            for(int nv : graph.get(cur)) {
                if(!visited[nv]) {
                    Q.add(nv);
                    visited[nv] = true;
                    answer++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

//        visited[1] = true;
//        dfs(1);
         bfs(1);

        System.out.print(answer);
    }
}