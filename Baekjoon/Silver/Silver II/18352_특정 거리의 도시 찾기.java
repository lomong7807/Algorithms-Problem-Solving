import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 특정 거리의 도시 찾기
 *  - 번호 : 18352
 *  - 링크 : https://www.acmicpc.net/problem/18352
 * 2. 풀이핵심
 *  - bfs
 *  - 최단 거리
 * 3. 풀이후기
 *  - dist[] 배열을 만들어서 해당 배열에 각 도시마다 거리를 넣을 수 있지만
 *  - 이번 문제는 특정 거리의 도시들을 모두 구하는 문제라 레벨로 구현했다.
 *  - 특정 레벨의 도시들을 모두 리스트에 담아 출력하게끔 함.
 */

public class Main {

    static int n, m, k, x;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static List<Integer> answer = new ArrayList<>();
    static boolean[] visited;

    public static void bfs(int v) {
        Deque<Integer> Q = new ArrayDeque<>();
        Q.add(v);
        visited[v] = true;
        int L = 0;

        while(!Q.isEmpty()) {
            int len = Q.size();
            L++;

            if(k < L) break;
            
            for(int i = 0; i < len; i++) {
                int cur = Q.poll();

                for(int nv : graph.get(cur)) {
                    if(!visited[nv]) {
                        Q.add(nv);
                        visited[nv] = true;
                        if(L == k) {
                            answer.add(nv);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
        }

        bfs(x);

        Collections.sort(answer);

        if(answer.isEmpty()) {
            System.out.print(-1);
        }else {
            for(int x : answer) {
                sb.append(x).append("\n");
            }
            System.out.println(sb);
        }
    }
}