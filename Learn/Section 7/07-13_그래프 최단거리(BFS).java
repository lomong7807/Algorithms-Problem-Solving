import java.io.*;
import java.util.*;
/*
 * 문제: 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 간선수를 출력
 * 입력: 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M이 주어진다. 그 다음부터 M줄에 걸쳐 연결정보가 주어진다.
 * 출력: 1번 정점에서 각 정점으로 가는 최소 간선수를 2번 정점부터 차례대로 출력
 * 풀이후기:
 *  - 각 정점마다의 거리를 저장해두기 위한 배열을 하나 만들어서 레벨이 올라갈때마다 거리를 1씩 더해주면 된다.
 *  - bfs는 점점 익숙해지는게 느껴진다.
 * */

public class Main {

    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] dist;

    public static void bfs(int v) {
        Deque<Integer> Q = new ArrayDeque<>();
        Q.add(v);
        visited[v] = true;

        while(!Q.isEmpty()) {
            int len = Q.size();

            for(int i = 0; i < len; i++) {
                int cur = Q.poll();

                for(int nv : graph.get(cur)) {
                    if(!visited[nv]) {
                        Q.add(nv);
                        visited[nv] = true;
                        dist[nv] = dist[cur] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        dist = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
        }

        bfs(1);

        for(int i = 2; i < dist.length; i++) {
            sb.append(i).append(" : ").append(dist[i]).append("\n");
        }

        System.out.print(sb);
    }
}